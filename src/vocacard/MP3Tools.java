/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

/**
 *
 * @author user
 */
public class MP3Tools {
    private static byte[] getIdvEnd(byte[] data){
        byte [] bt = new byte[128];
        System.arraycopy(data, data.length-128, bt, 0, 128);
        
        byte [] bts = new byte[3];
        String btstr = new String(bts);
        
        if (btstr.toUpperCase().equals("TAG")){
            return bt;
        }
        
        return null;
    }
    
    private static int getStart(byte[] data){
        for (int c=0; c<data.length; c++){
            if (data[c] == (byte)255)
                return c;
        }
        return -1;
    }
    
    private static byte[] stripTags(byte[] data){
        int start = getStart(data);
        if (start == -1){
            return null;
        }
        
        byte [] sbt = new byte[data.length-start];
        System.arraycopy(data, start, sbt, 0, data.length-start);
        
        byte [] end = getIdvEnd(sbt);
        
        if (end != null){
            byte [] ebt = new byte[data.length-129];
            System.arraycopy(sbt, 0, ebt, 0, data.length-129);
            
            return ebt;
        }
        
        return sbt;
    }
    
    public static byte[] merge(byte[] soc, byte[] soc1){
        byte [] sc1 = stripTags(soc1);
        byte [] socmrg = new byte[soc.length + sc1.length];
        
        System.arraycopy(soc, 0, socmrg, 0, soc.length);
        System.arraycopy(sc1, 0, socmrg, soc.length, sc1.length);
        
        return socmrg;
    }
}
