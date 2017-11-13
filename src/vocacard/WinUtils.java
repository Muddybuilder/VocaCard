/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Screen;

/**
 *
 * @author user
 */
public class WinUtils {
    public static String percentdpi = "";
    public static double perdpi = 1;
    
    public static void InitUtils(){
        double scrdpi = Screen.getPrimary().getDpi();
        double [] dpis = {96, 120, 144, 192};
        String [] per = {"", "_125", "_150", "_200"};
        double [] pers = {1, 1.2, 1.5, 2};
       
        for (int c=0; c<dpis.length; c++){
            if (dpis[c] == scrdpi){
                percentdpi = per[c];
                perdpi = pers[c];
                return;
            }
        }
    }
    
    public static void setAutoDPI(Parent parent){
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node != null){
                node.setId(node.getId() + percentdpi);
                //System.out.println(node.getId());
                if (node instanceof Parent) {
                    setAutoDPI((Parent) node);
                }
            }
        }
    }
    
    public static void memFree(){
        System.gc();
        //System.out.println("잔여 메모리 - " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB, " + Runtime.getRuntime().totalMemory()/1024/1024 + "MB");
    }
}
