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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ToolTipButtonController implements Initializable {
    @FXML
    private Button s1;
    @FXML
    private Label c1;
    @FXML
    private Label c0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void setNum(String num){
        c0.setText(num);
    }
    
    public void setData(String data){
        c1.setText(data);
    }

    @FXML
    private void onButtonCharAction(ActionEvent event) {
    }
    
}
