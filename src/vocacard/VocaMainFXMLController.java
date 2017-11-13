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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author user
 */
public class VocaMainFXMLController implements Initializable {
    @FXML
    private ToggleButton openbtn;
    @FXML
    private Pane opendlg;
    @FXML
    private ScrollPane savedlg;
    @FXML
    private ToggleButton savebtn;
    
    ToggleButton curBtnActive = null;
    Pane curActive = null;
    @FXML
    private ToggleButton previewbtn;
    @FXML
    private ToggleButton printbtn;
    @FXML
    private Pane previewdlg;
    @FXML
    private Pane printdlg;
    @FXML
    private Button btnopen;
    @FXML
    private Button btntxt;
    @FXML
    private Button btnxls;
    
    FileChooser dlg;
    ExtensionFilter vcfilter, txtfilter, xlsfilter;

    @FXML
    private Pane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vcfilter = new ExtensionFilter("단어장 파일(*.vc)", "*.vc");
        txtfilter = new ExtensionFilter("텍스트 파일(*.txt;*.csv)", "*.txt;*.csv");
        xlsfilter = new ExtensionFilter("엑셀 파일(*.xls;*.xlsx)", "*.xls;*xlsx");
        
        dlg = new FileChooser();
        closeDlg();
    }    

    @FXML
    private void onOpen(ActionEvent event) {
        closeDlg();
 
        openbtn.setSelected(!openbtn.isSelected());
        opendlg.setVisible(!opendlg.isVisible());
     }
    
    @FXML
    private void onSave(ActionEvent event) {
        closeDlg();

        savebtn.setSelected(!savebtn.isSelected());
        savedlg.setVisible(!savedlg.isVisible());
    }
    
    private void closeDlg(){        
        openbtn.setSelected(false);
        opendlg.setVisible(false);

        savebtn.setSelected(false);
        savedlg.setVisible(false);
        
        previewbtn.setSelected(false);
        previewdlg.setVisible(false);
        
        printbtn.setSelected(false);
        printdlg.setVisible(false);
    }

    @FXML
    private void onOutside(MouseEvent event) {
        closeDlg();
    }

    @FXML
    private void onPreview(ActionEvent event) {
        closeDlg();

        previewbtn.setSelected(!previewbtn.isSelected());
        previewdlg.setVisible(!previewdlg.isVisible());
    }

    @FXML
    private void onPrint(ActionEvent event) {
        closeDlg();

        printbtn.setSelected(!printbtn.isSelected());
        printdlg.setVisible(!printdlg.isVisible());
    }

    @FXML
    private void onVCOpen(MouseEvent event) {
        closeDlg();
        
        dlg.setTitle("단어장 열기");
        dlg.getExtensionFilters().clear();
        dlg.getExtensionFilters().add(vcfilter);
        
        dlg.showOpenDialog(((Node)event.getTarget()).getScene().getWindow());
    }

    @FXML
    private void onVCOpen(TouchEvent event) {
        closeDlg();
        
        dlg.setTitle("단어장 열기");
        dlg.getExtensionFilters().clear();
        dlg.getExtensionFilters().add(vcfilter);
        dlg.showOpenDialog(((Node)event.getTarget()).getScene().getWindow());
    }    
}
