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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AlertDlgController implements Initializable {
    @FXML
    private Text title;
    @FXML
    private Text msg1;
    @FXML
    private Text msg2;
    @FXML
    private ListView<AnchorPane> lv;
    @FXML
    private Button btnyes;
    @FXML
    private Button btnno;
    
    ListView<?> lvcpy;   
    boolean isWordMode;
    Stage stage;
    @FXML
    private Pane p1;
    @FXML
    private Pane p2;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WinUtils.setAutoDPI(root);
        
        lv.setOnMouseReleased((event)->{
            double sum = 0;
            for (int c=0; c<lv.getItems().size(); c++){
                AnchorPane pn = (AnchorPane) lv.getItems().get(c);
                sum += pn.getHeight();
            }
            
            if (event.getY() > sum)
                lv.getSelectionModel().clearSelection();
        });
    }
    
    public void setAlertData(boolean isWordMode, ListView<?> lv){
        WinUtils.memFree();
        this.lv.getItems().clear();
        this.lvcpy = lv;
        
        try{
            for (int c=0; c<lv.getItems().size(); c++){
                AnchorPane apane = (AnchorPane)lv.getItems().get(c);
                ExBoxController lvdata = (ExBoxController) apane.getUserData();
                
                if (lvdata.getChecked()){                
                    FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("ExBox.fxml"));
                    AnchorPane one = (AnchorPane) fx0.load();
                    ExBoxController box = (ExBoxController) fx0.getController();
                    
                    one.setUserData(box);

                    box.setListWidth(this.lv.getPrefWidth()-30);
                    
                    if (isWordMode)
                        box.setData(lvdata.part.getText(), lvdata.ex1.getText(), lvdata.ex2.getText());
                    else
                        box.setData(lvdata.ex1.getText(), lvdata.ex2.getText());

                    this.lv.getItems().add(one);
                    
                    box.setNonCheck();
                    
                    fx0 = null;
                    
                    WinUtils.memFree();
                }
            }
        }
        catch(Exception ex){
        }
        
        this.isWordMode = isWordMode;
        
        if (isWordMode){
            this.title.setText("단어 뜻/동의어 삭제 확인");
        }
        else{
            this.title.setText("단어 예문/예문 해석 삭제 확인");
        }
        
        this.msg1.setText("체크된 " + this.lv.getItems().size() + " 항목 모두를 삭제하시겠습니까?");
        this.msg2.setText("삭제할 항목 : ");
        
        WinUtils.memFree();
    }
    
    public void setStage(Stage stage){
        this.stage = stage;
       
        if (isWordMode)
            stage.setTitle("단어 뜻/동의어 삭제");
        else
            stage.setTitle("단어 예문/예문 해석 삭제");
        
        stage.widthProperty().addListener((event)->{
            p1.setPrefWidth(stage.getWidth());
            p2.setPrefWidth(stage.getWidth());
        });
        
        stage.heightProperty().addListener((event)->{
            p2.setPrefHeight(stage.getHeight() - p1.getPrefHeight());
        });
    }
    
    @FXML
    private void onYes(ActionEvent event) {
        stage.hide();
        
        boolean contains = true;
        while(contains){
            contains = false;
            for (int c=0; c<lvcpy.getItems().size(); c++){
                AnchorPane pane = (AnchorPane)lvcpy.getItems().get(c);
                ExBoxController conpane = (ExBoxController) pane.getUserData();

                if (conpane.getChecked()){
                    contains = true;
                    conpane.clear();
                    lvcpy.getItems().remove(c);
                    
                    pane = null;
                    conpane = null;
                    break;
                }
            }
        }
        
        contains = true;
        while(contains){
            contains = false;
            for (int c=0; c<lv.getItems().size(); c++){
                AnchorPane pane = (AnchorPane)lv.getItems().get(c);
                ExBoxController conpane = (ExBoxController) pane.getUserData();
                
                conpane.clear();
                lv.getItems().remove(c);
                
                pane = null;
                conpane = null;
                break;
            }
        }
        
        WinUtils.memFree();
    }

    @FXML
    private void onNo(ActionEvent event) {
        stage.hide();
    }
}