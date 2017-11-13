/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class VocaCard extends Application {
//     public static Image [] imgs;
//     //public static Scene adddlg;
//     public static Stage stage;

    public static int fromLang = 10, toLang = 26;
    public static ImageList image;
    public static ImageUtil imgutil;

    @Override
    public void init() throws Exception {
        super.init();

        image = new ImageList();
        image.initImage();
        
        imgutil = new ImageUtil();
        
//        Font.loadFont(getClass().getResourceAsStream("font/NotoKufiArabic-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoKufiArabic-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoNaskhArabic-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoNaskhArabic-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSans-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSans-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansArmenian-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansArmenian-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansBengali-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansBengali-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKjp-Bold.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKjp-DemiLight.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKkr-Bold.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKkr-DemiLight.otf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKsc-Bold.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKsc-DemiLight.otf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKtc-Bold.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansCJKtc-DemiLight.otf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansDevanagari-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansDevanagari-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansGeorgian-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansGeorgian-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansGujarati-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansGujarati-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansGurmukhi-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansGurmukhi-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansHebrew-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansHebrew-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansKannada-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansKannada-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansLao-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansLao-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansTamil-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansTamil-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansTelugu-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansTelugu-Regular.ttf"), 10);
//        Font.loadFont(getClass().getResourceAsStream("font/NotoSansThai-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/NotoSansThai-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/arial.ttf"), 10);

        WinUtils.InitUtils();

        //adddlg = new Scene(FXMLLoader.load(getClass().getResource("AddWord.fxml")));
    }

    @Override
    public void start(Stage stage) throws Exception {
//        TTSTools.getTTSData(10, "안녕하세요Nice to meet you");
//        Sample samp = new Sample();
//        samp.output();

        /*FXMLLoader loader = new FXMLLoader();
         Parent root = loader.load(
         new ByteArrayInputStream(FXML.getBytes("utf-8"))
         );*/
        //this.stage = stage;
        /*FXMLLoader loader = new FXMLLoader();
         Parent root = loader.load(getClass().getResource("Sample_FXML.fxml").openStream());
         Sample_FXMLController con = (Sample_FXMLController) loader.getController();
         Scene scene = new Scene(root);
         scene.setOnKeyReleased(new EventHandler<KeyEvent>(){

         @Override
         public void handle(KeyEvent event) {
         String text = "";
         if (event.isAltDown())
         text += "Alt+";
         if (event.isControlDown())
         text += "Ctrl+";
         if (event.isShiftDown())
         text += "Shift+";
                
         text += event.getCode().toString();
         con.key.setText(text);
         }
         });
        
        
         */
            FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("DicReader.fxml"));
    //        FXMLLoader fx2 = new FXMLLoader(VocaCard.class.getResource("Ansynym.fxml"));
                    Parent root = fx2.load();
                    //((WordDlgController)(fx2.getController())).setAutoSize(stage);
                    stage.setScene(new Scene(root));
                    stage.show();
                    
                    //stage.setResizable(false);
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                try{
//
//                
//                }
//                catch(Exception ex){
//                    System.out.println(ex.getMessage());
//                }
//            }
//        });
//          
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
