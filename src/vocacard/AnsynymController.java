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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class AnsynymController implements Dlgable, Initializable {
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
    private Pane pane1;
    @FXML
    private Pane p1;
    @FXML
    private ComboBox<String> p2;
    @FXML
    private Pane p3;
    @FXML
    private Button btn1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane p4;
    @FXML
    private ComboBox<String> p5;
    @FXML
    private Pane p6;
    @FXML
    private Button btn2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane p7;
    @FXML
    private Pane p8;
    
    Parent k1, k3, k4, k6, k7, k8;
    @FXML
    private Pane pane11;
    @FXML
    private Pane pane22;
    
    BoxView boxes;
    
    boolean isAny = false;
    @FXML
    private BorderPane root;
    @FXML
    private Label c0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k1 = fx1.load();            
            KeyBoxController keycon1 = (KeyBoxController) fx1.getController();
            k1.setUserData(keycon1);
            p1.getChildren().add(k1);
            keycon1.setInitialLang(VocaCard.fromLang);
            keycon1.setAutoSize(p1);
            
            FXMLLoader fx3 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k3 = fx3.load();            
            KeyBoxController keycon3 = (KeyBoxController) fx3.getController();
            k3.setUserData(keycon3);
            p3.getChildren().add(k3);
            keycon3.setInitialLang(VocaCard.toLang);
            keycon3.setAutoSize(p3);
            
            FXMLLoader fx4 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k4 = fx4.load();            
            KeyBoxController keycon4 = (KeyBoxController) fx4.getController();
            k4.setUserData(keycon4);
            p4.getChildren().add(k4);
            keycon4.setAutoSize(p4);
            keycon4.setInitialLang(VocaCard.fromLang);
            
            FXMLLoader fx6 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k6 = fx6.load();            
            KeyBoxController keycon6 = (KeyBoxController) fx6.getController();
            k6.setUserData(keycon6);
            p6.getChildren().add(k6);
            keycon6.setAutoSize(p6);
            keycon6.setInitialLang(VocaCard.toLang);
            
            FXMLLoader fx7 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k7 = fx7.load();            
            KeyBoxController keycon7 = (KeyBoxController) fx7.getController();
            k7.setUserData(keycon7);
            p7.getChildren().add(k7);
            keycon7.setAutoSize(p7);
            keycon7.setInitialLang(VocaCard.fromLang);
            
            FXMLLoader fx8 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k8 = fx8.load();            
            KeyBoxController keycon8 = (KeyBoxController) fx8.getController();
            k8.setUserData(keycon8);
            p8.getChildren().add(k8);
            keycon8.setAutoSize(p8);
            keycon8.setInitialLang(VocaCard.toLang);
            
            fx1 = null;
            fx3 = null;
            fx4 = null;
            fx7 = null;
            fx8 = null;
            
            WinUtils.memFree();
        }
        catch(Exception ex){
        }
    }
    
    @Override
    public void setAutoSize(double halfw){
        pane1.setPrefWidth(halfw);
        pane11.setPrefWidth(halfw);
        btn1.setPrefWidth(halfw-28);
        
        p1.setPrefWidth(halfw-30);
        p2.setPrefWidth(halfw-30);
        p3.setPrefWidth(halfw-30);
        
        ///////
        pane2.setPrefWidth(halfw);
        pane22.setPrefWidth(halfw);
        btn2.setPrefWidth(halfw-28);
        
        p4.setPrefWidth(halfw-30);
        p5.setPrefWidth(halfw-30);
        p6.setPrefWidth(halfw-30);
        
        ///////
        pane3.setPrefWidth(halfw*2);
        p7.setPrefWidth(halfw*2-30);
        p8.setPrefWidth(halfw*2-30);
        
        ((KeyBoxController)(k1.getUserData())).setAutoSize(p1);
        ((KeyBoxController)(k3.getUserData())).setAutoSize(p3);
        ((KeyBoxController)(k4.getUserData())).setAutoSize(p4);
        ((KeyBoxController)(k6.getUserData())).setAutoSize(p6);
        ((KeyBoxController)(k7.getUserData())).setAutoSize(p7);
        ((KeyBoxController)(k8.getUserData())).setAutoSize(p8);
    }

    @FXML
    private void OnHelp(ActionEvent event) {
    }
    
    private void onSymClick(){
        isAny = false;
        
        btn1.setStyle("-fx-effect: innershadow(three-pass-box , black, 10, 0.1 , 0 , 0);  -fx-base: grey;");      
        btn2.setStyle("-fx-base: grey;");
        
        pane11.setDisable(false);
        ((KeyBoxController)(k1.getUserData())).setDisable(false);
        p2.setDisable(false);
        ((KeyBoxController)(k3.getUserData())).setDisable(false);
        
        pane22.setDisable(true);
        ((KeyBoxController)(k4.getUserData())).setDisable(true);
        p5.setDisable(true);
        ((KeyBoxController)(k6.getUserData())).setDisable(true);
    }
    
    private void onAnyClick(){
        isAny = true;
        
        btn1.setStyle("-fx-base: grey;");
        btn2.setStyle("-fx-effect: innershadow(three-pass-box , black, 10, 0.1 , 0 , 0);  -fx-base: grey;");      
        
        pane11.setDisable(true);
        ((KeyBoxController)(k1.getUserData())).setDisable(true);
        p2.setDisable(true);
        ((KeyBoxController)(k3.getUserData())).setDisable(true);
        
        pane22.setDisable(false);
        ((KeyBoxController)(k4.getUserData())).setDisable(false);
        p5.setDisable(false);
        ((KeyBoxController)(k6.getUserData())).setDisable(false);
    }

    @FXML
    private void onToggle(ActionEvent event) {        
        if (event.getSource().equals(btn1)){
            onSymClick();
        }
        else if (event.getSource().equals(btn2)){
            onAnyClick();
        }
    }    

    @Override
    public void setBoxView(BoxView boxes) {
        this.boxes = boxes;
    }

    @Override
    public void showAddDlg() {
        Stage stage = new Stage();
        stage.setTitle("새 유의어/반의어 추가");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.widthProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                setAutoSize(newValue.doubleValue()/2.0);
        });
                
        c0.setText("유의어/반의어 추가");
        c1.setText("뜻/동의어/예문을 추가합니다.");
        btnadd.setText("내용 추가");
        btnclear.setVisible(true);
       
        stage.showAndWait();
   
        stage.setScene(null);
        stage = null;
        WinUtils.memFree();
    }

    @Override
    public void showModifyDlg(Boxable tag) {
        if (!tag.isContains("<ANSYNYM TYPE=\"", " />"))
            return;
        
        c0.setText("유의어/반의어 수정");
        c1.setText("유의어/반의어를 수정합니다.");
        btnadd.setText("내용 수정");
        btnclear.setVisible(false);
        
        String type = tag.getValue("type");
        if (type.equals("SY")){
            String text = tag.getValue("text");
            String cls = tag.getValue("class");
            String meaning = tag.getValue("meaning");
            String ex = tag.getValue("ex");
            String tex = tag.getValue("tex");
            
            ((KeyBoxController)(k1.getUserData())).setText(text);
            p2.getEditor().setText(cls);
            ((KeyBoxController)(k3.getUserData())).setText(meaning);            
            ((KeyBoxController)(k7.getUserData())).setText(ex);
            ((KeyBoxController)(k8.getUserData())).setText(tex);
        }
        else if (type.equals("AY")){
            String text = tag.getValue("text");
            String cls = tag.getValue("class");
            String meaning = tag.getValue("meaning");
            String ex = tag.getValue("ex");
            String tex = tag.getValue("tex");
            
            ((KeyBoxController)(k4.getUserData())).setText(text);
            p5.getEditor().setText(cls);
            ((KeyBoxController)(k6.getUserData())).setText(meaning);            
            ((KeyBoxController)(k7.getUserData())).setText(ex);
            ((KeyBoxController)(k8.getUserData())).setText(tex);
        }        
        
        Stage stage = new Stage();
        stage.setTitle("뜻/동의어/예문 수정");
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
    
    public void clear(){
        ((KeyBoxController)(k1.getUserData())).clear();
        p2.getEditor().clear();
        ((KeyBoxController)(k3.getUserData())).clear();
        ((KeyBoxController)(k4.getUserData())).clear();
        p5.getEditor().clear();
        ((KeyBoxController)(k6.getUserData())).clear();
        ((KeyBoxController)(k7.getUserData())).clear();
        ((KeyBoxController)(k8.getUserData())).clear();
    }

    @FXML
    private void onClear(ActionEvent event) {
        clear();
    }

    @FXML
    private void onAdd(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) {
    }
}
