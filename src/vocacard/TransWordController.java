/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class TransWordController implements Dlgable, Initializable {
    @FXML
    private Label c0;
    @FXML
    private Label c1;
    @FXML
    private Button btnhelp;
    @FXML
    private Button btnclear;
    @FXML
    private Button btnadd;
    @FXML
    private Button btncancel;
    @FXML
    private Pane k1;
    @FXML
    private BorderPane b1;
    @FXML
    private Pane p1;
    @FXML
    private Pane p2;
    @FXML
    private Pane p3;
    @FXML
    private Pane k2;
    @FXML
    private Pane p4;
    @FXML
    private Pane p5;
    @FXML
    private Pane p6;
    @FXML
    private Pane p7;
    @FXML
    private Pane p8;
    @FXML
    private Pane p9;
    
    Parent t1, t2, t3, t4, t5, t6, t7, t8, t9;
    @FXML
    private BorderPane root;
    
    BoxView boxes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t1 = fx1.load();            
            KeyBoxController keycon1 = (KeyBoxController) fx1.getController();
            keycon1.setInitialLang(VocaCard.fromLang);
            t1.setUserData(keycon1);            
            p1.getChildren().add(t1);
            keycon1.setAutoSize(p1);
            
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t2 = fx2.load();            
            KeyBoxController keycon2 = (KeyBoxController) fx2.getController();
            keycon2.setInitialLang(VocaCard.fromLang);
            t2.setUserData(keycon2);            
            p2.getChildren().add(t2);
            keycon2.setAutoSize(p2);
            
            FXMLLoader fx3 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t3 = fx3.load();            
            KeyBoxController keycon3 = (KeyBoxController) fx3.getController();
            keycon3.setInitialLang(VocaCard.fromLang);
            t3.setUserData(keycon3);            
            p3.getChildren().add(t3);
            keycon3.setAutoSize(p3);
            
            //////////////////////////////
            FXMLLoader fx4 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t4 = fx4.load();            
            KeyBoxController keycon4 = (KeyBoxController) fx4.getController();
            keycon4.setInitialLang(VocaCard.fromLang);
            t4.setUserData(keycon4);            
            p4.getChildren().add(t4);
            keycon4.setAutoSize(p4);
            
            FXMLLoader fx5 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t5 = fx5.load();
            KeyBoxController keycon5 = (KeyBoxController) fx5.getController();
            keycon5.setInitialLang(VocaCard.fromLang);
            t5.setUserData(keycon5);
            p5.getChildren().add(t5);
            keycon5.setAutoSize(p5);
            
            FXMLLoader fx6 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t6 = fx6.load();
            KeyBoxController keycon6 = (KeyBoxController) fx6.getController();
            keycon6.setInitialLang(VocaCard.fromLang);
            t6.setUserData(keycon6);
            p6.getChildren().add(t6);
            keycon6.setAutoSize(p6);
            
            FXMLLoader fx7 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t7 = fx7.load();
            KeyBoxController keycon7 = (KeyBoxController) fx7.getController();
            keycon7.setInitialLang(VocaCard.fromLang);
            t7.setUserData(keycon7);
            p7.getChildren().add(t7);
            keycon7.setAutoSize(p7);
            
            FXMLLoader fx8 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t8 = fx8.load();
            KeyBoxController keycon8 = (KeyBoxController) fx8.getController();
            keycon8.setInitialLang(VocaCard.fromLang);
            t8.setUserData(keycon8);
            p8.getChildren().add(t8);
            keycon8.setAutoSize(p8);
            
            FXMLLoader fx9 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            t9 = fx9.load();
            KeyBoxController keycon9 = (KeyBoxController) fx9.getController();
            keycon9.setInitialLang(VocaCard.fromLang);
            t9.setUserData(keycon9);
            p9.getChildren().add(t9);
            keycon9.setAutoSize(p9);
            
            fx1 = null;
            fx2 = null;
            fx3 = null;
            fx4 = null;
            fx5 = null;
            fx6 = null;
            fx7 = null;
            fx8 = null;
            fx9 = null;
            
            WinUtils.memFree();
        }
        catch(Exception ex){
        }
    }    

    @FXML
    private void OnHelp(ActionEvent event) {
    }

    @FXML
    private void onClear(ActionEvent event) {
        clear();
    }

    @FXML
    private void onAdd(ActionEvent event) {
        String res = "<TRANSFORM CUR=\"%s\" PAST=\"%s\" PP=\"%s\" SINGULAR=\"%s\" PLURAL=\"%s\" PRESENT=\"%s\" NOUN=\"%s\" ADJ=\"%s\" ADV=\"%s\" />";
        
        res = String.format(res, ((KeyBoxController)(t1.getUserData())).getText(),
                                 ((KeyBoxController)(t2.getUserData())).getText(),
                                 ((KeyBoxController)(t3.getUserData())).getText(),
                                 ((KeyBoxController)(t4.getUserData())).getText(),
                                 ((KeyBoxController)(t5.getUserData())).getText(),
                                 ((KeyBoxController)(t6.getUserData())).getText(),
                                 ((KeyBoxController)(t7.getUserData())).getText(),
                                 ((KeyBoxController)(t8.getUserData())).getText(),
                                 ((KeyBoxController)(t9.getUserData())).getText());
        
        int pos = 0;
        while((pos = res.indexOf("=\"\"")) >= 0){
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos+3);
            res = res.replace(posarr, "");
        }
        
        boxes.addItem(res);
        
        clear();
        ((Node)event.getSource()).getScene().getWindow().hide();
        
        res = null;
        WinUtils.memFree();
    }

    @FXML
    private void onCancel(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
        WinUtils.memFree();
    }

    @Override
    public void setAutoSize(double halfw) {
        k1.setPrefWidth(halfw);
        p1.setPrefWidth(halfw-30);
        p2.setPrefWidth(halfw-30);
        p3.setPrefWidth(halfw-30);
        b1.setPrefWidth(halfw-30);
                
        k2.setPrefWidth(halfw);
        p4.setPrefWidth(halfw-40);
        p5.setPrefWidth(halfw-40);
        p6.setPrefWidth(halfw-40);
        p7.setPrefWidth(halfw-40);
        p8.setPrefWidth(halfw-40);
        p9.setPrefWidth(halfw-40);
        
        ((KeyBoxController)(t1.getUserData())).setAutoSize(p1);
        ((KeyBoxController)(t2.getUserData())).setAutoSize(p2);
        ((KeyBoxController)(t3.getUserData())).setAutoSize(p3);
        ((KeyBoxController)(t4.getUserData())).setAutoSize(p4);
        ((KeyBoxController)(t5.getUserData())).setAutoSize(p5);
        ((KeyBoxController)(t6.getUserData())).setAutoSize(p6);
        ((KeyBoxController)(t7.getUserData())).setAutoSize(p7);
        ((KeyBoxController)(t8.getUserData())).setAutoSize(p8);
        ((KeyBoxController)(t9.getUserData())).setAutoSize(p9);
    }

    @Override
    public void setBoxView(BoxView boxes) {
        this.boxes = boxes;
    }

    @Override
    public void showAddDlg() {
        Stage stage = new Stage();
        stage.setTitle("새 단어 변화 형태 추가");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.widthProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                setAutoSize(newValue.doubleValue()/2.0);
        });
                
        c0.setText("단어 변화 형태 추가");
        c1.setText("단어 변화 형태를 추가합니다.");
        btnadd.setText("내용 추가");
        
        clear();       
       
        stage.showAndWait();
   
        stage.setScene(null);
        stage = null;
        WinUtils.memFree();
    }

    @Override
    public void showModifyDlg(Boxable tag) {
        if (!tag.isContains("<TRANSFORM ", " />"))
            return;
        
        c0.setText("단어 변화 형태 수정");
        c1.setText("단어 변화 형태를 수정합니다.");
        btnadd.setText("내용 수정");
        
        String cur = tag.getValue("cur");
        String past = tag.getValue("past");
        String pp =  tag.getValue("pp");
        
        String singular = tag.getValue("singular");
        String plural = tag.getValue("plural");
        String present = tag.getValue("present");
        String noun = tag.getValue("noun");
        String adj = tag.getValue("adj");
        String adv = tag.getValue("adv");
        
        ((KeyBoxController)(t1.getUserData())).setText(cur);
        ((KeyBoxController)(t2.getUserData())).setText(past);
        ((KeyBoxController)(t3.getUserData())).setText(pp);
        ((KeyBoxController)(t4.getUserData())).setText(singular);
        ((KeyBoxController)(t5.getUserData())).setText(plural);
        ((KeyBoxController)(t6.getUserData())).setText(present);
        ((KeyBoxController)(t7.getUserData())).setText(noun);
        ((KeyBoxController)(t8.getUserData())).setText(adj);
        ((KeyBoxController)(t9.getUserData())).setText(adv);
        
        Stage stage = new Stage();
        stage.setTitle("단어 변화 형태 수정");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.widthProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                setAutoSize(newValue.doubleValue()/2.0);
        });
        
        stage.showAndWait();
   
        stage.setScene(null);
        stage = null;
        WinUtils.memFree();
    }
    
    private void clear(){
        ((KeyBoxController)(t1.getUserData())).clear();
        ((KeyBoxController)(t2.getUserData())).clear();
        ((KeyBoxController)(t3.getUserData())).clear();
        ((KeyBoxController)(t4.getUserData())).clear();
        ((KeyBoxController)(t5.getUserData())).clear();
        ((KeyBoxController)(t6.getUserData())).clear();
        ((KeyBoxController)(t7.getUserData())).clear();
        ((KeyBoxController)(t8.getUserData())).clear();
        ((KeyBoxController)(t9.getUserData())).clear();
    }
}
