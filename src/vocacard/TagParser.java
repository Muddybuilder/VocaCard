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
public class TagParser {
    public static String valueParse(String soc, String find){
        int n0 = soc.indexOf(find.toUpperCase() + "=\"");
        if (n0 == -1)
            return "";
        
        n0 += find.length() + 2;
        
        return soc.substring(n0, soc.indexOf("\"", n0+1));
    }
    
    public static String[] multiTagParse(String soc, String find){
        int n0 = soc.indexOf("<" + find.toUpperCase() + ">\n");
        if (n0 == -1)
            return null;
        
        n0 += find.length() + 4;
        
        soc = soc.substring(n0, soc.indexOf("</" + find.toUpperCase() + ">", n0+1));
        
        return soc.split("\\>");
    }
    
    public static String tagParse(String soc, String find){
        int n0 = soc.indexOf("<" + find.toUpperCase());
        if (n0 == -1)
            return "";
        
        n0 += find.length() + 2;
        
        return soc.substring(n0, soc.indexOf(" />", n0+1));
    }
}