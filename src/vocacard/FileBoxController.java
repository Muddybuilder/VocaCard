/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FileBoxController implements Initializable {
    @FXML
    private StackPane s2;
    @FXML
    private BorderPane imgpane;
    @FXML
    private Label lbldim;
    @FXML
    private Label lblsz;
    @FXML
    private ImageView imgvw;
    @FXML
    private BorderPane sndpane;
    @FXML
    private Button btnplay;
    
    @FXML
    private StackPane s1;
    @FXML
    private Rectangle root1;
    @FXML
    private BorderPane b1;
    @FXML
    private ImageView tview;
    @FXML
    private Label lblerror;
    @FXML
    private TextField path;
    
    FileType type;
    FileChooser dlg;
    
    String data;
    
    Parent parent;
    
    public enum FileType{IMAGEFILE, SNDFILE};    
    private ExtensionFilter fimg, fsnd;
    
    SoundJLayer snd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dlg = new FileChooser();
        
        fimg = new ExtensionFilter("그림 파일(*.png, *.jpg, *.jpeg, *.gif)", "*.png;*.jpg;*.jpeg;*.gif");
        fsnd = new ExtensionFilter("음성 파일(*.mp3)", "*.mp3");
        lblerror.setVisible(false);
        s2.setVisible(false);
        btnplay.setUserData("play");
        
        snd = new SoundJLayer(btnplay);
    }
    
    public void setType(FileType type){
        this.type = type;
    }
    
    public void setData(String data){
        this.data = data;
        
        s2.setVisible(true);
        
        imgpane.setVisible(false);
        sndpane.setVisible(false);
        
        if (type == FileType.IMAGEFILE)
            imgpane.setVisible(true);
        else
            sndpane.setVisible(true);
    }

    @FXML
    private void onPlay(ActionEvent event) {
        if (btnplay.getUserData().equals("play")){
            btnplay.setGraphic(VocaCard.image.stop);
            snd.play(Base64.getDecoder().decode(toBase64()));
            btnplay.setUserData("stop");
        }
        else if (btnplay.getUserData().equals("stop")){
            snd.stop();
            btnplay.setUserData("play");
            btnplay.setGraphic(VocaCard.image.play);
        }
    }
    
    @FXML
    private void onFind(MouseEvent event) {
        try{
            if (type == FileType.IMAGEFILE){
                dlg.setTitle("그림 파일 추가");
                dlg.getExtensionFilters().clear();
                dlg.getExtensionFilters().add(fimg);
            }
            else if (type == FileType.SNDFILE){
                dlg.setTitle("음성 파일 추가");
                dlg.getExtensionFilters().clear();
                dlg.getExtensionFilters().add(fsnd);
            }

            File fp = dlg.showOpenDialog(((Node)event.getTarget()).getScene().getWindow());
            if (fp == null)
                path.setText("");
            else{
                path.setText(fp.getPath());

                data = toBase64();
            }

            if (path.getLength() > 0){
                s2.setVisible(true);
                imgpane.setVisible(false);
                sndpane.setVisible(false);

                if (type == FileType.IMAGEFILE)
                    imgpane.setVisible(true);
                else{
                    sndpane.setVisible(true);
                    BufferedImage bimg = ImageIO.read(new File(path.getText()));
                    int width = bimg.getWidth();
                    int height = bimg.getHeight();

                    imgvw.setImage(VocaCard.imgutil.getJavaFXImage(Base64.getDecoder().decode(toBase64()), width, height));
                }
            }
            else{
                s2.setVisible(false);
            }
        }
        catch(Exception ex){
            
        }
    }
    
    public void setAutoSize(Pane parent){
        this.parent = parent;
        
        double w = parent.getPrefWidth();
        root1.setWidth(w);
        b1.setPrefWidth(w);
        lblerror.setPrefWidth(w);
    }
    
    public void setError(boolean isError){
        root1.setStyle("");
        lblerror.setVisible(false);
        
        if (isError) {
            root1.setStyle("-fx-fill: \n"
                    + "        linear-gradient(\n"
                    + "        to bottom,\n"
                    + "        derive(red,70%) 5%,\n"
                    + "        derive(red,90%) 40%\n"
                    + "        );");
            
            lblerror.setVisible(true);
        }
    }
    
    public void setError(String txt){
        root1.setStyle("");
        lblerror.setVisible(false);
        
        if (txt.length() > 0) {
            root1.setStyle("-fx-fill: \n"
                    + "        linear-gradient(\n"
                    + "        to bottom,\n"
                    + "        derive(red,70%) 5%,\n"
                    + "        derive(red,90%) 40%\n"
                    + "        );");
            
            lblerror.setText(txt);
            lblerror.setVisible(true);
        }
    }
       
    public void clear(){
        path.clear();
    }
    
    public String toBase64(){
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        String res = "";
        try {
            bis = new BufferedInputStream(new FileInputStream(path.getText()));
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[8192];
            int readSize = 0;
            while ((readSize = bis.read(buffer)) > -1) {
                    baos.write(buffer, 0, readSize);
            }

            baos.close();
            bis.close();
            
            res = Base64.getEncoder().encodeToString(baos.toByteArray());
            
            baos = null;
            bis = null;
            buffer = null;
            WinUtils.memFree();
            
        } 
        catch(Exception ex){
            try{
                if (bis != null)
                    bis.close();
                
                if (baos != null)
                    baos.close();
            }
            catch(Exception e){
            }
        }
        
        return res;
    }
    
    @FXML
    private void onChanged(ActionEvent event) {
    }
}

class SoundJLayer extends PlaybackListener implements Runnable
{
    private String path;
    private AdvancedPlayer player;
    private Thread playerThread;
    Button btn;

    public SoundJLayer(Button btn)
    {
        this.btn = btn;
    }

    public void play(byte[] base64)
    {
        try
        {           
            this.player = new AdvancedPlayer(new ByteArrayInputStream(base64));

            this.player.setPlayBackListener(this);

            this.playerThread = new Thread(this, "AudioPlayerThread");

            this.playerThread.start();
            

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // PlaybackListener members

    public void playbackStarted(PlaybackEvent e)
    {
        Platform.runLater(new Runnable(){

            @Override
            public void run() {
                btn.setGraphic(VocaCard.image.stop);
            }
            
        });
        
    }

    public void playbackFinished(PlaybackEvent playbackEvent)
    {
        Platform.runLater(new Runnable(){

            @Override
            public void run() {
                btn.setGraphic(VocaCard.image.play);
            }
            
        });
        

        if (player != null){
            player.close();
            player = null;
            WinUtils.memFree();
        }
        
    }
    
    public void stop(){
        if (player != null){
            player.stop();
            player.close();
            player = null;
            WinUtils.memFree();
        }
    }

    // Runnable members

    public void run()
    {
        try
        {
            this.player.play();
        }
        catch (javazoom.jl.decoder.JavaLayerException ex)
        {
            ex.printStackTrace();
        }

    }
}