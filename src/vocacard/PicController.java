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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PicController implements Dlgable, Initializable {
    @FXML
    private BorderPane root;
    @FXML
    private Label c0;
    @FXML
    private Label c1;
    @FXML
    private Button btnhelp;
    @FXML
    private HBox hb;
    @FXML
    private Pane pane;
    @FXML
    private Pane p1;
    @FXML
    private Pane p2;
    @FXML
    private Button btnclear;
    @FXML
    private Button btnadd;
    @FXML
    private Button btncancel;
    
    Parent k1, k2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try{
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("FileBox.fxml"));
            k1 = fx1.load();            
            FileBoxController keycon = (FileBoxController) fx1.getController();
            k1.setUserData(keycon);
            p1.getChildren().add(k1);
            keycon.setAutoSize(p1);
                                    
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k2 = fx2.load();
            KeyBoxController keycon1 = (KeyBoxController) fx2.getController();
            k2.setUserData(keycon1);
            p2.getChildren().add(k2);
            keycon1.setAutoSize(p2);
         }
         catch(Exception ex){
             
         }
    }

    @FXML
    private void OnHelp(ActionEvent event) {
    }

    @FXML
    private void onClear(ActionEvent event) {
    }

    @FXML
    private void onAdd(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) {
    }

    @Override
    public void setAutoSize(double halfw) {
        
    }

    @Override
    public void setBoxView(BoxView boxes) {
        
    }

    @Override
    public void showAddDlg() {
        
    }

    @Override
    public void showModifyDlg(Boxable tag) {
        
    }
    
}
