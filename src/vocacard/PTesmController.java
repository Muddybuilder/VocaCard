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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PTesmController implements Dlgable, Initializable {
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
    private Pane vbox1;
    @FXML
    private ComboBox<String> p0;
    @FXML
    private Pane p1;
    @FXML
    private Pane p2;
    @FXML
    private Pane p3;
    @FXML
    private Pane p4;
    @FXML
    private Pane p5;
    @FXML
    private Pane p6;
    @FXML
    private BorderPane root;
    
    Parent k1, k2, k3, k4, k5, k6;
    @FXML
    private Label c0;
    @FXML
    private Label c2;
    @FXML
    private Label c3;
    @FXML
    private Label c4;
    
    BoxView boxes;
    boolean isMeaning = true;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Pane vbox2;
    @FXML
    private HBox hb;
    @FXML
    private VBox vb1;
    @FXML
    private VBox vb2;
    @FXML
    private Label lbl0;
    @FXML
    private Label lbl1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k1 = fx1.load();            
            KeyBoxController keycon = (KeyBoxController) fx1.getController();
            k1.setUserData(keycon);
            p1.getChildren().add(k1);
            keycon.setAutoSize(p1);
                                    
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k2 = fx2.load();
            KeyBoxController keycon1 = (KeyBoxController) fx2.getController();
            k2.setUserData(keycon1);
            p2.getChildren().add(k2);
            keycon1.setAutoSize(p2);
                                    
            FXMLLoader fx3 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k3 = fx3.load();
            KeyBoxController keycon2 = (KeyBoxController) fx3.getController();
            k3.setUserData(keycon2);
            p3.getChildren().add(k3);
            keycon2.setAutoSize(p3);
            
            FXMLLoader fx4 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k4 = fx4.load();            
            KeyBoxController keycon3 = (KeyBoxController) fx4.getController();
            k4.setUserData(keycon3);
            p4.getChildren().add(k4);
            keycon3.setAutoSize(p4);
            
            FXMLLoader fx5 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k5 = fx5.load();            
            KeyBoxController keycon4 = (KeyBoxController) fx5.getController();
            k5.setUserData(keycon4);
            p5.getChildren().add(k5);
            keycon4.setAutoSize(p5);
            
            FXMLLoader fx6 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k6 = fx6.load();            
            KeyBoxController keycon5 = (KeyBoxController) fx6.getController();
            k6.setUserData(keycon5);
            p6.getChildren().add(k6);            
            keycon5.setAutoSize(p6);
            
            p1.toFront();
            p2.toFront();
            p3.toFront();
            p4.toFront();          
            
            p5.toFront();
            p6.toFront();
            
            k1.setOnMouseReleased((e)->{           
                if (!keycon.isExpanded()){
                    p1.toFront();
                    p2.toFront();
                    p3.toFront();
                    p4.toFront();
                }
                else{                    
                    p4.toFront();
                    p3.toFront();
                    p2.toFront();
                    p1.toFront();
                   
                }
            });
            
            k2.setOnMouseReleased((e)->{                         
                if (!keycon1.isExpanded()){
                    p1.toFront();
                    p2.toFront();
                    p3.toFront();
                    p4.toFront();
                }
                else{
                    p4.toFront();
                    p3.toFront();
                    p2.toFront();
                    p1.toFront();
                    
                    p2.toFront();                   
                }
//                p2.setPrefHeight(-1);
            });
            
            k3.setOnMouseReleased((e)->{                         
                if (!keycon2.isExpanded()){
                    p1.toFront();
                    p2.toFront();
                    p3.toFront();
                    p4.toFront();
                }
                else{                    
                    p4.toFront();
                    p3.toFront();
                    p2.toFront();
                    p1.toFront();
                    
                    p3.toFront();                   
                }
//                p3.setPrefHeight(-1);
            });
            
            k4.setOnMouseReleased((e)->{                         
                if (!keycon3.isExpanded()){
                    p1.toFront();
                    p2.toFront();
                    p3.toFront();
                    p4.toFront();
                }
                else{
                    p4.toFront();
                    p3.toFront();
                    p2.toFront();
                    p1.toFront();
                    
                    p4.toFront();                                     
                }
//                p4.setPrefHeight(-1);
            });
            
            k5.setOnMouseReleased((e)->{                         
                if (!keycon4.isExpanded()){
                    p5.toFront();
                    p6.toFront();
                }
                else{        
                    p6.toFront();
                    p5.toFront();
                }
//                p4.setPrefHeight(-1);
            });
            
             k6.setOnMouseReleased((e)->{                         
                if (!keycon4.isExpanded()){
                    p5.toFront();
                    p6.toFront();
                }
                else{        
                    p6.toFront();
                    p5.toFront();
                    
                    p6.toFront();
                }
//                p4.setPrefHeight(-1);
            });
             
            //ex disable
            isMeaning = true;
            btn1.setStyle("-fx-effect: innershadow(three-pass-box , black, 10, 0.1 , 0 , 0); -fx-base: grey;");
            btn2.setStyle("-fx-base: grey;");

            vbox1.setDisable(false);
            p0.setDisable(false);        
            ((KeyBoxController)(k1.getUserData())).setDisable(false);
            ((KeyBoxController)(k2.getUserData())).setDisable(false);
            ((KeyBoxController)(k3.getUserData())).setDisable(false);
            ((KeyBoxController)(k4.getUserData())).setDisable(false);

            vbox2.setDisable(true);
            ((KeyBoxController)(k5.getUserData())).setDisable(true);
            ((KeyBoxController)(k6.getUserData())).setDisable(true);
            
            p0.getItems().addAll("명사", "대명사", "동사", "수사", "조사", "형용사", "관형사", "부사", "접속사", "전치사", "감탄사");
        }
        catch(Exception ex){
        }
    }

    @FXML
    private void OnHelp(ActionEvent event) {
    }
    
    @Override
    public void setAutoSize(double halfw){
        btn1.setPrefWidth(halfw);
        btn2.setPrefWidth(halfw);
        
        vb1.setPrefWidth(halfw);
        vb2.setPrefWidth(halfw);
        hb.setPrefWidth(halfw);
        
        p0.setPrefWidth(halfw-30);
        p1.setPrefWidth(halfw-30);
        p2.setPrefWidth(halfw-30);
        p3.setPrefWidth(halfw-30);
        p4.setPrefWidth(halfw-30);
        p5.setPrefWidth(halfw-30);
        p6.setPrefWidth(halfw-30);
        
        lbl0.setPrefWidth(halfw-30);
        lbl1.setPrefWidth(halfw-50);

        ((KeyBoxController)(k1.getUserData())).setAutoSize(p1);
        ((KeyBoxController)(k2.getUserData())).setAutoSize(p2);
        ((KeyBoxController)(k3.getUserData())).setAutoSize(p3);
        ((KeyBoxController)(k4.getUserData())).setAutoSize(p4);
        ((KeyBoxController)(k5.getUserData())).setAutoSize(p5);
        ((KeyBoxController)(k6.getUserData())).setAutoSize(p6);
    }

    @Override
    public void showAddDlg() {
        Stage stage = new Stage();
        stage.setTitle("새 뜻/동의어/예문 추가");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.widthProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                setAutoSize(newValue.doubleValue()/2.0);
        });
                
        c0.setText("뜻/동의어/예문 추가");
        c1.setText("뜻/동의어/예문을 추가합니다.");
        c2.setText("추가할 뜻의 품사 (선택) : ");
        c3.setText("추가할 뜻 (필수) : ");
        btnadd.setText("내용 추가");
       
        stage.showAndWait();
   
        stage.setScene(null);
        stage = null;
        WinUtils.memFree();
    }

    @Override
    public void showModifyDlg(Boxable tag) {
        if (!tag.isContains("<PTESMDATA TYPE=\"", " />"))
            return;
        
        c0.setText("뜻/동의어/예문 수정");
        c1.setText("뜻/동의어/예문을 수정합니다.");
        c2.setText("수정할 뜻의 품사 (선택) : ");
        c3.setText("수정할 뜻 (필수) : ");
        btnadd.setText("내용 수정");
        
        String type = tag.getValue("type");
        
        if (type.equals("PSM")){
            String cls = tag.getValue("class");
            String mean = tag.getValue("meaning");
            String syn = tag.getValue("synonym");
            String ex = tag.getValue("ex");
            String tex = tag.getValue("tex");
            
            onMeanClick();

            p0.getEditor().setText(cls);            
            ((KeyBoxController)(k1.getUserData())).setText(mean);
            ((KeyBoxController)(k2.getUserData())).setText(syn);
            ((KeyBoxController)(k3.getUserData())).setText(ex);
            ((KeyBoxController)(k4.getUserData())).setText(tex);
        }
        else if (type.equals("TEX")){
            String ex = tag.getValue("ex");
            String tex = tag.getValue("tex");
            
            onExClick();
            
            ((KeyBoxController)(k5.getUserData())).setText(ex);
            ((KeyBoxController)(k6.getUserData())).setText(tex);
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

    @FXML
    private void onClear(ActionEvent event) {
        clear();
    }

    @FXML
    private void onAdd(ActionEvent event) {
        String res = "";
        if (isMeaning){
            String s0 = p0.getEditor().getText();
            String s1 = ((KeyBoxController)(k1.getUserData())).getText();
            ((KeyBoxController)(k1.getUserData())).setError(false);
            
            if (s1.length() == 0){
                ((KeyBoxController)(k1.getUserData())).setError("뜻을 필수로 입력해야 합니다!");
                return;
            }
            
            String s2 = ((KeyBoxController)(k2.getUserData())).getText();
            String s3 = ((KeyBoxController)(k3.getUserData())).getText();
            String s4 = ((KeyBoxController)(k4.getUserData())).getText();
            
            res = "<PTESMDATA TYPE=\"PSM\" CLASS=\"%s\" MEANING=\"%s\" SYNONYM=\"%s\" EX=\"%s\" TEX=\"%s\" />";
            res = String.format(res, s0, s1, s2, s3, s4);              
        }
        else{
            String s5 = ((KeyBoxController)(k5.getUserData())).getText();
            ((KeyBoxController)(k5.getUserData())).setError(false);
            
            if (s5.length() == 0){
                ((KeyBoxController)(k5.getUserData())).setError("단독 예문을 필수로 입력해야 합니다!");
                return;
            }
            String s6 = ((KeyBoxController)(k6.getUserData())).getText();
            
            res = "<PTESMDATA TYPE=\"TEX\" EX=\"%s\" TEX=\"%s\" />";
            res = String.format(res, s5, s6);
        }
        
        int pos = 0;
        while((pos = res.indexOf("=\"\"")) >= 0){
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos+3);
            res = res.replace(posarr, "");
        }
        
        boxes.addItem(res);
        
        clear();
        
        res = null;
        WinUtils.memFree();
    }

    @FXML
    private void onCancel(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
        WinUtils.memFree();
    }    

    @Override
    public void setBoxView(BoxView boxes) {
        this.boxes = boxes;
    }

    @FXML
    private void onMeaning(ActionEvent event) {
        onMeanClick();
    }

    @FXML
    private void onEx(ActionEvent event) {
        onExClick();
    }
    
    public void clear(){
        p0.getEditor().clear();
        
        ((KeyBoxController)(k1.getUserData())).clear();
        ((KeyBoxController)(k2.getUserData())).clear();
        ((KeyBoxController)(k3.getUserData())).clear();
        ((KeyBoxController)(k4.getUserData())).clear();
        
        ((KeyBoxController)(k5.getUserData())).clear();
        ((KeyBoxController)(k6.getUserData())).clear();
    }
    
    private void onExClick(){
        isMeaning = false;
        
        btn2.setStyle("-fx-effect: innershadow(three-pass-box , black, 10, 0.1 , 0 , 0);  -fx-base: grey;");
        btn1.setStyle("-fx-base: grey;");
        
        
        vbox1.setDisable(true);
        p0.setDisable(true);        
        ((KeyBoxController)(k1.getUserData())).setDisable(true);
        ((KeyBoxController)(k2.getUserData())).setDisable(true);
        ((KeyBoxController)(k3.getUserData())).setDisable(true);
        ((KeyBoxController)(k4.getUserData())).setDisable(true);
        
        vbox2.setDisable(false);
        ((KeyBoxController)(k5.getUserData())).setDisable(false);
        ((KeyBoxController)(k6.getUserData())).setDisable(false);
        
        ((KeyBoxController)(k5.getUserData())).setError(false);
    }
    
    private void onMeanClick(){
        isMeaning = true;
        btn1.setStyle("-fx-effect: innershadow(three-pass-box , black, 10, 0.1 , 0 , 0); -fx-base: grey;");
        btn2.setStyle("-fx-base: grey;");
        
        vbox1.setDisable(false);
        p0.setDisable(false);        
        ((KeyBoxController)(k1.getUserData())).setDisable(false);
        ((KeyBoxController)(k2.getUserData())).setDisable(false);
        ((KeyBoxController)(k3.getUserData())).setDisable(false);
        ((KeyBoxController)(k4.getUserData())).setDisable(false);
        
        ((KeyBoxController)(k1.getUserData())).setError(false);
        
        vbox2.setDisable(true);
        ((KeyBoxController)(k5.getUserData())).setDisable(true);
        ((KeyBoxController)(k6.getUserData())).setDisable(true);
    }
}
