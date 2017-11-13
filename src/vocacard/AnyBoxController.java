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
public class AnyBoxController implements Boxable, Initializable {
    @FXML
    private Pane root;
    @FXML
    private VBox vbox;
    @FXML
    private TextFlow tf0;
    @FXML
    private Text txt0;
    @FXML
    private ImageView img0;
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
    private TextFlow tf3;
    @FXML
    private Text txt3;
    @FXML
    private ImageView img3;
    @FXML
    private CheckBox chk;
    
    String tag;
    @FXML
    private Label lbltitle;

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
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("AnyBox.fxml"));
            node = fx2.load();
            node.setUserData((AnyBoxController) fx2.getController());
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
            
            if (tag.startsWith("<ANSYNYMDATA ") && tag.endsWith(" />")){
                String type = TagParser.valueParse(tag, "type");
                
                if (type.equals("AY") || type.equals("SY")){
                    String text = TagParser.valueParse(tag, "text");
                    if (text.length() == 0){
                        type = null;
                        text = null;
                        tag = null;
                        WinUtils.memFree();
                        return false;
                    }
                    
                    if (type.equals("AY"))
                        lbltitle.setText("[반의어]");
                    else
                        lbltitle.setText("[유의어]");
                    
                    String cls = TagParser.valueParse(tag, "class");
                    String meaning = TagParser.valueParse(tag, "meaning");
                    String ex = TagParser.valueParse(tag, "ex");
                    String tex = TagParser.valueParse(tag, "tex");
                    
                    txt0.setText(text);
                    img0.setImage(KeyList.getKeyInfo(VocaCard.fromLang).img);
                    
                    tf1.setVisible(false);
                    tf2.setVisible(false);
                    tf3.setVisible(false);
                    
                    String clsmean = "";
                    if (cls.length() > 0)
                        clsmean = cls + ") ";
                    
                    if (meaning.length() > 0){
                        tf1.setVisible(true);
                        clsmean += meaning;
                        
                        txt1.setText(clsmean);
                        img1.setImage(KeyList.getKeyInfo(VocaCard.toLang).img);
                    }
                    
                    if (ex.length() > 0){
                        tf2.setVisible(true);
                        txt2.setText(ex);
                        img2.setImage(KeyList.getKeyInfo(VocaCard.fromLang).img);
                    }
                    
                    if (tex.length() > 0){
                        tf3.setVisible(true);
                        txt3.setText(tex);
                        img3.setImage(KeyList.getKeyInfo(VocaCard.toLang).img);
                    }
                    
                    type = null;
                    text = null;
                    tag = null;
                    cls = null;
                    meaning = null;
                    ex = null;
                    tex = null;
                    
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
        String res = "";
        if (lbltitle.getText().equals("[반의어]")){
            res = "<ANSYNYMDATA TYPE=\"AY\" TEXT=\"%s\" CLASS=\"%s\" MEANING=\"%s\" EX=\"%s\" TEX=\"%s\"";
        }
        else if (lbltitle.getText().equals("[유의어]")){
            res = "<ANSYNYMDATA TYPE=\"SY\" TEXT=\"%s\" CLASS=\"%s\" MEANING=\"%s\" EX=\"%s\" TEX=\"%s\"";
        }
        
        String cls = "";
        String mean = "";
        if (txt1.getText().contains(") ")){
            int n1 = txt1.getText().indexOf(") ");
            cls = txt1.getText().substring(0, n1-1);
            mean = txt1.getText().substring(n1 + 2);
        }
        
        String ex = (tf2.isVisible()) ? txt2.getText() : "";
        String tex = (tf3.isVisible()) ? txt3.getText() : "";
        
        res = String.format(res, txt0.getText(), cls, mean, ex, tex);
        
        int pos = 0;
        while((pos = res.indexOf("=\"\"")) >= 0){
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos+3);
            res = res.replace(posarr, "");
        }
       
        cls = null;
        mean = null;
        ex = null;
        tex = null;
        
        WinUtils.memFree();

        return res;
    }

    @Override
    public void setAutoSize(BoxView boxes) {
        vbox.setPrefWidth(boxes.getPrefWidth() - 14);
        txt0.setWrappingWidth(vbox.getPrefWidth()-30);
        txt1.setWrappingWidth(vbox.getPrefWidth()-30);
        txt2.setWrappingWidth(vbox.getPrefWidth()-30);
        txt3.setWrappingWidth(vbox.getPrefWidth()-30);
        
        tf0.setPrefWidth(vbox.getPrefWidth());
        tf1.setPrefWidth(vbox.getPrefWidth());
        tf2.setPrefWidth(vbox.getPrefWidth());
        tf3.setPrefWidth(vbox.getPrefWidth());
        
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
