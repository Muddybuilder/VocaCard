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
public class MeanBoxController implements Boxable, Initializable {
    @FXML
    private Pane root;
    @FXML
    private VBox vbox;
    @FXML
    private Text txt1;
    @FXML
    private ImageView img1;
    @FXML
    private Text txt2;
    @FXML
    private Text txt3;
    @FXML
    private Text txt4;
    @FXML
    private CheckBox chk;
    @FXML
    private TextFlow tf1;
    @FXML
    private TextFlow tf2;
    @FXML
    private TextFlow tf3;
    @FXML
    private TextFlow tf4;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;

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
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("MeanBox.fxml"));
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

                if (type.equals("PSM")){
                    String cls = TagParser.valueParse(tag, "class");
                    String meaning = TagParser.valueParse(tag, "meaning");
                    if (meaning.length() == 0){
                        cls = null;
                        type = null;
                        tag = null;
                        WinUtils.memFree();
                        return false;
                    }
                    String syn = TagParser.valueParse(tag, "synonym");
                    String ex = TagParser.valueParse(tag, "ex");
                    String tex = TagParser.valueParse(tag, "tex");
                    
                    tf2.setVisible(false);
                    tf3.setVisible(false);
                    tf4.setVisible(false);
                    
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");
                    
                    //add Value
                    if (cls.length() > 0){
                        txt1.setText(cls + ") " + meaning);
                    }
                    else txt1.setText(meaning);
                    
                    //
                    if (syn.length() > 0){
                        tf2.setVisible(true);
                        txt2.setText(syn);
                    }
                    
                    //
                    if (ex.length() > 0){
                        tf3.setVisible(true);
                        txt3.setText(ex);
                    }
                    
                    //
                    if (tex.length() > 0){
                        tf4.setVisible(true);
                        txt4.setText(tex);
                    }
                    
                    cls = null;
                    meaning = null;
                    syn = null;
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
    public String toTag() {
        String res = "<PTESMDATA TYPE=\"PSM\" CLASS=\"%s\" MEANING=\"%s\" SYNONYM=\"%s\" EX=\"%s\" TEX=\"%s\" />";
        
        String cls = "";
        String mean = "";
        if (txt1.getText().contains(") ")){
            int n1 = txt1.getText().indexOf(") ");
            cls = txt1.getText().substring(0, n1-1);
            mean = txt1.getText().substring(n1 + 2);
        }
        else mean = txt1.getText();
        
        res = String.format(res, cls, mean, txt2.getText(), txt3.getText(), txt4.getText());

        int pos = 0;
        while((pos = res.indexOf("=\"\"")) >= 0){
            String posarr = res.substring(res.lastIndexOf(" ", pos), pos+3);
            res = res.replace(posarr, "");
        }

        cls = null;
        mean = null;
        WinUtils.memFree();

        return res;
    }

    @Override
    public void setAutoSize(BoxView boxes) {
        vbox.setPrefWidth(boxes.getPrefWidth() - 20);
        txt1.setWrappingWidth(vbox.getPrefWidth()-30);
        txt2.setWrappingWidth(vbox.getPrefWidth()-30);
        txt3.setWrappingWidth(vbox.getPrefWidth()-30);
        txt4.setWrappingWidth(vbox.getPrefWidth()-30);
        
        tf1.setPrefWidth(vbox.getPrefWidth());
        tf2.setPrefWidth(vbox.getPrefWidth());
        tf3.setPrefWidth(vbox.getPrefWidth());
        tf4.setPrefWidth(vbox.getPrefWidth());
        
        root.autosize();
    }    

    @Override
    public String getValue(String key) {
        return TagParser.valueParse(toTag(), key);
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
