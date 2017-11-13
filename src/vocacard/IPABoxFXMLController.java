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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

/**
 * FXML Controller class
 *
 * @author user
 */
public class IPABoxFXMLController implements Initializable {
    @FXML
    public Pane tipbox;
    @FXML
    private BorderPane root;
    @FXML
    private Rectangle root1;
    @FXML
    private BorderPane root3;
    @FXML
    public TextField tfield;
    @FXML
    private Pane clearpane;
    @FXML
    private ImageView clear;
    @FXML
    private ImageView tview;
    @FXML
    private AnchorPane root4;
    @FXML
    private Rectangle root2;
    @FXML
    private Button btnsel;
    @FXML
    private SVGPath svg;
    @FXML
    private Pane supra;
    @FXML
    private VBox svbox;
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
    private Button s6;
    @FXML
    private Button s7;
    @FXML
    private Button s8;
    @FXML
    private Button s9;
    @FXML
    private Pane other;
    @FXML
    private VBox ovbox;
    @FXML
    private Button o1;
    @FXML
    private Button o2;
    @FXML
    private Button o3;
    @FXML
    private Button o4;
    @FXML
    private Button o5;
    @FXML
    private Button o6;
    @FXML
    private Button o7;
    @FXML
    private Button o8;
    @FXML
    private Button o9;
    @FXML
    private Button o10;
    @FXML
    private Button o11;
    @FXML
    private Button o12;
    @FXML
    private Button o13;
    @FXML
    private Button o14;
    @FXML
    private Button o15;
    @FXML
    private Button o16;
    @FXML
    private Button o17;
    @FXML
    private Pane non_pulmo;
    @FXML
    private VBox npbox;
    @FXML
    private Button n1;
    @FXML
    private Button n2;
    @FXML
    private Button n3;
    @FXML
    private Button n4;
    @FXML
    private Button n5;
    @FXML
    private Button n6;
    @FXML
    private Button n7;
    @FXML
    private Button n8;
    @FXML
    private Button n9;
    @FXML
    private Button n10;
    @FXML
    private Button n11;
    @FXML
    private Button n12;
    @FXML
    private Button n13;
    @FXML
    private Button n14;
    @FXML
    private Button n15;
    @FXML
    private Pane diacritics;
    @FXML
    private VBox dvbox;
    @FXML
    private Button d1;
    @FXML
    private Button d2;
    @FXML
    private Button d3;
    @FXML
    private Button d4;
    @FXML
    private Button d5;
    @FXML
    private Button d6;
    @FXML
    private Button d7;
    @FXML
    private Button d8;
    @FXML
    private Button d9;
    @FXML
    private Button d10;
    @FXML
    private Button d11;
    @FXML
    private Button d12;
    @FXML
    private Button d13;
    @FXML
    private Button d14;
    @FXML
    private Button d15;
    @FXML
    private Button d16;
    @FXML
    private Button d17;
    @FXML
    private Button d18;
    @FXML
    private Button d19;
    @FXML
    private Button d20;
    @FXML
    private Button d21;
    @FXML
    private Button d22;
    @FXML
    private Button d23;
    @FXML
    private Button d24;
    @FXML
    private Button d25;
    @FXML
    private Button d26;
    @FXML
    private Button d27;
    @FXML
    private Button d28;
    @FXML
    private Button d29;
    @FXML
    private Button d30;
    @FXML
    private Button d31;
    @FXML
    private Button d32;
    @FXML
    private Pane tones;
    @FXML
    private VBox tvbox;
    @FXML
    private Button t1;
    @FXML
    private Button t2;
    @FXML
    private Button t3;
    @FXML
    private Button t4;
    @FXML
    private Button t5;
    @FXML
    private Button t6;
    @FXML
    private Button t7;
    @FXML
    private Button t8;
    @FXML
    private Button t9;
    @FXML
    private Button t10;
    @FXML
    private Button t11;
    @FXML
    private Button t12;
    @FXML
    private Button t13;
    @FXML
    private Button t14;
    @FXML
    private Button t15;
    @FXML
    private Pane help;
    @FXML
    private Pane selector;
    @FXML
    private VBox vbox;
    @FXML
    private Button btn0;
    @FXML
    private Line ln;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClear(MouseEvent event) {
    }

    @FXML
    private void onToggle(MouseEvent event) {
    }

    @FXML
    private void onSelectReleased(ActionEvent event) {
    }

    @FXML
    private void onPushText(ActionEvent event) {
    }

    @FXML
    private void onbtn0Released(ActionEvent event) {
    }

    @FXML
    private void onbtn1Released(ActionEvent event) {
    }

    @FXML
    private void onbtn2Released(ActionEvent event) {
    }

    @FXML
    private void onbtn3Released(ActionEvent event) {
    }

    @FXML
    private void onbtn4Released(ActionEvent event) {
    }

    @FXML
    private void onbtn5Released(ActionEvent event) {
    }

    @FXML
    private void onRootReleased(MouseEvent event) {
    }
    
}
