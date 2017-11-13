/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

/**
 *
 * @author user
 */

class TTSData{
    public int lang;
    public String langnm, soc;
    
    public TTSData(int lang, String soc){
        this.lang = lang;
        langnm = KeyList.getKeyInfo(lang).ttsname;
        this.soc = soc;
    }
//    
//    public String toString(){
//        return lang + "_" + soc;
//    }
}

public class TTSTools {    
    private static byte[] getBytes(InputStream is) throws IOException {

        int len;
        int size = 1024;
        byte[] buf;

        if (is instanceof ByteArrayInputStream) {
            size = is.available();
            buf = new byte[size];
            len = is.read(buf, 0, size);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            buf = new byte[size];
            while ((len = is.read(buf, 0, size)) != -1) {
                bos.write(buf, 0, len);
            }
            buf = bos.toByteArray();
        }
        return buf;
    }

    
    private static byte[] getFileContents(TTSData wordifo){
        HttpURLConnection conn = null;
        byte [] btdata = null;
        
        try{
            URL openurl = new URL("http://translate.google.com/translate_tts?tl=" + wordifo.langnm + "&q=" + URLEncoder.encode(wordifo.soc, "UTF-8"));
            
            conn = (HttpURLConnection) openurl.openConnection();
            conn.addRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
            
            btdata = getBytes(conn.getInputStream());
            
            conn.disconnect();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return btdata;
    }
    
    public static void getTTSData(int lang, String sen){
        String lnregex = KeyList.getLangRegex(lang, false);
        String usaregex = KeyList.getLangRegex(10, false);
        String korregex = KeyList.getLangRegex(26, false);
        
        String lnname = KeyList.getKeyInfo(lang).ttsname;
        String usaname = "en";
        String korname = "ko";
        
        Vector<TTSData> ttssoc = new Vector<TTSData>();
        
        StringBuilder mp3 = new StringBuilder();
        
        /*
         *  다른 문자 기준으로 데이터 분류해서 자동 처리!
         */

        char [] sp = sen.toCharArray();
        int [] langifo = new int[sp.length];

        //langCode로 분류
        for (int c=0; c<sp.length; c++){
            String spdt = "" + sp[c];

            if (spdt.matches(lnregex)){
                langifo[c] = lang;
            }
            else if (spdt.matches(usaregex)){
                langifo[c] = 10;
            }
            else if (spdt.matches(korregex)){
                langifo[c] = 26;                    
            }
        }

        //실제 문자열 벡터에다가 분류 내용 삽입
        StringBuilder builder = new StringBuilder();
        int cur = langifo[0];
        builder.append(sp[0]);

        for (int c=1; c<langifo.length; c++){
            if (cur != langifo[c]){
                ttssoc.add(new TTSData(cur, builder.toString()));
                builder.setLength(0);
                cur = langifo[c];
            }

            builder.append(sp[c]);
        }
        ttssoc.add(new TTSData(cur, builder.toString()));

        langifo = null;
        builder = null;
     
        byte[] socmp3 = getFileContents(ttssoc.get(0));
        for (int c=1; c<ttssoc.size(); c++){
            socmp3 = MP3Tools.merge(socmp3, getFileContents(ttssoc.get(c)));
        }
        
        try{
            FileOutputStream fp = new FileOutputStream("C:\\Users\\user\\Desktop\\ttssample.mp3", false);
            fp.write(socmp3);
            fp.close();
            
            fp = null;
        }
        catch(Exception ex){
            
        }
        
        ttssoc.clear();
        ttssoc = null;
        
        mp3 = null;
    }
}
