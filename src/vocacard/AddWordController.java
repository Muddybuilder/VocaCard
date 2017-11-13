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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
public class AddWordController implements Initializable {
    @FXML
    private CheckBox usepart;
    @FXML
    private AnchorPane partpane;
    @FXML
    private ComboBox<String> part;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnclear;
    @FXML
    private Button btncancel;
    @FXML
    private Pane s1;
    @FXML
    private Pane s2;
    @FXML
    private Pane pane;
    @FXML
    private Label lbltitle;
    @FXML
    private Label lblsubtitle;
    @FXML
    private Label lbl0;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl1;
    
    BorderPane p1, p2;
    KeyBoxFXMLController p1con, p2con;
    
    ListView lv;
    @FXML
    private Label s1err;
    @FXML
    private Label s2err;
    @FXML
    private Label s0err;
    
    int errcnt = 0;
    
    boolean isAdd = true;
    
    SearchPaneFXMLController searchpane;
    @FXML
    private Pane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WinUtils.setAutoDPI(root);
        try{
            s0err.setVisible(false);
            s1err.setVisible(false);
            s2err.setVisible(false);
            
            usepart.setSelected(true);
            
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("KeyBoxFXML.fxml"));
            p1 = (BorderPane) fx1.load();
            p1con = (KeyBoxFXMLController) fx1.getController();
            s1.getChildren().add(p1);
            p1con.setSize(s1.getPrefWidth());
            
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("KeyBoxFXML.fxml"));
            p2 = (BorderPane) fx2.load();
            p2con = (KeyBoxFXMLController) fx2.getController();
            s2.getChildren().add(p2);
            p2con.setSize(s2.getPrefWidth());
            
            p1con.setError(false, s1err);
            p2con.setError(false, s2err);
                        
            part.getEditor().setOnKeyPressed((event)->{
                String code = event.getCode().toString();
                
                switch(code){
                    case "TAB":
                        p1con.getTextField().requestFocus();
                        event.consume();
                        
                        break;
                }
            });
            
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
                        if (usepart.isSelected())
                            part.getEditor().requestFocus();
                        else
                            p1con.getTextField().requestFocus();
                        
                        event.consume();
                        
                        break;
                }
            });
            
            part.getItems().addAll("명사", "대명사", "동사", "수사", "조사", "형용사", "관형사", "부사", "접속사", "전치사", "감탄사");
            
            //errCheck();
            
            part.getEditor().textProperty().addListener((event)->{
                if (part.getEditor().getText().length() > 0){
                    part.getEditor().setStyle("");
                    s0err.setVisible(false);
                }
            });
            
            p1con.getTextField().textProperty().addListener((event)->{
                if (p1con.getText().length() > 0){
                    p1con.setError(false);
                    s1err.setVisible(false);
                }
            });
            
            p2con.getTextField().textProperty().addListener((event)->{
                p2con.setError(false);
                s2err.setVisible(false);
            });
            
            ((Node)part).getScene().getWindow().setHeight(540);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void setAddMode(){
        lbltitle.setText("뜻/동의어 추가");
        lblsubtitle.setText("뜻/동의어를 추가합니다.");
        lbl0.setText("추가할 뜻의 품사 :  ");
        lbl1.setText("추가할 뜻 : ");
        lbl2.setText("추가할 동의어 : ");
        btnadd.setText("입력한 뜻/동의어 추가");
        
//        p1con.setInitialLang(KeyList.toLang);
//        p2con.setInitialLang(KeyList.fromLang);
        
        isAdd = true;
        
        btnclear.setVisible(true);
        
        s0err.setVisible(false);
        s1err.setVisible(false);
        s2err.setVisible(false);

        p1con.setError(false);
        p2con.setError(false);
        
        p2con.clear();
        p1con.clear();
        part.getEditor().setText("");
        
        if (usepart.isSelected()){
            part.getEditor().requestFocus();
        }        
        else
            p1con.getTextField().requestFocus();
    }
     
    public void setModifyMode(String s1, String s2, String s3){
        lbltitle.setText("뜻/동의어 수정");
        lblsubtitle.setText("선택된 뜻/동의어를 수정합니다.");
        lbl0.setText("수정할 뜻의 품사 : ");
        lbl1.setText("수정할 뜻 : ");
        lbl2.setText("수정할 동의어 : ");
        btnadd.setText("입력한 뜻/동의어로 수정");
        
//        p1con.setInitialLang(KeyList.toLang);
//        p2con.setInitialLang(KeyList.fromLang);
        
        btnclear.setVisible(false);
        
        isAdd = false;
        
        s0err.setVisible(false);
        s1err.setVisible(false);
        s2err.setVisible(false);

        p1con.setError(false);
        p2con.setError(false);
        
        p1con.setText(s2);
        part.getEditor().setText(s1);
        usepart.setSelected((s1.length() > 0));
        p2con.setText(s3);
    }
    
    public void setListView(ListView lv){
        this.lv = lv;
    }
    
    public void setFirstFocus(){
        if (usepart.isSelected()){
            part.getEditor().requestFocus();
        }        
        else
            p1con.getTextField().requestFocus();
    }

    @FXML
    private void Onclick(ActionEvent event) {
        partpane.setVisible(usepart.isSelected());
        
        if (!usepart.isSelected()){
            pane.setLayoutY(usepart.getLayoutY() + 25);
            ((Node)event.getSource()).getScene().getWindow().setHeight(540-partpane.getHeight());
        }
        else{
            pane.setLayoutY(169);
            ((Node)event.getSource()).getScene().getWindow().setHeight(540);
        }
    }

    @FXML
    private void OnClear(ActionEvent event) {
        part.getEditor().clear();
        p1con.clear();
        p2con.clear();
    }

    @FXML
    private void OnCancel(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    private void errCheck(){
        errcnt = 0;
        part.getEditor().setStyle("");
            
        s0err.setVisible(false);
        s1err.setVisible(false);
        s2err.setVisible(false);

        p1con.setError(false);
        p2con.setError(false);

        if (usepart.isSelected() && part.getEditor().getText().length() == 0){

            part.getEditor().setStyle("-fx-background-color: red,\n"
                    + "        linear-gradient(\n"
                    + "        to bottom,\n"
                    + "        derive(red,70%) 5%,\n"
                    + "        derive(red,90%) 40%\n"
                    + "        );");

            s0err.setText("'품사 사용' 체크시에는 품사를 입력 또는 선택해야 합니다!");
            s0err.setVisible(true);
            errcnt++;
        }

        if (p1con.getText().length() == 0){
            p1con.setError(true);
            s1err.setText("단어 뜻은 필수로 입력해야 합니다!");
            s1err.setVisible(true);
            errcnt++;
        }
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

                    if (usepart.isSelected())
                        box.setData(part.getEditor().getText(), p1con.getText(), p2con.getText());
                    else
                        box.setData("", p1con.getText(), p2con.getText());
                    
                    box.setSearchPane(searchpane);

                    one.setUserData(box);

                    lv.getItems().add(one);

                    part.getEditor().clear();
                    p1con.clear();
                    p2con.clear();
                    
                    searchpane.updateChecking();
                    lv.scrollTo(lv.getItems().size()-1);
                    
                    setFirstFocus();
                }
                else{
                    AnchorPane pn = (AnchorPane) lv.getItems().get(lv.getSelectionModel().getSelectedIndex());
                    ExBoxController box = (ExBoxController) pn.getUserData();
                    
                    box.setSearchPane(searchpane);

                    if (usepart.isSelected())
                        box.setData(part.getEditor().getText(), p1con.getText(), p2con.getText());
                    else
                        box.setData("", p1con.getText(), p2con.getText());
                    
                    ((Node)event.getSource()).getScene().getWindow().hide();
                }
            }
        }
        catch(Exception ex){
        }
    }
    
    public void setSearchPane(SearchPaneFXMLController conpane){
        this.searchpane = conpane;
    }
}
