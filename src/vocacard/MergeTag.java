/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.util.Vector;

/**
 *
 * @author 정용훈
 */
public class MergeTag {

    private String name;
    private String form;
    public Vector<String> ptesm, phosnd, ansynym, idiom, pic;
    private String text;

   public MergeTag() {
        ptesm = new Vector<String>();
        phosnd = new Vector<String>();
        ansynym = new Vector<String>();
        idiom = new Vector<String>();
        pic = new Vector<String>();
    }

    public void setName(String s) {
        name = s;

    }

    public void setForm(String cur, String past, String pp, String singular,
            String plural, String present,
            String noun, String adj, String adv) {
        int pos = 0;

        String res = "<TRANSFORM CUR=\"%s\" PAST=\"%s\" PP=\"%s\""
                + " SINGULAR=\"%s\" PLURAL=\"%s\" PRESENT=\"%s\" NOUN=\"%s\" ADJ=\"%s\" ADV=\"%s\" />";

        res = String.format(res, cur, past, pp, singular, plural, present, noun, adj, adv);

        while ((pos = res.indexOf("=\"\"")) >= 0) {
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos + 3);
            res = res.replace(posarr, "");
        }
        form = res;
    }

    public void addPtesm( String cls, String meaning, String Synonym, String ex, String tex) {
        String res = "<PTESMDATA TYPE=\"PSM\" CLASS=\"%s\" MEANING=\"%s\" SYNONYM=\"%s\" EX=\"%s\" TEX=\"%s\" />";

        res = String.format(res, cls, meaning, Synonym, ex, tex);

        int pos = 0;
        while ((pos = res.indexOf("=\"\"")) >= 0) {
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos + 3);
            res = res.replace(posarr, "");
        }
        ptesm.add(res);
    }

    public void addPtesm(String ex, String tex) {
        String res = "<PTESMDATA TYPE=\"TEX\" EX=\"%s\" TEX=\"%s\" />";

        res = String.format(res, ex, tex);

        int pos = 0;
        while ((pos = res.indexOf("=\"\"")) >= 0) {
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos + 3);
            res = res.replace(posarr, "");

        }
        ptesm.add(res);

    }

    public void addPhosnd(String text, String phonetic, String sound) {
        String res = "<PHOSNDDATA TEXT=\"%S\" PHONETIC= \"%s\" SOUND=\"%S\" />";
        res = String.format(res, text, phonetic, sound);
        int pos = 0;
        while ((pos = res.indexOf("=\"\"")) >= 0) {
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos + 3);
            res = res.replace(posarr, "");
        }
        phosnd.add(res);
    }

    public void addAnsynym(String type, String text, String cls, String meaning, String ex, String tex) {

        String res = "<ANSYNYMDATA TYPE=\"%S\" TEXT= \"%s\" CLS=\"%S\" MEANING=\"%S\" EX=\"%S\" TEX=\"%S\" />";
        res = String.format(res, type, text, cls, meaning, ex, tex);
        int pos = 0;
        while ((pos = res.indexOf("=\"\"")) >= 0) {
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos + 3);
            res = res.replace(posarr, "");
        }
        ansynym.add(res);
    }

    public void addIdiom(String text, String meaning) {

        String res = "<IDIOMDATA TEXT=\"%S\" MEANING= \"%s\" />";
        res = String.format(res, text, meaning);
        int pos = 0;
        while ((pos = res.indexOf("=\"\"")) >= 0) {
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos + 3);
            res = res.replace(posarr, "");
        }
        idiom.add(res);
    }

    public void addPic(String pic, String text) {

        String res = "<PICDATA PIC=\"%S\" TEXT= \"%s\" />";
        res = String.format(res, pic, text);
        int pos = 0;
        while ((pos = res.indexOf("=\"\"")) >= 0) {
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos + 3);
            res = res.replace(posarr, "");
        }
        this.pic.add(res);
    }

    public void setText(String s) {
        text = s;
    }

}
