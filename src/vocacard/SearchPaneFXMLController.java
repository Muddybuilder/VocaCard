/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SearchPaneFXMLController implements Initializable {
    @FXML
    private BorderPane root;
    @FXML
    private Rectangle root1;
    @FXML
    private BorderPane root3;
    @FXML
    private ImageView flag;
    @FXML
    private ImageView tview;
    @FXML
    private AnchorPane root4;
    @FXML
    private Rectangle root2;
    @FXML
    private StackPane stack;
    @FXML
    private Group grp;
    @FXML
    private VBox vbox;
    @FXML
    private Button c11;
    @FXML
    private Label p11;
    @FXML
    private Label k11;
    @FXML
    private Button c12;
    @FXML
    private Label p12;
    @FXML
    private Label k12;
    @FXML
    private Button c13;
    @FXML
    private Label p13;
    @FXML
    private Label k13;
    @FXML
    private Button c14;
    @FXML
    private Label p14;
    @FXML
    private Label k14;
    @FXML
    private Button c15;
    @FXML
    private Label p15;
    @FXML
    private Label k15;
    @FXML
    private Button c16;
    @FXML
    private Label p16;
    @FXML
    private Label k16;
    @FXML
    private Button c17;
    @FXML
    private Label p17;
    @FXML
    private Label k17;
    @FXML
    private Button c18;
    @FXML
    private Label p18;
    @FXML
    private Label k18;
    @FXML
    private Button c19;
    @FXML
    private Label p19;
    @FXML
    private Label k19;
    @FXML
    private Button c20;
    @FXML
    private Label p20;
    @FXML
    private Label k20;
    @FXML
    private Button c21;
    @FXML
    private Label p21;
    @FXML
    private Label k21;
    @FXML
    private Button c22;
    @FXML
    private Label p22;
    @FXML
    private Label k22;
    @FXML
    private Button c23;
    @FXML
    private Label p23;
    @FXML
    private Label k23;
    @FXML
    private Button c24;
    @FXML
    private Label p24;
    @FXML
    private Label p25;
    @FXML
    private Pane c241;
    @FXML
    private Button c25;
    @FXML
    private Label p26;
    @FXML
    private Label k24;
    @FXML
    private Button c26;
    @FXML
    private Label p27;
    @FXML
    private Label k25;
    @FXML
    private Button c27;
    @FXML
    private Label p28;
    @FXML
    private Label k26;
    @FXML
    private Button c28;
    @FXML
    private Label p29;
    @FXML
    private Label k27;
    @FXML
    private Button c29;
    @FXML
    private Label p30;
    @FXML
    private Label k28;
    @FXML
    private Button c30;
    @FXML
    private Label p31;
    @FXML
    private Label k29;
    @FXML
    private Button c31;
    @FXML
    private Label p32;
    @FXML
    private Label k30;
    @FXML
    private Button c32;
    @FXML
    private Label p33;
    @FXML
    private Label k31;
    @FXML
    private Button c33;
    @FXML
    private Label p34;
    @FXML
    private Label k32;
    @FXML
    private Button c34;
    @FXML
    private Label p35;
    @FXML
    private Label k33;
    @FXML
    private Button c35;
    @FXML
    private Label p36;
    @FXML
    private Label k34;
    @FXML
    private Button c36;
    @FXML
    private Label p37;
    @FXML
    private Label k35;
    @FXML
    private Button c37;
    @FXML
    private Label p38;
    @FXML
    private Label k36;
    @FXML
    private Button c38;
    @FXML
    private Label p39;
    @FXML
    private Label p40;
    @FXML
    private Button c39;
    @FXML
    private Label p41;
    @FXML
    private Label k37;
    @FXML
    private Button c40;
    @FXML
    private Label p42;
    @FXML
    private Label k38;
    @FXML
    private Button c41;
    @FXML
    private Label p43;
    @FXML
    private Label k39;
    @FXML
    private Button c42;
    @FXML
    private Label p44;
    @FXML
    private Label k40;
    @FXML
    private Button c43;
    @FXML
    private Label p45;
    @FXML
    private Label k41;
    @FXML
    private Button c44;
    @FXML
    private Label p46;
    @FXML
    private Label k42;
    @FXML
    private Button c45;
    @FXML
    private Label p47;
    @FXML
    private Label k43;
    @FXML
    private Button c46;
    @FXML
    private Label p48;
    @FXML
    private Label k44;
    @FXML
    private Button c47;
    @FXML
    private Label p49;
    @FXML
    private Label k45;
    @FXML
    private Button c48;
    @FXML
    private Label p50;
    @FXML
    private Label k46;
    @FXML
    private Button c49;
    @FXML
    private Label p51;
    @FXML
    private Label k47;
    @FXML
    private Button c50;
    @FXML
    private Label p52;
    @FXML
    private Label p53;
    @FXML
    private Button c51;
    @FXML
    private Label p54;
    @FXML
    private Label p55;
    @FXML
    private Button c521;
    @FXML
    private Label k48;
    @FXML
    private Button c52;
    @FXML
    private Label p56;
    @FXML
    private Label k49;
    @FXML
    private Button c53;
    @FXML
    private Label p57;
    @FXML
    private Label k50;
    @FXML
    private Button c54;
    @FXML
    private Label p58;
    @FXML
    private Label k51;
    @FXML
    private Button c55;
    @FXML
    private Label p59;
    @FXML
    private Label k52;
    @FXML
    private Button c56;
    @FXML
    private Label p60;
    @FXML
    private Label k53;
    @FXML
    private Button c57;
    @FXML
    private Label p61;
    @FXML
    private Label k54;
    @FXML
    private Button c58;
    @FXML
    private Label p62;
    @FXML
    private Label k55;
    @FXML
    private Button c59;
    @FXML
    private Label p63;
    @FXML
    private Label k56;
    @FXML
    private Button c60;
    @FXML
    private Label p64;
    @FXML
    private Label k57;
    @FXML
    private Button c61;
    @FXML
    private Label p65;
    @FXML
    private Label k58;
    @FXML
    private Button c62;
    @FXML
    private Label p66;
    @FXML
    private Label p67;
    @FXML
    private Button c63;
    @FXML
    private Label p68;
    @FXML
    private Button c64;
    @FXML
    private Label p69;
    @FXML
    private Button c65;
    @FXML
    private Label p71;
    @FXML
    private Button c66;
    @FXML
    private Label p72;
    @FXML
    private Button soc;
    @FXML
    private ImageView tflag1;
    @FXML
    private Label keytitle1;
    @FXML
    private Button soc1;
    @FXML
    private ImageView tflag2;
    @FXML
    private Label keytitle2;
    @FXML
    private AnchorPane aroot;
    @FXML
    private ListView<?> lv;
    @FXML
    private Rectangle arect;
    @FXML
    private Pane img;
    @FXML
    private Label lbltip;
    @FXML
    private Label lblcnt;
    @FXML
    private Label lblchk;
    @FXML
    private Button btnadd;
    @FXML
    private Button btndel;
    @FXML
    private Button btnmod;
    
    private TextField tfield;
    
    Label [] keylbls;
    boolean capson;
    int lang, prelang;
    
    Image delkey, addkey;
    
    /*ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ */
    char [] initial = {0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
		0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    
//    /*ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ*/
//    char [] jun = {0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
//		0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160,	0x3161,	0x3162,
//		0x3163};
    
    /*X ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ*/    
    char [] finale = {0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
		0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
		0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    
    char [] dMedial = {0,0,0,0,0,0,0,0,0,800,801,820,0,0,1304,1305,1320,0,0,1820};
    char [] dFinale = {0,0,0,119,0,422,427,0,0,801,816,817,819,825,826,827,0,0,1719,0,1919};
    
    int SBase = 0xAC00, LBase = 4352, VBase = 12623, TBase = 4519;
    int LCount = 19, VCount = 21, TCount = 28, NCount = 588, SCount = 11172;
    
    KeyCodeCombination [] shortcuts = {
        new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN),
        new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN),
        new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN),
        new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN),
        new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN),
        new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN),
        new KeyCodeCombination(KeyCode.HOME, KeyCombination.SHIFT_DOWN),
        new KeyCodeCombination(KeyCode.END, KeyCombination.SHIFT_DOWN),
        new KeyCodeCombination(KeyCode.END),
        new KeyCodeCombination(KeyCode.HOME),
        new KeyCodeCombination(KeyCode.LEFT, KeyCombination.SHIFT_DOWN),
        new KeyCodeCombination(KeyCode.RIGHT, KeyCombination.SHIFT_DOWN),
        new KeyCodeCombination(KeyCode.LEFT),
        new KeyCodeCombination(KeyCode.RIGHT),
        new KeyCodeCombination(KeyCode.INSERT),
        new KeyCodeCombination(KeyCode.PAGE_UP),
        new KeyCodeCombination(KeyCode.PAGE_DOWN),
        new KeyCodeCombination(KeyCode.NUM_LOCK),
        new KeyCodeCombination(KeyCode.DELETE),
        new KeyCodeCombination(KeyCode.NUMBER_SIGN),
        new KeyCodeCombination(KeyCode.NUMPAD0),
        new KeyCodeCombination(KeyCode.NUMPAD1),
        new KeyCodeCombination(KeyCode.NUMPAD2),
        new KeyCodeCombination(KeyCode.NUMPAD3),
        new KeyCodeCombination(KeyCode.NUMPAD4),
        new KeyCodeCombination(KeyCode.NUMPAD5),
        new KeyCodeCombination(KeyCode.NUMPAD6),
        new KeyCodeCombination(KeyCode.NUMPAD7),
        new KeyCodeCombination(KeyCode.NUMPAD8),
        new KeyCodeCombination(KeyCode.NUMPAD9),
    };
    
    boolean tfieldkey = false;
    String prev = "", lastone="";
    int fixedlang1, fixedlang2;
    
    Button clickedbtn;
    
    Parent addword, addex;
    AddWordController addwordcon;
    Example_Sentence_AddController excon;
    Stage addwordstage, addexstage;
    
    Parent deldlg;
    AlertDlgController delcon;
    Stage delstage;
    
    @FXML
    private HBox hbox;
    
    boolean isWordMode;
    @FXML
    private Label lbladd;
    @FXML
    private Label lbldel;
    @FXML
    private Label lblmod;
    
    @FXML
    private Pane clearpane;
    @FXML
    private ImageView clear;
    @FXML
    private Pane tviewpane;
    @FXML
    private Pane nondisplay;
    
    boolean isReleased = false;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        keylbls = new Label[] {k11, k12, k13, k14, k15, k16, k17, k18, k19, k20, k21, k22, k23, k24, k25, k26, k27, k28, k29, k30, k31, k32, k33, k34, k35, k36, k37, k38, k39, k40, k41, k42, k43, k44, k45, k46, k47, k49, k50, k51, k52, k53, k54, k55, k56, k57, k58, k48};
        
        clearpane.setVisible(false);
        
        lv.setEditable(false);
        nondisplay.setVisible(true);
        lv.setPlaceholder(nondisplay);
        
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        lv.getSelectionModel().selectedIndexProperty().addListener((event)->{
            updateChecking();
        });
        
        lv.setOnKeyPressed((event)->{
            String code = event.getCode().toString().toUpperCase();
            
            switch(code){
                case "ESC":
                    lv.getSelectionModel().clearSelection();
                    break;
                    
                case "ENTER":
                    if (!btnmod.isDisable()){
                        AnchorPane pane = (AnchorPane)lv.getItems().get(lv.getSelectionModel().getSelectedIndex());
                        ExBoxController conpane = (ExBoxController) pane.getUserData();

                        if (isWordMode){
                            addwordcon.setModifyMode(conpane.part.getText(), conpane.ex1.getText(), conpane.ex2.getText());
                            if (addwordstage.getOwner() == null)
                                addwordstage.initOwner(((Node)event.getSource()).getScene().getWindow());

                            addwordstage.showAndWait();
                            System.gc();
                        }
                        else{
                            excon.setModifyMode(conpane.ex1.getText(), conpane.ex2.getText());

                            if (addexstage.getOwner() == null){
                                addexstage.initOwner(((Node)event.getSource()).getScene().getWindow());
                            }

                            addexstage.showAndWait();
                            System.gc();
                        }
                    }
                    break;
                    
                case "DELETE":
                    removeChecking();
                    break;
                    
                case "SPACE":
                    if (lv.getSelectionModel().getSelectedIndex() != -1){
                        AnchorPane pane = (AnchorPane)lv.getItems().get(lv.getSelectionModel().getSelectedIndex());
                        ExBoxController conpane = (ExBoxController) pane.getUserData();
                        conpane.setChecked(!conpane.getChecked());
                    }
                    break;
                    
                default:
                    updateChecking();
                    return;
            }
            
            updateChecking();
            WinUtils.memFree();
            event.consume();
        });
        
        lv.setOnMouseReleased((event)->{
            double sum = 0;
            for (int c=0; c<lv.getItems().size(); c++){
                AnchorPane pn = (AnchorPane) lv.getItems().get(c);
                sum += pn.getHeight();
            }
            
            if (event.getY() > sum)
                lv.getSelectionModel().clearSelection();
            
            WinUtils.memFree();
            updateChecking();
        });
                     
        tfield = new TextField(){
            @Override
            public void replaceText(int start, int end, String text) {
                if (root4.isVisible()){
                    String handlekey = handling(text, isReleased);
                    
//                    System.out.println(handlekey);
                    
                    if (handlekey.length() == 0) handlekey = text;
                    
                    String [][] deadkeys = KeyList.getKeyInfo(lang).deadkeys;
                    
                    if (prev.length() > 0){
                        String mapped = getMappedValue(deadkeys, handlekey, prev);
                        if (mapped.length() > 0){
                            super.replaceText(start-1, end, mapped);
                        }
                        
                        prev = "";
                    }
                    else{
                        if (isDeadKey(deadkeys, handlekey)){
                            prev = handlekey;
                        }
                        if (lang == 26){
                            insertAtCaret(handlekey);
                            String a = deleteAtCaret(2,0);
                            if (a.length() > 0)
                                super.replaceText(tfield.getCaretPosition(), tfield.getCaretPosition(), composeHangul(a));
                        }
                        else{
                            super.replaceText(start, end, handlekey);
                        }
                    }                    
                }
                else{
                    String [][] deadkeys = KeyList.getKeyInfo(lang).deadkeys;
                    
                    if (prev.length() > 0){
                        String mapped = getMappedValue(deadkeys, text, prev);
                        if (mapped.length() > 0){
                            super.replaceText(start-1, end, mapped);
                        }
                        
                        prev = "";
                    }
                    else{
                        if (isDeadKey(deadkeys, text)){
                            prev = text;
                        }
                        
                        super.replaceText(start, end, text);
                    }
                }
            }

            @Override
            public void replaceSelection(String text) {
                 if (root4.isVisible()){
                    String handlekey = handling(text, isReleased);
                    
//                    System.out.println(handlekey);
                    
                    if (handlekey.length() == 0) handlekey = text;
                    
                    String [][] deadkeys = KeyList.getKeyInfo(lang).deadkeys;
                    
                    if (prev.length() > 0){
                        String mapped = getMappedValue(deadkeys, handlekey, prev);
                        if (mapped.length() > 0){
                            super.replaceSelection(mapped);
                        }
                        
                        prev = "";
                    }
                    else{
                        if (isDeadKey(deadkeys, handlekey)){
                            prev = handlekey;
                        }
                        if (lang == 26){
                            insertAtCaret(handlekey);
                            String a = deleteAtCaret(2,0);
                            if (a.length() > 0)
                                super.replaceSelection(composeHangul(a));
                        }
                        else{
                            super.replaceSelection(handlekey);
                        }
                    }                    
                }
                else{
                    String [][] deadkeys = KeyList.getKeyInfo(lang).deadkeys;
                    
                    if (prev.length() > 0){
                        String mapped = getMappedValue(deadkeys, text, prev);
                        if (mapped.length() > 0){
                            super.replaceSelection(mapped);
                        }
                        
                        prev = "";
                    }
                    else{
                        if (isDeadKey(deadkeys, text)){
                            prev = text;
                        }
                        
                        super.replaceSelection(text);
                    }
                }
            }
        };
        
        tfield.setId("nm10");
        
        tfield.setStyle("-fx-background-color: rgba(0,0,0,0);");
        tfield.setPrefHeight(root3.getPrefHeight());
        root3.setCenter(tfield);
        
        tfield.textProperty().addListener((event)->{
            clearpane.setVisible(!(tfield.getLength() == 0));            
        });
  
         tfield.setOnKeyPressed((event)->{
            if (!root4.isVisible())
                return;
            
            String code = event.getCode().toString().toUpperCase();
            
            isReleased = false;
            
            for (int c=0; c<shortcuts.length; c++){
                if (shortcuts[c].match(event)){
                    return;
                }
            }
            
            String style = "";
            
            if (!isReleased){
                style = "-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);" +
                        "-fx-background-color: linear-gradient(white 0%, #828282 100%);";
            }
            
            switch(code){
                case "ALT":
                    c63.setStyle(style);
                    c66.setStyle(style);
                    break;
                    
                case "SHIFT":
                    c51.setStyle(style);    
                    c62.setStyle(style);
                    break;
                    
                case "CONTROL":
                    c63.setStyle(style);
                    c66.setStyle(style);
                    break;
                    
                case "CAPS":
                    capson = !capson;
                    if (capson){
                        c38.setStyle("-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);" +
                            "-fx-background-color: linear-gradient(white 0%, #828282 100%);");
                    }
                    else{
                        c38.setStyle("");
                    }
             
                break;
                
                case "BACK_SPACE":
                    c24.setStyle(style);

                    if (prev.length() > 0){
                        prev = "";
                    }
                    else{
                        if (tfield.getSelectedText().length() > 0){
                            deleteAtCaret(1, 0);
                        }
                        else{
                            String dc = decomposeHangul(deleteAtCaret(1, 0));

                            if (dc.length() > 1){
                                insertAtCaret(composeHangul(dc.substring(0, dc.length()-1)));
                            } 
                        }
                    }

                    break;
                
                case "DELETE":
                    if (tfield.getSelectedText().length() > 0){
                        deleteAtCaret(1, 0);
                    }
                    else if (tfield.getText().length() > 0)
                        tfield.deleteNextChar();
                    break;
                    
                case "SPACE":
                    c64.setStyle(style);
                    insertAtCaret(" ");
                    break;
            }
            
            boolean alt = (c63.getStyle().length() == 0) ? false : true;
            boolean ctrl = alt;
            boolean shift = (c51.getStyle().length() == 0) ? false : true;

            if (alt || ctrl || shift || capson || isReleased){
                setLanguage(lang);
            }
            
            event.consume();
        });
        
        tfield.setOnKeyReleased((event)->{
            if (!root4.isVisible())
                return;
            
            String code = event.getCode().toString().toUpperCase();
            
            isReleased = true;
            
            for (int c=0; c<shortcuts.length; c++){
                if (shortcuts[c].match(event)){
                    return;
                }
            }
            
            String style = "";
            
            if (!isReleased){
                style = "-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);" +
                        "-fx-background-color: linear-gradient(white 0%, #828282 100%);";
            }
            
            switch(code){
                case "ALT":
                    c63.setStyle(style);
                    c66.setStyle(style);
                    break;
                    
                case "SHIFT":
                    c51.setStyle(style);    
                    c62.setStyle(style);
                    break;
                    
                case "CONTROL":
                    c63.setStyle(style);
                    c66.setStyle(style);
                    break;
                    
                case "CAPS":
                    capson = !capson;
                    if (capson){
                        c38.setStyle("-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);" +
                            "-fx-background-color: linear-gradient(white 0%, #828282 100%);");
                    }
                    else{
                        c38.setStyle("");
                    }
             
                break;

            }
            
            boolean alt = (c63.getStyle().length() == 0) ? false : true;
            boolean ctrl = alt;
            boolean shift = (c51.getStyle().length() == 0) ? false : true;

            if (alt || ctrl || shift || capson || isReleased){
                setLanguage(lang);
            }
            
            event.consume();
        });
        
        root.setPrefHeight(36);
        root4.setVisible(false);
        capson = false;
        
        delkey = new Image(getClass().getResourceAsStream("image/delkeyboard.png"));
        addkey = new Image(getClass().getResourceAsStream("image/showkeyboard.png"));
        
        prelang = 10;
        
        setInitialLang(26, 10);
        
        setSize(480);
        
        clickedbtn = soc;

        try{
            FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("AddWord.fxml"));
            addword = fx0.load();
            addwordcon = (AddWordController) fx0.getController();
            addwordcon.setListView(lv);
            addwordcon.setSearchPane(this);
                       
            addwordstage = new Stage();
            addwordstage.setTitle("새 뜻/동의어 추가");
            addwordstage.setScene(new Scene(addword));
            addwordstage.initModality(Modality.WINDOW_MODAL);
            addwordstage.setResizable(false);
                        
            FXMLLoader fx1 = new FXMLLoader(VocaCard.class.getResource("Example_Sentence_Add.fxml"));
            addex = fx1.load();
            excon = (Example_Sentence_AddController) fx1.getController();
            excon.setListView(lv);
            excon.setSearchPane(this);
            
            addexstage = new Stage();
            addexstage.setTitle("새 뜻/동의어 추가");
            addexstage.setScene(new Scene(addex));
            addexstage.initModality(Modality.WINDOW_MODAL);
            addexstage.setResizable(false);
            
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("AlertDlg.fxml"));
            deldlg = fx2.load();
            delcon = (AlertDlgController) fx2.getController();
            
            delstage = new Stage();
            delstage.initModality(Modality.WINDOW_MODAL);
            delstage.setScene(new Scene(deldlg));
            delstage.setResizable(false);
            
            fx0 = null;
            fx1 = null;
            fx2 = null;
            
            WinUtils.memFree();

        }
        catch(Exception ex){
        }
        
        lblcnt.setVisible(false);
        lblchk.setVisible(false);
        
        setWordMode();
    }
    
    public void updateChecking(){
        boolean checking = false;
        int chkcnt = 0;
        for (int c=0; c<lv.getItems().size(); c++){
            AnchorPane pane = (AnchorPane)lv.getItems().get(c);
            ExBoxController conpane = (ExBoxController) pane.getUserData();
            
            if (conpane.getChecked()){
                checking = true;
                chkcnt++;
            }
        }
        
        lblchk.setVisible(checking);
        lblchk.setText("총 체크한 항목 개수 : " + chkcnt + " 항목");
        
        lblcnt.setVisible((lv.getItems().size() > 0));
        lblcnt.setText("총 항목 개수 : " + lv.getItems().size() + " 항목");
        
        btnmod.setDisable((lv.getSelectionModel().getSelectedIndex() == -1));
        btndel.setDisable(!checking);
    }
    
    private void removeChecking(){
       delcon.setAlertData(isWordMode, lv);
       delcon.setStage(delstage);
       delstage.showAndWait();
       System.gc();
    }
    
    public void setSize(double w){
        root1.setWidth(w); //Rectangle
        root3.setPrefWidth(w-14); //Top BorderPane     
        
        double hrate = 230*(w-12)/667+47;
        double rate = (w-12)/667;
        
        vbox.setScaleX(rate);
        vbox.setScaleY(rate);
        
        root2.setWidth(w);
        root2.setHeight(hrate);
        
        lv.setPrefWidth(w - 12 - 143);
        arect.setWidth(lv.getPrefWidth()+12);
        lblchk.setLayoutX(w - 143 - 160);
        aroot.setPrefWidth(lv.getPrefWidth());
        
        lbltip.setPrefWidth(arect.getWidth());
        lbltip.setLayoutY((arect.getHeight()-15)/2 + 60);
        
        img.setLayoutX((arect.getWidth()-141)/2);
        img.setLayoutY((arect.getHeight()-141)/2-50);
        
        hbox.setPrefWidth(w);
        
        root4.setPrefSize(w, hrate);
        root.setPrefWidth(w);
    }

    private String handling(String code, boolean isReleased){
        code = code.toUpperCase();
        
        Label txt = null;
        String style = "";
        
        if (!isReleased){
            style = "-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);" +
                    "-fx-background-color: linear-gradient(white 0%, #828282 100%);";
        }
        
        switch(code){
            case "~":
            case "`":
            case "BACK_QUOTE":
                c11.setStyle(style);
                txt = k11;
                break;

            case "1":
            case "DIGIT1":
                c12.setStyle(style);
                txt = k12;
                break;

            case "2":
            case "DIGIT2":
                c13.setStyle(style);
                txt = k13;
                break;
                
            case "3":
            case "DIGIT3":
                c14.setStyle(style);
                txt = k14;
                break;

            case "4":
            case "DIGIT4":
                c15.setStyle(style);
                txt = k15;
                break;

            case "5":
            case "DIGIT5":
                c16.setStyle(style);
                txt = k16;
                break;

            case "6":
            case "DIGIT6":
                c17.setStyle(style);
                txt = k17;
                break;

            case "7":
            case "DIGIT7":
                c18.setStyle(style);
                txt = k18;
                break;

            case "8":
            case "DIGIT8":
                c19.setStyle(style);
                txt = k19;
                break;

            case "9":
            case "DIGIT9":
                c20.setStyle(style);
                txt = k20;
                break;
                
            case "0":
            case "DIGIT0":
                c21.setStyle(style);
                txt = k21;
                break;

            case "_":
            case "-":
            case "MINUS":
                c22.setStyle(style);
                txt = k22;
                break;
                
            case "=":
            case "+":
            case "EQUALS":
                c23.setStyle(style);
                txt = k23;
                break;

            case "Q":
                c25.setStyle(style);
                txt = k24;
                break;

            case "W":
                c26.setStyle(style);
                txt = k25;
                break;

            case "E":
                c27.setStyle(style);
                txt = k26;
                break;

            case "R":
                c28.setStyle(style);
                txt = k27;
                break;

            case "T":
                c29.setStyle(style);
                txt = k28;
                break;

            case "Y":
                c30.setStyle(style);
                txt = k29;
                break;

            case "U":
                c31.setStyle(style);
                txt = k30;
                break;

            case "I":
                c32.setStyle(style);
                txt = k31;
                break;

            case "O":
                c33.setStyle(style);
                txt = k32;
                break;

            case "P":
                c34.setStyle(style);
                txt = k33;
                break;

            case "[":
            case "{":
            case "OPEN_BRACKET":
                c35.setStyle(style);
                txt = k34;
                break;

            case "]":
            case "}":
            case "CLOSE_BRACKET":
                c36.setStyle(style);
                txt = k35;
                break; 

            case "|":
            case "\\":
            case "BACK_SLASH":
                c37.setStyle(style);
                txt = k36;
                break;

            case "A":
                c39.setStyle(style);
                txt = k37;
                break;

            case "S":
                c40.setStyle(style);
                txt = k38;
                break;

            case "D":
                c41.setStyle(style);
                txt = k39;
                break;

            case "F":
                c42.setStyle(style);
                txt = k40;
                break;

            case "G":
                c43.setStyle(style);
                txt = k41;
                break;

            case "H":
                c44.setStyle(style);
                txt = k42;
                break;

            case "J":
                c45.setStyle(style);
                txt = k43;
                break;

            case "K":
                c46.setStyle(style);
                txt = k44;
                break;

            case "L":
                c47.setStyle(style);
                txt = k45;
                break;

            case ";":
            case ":":
            case "SEMICOLON":
                c48.setStyle(style);
                txt = k46;
                break;

            case "\"":
            case "'":
            case "QUOTE":
                c49.setStyle(style);
                txt = k47;
                break;

            case "ENTER":
                c50.setStyle(style);
                break;

            case "Z":
                c52.setStyle(style);
                txt = k49;
                break;

            case "X":
                c53.setStyle(style);
                txt = k50;
                break;

            case "C":
                c54.setStyle(style);
                txt = k51;
                break;

            case "V":
                c55.setStyle(style);
                txt = k52;
                break;

            case "B":
                c56.setStyle(style);
                txt = k53;
                break;

            case "N":
                c57.setStyle(style);
                txt = k54;
                break;

            case "M":
                c58.setStyle(style);
                txt = k55;
                break;

            case "<":
            case ",":
            case "COMMA":
                c59.setStyle(style);
                txt = k56;
                break;

            case ">":
            case ".":
            case "PERIOD":
                c60.setStyle(style);
                txt = k57;
                break;

            case "?":
            case "/":
            case "SLASH":
                c61.setStyle(style);
                txt = k58;
                break;
        }
        
        if (txt == null)
            return "";
        
        return txt.getText();
    }
    
    //////////////////////////////////////////////////    
    static private int indexOf(char [] arr, char cmp){
        int no = -1;
        for (int i=0; i<arr.length; i++){
            if (arr[i] == cmp){
                no = i;
                break;
            }
        }
        return no;
    }
    
    private void setCaretPosition(int d, int a){
        int c = tfield.getLength();
        if (d > c)
            d = c;
        
        if (d+a > c)
            a = c-a;
        
        tfield.selectRange(d, d+a);
    }
    
    private void insertAtCaret(String f){
        int d = tfield.getSelection().getStart();
        int b = tfield.getSelection().getEnd();
        
        String txt = tfield.getText();
        
        tfield.setText(txt.substring(0, d) + f + txt.substring(b, txt.length()));
        setCaretPosition(d+f.length(), 0);
    }
    
    private String deleteAtCaret(int b, int a){
        int g = tfield.getSelection().getStart();
        int d = tfield.getSelection().getEnd();
        int f = tfield.getLength();
        
        if (b > g)
            b = g;
        
        if (d+a > f)
            a = f - d;
        
        String txt = tfield.getText();
        
        String h = txt.substring(g-b, d+a);
        tfield.setText(txt.substring(0, g-b) + txt.substring(d+a));
        setCaretPosition(g-b, 0);
        
        return h;
    }
    
    static private boolean isDeadKey(String [][] deadkeys, String e){
        if (deadkeys == null)
            return false;
        
        for (int c=0; c<deadkeys.length; c++){
            if (deadkeys[c][0].equals(e)){
                return true;
            }
        }
        
        return false;
    }
    
    static private String getMappedValue(String [][] deadkeys, String e, String prev){
        if (deadkeys == null)
            return "";
        
        for (int c=0; c<deadkeys.length; c++){
            if (deadkeys[c][0].equals(prev) && deadkeys[c][1].equals(e)){
                return deadkeys[c][2];
            }
        }
        
        return "";
    }
    
    private String composeHangul(String s){
        char [] sp = s.toCharArray();
        
        int g, m, l, c, b;
        char e = sp[0], a, j;
        String h = "";
        
        for (int d=0; d<sp.length; d++){
            a = sp[d];
            
            g = indexOf(this.initial,e);
            if (g != -1){
                m = a - VBase;
                if (m>=0 && m<VCount){
                    e = (char)(SBase + (g*VCount+m)*TCount);

                    if (h.length() > 0)
                        h = h.substring(0, h.length()-1);

                    h += e;

                    continue;
                }
            }
            
            j = (char)(e - SBase);
            
            if (j >=0 && j<11145 && (j % TCount) == 0){
                l = indexOf(finale, a);
                if (l != -1){
                    e += (char)l;
                    
                    if (h.length() > 0)
                        h = h.substring(0, h.length()-1);

                    h += e;
                    
                    continue;
                }
                
                m = (j % NCount) / TCount;
                c = indexOf(dMedial, (char)((m*100)+(a-VBase)));
                
                if (c > 0){
                    e += (char)((c-m)*TCount);
                    
                    if (h.length() > 0)
                        h = h.substring(0, h.length()-1);

                    h += e;
                    
                    continue;
                }
            }
            
            if (j >=0 && j < 11172 && (j % TCount) != 0){
                l = j % TCount;
                m = a - VBase;
                
                if (m>=0 && m < VCount){
                    g = indexOf(initial, finale[l]);
                    
                    if (g >= 0 && g < LCount){
                        if (h.length() > 0)
                            h = h.substring(0, h.length()-1);

                        h += (char)(e-l);
                        
                        e = (char)(SBase + (g * VCount + m) * TCount);
                        h += e;
                        continue;
                    }
                    
                    if (l < dFinale.length && dFinale[l] != 0){
                        if (h.length() > 0)
                            h = h.substring(0, h.length()-1);
                        
                        h += (char)(e - l + Math.floor(dFinale[l]/100));
                        e = (char)(SBase + (indexOf(initial, finale[dFinale[l] % 100]) * VCount + m) * TCount);
                        h += e;
                        continue;
                    }
                }
                
                b = indexOf(dFinale, (char)((l*100)+indexOf(finale, a)));
                if (b > 0){
                    e += (char)(b-l);
                    
                    if (h.length() > 0)
                        h = h.substring(0, h.length()-1);
                    
                    h+= e;
                    continue;
                }
            }
            e = a;
            h += a;
        }
        
        WinUtils.memFree();
        return h;
    }
    
    private String decomposeHangul(String s){
        char [] sp = s.toCharArray();
        String e = "";
        
        int f;
        char c, j, h;
        for (int b=0; b<sp.length; b++){
            char a = sp[b];
            f = (int)(a - SBase);
            
            if (f < 0 || f >= SCount){
                e += a;
                continue;
            }
            
            c = initial[(int)(Math.floor(f / NCount))];
            j = (char)(VBase + (f % NCount) / TCount);
            h = finale[f % TCount];
            e += c;
            e += j;
            
            if (h != 0){
                e += h;
            }
        }
        
        WinUtils.memFree();
        return e;
    }
    
    //////////////////////////////////////////////////////
    
    private String getState(String [] cur)
    {
        boolean alt = (c63.getStyle().length() == 0) ? false : true;
        boolean ctrl = alt;
        boolean shift = (c51.getStyle().length() == 0) ? false : true;
        boolean caps = capson;

        int state = 1; 
        
        if(!alt&&!shift&&ctrl)
        {
            state = 1;
        }
        else{
            if(!alt&&shift&&!ctrl)
            {
                state = 2;
            }
            else{
                if(!alt&&shift&&ctrl)
                {
                    state = 2;
                }
                else{
                    if(alt&&!shift&&!ctrl)
                    {
                        state = 1;
                    }
                    else{
                        if(alt&&!shift&&ctrl)
                        {
                            state = 4;
                        }
                        else{
                            if(alt&&shift&&!ctrl)
                            {
                                state = 2;
                            }
                            else{
                                if(alt&&shift&&ctrl)
                                {
                                    state = 5;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if((state == 1 || state == 2) && caps)
        {
            if(cur[0].equals("1"))
            {
                if (state == 1)
                {
                    state = 2;
                }
                else
                {
                    state = 1;
                }
            }
            
            if(cur[0].equals("2")) //SGCap
            {
                if(state == 1)
                {
                    state = 6;
                }
                else{
                    if(state == 2)
                    {
                        state = 7;
                    }
                }
            }
        }
        
        return cur[state];
    }
    
    private void switchLang(){
        if (clickedbtn.equals(soc)){ //fixedlang1
            flag.setImage(KeyList.getKeyInfo(fixedlang2).img);
            
            clickedbtn.setStyle("");
            clickedbtn = soc1;
            clickedbtn.setStyle("-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);");
            
            setLanguage(fixedlang2);
        }
        else{
            flag.setImage(KeyList.getKeyInfo(fixedlang1).img);
            
            clickedbtn.setStyle("");
            clickedbtn = soc;
            clickedbtn.setStyle("-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);");
            
            setLanguage(fixedlang1);
        }
    }
    
    public void setInitialLang(int n, int p){
        fixedlang1 = n;
        fixedlang2 = p;
        
        KeyInfo info1 = KeyList.getKeyInfo(fixedlang1);
        flag.setImage(info1.img);
        tflag1.setImage(info1.img);
        keytitle1.setText(info1.korname);
        
        KeyInfo info2 = KeyList.getKeyInfo(fixedlang2);
        tflag2.setImage(info2.img);
        keytitle2.setText(info2.korname);
        
        clickedbtn = soc;
        clickedbtn.setStyle("-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);");
        
        setLanguage(fixedlang1);
    }
    
    private void setLanguage(int n){
        KeyInfo info = KeyList.getKeyInfo(n);
        
        lang = n;
        
        tfield.setNodeOrientation((info.ltr) ? NodeOrientation.LEFT_TO_RIGHT : NodeOrientation.RIGHT_TO_LEFT);

        for (int x=0; x<info.keys.length; x++){
            keylbls[x].setText(getState(info.keys[x]));
        }
    }

    @FXML
    private void onToggle(MouseEvent event) {
        root4.setVisible(!root4.isVisible());
        
        tview.setImage((root4.isVisible()) ? delkey : addkey);
        
        if (root4.isVisible()){
            root.setPrefHeight(-1);
            root4.toFront();
            root.toFront();
        }
        else{
            root.setPrefHeight(36);
            root4.toBack();
            root.toBack();
        }
    }

    @FXML
    private void onButtonAction(ActionEvent event) {
        Button btn = (Button) event.getSource();
        Pane pane = (Pane) btn.getChildrenUnmodifiable().get(0);
        
        List<Node> nodes = pane.getChildrenUnmodifiable();
                
        boolean found = false;
        for (int c=0; c<keylbls.length; c++){
            if (nodes.contains(keylbls[c])){
                 String [][] deadkeys = KeyList.getKeyInfo(lang).deadkeys;
                if (prev.length() > 0){
                    String mapped = getMappedValue(deadkeys, keylbls[c].getText(), prev);
                    if (mapped.length() > 0){
                        insertAtCaret(mapped);
                    }
                    prev = "";
                }
                else{
                    if (isDeadKey(deadkeys, keylbls[c].getText())){
                        prev = keylbls[c].getText();
                    }
                    else{
                        if (lang == 26){
                            insertAtCaret(keylbls[c].getText());
                            String a = deleteAtCaret(2, 0);
                            insertAtCaret(composeHangul(a));
                        }
                        else{
                            insertAtCaret(keylbls[c].getText());
                        }
                    }
                }
                
                found = true;
                break;
            }
        }
        
        if (!found){
            String style = "-fx-effect: innershadow(three-pass-box, black, 10, 0.28, 1, 0, 0);" +
                    "-fx-background-color: linear-gradient(white 0%, #828282 100%);";
            
            if (btn.equals(c24)){ //Backspace
                if (prev.length() > 0){
                    prev = "";
                }
                else{
                    if (tfield.getSelectedText().length() > 0){
                        deleteAtCaret(1, 0);
                    }
                    else{
                        String dc = decomposeHangul(deleteAtCaret(1, 0));
//                        System.out.println(dc);
                        
                        if (dc.length() > 1){
                            insertAtCaret(composeHangul(dc.substring(0, dc.length()-1)));
                        } 
                    }
                }
            }
            else if (btn.equals(c38)){ //CapsLock
                capson = !capson;
                if (capson){
                    c38.setStyle(style);
                }
                else{
                    c38.setStyle("");
                }
                
                setLanguage(lang);
            }
            else if (btn.equals(c50)){ //Enter
            }
            else if (btn.equals(c51) || btn.equals(c62)){ //Shift
                if (c51.getStyle().length() == 0){
                    c51.setStyle(style);
                    c62.setStyle(style);
                }
                else{
                    c51.setStyle("");
                    c62.setStyle("");
                }                
                setLanguage(lang);
            }
            else if (btn.equals(c64)){ //Space
                insertAtCaret(" ");
            }            
            else if (btn.equals(c65)){ //영어 키보드 [언어 전환]
                int t = lang;
                lang = prelang;
                prelang = t;
                
                setLanguage(lang);
                
                if (lang == 10){
                    int lng = (clickedbtn.equals(soc)) ? fixedlang1 : fixedlang2;
                    p71.setText(KeyList.getKeyInfo(lng).korname);
                }
                else{
                    p71.setText("영어(미국)");
                }

            }
            else if (btn.equals(c63) || btn.equals(c66)){ //Ctrl+Alt
                if (c63.getStyle().length() == 0){
                    c63.setStyle(style);
                    c66.setStyle(style);
                }
                else{
                    c63.setStyle("");
                    c66.setStyle("");
                }
                setLanguage(lang);
            }
        }
    }

    @FXML
    private void onChange(ActionEvent event) {
        if (event.getSource().equals(soc)){
            clickedbtn = soc1;
        }
        else{
            clickedbtn = soc;
        }
        
        switchLang();
    }

    @FXML
    private void OnAdd(ActionEvent event) {
        if (isWordMode){
            if (addwordstage.getOwner() == null)
                addwordstage.initOwner(((Node)event.getSource()).getScene().getWindow());
            
            addwordcon.setAddMode();
            
            addwordstage.showAndWait();
            WinUtils.memFree();
        }
        else{
            if (addexstage.getOwner() == null)
                addexstage.initOwner(((Node)event.getSource()).getScene().getWindow());
            
            excon.setAddMode();
            
            addexstage.showAndWait();
            WinUtils.memFree();
        }
    }

    @FXML
    private void OnDelete(ActionEvent event) {
        removeChecking();
        updateChecking();
        WinUtils.memFree();
    }

    @FXML
    private void OnModify(ActionEvent event) {
        AnchorPane pane = (AnchorPane)lv.getItems().get(lv.getSelectionModel().getSelectedIndex());
        ExBoxController conpane = (ExBoxController) pane.getUserData();
        
        if (isWordMode){
            addwordcon.setModifyMode(conpane.part.getText(), conpane.ex1.getText(), conpane.ex2.getText());
            if (addwordstage.getOwner() == null)
                addwordstage.initOwner(((Node)event.getSource()).getScene().getWindow());

            addwordstage.showAndWait();
            WinUtils.memFree();
        }
        else{
            excon.setModifyMode(conpane.ex1.getText(), conpane.ex2.getText());
            
            if (addexstage.getOwner() == null){
                addexstage.initOwner(((Node)event.getSource()).getScene().getWindow());
            }
            
            addexstage.showAndWait();
            WinUtils.memFree();
        }
    }
    
    public void setWordMode(){
        lbltip.setText("'새 뜻/동의어 추가' 버튼을 클릭하여 항목을 추가하세요.");
        lbladd.setText("새 뜻/동의어 추가");
        lbldel.setText("체크된 뜻/동의어 삭제");
        lblmod.setText("선택된 뜻/동의어 수정");
        
        isWordMode = true;
        WinUtils.memFree();
    }
    
    public void setExampleMode(){
        lbltip.setText("'새 예문/예문 해석 추가' 버튼을 클릭하여 항목을 추가하세요.");
        lbladd.setText("새 예문/예문 해석 추가");
        lbldel.setText("체크된 예문/예문 해석 삭제");
        lblmod.setText("선택된 예문/예문 해석 수정");
        
        isWordMode = false;
        WinUtils.memFree();
    }

    @FXML
    private void onClear(MouseEvent event) {
        tfield.clear();
        clearpane.setVisible(false);
        WinUtils.memFree();
    }
}
