/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PhoBoxController implements Boxable, Initializable {
    @FXML
    private Pane root;
    @FXML
    private VBox vbox;
    @FXML
    private TextFlow tf1;
    @FXML
    private Text txt1;
    @FXML
    private ImageView img1;
    @FXML
    private TextFlow tf2;
    @FXML
    private Text txt2;
    @FXML
    private CheckBox chk;
    
    String snddata;
    @FXML
    private TextFlow tf21;
    @FXML
    private Button btnplay;
    @FXML
    private Label lblcur;
    @FXML
    private Label lbltotal;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public Parent clone() {
        Parent node = null;
        try{
            snddata = "";
            
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("PhoBox.fxml"));
            node = fx2.load();
            node.setUserData((PhoBoxController) fx2.getController());
        }
        catch(Exception ex){
            return null;
        }
        
        return node;
    }

    @Override
    public boolean setTag(String tag) {
        try{            
            if (tag.startsWith("<PHOSNDDATA ") && tag.endsWith(" />")){
                String text = TagParser.valueParse(tag, "text");
                                
                if (text.length() == 0){
                    text = null;
                    tag = null;
                    WinUtils.memFree();
                    
                    return false;
                }
                else{
                    txt1.setText(text);                    
                }
                
                String pho = TagParser.valueParse(tag, "phonetic");           
                if (pho.length() == 0){
                    text = null;
                    tag = null;
                    pho = null;                    
                    WinUtils.memFree();
                    
                    return false;
                }
                else{
                    txt2.setText(pho);
                }
                
                String snd = TagParser.valueParse(tag, "sound");
                this.snddata = snd;
                
                if (snd.length() > 0){
                    tf21.setVisible(true);
                    txt2.setText(snd);
                }
                else{
                    tf21.setVisible(false);
                }
                
                return true;
            }
        }
        catch(Exception ex){
            tag = null;
            WinUtils.memFree();
        }
        
        return false;
    }

    @Override
    public void setChecking(boolean chk) {
        this.chk.setSelected(chk);
    }

    @Override
    public boolean isChecked() {
        return chk.isSelected();
    }

    @Override
    public String getValue(String key) {
        return TagParser.valueParse(toTag(), key);
    }

    @Override
    public String toTag() {
        String res = "<PTESMDATA TYPE=\"PSM\" CLASS=\"%s\" MEANING=\"%s\" SYNONYM=\"%s\" EX=\"%s\" TEX=\"%s\" />";
        
        String text = txt1.getText();
        String pho = txt2.getText();
        
        res = String.format(res, text, pho, snddata);
        
        int pos = 0;
        while((pos = res.indexOf("=\"\"")) >= 0){
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos+3);
            res = res.replace(posarr, "");
        }
        
        text = null;
        pho = null;
        WinUtils.memFree();
       
        return res;
    }

    @Override
    public void setAutoSize(BoxView boxes) {
        vbox.setPrefWidth(boxes.getPrefWidth() - 14);
        txt1.setWrappingWidth(vbox.getPrefWidth()-30);
        txt2.setWrappingWidth(vbox.getPrefWidth()-30);
        
        tf1.setPrefWidth(vbox.getPrefWidth());
        tf2.setPrefWidth(vbox.getPrefWidth());
        tf21.setPrefWidth(vbox.getPrefWidth());
        
        root.autosize();
    }

    @Override
    public boolean isContains(String start, String end) {
        String tag = toTag();
        return (tag.startsWith(start) && tag.endsWith(end));
    }

    @Override
    public boolean isContains(String find) {
        return true;
    }    
}
