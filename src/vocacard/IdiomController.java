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
public class IdiomController implements Dlgable, Initializable {
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
    private Pane v1;
    @FXML
    private Pane p1;
    @FXML
    private Pane p2;
    
    Parent k1, k2;
    BoxView boxes;
    @FXML
    private BorderPane root;

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
            
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k2 = fx2.load();
            KeyBoxController keycon2 = (KeyBoxController) fx2.getController();
            k2.setUserData(keycon2);
            p2.getChildren().add(k2);
            keycon2.setInitialLang(VocaCard.toLang);
            keycon2.setAutoSize(p1);
            
            fx1 = null;
            fx2 = null;
            
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
        String res = "<IDIOMDATA TEXT=\"%s\" MEANING=\"%s\" />";
        
        String s1 = ((KeyBoxController)(k1.getUserData())).getText();
        String s2 = ((KeyBoxController)(k2.getUserData())).getText();
        res = String.format(res, s1, s2);
        
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

    @Override
    public void showAddDlg() {
        Stage stage = new Stage();
        stage.setTitle("새 숙어 추가");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.widthProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                setAutoSize(newValue.doubleValue());
        });
                
        c0.setText("숙어 추가");
        c1.setText("숙어를 추가합니다.");
        btnadd.setText("내용 추가");
       
        stage.showAndWait();
   
        stage.setScene(null);
        stage = null;
        WinUtils.memFree();
    }

    @Override
    public void showModifyDlg(Boxable tag) {
        if (!tag.isContains("<IDIOMDATA TYPE=\"", " />"))
            return;
        
        c0.setText("숙어 수정");
        c1.setText("숙어를 수정합니다.");
        btnadd.setText("내용 수정");
        btnclear.setVisible(false);
        
        String text = tag.getValue("text");
        
        String meaning = tag.getValue("meaning");
                
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

    @Override
    public void setAutoSize(double halfw) {
        v1.setPrefWidth(halfw);
        
        p1.setPrefWidth(halfw-30);
        p2.setPrefWidth(halfw-30);
        
        ((KeyBoxController)(k1.getUserData())).setAutoSize(p1);
        ((KeyBoxController)(k2.getUserData())).setAutoSize(p2);
    }
   
    private void clear(){
        ((KeyBoxController)(k1.getUserData())).clear();
        ((KeyBoxController)(k2.getUserData())).clear();
    }
}
