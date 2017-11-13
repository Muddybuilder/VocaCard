/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ExBoxController implements Initializable {
    @FXML
    private CheckBox chk;
    public Text ex1;
    public Text ex2;
    public Text part;
    private ImageView ex1img, ex2img;
    
    static double maxw = 0;

    @FXML
    private AnchorPane root;
    @FXML
    private VBox vbox;
    
    ListView lv;
    
    SearchPaneFXMLController conpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WinUtils.setAutoDPI(root);
        ex1 = new Text();
        ex2 = new Text();
        part = new Text();
        ex1img = new ImageView();
        ex2img = new ImageView();
    }
        
    public void setListWidth(double w){
        maxw = w;
    }
    
    public void setData(String s1, String s2, String s3){
        WinUtils.memFree();
        vbox.setPrefWidth(maxw-10);
        ex1.setWrappingWidth(maxw);
        ex1.setId("bold16");
        ex1.setText(s2);
        ex1img.setImage(KeyList.getKeyInfo(VocaCard.toLang).img);
        vbox.getChildren().clear();
        
        TextFlow f1 = new TextFlow(ex1, ex1img);
        f1.setPrefWidth(maxw-10);
        vbox.getChildren().add(f1);
        
        ///////////////////////////////
        if (s1.length() > 0){
            part.setVisible(true);
            part.setWrappingWidth(maxw);
            part.setId("bold10");
            part.setText(s1);
                 
            vbox.getChildren().add(new TextFlow(part, new Text(")")));
        }
        
        ////////////////////////////////
        if (s3.length() > 0){
            ex2.setWrappingWidth(maxw);
            ex2.setId("nm10");
            ex2.setText(s3);
            ex2img.setImage(KeyList.getKeyInfo(VocaCard.fromLang).img);

            TextFlow f2 = new TextFlow(ex2, ex2img);
            f2.setPrefWidth(maxw-10);
            vbox.getChildren().add(f2);
        }
        else{
            s3 = "";
        }
        
        root.setPrefSize(maxw, -1);
        WinUtils.memFree();
    }
    
    public void clear(){
        while(vbox.getChildren().size() > 0){
            for (Node node : vbox.getChildren()){
                vbox.getChildren().remove(node);
                node = null;
                break;
            }
        }
        vbox = null;
        
        ex1.setText(null);
        ex2.setText(null);
        part.setText(null);
        
        chk = null;
        ex1 = null;
        ex2 = null;
        part = null;
        ex1img = null;
        ex2img = null;
        
        lv = null;
        conpane = null;
        
        WinUtils.memFree();
    }
    
    public void setData(String s2, String s3){
        WinUtils.memFree();
        ex1.setWrappingWidth(maxw);
        ex1.setId("bold16");
        ex1.setText(s2);
        ex1img.setImage(KeyList.getKeyInfo(VocaCard.fromLang).img);
        
        TextFlow f1 = new TextFlow(ex1, ex1img);
        f1.setPrefWidth(maxw-10);
       
        vbox.getChildren().clear();
        vbox.getChildren().add(f1);
        
        ///////////////////////////////////////////////
        if (s3.length() > 0){
            ex2.setWrappingWidth(maxw-ex2.getLayoutX());
            ex2.setId("nm10");
            ex2.setText(s3);
            ex2img.setImage(KeyList.getKeyInfo(VocaCard.toLang).img);

            TextFlow f2 = new TextFlow(ex2, ex2img);
            f2.setPrefWidth(maxw-10);

            vbox.getChildren().add(f2);
        }
        else{
            s3 = "";
        }
        
        root.setPrefSize(maxw, -1);
        WinUtils.memFree();
    }
    
    public void setChecked(boolean chking){
        chk.setSelected(chking);
    }
    
    public boolean getChecked(){
        return chk.isSelected();
    }
    
    public void setSearchPane(SearchPaneFXMLController conpane){
        this.conpane = conpane;
    }

    @FXML
    private void OnCheck(ActionEvent event) {
        conpane.updateChecking();
    }
    
    public void setNonCheck(){
        chk.setVisible(false);
    }
}