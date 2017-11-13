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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author user
 */
public class TransPaneController implements Initializable {
    @FXML
    private HBox v2;
    @FXML
    private VBox v3;
    @FXML
    private Pane lvpane;
    @FXML
    private VBox v4;
    @FXML
    private Button btnadd;
    @FXML
    private Button btndel;
    
    BoxView lv;
    Pane parent;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            lv = new BoxView(lvpane);
            lv.setType(BoxView.PaneType.TRANSBOX);
            btndel.setDisable(false);
            btndel.setVisible(false);
        }
        catch(Exception ex){            
        }
    }

    @FXML
    private void onAdd(ActionEvent event) {
        try{
            if (lv.size() == 0){
                FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("TransWord.fxml"));
                fx2.load();
                ((TransWordController)(fx2.getController())).setBoxView(lv);
                ((TransWordController)(fx2.getController())).showAddDlg();
                
                fx2 = null;
                WinUtils.memFree();
            }
            else{
                Parent p = lv.getItems().get(0);
                
                FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("TransWord.fxml"));
                fx2.load();
                ((TransWordController)(fx2.getController())).setBoxView(lv);
                ((TransWordController)(fx2.getController())).showModifyDlg(((Boxable)(p.getUserData())));

                fx2 = null;
                WinUtils.memFree();
            }
            
            btndel.setVisible(lv.size() > 0);
            if (lv.size() > 0){
                btnadd.setText("단어 변화 형태 수정");
            }
            else{
                btnadd.setText("단어 변화 형태 추가");
            }
            setAutoSize(parent);            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void onDelete(ActionEvent event) {
        lv.removeAll();
        
        btndel.setVisible(lv.size() > 0);
        if (lv.size() > 0){
            btnadd.setText("단어 변화 형태 수정");
        }
        else{
            btnadd.setText("단어 변화 형태 추가");
        }
    }
    
    public void setAutoSize(Pane pane){
        this.parent = pane;
        double w = pane.getPrefWidth();

        v3.setPrefWidth(w-145);
        v4.setPrefWidth(145);
        v2.setPrefSize(w, pane.getPrefHeight());
        lvpane.setPrefSize(v3.getPrefWidth()-16, v2.getPrefHeight());
        lv.resize();
    }
    
    public void setData(String tag){
        try{
            lv.removeAll();
            
            lv.addItem(tag);
            btndel.setVisible(lv.size() > 0);
            if (lv.size() > 0){
                btnadd.setText("단어 변화 형태 수정");
            }
            else{
                btnadd.setText("단어 변화 형태 추가");
            }
            
            setAutoSize(parent);
        }
        catch(Exception ex){
        }
    }
    
    public void clear(){
        lv.removeAll();
        
        btndel.setVisible(lv.size() > 0);
        if (lv.size() > 0){
            btnadd.setText("단어 변화 형태 수정");
        }
        else{
            btnadd.setText("단어 변화 형태 추가");
        }
        setAutoSize(parent);
    }
}
