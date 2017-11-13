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
import javafx.scene.control.CheckBox;
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
public class IdBoxController implements Boxable, Initializable {
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
    private ImageView img2;
    @FXML
    private CheckBox chk;
    
    String tag;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public Parent clone() {
        Parent node = null;
        try{
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("IdBox.fxml"));
            node = fx2.load();
            node.setUserData((IdBoxController) fx2.getController());
        }
        catch(Exception ex){
            return null;
        }
        
        return node;
    }

    @Override
    public boolean setTag(String tag) {
        try{
            this.tag = tag;
            
            if (tag.startsWith("<IDIOMDATA ") && tag.endsWith(" />")){
                String text = TagParser.valueParse(tag, "text");
                if (text.length() == 0){
                    text = null;
                    tag = null;
                    WinUtils.memFree();
                    return false;
                }
                String meaning = TagParser.valueParse(tag, "meaning");
                
                txt1.setText(text);
                img1.setImage(KeyList.getKeyInfo(VocaCard.fromLang).img);
                
                tf2.setVisible(false);
                if (meaning.length() > 0){
                    tf2.setVisible(true);
                    txt2.setText(meaning);
                    img2.setImage(KeyList.getKeyInfo(VocaCard.toLang).img);
                }
                
                text = null;
                meaning = null;
                WinUtils.memFree();
                
                return true;
            }
        }
        catch(Exception ex){
            tag = null;
            return false;
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
       String res = "<IDIOMDATA TEXT=\"%s\" MEANING=\"%s\"";
       
       res = String.format(res, txt1.getText(), txt2.getText());
       
        int pos = 0;
        while((pos = res.indexOf("=\"\"")) >= 0){
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos+3);
            res = res.replace(posarr, "");
        }
        
        return res;
    }

    @Override
    public void setAutoSize(BoxView boxes) {
        vbox.setPrefWidth(boxes.getPrefWidth() - 14);
        txt1.setWrappingWidth(vbox.getPrefWidth()-30);
        txt2.setWrappingWidth(vbox.getPrefWidth()-30);
        
        tf1.setPrefWidth(vbox.getPrefWidth());
        tf2.setPrefWidth(vbox.getPrefWidth());
        
        root.autosize();
    }

    @Override
    public boolean isContains(String start, String end) {
        return (tag.startsWith(start) && tag.endsWith(end));
    }

    @Override
    public boolean isContains(String find) {
        return true;
    }
    
}
