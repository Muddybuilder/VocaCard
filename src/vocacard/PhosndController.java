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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vocacard.FileBoxController.FileType;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PhosndController implements Dlgable, Initializable {
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
    private Pane p1;
    @FXML
    private Pane p2;
    @FXML
    private Pane p3;
    
    Parent k1, k2, k3;
    BoxView boxes;
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
            keycon1.setInitialLang(VocaCard.toLang);
            keycon1.setAutoSize(p1);
            k1.setUserData(keycon1);
            p1.getChildren().add(k1);
            
//            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("IPABox.fxml"));
//            k2 = fx2.load();
//            IPABoxController keycon2 = (IPABoxController) fx1.getController();
//            keycon2.setInitialLang(VocaCard.toLang);
//            keycon2.setAutoSize(p2);
//            p2.setUserData(keycon1);
//            p2.getChildren().add(k2);            
            
            FXMLLoader fx3 = new FXMLLoader(VocaCard.class.getResource("FileBox.fxml"));
            k3 = fx3.load();
            FileBoxController keycon3 = (FileBoxController) fx3.getController();
            keycon3.setAutoSize(p3);
            keycon3.setType(FileType.SNDFILE);
            k3.setUserData(keycon3);
            p3.getChildren().add(k3);
            
            k1.setOnMouseReleased((e)->{           
                if (!keycon1.isExpanded()){
                    p1.toFront();
                    p2.toFront();
                    p3.toFront();
                }
                else{
                    p3.toFront();
                    p2.toFront();
                    p1.toFront();
                   
                }
            });
            
//            k2.setOnMouseReleased((e)->{           
//                if (!keycon2.isExpanded()){
//                    p1.toFront();
//                    p2.toFront();
//                    p3.toFront();
//                }
//                else{
//                    p3.toFront();
//                    p2.toFront();
//                    p1.toFront();
//                    
//                    p2.toFront();
//                   
//                }
//            });
            
            k3.setOnMouseReleased((e)->{           
                p1.toFront();
                p2.toFront();
                p3.toFront();
            });
            
            fx1 = null;
//            fx2 = null;
            fx3 = null;
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
        String res = "<PHOSNDDATA TEXT=\"%s\" phonetic=\"%s\" sound=\"%s\" />";
        String s1 = ((KeyBoxController)(k1.getUserData())).getText();
        ((KeyBoxController)(k1.getUserData())).setError(false);
        
        if (s1.length() == 0){
            ((KeyBoxController)(k1.getUserData())).setError("뜻을 필수로 입력해야 합니다!");
            return;
        }
        
        String s3 = ((FileBoxController)(k3.getUserData())).toBase64();
        
        res = String.format(res, s1, "", s3);
        
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
    }

    private void clear(){
        ((KeyBoxController)(k1.getUserData())).clear();
        ((FileBoxController)(k3.getUserData())).clear();
    }
    
    public void setAutoSize(double w){
        
    }
    
    @Override
    public void setBoxView(BoxView boxes) {
        this.boxes = boxes;
    }

    @Override
    public void showAddDlg() {
        Stage stage = new Stage();
        stage.setTitle("새 발음 기호/음성 추가");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.widthProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                setAutoSize(newValue.doubleValue()/2.0);
        });
                
        c0.setText("발음 기호/음성 추가");
        c1.setText("발음 기호 또는 음성 파일을 추가합니다.");
        btnadd.setText("내용 추가");
        
        clear();
       
        stage.showAndWait();
   
        stage.setScene(null);
        stage = null;
        WinUtils.memFree();
    }

    @Override
    public void showModifyDlg(Boxable tag) {
        if (!tag.isContains("<PHOSNDDATA ", " />"))
            return;
        
        c0.setText("발음 기호/음성 수정");
        c1.setText("발음 기호 또는 음성 파일을 수정합니다.");
        btnadd.setText("내용 수정");
                
        String type = tag.getValue("text");
        String pho = tag.getValue("phonetic");
        String snd = tag.getValue("sound");
        
        ((KeyBoxController)(k1.getUserData())).setText(type);
        ((KeyBoxController)(k2.getUserData())).setText(pho);
        ((KeyBoxController)(k3.getUserData())).setText(type);
                
        Stage stage = new Stage();
        stage.setTitle("발음 기호/음성 수정");
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
    
}
