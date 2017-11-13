/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ToolTipBoxFXMLController implements Initializable {
    @FXML
    private VBox root;
    @FXML
    private Button btnprev;
    @FXML
    private Button btnnext;
    
    IPABoxFXMLController ipa;
    String [] vec;
    int lastpos = 0;
    
    Vector<Button> btns;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            btnprev.setDisable(true);
            btnnext.setDisable(true);

            btns = new Vector<Button>();
            for (int c=1; c<11; c++){
                FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("ToolTipButton.fxml"));
                Button one = (Button) fx0.load();
                ToolTipButtonController tipcon = (ToolTipButtonController)fx0.getController();
                
                if (c == 10)
                    tipcon.setNum("0");
                else
                    tipcon.setNum("" + c);
                                
                one.setUserData(tipcon);
                btns.add(one);
                                
                fx0 = null;
            }
            
            
            WinUtils.memFree();
        }
        catch(Exception ex){
        }
    }
    
    public void setIPABox(IPABoxFXMLController ipa){
        this.ipa = ipa;
    }
    
    public void setData(String [] vec){
        this.vec = vec;
        
        while(root.getChildren().size() > 1){
            root.getChildren().remove(0);
        }
        
        if (vec.length > 10){
            for (int c=0; c<btns.size(); c++)
                root.getChildren().add(c, btns.get(c));
                
            lastpos = 0;
        }
        else{
            for (int c=0; c<vec.length; c++)
                root.getChildren().add(c, btns.get(c));
        }
    }
    
    private void setData(){
        if (vec.length > 10){
            for (int c=lastpos; c<lastpos+10; c++){
                ToolTipButtonController tipcon = (ToolTipButtonController) btns.get(c-lastpos).getUserData();
//                tipcon
            }
        }
    }

    @FXML
    private void onPrev(ActionEvent event) {
        lastpos -= 10;
        btnprev.setDisable((lastpos < 0));
        
        if (lastpos < 0)
            lastpos = 0;
        
        setData();
    }

    @FXML
    private void onNext(ActionEvent event) {
        lastpos += 10;
        btnnext.setDisable((lastpos >= vec.length));
        
        if (lastpos >= vec.length){
            lastpos = vec.length-10;
        }
        
        setData();
    }
}
