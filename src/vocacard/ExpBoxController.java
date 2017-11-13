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
public class ExpBoxController implements Boxable, Initializable {
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

    @FXML
    private Pane root;

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
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("ExpBox.fxml"));
            node = fx2.load();
            node.setUserData((MeanBoxController) fx2.getController());
        }
        catch(Exception ex){
            return null;
        }
        
        return node;
    }

    @Override
    public boolean setTag(String tag) {
        try{            
            if (tag.startsWith("<PTESMDATA ") && tag.endsWith(" />")){
                //type
                String type = TagParser.valueParse(tag, "type");

                if (type.equals("TEX")){
                    String ex = TagParser.valueParse(tag, "ex");
                    if (ex.length() == 0){
                        ex = null;
                        type = null;
                        tag = null;
                        
                        WinUtils.memFree();
                        return false;
                    }
                    String tex = TagParser.valueParse(tag, "tex");
                    
                    tf2.setVisible(false);
                    
                    txt1.setText(ex);
                    img1.setImage(KeyList.getKeyInfo(VocaCard.fromLang).img);
                    
                    if (tex.length() > 0){
                        tf2.setVisible(true);
                        txt2.setText(tex);
                        img2.setImage(KeyList.getKeyInfo(VocaCard.toLang).img);
                    }
                    
                    ex = null;
                    tex = null;
                    type = null;
                    tag = null;
                    WinUtils.memFree();
                    
                    return true;
                }
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
        String res = "<PTESMDATA TYPE=\"TEX\" EX=\"%s\" TEX=\"%s\" />";
        
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
        String tag = toTag();
        return (tag.startsWith(start) && tag.endsWith(end));
    }    

    @Override
    public boolean isContains(String find) {
        return true;
    }
}
