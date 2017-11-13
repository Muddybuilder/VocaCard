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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class WordDlgFXMLController implements Initializable {
    @FXML
    private Pane namebox;
    @FXML
    private Button btndic;
    @FXML
    private Button btnhelp;
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
    private Pane p1;
    @FXML
    private StackPane ipabox;
    @FXML
    private Pane p2;
    @FXML
    private StackPane wordbox;
    @FXML
    private Pane p3;
    @FXML
    private StackPane exbox;
    @FXML
    private Pane p4;
    @FXML
    private Rectangle root1;
    @FXML
    private BorderPane root3;
    @FXML
    private TextField imgpath;
    @FXML
    private ImageView imgopen;
    @FXML
    private ImageView imgvw;
    @FXML
    private Pane p5;
    @FXML
    private Rectangle root11;
    @FXML
    private BorderPane root31;
    @FXML
    private TextField sndpath;
    @FXML
    private ImageView sndopen;
    @FXML
    private Button btnpreview;
    @FXML
    private ImageView previewimg;

    /**
     * Initializes the controller class.
     */
    
    Parent wordname, meaning, ipa, reverse, ex;
    
    IPABoxFXMLController ipacon;
    KeyBoxFXMLController nameboxcon, revboxcon;
    SearchPaneFXMLController meancon, excon;
    
    Parent dic;
    DicReaderController dicreader;
    Stage dicstage;
    
    Pane [] panes;
    Button [] btns;
    final String [] btntitle = {"발음 기호", "반의어", "예문/예문 해석", "관련 그림", "추가 음성 파일"};
    
    @FXML
    private Pane p0;
    @FXML
    private Pane searchbox;
    @FXML
    private AnchorPane root;
    @FXML
    private Pane b1;
    @FXML
    private Pane b2;
    @FXML
    private Label c1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WinUtils.setAutoDPI(root);
        
        try{
            //meaning
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("SearchPaneFXML.fxml"));
            meaning = fx2.load();
            meancon = (SearchPaneFXMLController) fx2.getController();
//            meancon.setInitialLang(KeyList.fromLang, KeyList.toLang);
            searchbox.getChildren().add(meaning);
            meancon.setSize(searchbox.getPrefWidth());
            searchbox.toFront();
            
            //wordname
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("KeyBoxFXML.fxml"));
            wordname = fx1.load();
            nameboxcon = (KeyBoxFXMLController) fx1.getController();
//            nameboxcon.setInitialLang(KeyList.fromLang);
            namebox.getChildren().add(wordname);
            nameboxcon.setSize(namebox.getPrefWidth());
            namebox.toFront();            
            
            //ipa
            FXMLLoader fx3 = new FXMLLoader(VocaCard.class.getResource("IPABoxFXML.fxml"));
            ipa = fx3.load();
            ipacon = (IPABoxFXMLController) fx3.getController();
            ipabox.getChildren().add(ipa);
//            ipacon.setSize(ipabox.getPrefWidth());
            
            //reverse
            FXMLLoader fx4 = new FXMLLoader(VocaCard.class.getResource("KeyBoxFXML.fxml"));
            reverse = fx4.load();
            revboxcon = (KeyBoxFXMLController) fx4.getController();
            wordbox.getChildren().add(reverse);
//            revboxcon.setInitialLang(KeyList.fromLang);
            revboxcon.setSize(wordbox.getPrefWidth());
            
            //ex
            FXMLLoader fx5 = new FXMLLoader(VocaCard.class.getResource("SearchPaneFXML.fxml"));
            ex = fx5.load();
            excon = (SearchPaneFXMLController) fx5.getController();
            exbox.getChildren().add(ex);
//            excon.setInitialLang(KeyList.fromLang, KeyList.toLang);
            excon.setSize(exbox.getPrefWidth());
            excon.setExampleMode();
            
            FXMLLoader fx6 = new FXMLLoader(VocaCard.class.getResource("DicReader.fxml"));
            dic = fx6.load();
            dicreader = (DicReaderController) fx6.getController();
            dicstage = new Stage();
            dicstage.setScene(new Scene(dic));
            
            fx1 = null;
            fx2 = null;
            fx3 = null;
            fx4 = null;
            fx5 = null;
            fx6 = null;
            WinUtils.memFree();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        panes = new Pane [] {p1, p2, p3, p4, p5};
        btns = new Button[] {s1, s2, s3, s4, s5};
        
        setZOrder(0);
        
        searchbox.toBack();
        
        /******* Layout Setting *******/
        
    }
    
    private void setZOrder(int n){
        panes[n].toFront();
        for (Pane ps : panes){
            ps.setVisible(false);
        }
        panes[n].setVisible(true);
        btnsel.setText(btntitle[n]);
    }

    @FXML
    private void onSelectInfo(ActionEvent event) {
        if (btnsel.getStyle().length() == 0){
            p0.toFront();
            btnsel.setStyle("-fx-effect: innershadow(three-pass-box , black, 10, 0.1 , 0 , 0);");
            selector.setVisible(true);
        }
        else{
            btnsel.setStyle("");
            selector.setVisible(false);
        }
    }

    @FXML
    private void onAdditionalInfo(ActionEvent event) {
        for (int c=0; c<btns.length; c++){
            if (event.getSource().equals(btns[c])){
                setZOrder(c);
                break;
            }
        }
        
        btnsel.setStyle("");
        selector.setVisible(false);
    }

    @FXML
    private void OnDic(ActionEvent event) {
       // dicreader.readPage();
        dicstage.show();        
        WinUtils.memFree();
    }

    @FXML
    private void onFileDialog(MouseEvent event) {
    }

    @FXML
    private void OnHelp(ActionEvent event) {
    }
}
