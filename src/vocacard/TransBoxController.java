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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author user
 */
public class TransBoxController implements Boxable, Initializable {
    @FXML
    private Pane root;
    @FXML
    private VBox vbox;
    @FXML
    private TextFlow tf1;
    @FXML
    private Text txt1;
    @FXML
    private TextFlow tf2;
    @FXML
    private Text txt2;
    @FXML
    private TextFlow tf3;
    @FXML
    private Text txt3;
    @FXML
    private TextFlow tf4;
    @FXML
    private Text txt4;
    @FXML
    private TextFlow tf5;
    @FXML
    private Text txt5;
    @FXML
    private TextFlow tf6;
    @FXML
    private Text txt6;
    @FXML
    private TextFlow tf7;
    @FXML
    private Text txt7;

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
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("TransBox.fxml"));
            node = fx2.load();
            node.setUserData((TransBoxController) fx2.getController());
        }
        catch(Exception ex){
            return null;
        }
        
        return node;
    }

    @Override
    public boolean setTag(String tag) {
         try{            
            if (tag.startsWith("<TRANSFORM ") && tag.endsWith(" />")){
                String cur = TagParser.valueParse(tag, "cur");
                String past = TagParser.valueParse(tag, "past");
                String pp = TagParser.valueParse(tag, "pp");
                
                if (cur.length() == 0 || past.length() == 0 || pp.length() == 0){
                    cur = null;
                    past = null;
                    pp = null;
                    tag = null;
                    
                    WinUtils.memFree();
                    
                    return false;
                }
                txt1.setText(cur + "-" + past + "-" + pp);                
               
                String singular = TagParser.valueParse(tag, "singular");
                String plural = TagParser.valueParse(tag, "plural");
                String present = TagParser.valueParse(tag, "present");
                String noun = TagParser.valueParse(tag, "noun");
                String adj = TagParser.valueParse(tag, "adj");
                String adv = TagParser.valueParse(tag, "adv");
                
                tf2.setVisible(false);
                tf3.setVisible(false);
                tf4.setVisible(false);
                tf5.setVisible(false);
                tf6.setVisible(false);
                tf7.setVisible(false);
                
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                txt5.setText("");
                txt6.setText("");
                txt7.setText("");
                
                if (singular.length() > 0){
                    tf2.setVisible(true);
                    txt2.setText(singular);
                }
                                
                if (plural.length() > 0){
                    tf3.setVisible(true);
                    txt3.setText(plural);
                }
                
                if (present.length() > 0){
                    tf4.setVisible(true);
                    txt4.setText(present);
                }
                
                if (noun.length() > 0){
                    tf5.setVisible(true);
                    txt5.setText(noun);
                }
                
                if (adj.length() > 0){
                    tf6.setVisible(true);
                    txt6.setText(adj);
                }
                
                if (adv.length() > 0){
                    tf7.setVisible(true);
                    txt7.setText(adv);
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
        return;
    }

    @Override
    public boolean isChecked() {
        return true;
    }

    @Override
    public String getValue(String key) {
        return TagParser.valueParse(toTag(), key);
    }

    @Override
    public String toTag() {
        String res = "<TRANSFORM CUR=\"%s\" PAST=\"%s\" PP=\"%s\" SINGULAR=\"%s\" PLURAL=\"%s\" PRESENT=\"%s\" NOUN=\"%s\" ADJ=\"%s\" ADV=\"%s\" />";
        
        String [] split = txt1.getText().split("\\-");
        res = String.format(res, split[0], split[1], split[2], txt2.getText(), txt3.getText(),
                            txt4.getText(), txt5.getText(), txt6.getText(), txt7.getText());
        
        int pos = 0;
        while((pos = res.indexOf("=\"\"")) >= 0){
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos+3);
            res = res.replace(posarr, "");
        }
        
        split = null;
        WinUtils.memFree();
        
        return res;
    }

    @Override
    public void setAutoSize(BoxView boxes) {
        vbox.setPrefWidth(boxes.getPrefWidth() - 14);
        
        txt1.setWrappingWidth(vbox.getPrefWidth()-30);
        txt2.setWrappingWidth(vbox.getPrefWidth()-30);
        txt3.setWrappingWidth(vbox.getPrefWidth()-30);
        txt4.setWrappingWidth(vbox.getPrefWidth()-30);
        txt5.setWrappingWidth(vbox.getPrefWidth()-30);
        txt6.setWrappingWidth(vbox.getPrefWidth()-30);
        txt7.setWrappingWidth(vbox.getPrefWidth()-30);
        
        tf1.setPrefWidth(vbox.getPrefWidth());
        tf2.setPrefWidth(vbox.getPrefWidth());
        tf3.setPrefWidth(vbox.getPrefWidth());
        tf4.setPrefWidth(vbox.getPrefWidth());
        tf5.setPrefWidth(vbox.getPrefWidth());
        tf6.setPrefWidth(vbox.getPrefWidth());
        tf7.setPrefWidth(vbox.getPrefWidth());
        
        root.autosize();
    }

    @Override
    public boolean isContains(String start, String end) {
        String tag = toTag();
        if (tag.contains(start) && tag.contains(end))
            return true;
        
        return false;
    }

    @Override
    public boolean isContains(String find) {
        return true;
    }    
}