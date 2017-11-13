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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Example_Sentence_AddController implements Initializable {
    @FXML
    private Label lbltitle;
    @FXML
    private Label lblsubtitle;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl0;
    @FXML
    private Pane expane;
    @FXML
    private Pane texpane;
    @FXML
    private Button btnadd;
    @FXML
    private Button btncancel;
    @FXML
    private Button btnclear;
    
    BorderPane p1, p2;
    KeyBoxFXMLController p1con, p2con;
    @FXML
    private Label s0err;
    @FXML
    private Label s1err;
    ListView lv;
    
    boolean isAdd = true;
    
    int errcnt = 0;
    SearchPaneFXMLController searchpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            s0err.setVisible(false);
            s1err.setVisible(false);
            
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("KeyBoxFXML.fxml"));
            p1 = (BorderPane) fx1.load();
            p1con = (KeyBoxFXMLController) fx1.getController();
            expane.getChildren().add(p1);
           
            p1con.setSize(expane.getPrefWidth());
            p1con.setError(false, s0err);
            
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("KeyBoxFXML.fxml"));
            p2 = (BorderPane) fx2.load();
            p2con = (KeyBoxFXMLController) fx2.getController();
            texpane.getChildren().add(p2);
            
            p2con.setSize(texpane.getPrefWidth());
            p2con.setError(false, s1err);
            
            p1con.getTextField().setOnKeyPressed((event)->{
                String code = event.getCode().toString();
                
                switch(code){
                    case "TAB":
                        p2con.getTextField().requestFocus();
                        event.consume();
                        
                        break;
                }
            });
            
            p2con.getTextField().setOnKeyPressed((event)->{
                String code = event.getCode().toString();
                
                switch(code){
                    case "TAB":
                        p1con.getTextField().requestFocus();
                        event.consume();
                        
                        break;
                }
            });
            
            p1con.getTextField().textProperty().addListener((event)->{
                if (p1con.getText().length() > 0){
                    p1con.setError(false);
                    s0err.setVisible(false);
                }
            });
            
            p2con.getTextField().textProperty().addListener((event)->{
                p2con.setError(false);
                s1err.setVisible(false);
            });
            
            fx1 = null;
            fx2 = null;
            
            WinUtils.memFree();
        }
        catch(Exception ex){
        }
    }
    
    public void setAddMode(){
        lbltitle.setText("예문/예문 해석 추가");
        lblsubtitle.setText("예문/예문 해석을 추가합니다.");
        lbl0.setText("추가할 예문 :  ");
        lbl1.setText("추가할 예문 해석 : ");
        btnadd.setText("입력한 예문/예문 해석 추가");
        
//        p1con.setInitialLang(KeyList.fromLang);
//        p2con.setInitialLang(KeyList.toLang);
        
        btnclear.setVisible(true);
        
        s0err.setVisible(false);
        s1err.setVisible(false);

        p1con.setError(false);
        p2con.setError(false);
        
        isAdd = true;
        
        p1con.clear();
        p2con.clear();
        
        p1con.getTextField().requestFocus();
        
        WinUtils.memFree();
    }
    
    public void setModifyMode(String s1, String s2){
        lbltitle.setText("예문/예문 해석 수정");
        lblsubtitle.setText("선택된 예문/예문 해석을 수정합니다.");
        lbl0.setText("수정할 예문 ");
        lbl1.setText("수정할 예문 해석 : ");
        btnadd.setText("입력한 예문/예문 해석으로 수정");
        
//        p1con.setInitialLang(KeyList.fromLang);
//        p2con.setInitialLang(KeyList.toLang);
        
        btnclear.setVisible(false);
        
        isAdd = false;
        
        s0err.setVisible(false);
        s1err.setVisible(false);

        p1con.setError(false);
        p2con.setError(false);
        
        p1con.setText(s1);
        p2con.setText(s2);
        
        p1con.getTextField().requestFocus();
        
        WinUtils.memFree();
    }
    
    private void errCheck(){
        errcnt = 0;
            
        s0err.setVisible(false);
        s1err.setVisible(false);

        p1con.setError(false);
        p2con.setError(false);

        if (p1con.getText().length() == 0){
            p1con.setError(true);
            s0err.setText("단어 예문은 필수로 입력해야 합니다!");
            s0err.setVisible(true);
            errcnt++;
        }
        
        WinUtils.memFree();
    }
    
    public void setListView(ListView lv){
        this.lv = lv;
    }
    
    public void setFirstFocus(){
        p1con.getTextField().requestFocus();
    }

    @FXML
    private void OnAdd(ActionEvent event) {
        try{
            errCheck();

            if (errcnt == 0){
                if (isAdd){
                    FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("ExBox.fxml"));
                    Parent one = fx0.load();
                    ExBoxController box = (ExBoxController) fx0.getController();
                    box.setListWidth(lv.getPrefWidth()-30);

                    box.setData(p1con.getText(), p2con.getText());
                    
                    box.setSearchPane(searchpane);

                    one.setUserData(box);

                    lv.getItems().add(one);

                    p1con.clear();
                    p2con.clear();
                    
                    searchpane.updateChecking();
                    lv.scrollTo(lv.getItems().size()-1);
                    
                    setFirstFocus();
                }
                else{
                    AnchorPane pn = (AnchorPane) lv.getItems().get(lv.getSelectionModel().getSelectedIndex());
                    ExBoxController box = (ExBoxController) pn.getUserData();
                    
                    box.setData(p1con.getText(), p2con.getText());
                    
                    ((Node)event.getSource()).getScene().getWindow().hide();
                }
            }
            
            WinUtils.memFree();
        }
        catch(Exception ex){
            
        }
    }

    @FXML
    private void OnCancel(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
        WinUtils.memFree();
    }

    @FXML
    private void OnClear(ActionEvent event) {
        p1con.clear();
        p2con.clear();
        WinUtils.memFree();
    }
    
    public void setSearchPane(SearchPaneFXMLController con){
        this.searchpane = con;
    }
}
