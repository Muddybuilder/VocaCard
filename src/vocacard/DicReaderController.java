/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DicReaderController implements Initializable {

    @FXML
    private Label lbltitle;
    @FXML
    private Label lblsubtitle;
    @FXML
    private Button btnsel;
    @FXML
    private Pane daum;
    @FXML
    private Pane dic;
    @FXML
    private Pane naver;
    @FXML
    private WebView nweb;
    @FXML
    private Button btnnsend;

    WebEngine engine;

    String html;

    /**
     * Initializes the controller class.
     */
    MergeTag mt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mt = new MergeTag();
        engine = nweb.getEngine();
        nweb.setFontSmoothingType(FontSmoothingType.GRAY);
        engine.setJavaScriptEnabled(true);
        nweb.setContextMenuEnabled(false);
        engine.load("http://m.krdic.naver.com");// 바꿀부분1

        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override

            public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {

                if (newValue.equals(State.SUCCEEDED)) {

                }
            }
        });

        btnnsend.setDisable(false);
    }

    private void parseEnDic() {
        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("h2.dht5 strong");
        System.out.println(rows.text()); //단어명
        rows.clear();

        rows = doc.select("div.dh1t span.sort");
        for (Element row : rows) {
            System.out.println(row.text()); // 발음기호 종류
        }

        rows.clear();

        rows.clear();
        rows = doc.select("div.dh1t span.sym");
        for (Element row : rows) {
            System.out.println(row.text()); // 발음기호 목록
        }

        rows.clear();
        rows = null;
        doc = null;
    }

    private void parseKrdic() {
        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("div.dnt dt.tit_z");
        Elements tmp = doc.select("div#ct div.con h2.con_z");
        String res;

        rows.select("span").remove();
        mt.setName(rows.text());

        //뜻,동의어,예문,예문해석
        System.out.println(rows.text());

        rows = doc.select("div#ct div.con h2.con_z");
        rows.select("span").remove();

        //System.out.println(rows.text());
        rows = doc.select("div#ct div.con ol li.li dl dt.lt");
        rows.select("dd.inf2.wordHidden").remove();
        rows.select("dd.inf3.wordHidden").remove();

        for (Element e : rows) {
            res = e.text();
           res =  Pattern.compile("^<(.*)>").matcher(res).replaceAll("");
            res = Pattern.compile("^\\[(.*)\\]").matcher(res).replaceAll("");

            mt.addPtesm(tmp.text(), res, "", "", "");

          //  mt.addPtesm(html, html, html, html, html, html);
//            tmp = e.select("dd.inf2");
//          
//            for(Element ee : tmp)
//            {
//                 System.out.println(ee.text());
//            }
        }
        for (int i = 0; i < mt.ptesm.size(); i++) {
            System.out.println(mt.ptesm.get(i));
        }
        rows.clear();
    }

    private void parseHanjadic() {

        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("div#ct div.h_word");
        Elements mean = doc.select("div#ct div.word ol.ul_s li.ul_s_l");

        rows.select("div.p_word em.col").remove();
        rows.select("div.p_word span").remove();
        System.out.println(rows.text());
        for (Element e : mean) {

            System.out.println(e.text());
        }
    }

    private void parseFrDic() {

        org.w3c.dom.Document dc = engine.getDocument();

        try {
            StringWriter writer = new StringWriter();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            StreamResult sres = new StreamResult(writer);
            transformer.transform(new DOMSource(dc),
                    sres);

            html = writer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("div#_mainView div#container div.entry_top ");
        System.out.println(rows.text());
    }

    @FXML
    private void onSelectInfo(ActionEvent event) {

    }

    @FXML
    private void OnSend(ActionEvent event) {
        if (engine.getLocation().contains("m.krdic.naver.com")) { //바꿀부분2
            html = (String) engine.executeScript("document.documentElement.outerHTML");
            parseKrdic(); //바꿀함수

        } else if (engine.getLocation().contains("m.hanja.naver.com")) {
            html = (String) engine.executeScript("document.documentElement.outerHTML");
            parseHanjadic();

        }
        if (engine.getLocation().contains("m.frdic.naver.com")) {
            System.out.println(engine.getLocation());
            html = (String) engine.executeScript("document.getElementById('container').innerHTML");
            parseFrDic();
        }
    }

}
