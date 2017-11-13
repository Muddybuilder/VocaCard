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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class WordDlgController implements Dlgable, Initializable {
    @FXML
    private Label c1;
    @FXML
    private Button btnhelp;
    @FXML
    private Pane namepane;
    @FXML
    private Pane meanpane;
    @FXML
    private Pane pane;
    @FXML
    private Pane p0;
    @FXML
    private Button btnsel;
    @FXML
    private Pane selector;
    @FXML
    private Button s1;
    @FXML
    private Button s2;
    @FXML
    private Button s3;
    @FXML
    private Button s4;
    @FXML
    private Button s5;
    @FXML
    private Pane h1;
    @FXML
    private Pane h2;
    @FXML
    private SVGPath arrow;
    @FXML
    private VBox sv;
    @FXML
    private Label sl1;
    @FXML
    private Label sl2;
    @FXML
    private Label sl3;
    @FXML
    private Label sl4;
    @FXML
    private Label sl5;
    
    Parent k1, k2, k3, k4, k5, k6, k7, k8;
    @FXML
    private BorderPane root;
    @FXML
    private Button btndic;
    @FXML
    private HBox hbox;
    @FXML
    private Pane selpane;
    
    BoxView boxes;
    @FXML
    private Button btnclear;
    @FXML
    private Button btnpreview;
    @FXML
    private Button btnadd;
    @FXML
    private Button btncancel;
    @FXML
    private Label c0;
    @FXML
    private Button s0;
    @FXML
    private Label sl0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("KeyBox.fxml"));
            k1 = fx2.load();            
            KeyBoxController keycon = (KeyBoxController) fx2.getController();
            keycon.setInitialLang(VocaCard.fromLang);
            k1.setUserData(keycon);            
            namepane.getChildren().add(k1);
            keycon.setAutoSize(namepane);
            //namepane.toFront();
            
            FXMLLoader fx21 = new FXMLLoader(VocaCard.class.getResource("TransPane.fxml"));
            k2 = fx21.load();
            TransPaneController spane0 = (TransPaneController) fx21.getController();
            spane0.setAutoSize(selpane);
            k2.setUserData(spane0);
            
            FXMLLoader fx3 = new FXMLLoader(VocaCard.class.getResource("SearchPane.fxml"));
            k3 = fx3.load();
            SearchPaneController spane = (SearchPaneController) fx3.getController();
            spane.setAutoSize(meanpane);
            spane.setInitialLang(VocaCard.fromLang, VocaCard.toLang);
            spane.setType(BoxView.PaneType.MEANBOX);
            k3.setUserData(spane);
            meanpane.getChildren().add(k3);
            meanpane.toFront();
            
            FXMLLoader fx4 = new FXMLLoader(VocaCard.class.getResource("SearchPane.fxml"));
            k4 = fx4.load();
            SearchPaneController spane4 = (SearchPaneController) fx4.getController();
            spane4.setAutoSize(selpane);
            spane4.setInitialLang(VocaCard.fromLang, VocaCard.toLang);
            spane4.setType(BoxView.PaneType.PHOBOX);
            k4.setUserData(spane4);
//            selpane.getChildren().add(p3);
            
            FXMLLoader fx5 = new FXMLLoader(VocaCard.class.getResource("SearchPane.fxml"));
            k5 = fx5.load();
            SearchPaneController spane5 = (SearchPaneController) fx5.getController();
            spane5.setAutoSize(selpane);
            spane5.setInitialLang(VocaCard.fromLang, VocaCard.toLang);
            spane5.setType(BoxView.PaneType.ANSBOX);
            k5.setUserData(spane5);
            
            FXMLLoader fx6 = new FXMLLoader(VocaCard.class.getResource("SearchPane.fxml"));
            k6 = fx6.load();
            SearchPaneController spane6 = (SearchPaneController) fx6.getController();
            spane6.setAutoSize(selpane);
            spane6.setInitialLang(VocaCard.fromLang, VocaCard.toLang);
            spane6.setType(BoxView.PaneType.IDIOMBOX);
            k6.setUserData(spane6);
            
            FXMLLoader fx7 = new FXMLLoader(VocaCard.class.getResource("SearchPane.fxml"));
            k7 = fx7.load();
            SearchPaneController spane7 = (SearchPaneController) fx7.getController();
            spane7.setAutoSize(selpane);
            spane7.setInitialLang(VocaCard.fromLang, VocaCard.toLang);
            spane7.setType(BoxView.PaneType.PICBOX);
            k7.setUserData(spane7);
            
            s0.setUserData(sl0);
            s1.setUserData(sl1);
            s2.setUserData(sl2);
            s3.setUserData(sl3);
            s4.setUserData(sl4);
            s5.setUserData(sl5);
            
            selpane.getChildren().add(k2);
            
            fx2 = null;
            fx3 = null;
            fx4 = null;
            fx5 = null;
            fx6 = null;
            fx7 = null;
            WinUtils.memFree();
        }
        catch(Exception ex){
        }
    }   

    @FXML
    private void OnHelp(ActionEvent event) {
    }

    @FXML
    private void onSelectInfo(ActionEvent event) {
        String style = "";
        if (btnsel.getStyle().length() == 0){
            btnsel.setStyle("-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);");
            selector.setVisible(true);
            p0.toFront();
        }
        else{
            btnsel.setStyle("");
            selector.setVisible(false);
            selpane.toFront();
        }
    }

    @FXML
    private void onAdditionalInfo(ActionEvent event) {
        Button btn = (Button) event.getSource();
        
        selpane.getChildren().clear();
        if (btn.equals(s0)){
            selpane.getChildren().add(k2);
        }
        if (btn.equals(s1)){
            selpane.getChildren().add(k4);
        }
        else if (btn.equals(s2)){
            selpane.getChildren().add(k5);
        }
        else if (btn.equals(s3)){
            selpane.getChildren().add(k6);
        }
        else if (btn.equals(s4)){
            selpane.getChildren().add(k7);            
        }
        else if (btn.equals(s5)){
            
        }
        
        btnsel.setText(((Label)(btn.getUserData())).getText());
        btnsel.setStyle("");
        selector.setVisible(false);
        selpane.toFront();
    }

    @FXML
    private void onRootReleased(MouseEvent event) {
        if (selector.isVisible()){
            btnsel.setStyle("");
            selector.setVisible(false);
            selpane.toFront();
        }
    }

    @FXML
    private void OnDic(ActionEvent event) {
    }

    @Override
    public void setAutoSize(double halfw) {
        h1.setPrefWidth(halfw);
        namepane.setPrefWidth(halfw-30);
        ((KeyBoxController)(k1.getUserData())).setAutoSize(namepane);
        meanpane.setPrefWidth(halfw-30);

        h2.setPrefWidth(halfw);
        btnsel.setPrefWidth(halfw-30);
        arrow.setLayoutX(btnsel.getPrefWidth()-7);

        sv.setPrefWidth(btnsel.getPrefWidth());
        s1.setPrefWidth(sv.getPrefWidth()-10);
        s2.setPrefWidth(sv.getPrefWidth()-10);
        s3.setPrefWidth(sv.getPrefWidth()-10);
        s4.setPrefWidth(sv.getPrefWidth()-10);
        s5.setPrefWidth(sv.getPrefWidth()-10);

        selector.setPrefWidth(sv.getPrefWidth());
        p0.setPrefWidth(halfw);
        pane.setPrefWidth(halfw);

        selpane.setPrefWidth(halfw-8);
    }

    @Override
    public void setBoxView(BoxView boxes) {
        this.boxes = boxes;
    }

    @Override
    public void showAddDlg() {
        Stage stage = new Stage();
        stage.setTitle("새 단어 추가");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.widthProperty().addListener(
            (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                setAutoSize(newValue.doubleValue()/2.0);
        });
                
        c0.setText("단어 추가");
        c1.setText("현재 VocaCard 단어장에 단어를 추가합니다.");
        btnadd.setText("내용 추가");
        
        clear();
       
        stage.showAndWait();
   
        stage.setScene(null);
        stage = null;
        WinUtils.memFree();
    }

    @Override
    public void showModifyDlg(Boxable tag) {
        if (!tag.isContains("<WORD>\n", "</WORD>"))
            return;
        
        c0.setText("단어 수정");
        c1.setText("뜻/동의어/예문을 수정합니다.");
        btnadd.setText("내용 수정");
        
        String alltag = tag.toTag();
        
        ((KeyBoxController)(k1.getUserData())).setText(TagParser.tagParse(alltag, "name"));
        ((TransPaneController)(k2.getUserData())).setData(TagParser.tagParse(alltag, "transform"));
        
        ((SearchPaneController)(k3.getUserData())).setData(TagParser.multiTagParse(alltag, "ptesm"));
        ((SearchPaneController)(k4.getUserData())).setData(TagParser.multiTagParse(alltag, "phosnd"));
        ((SearchPaneController)(k5.getUserData())).setData(TagParser.multiTagParse(alltag, "ansynym"));
        ((SearchPaneController)(k6.getUserData())).setData(TagParser.multiTagParse(alltag, "idiom"));
        ((SearchPaneController)(k7.getUserData())).setData(TagParser.multiTagParse(alltag, "pic"));
        ((SearchPaneController)(k8.getUserData())).setData(TagParser.multiTagParse(alltag, "ptesm"));
        
        Stage stage = new Stage();
        stage.setTitle("단어 수정");
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
    
    private void clear(){
        ((KeyBoxController)(k1.getUserData())).clear();
        ((TransPaneController)(k2.getUserData())).clear();
        
        ((SearchPaneController)(k3.getUserData())).clear();
        ((SearchPaneController)(k4.getUserData())).clear();
        ((SearchPaneController)(k5.getUserData())).clear();
        ((SearchPaneController)(k6.getUserData())).clear();
        ((SearchPaneController)(k7.getUserData())).clear();
        ((SearchPaneController)(k8.getUserData())).clear();
        
        WinUtils.memFree();
    }

    @FXML
    private void onPreview(ActionEvent event) {
    }

    @FXML
    private void onAdd(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) {
    }
}
