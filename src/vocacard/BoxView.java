/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import java.util.Vector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;

/**
 *
 * @author user
 */
public class BoxView extends ListView<Parent>{
    public enum PaneType{TRANSBOX, MEANBOX, PHOBOX, ANSBOX, IDIOMBOX, PICBOX};
    Pane parent;
    PaneType type;
    
    public BoxView(Pane parent){
        this.parent = parent;
        this.setEditable(false);
        this.setFixedCellSize(-1);
        this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        parent.getChildren().add(this);
        setPrefSize(parent.getPrefWidth(), parent.getPrefHeight());
    }
    
    public PaneType getType(){
        return type;
    }
    
    public void setType(PaneType type){
        this.type = type;
    }
    
    public boolean addItem(String tag){
        try{
            if (type == PaneType.TRANSBOX){
                FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("TransBox.fxml"));
                Parent meanbox = fx0.load();
                TransBoxController meancon = (TransBoxController) fx0.getController();

                if (meancon.setTag(tag)){
                    meanbox.setUserData(meancon);
                    meancon.setAutoSize(this);
                    this.getItems().add(meanbox);
                }
                else{
                    meancon = null;
                    meanbox = null;
                    fx0 = null;
                    WinUtils.memFree();
                    return false;
                }
                
                fx0 = null;
                WinUtils.memFree();
                return true;
            }
            else if (type == PaneType.MEANBOX){
                FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("MeanBox.fxml"));
                Parent meanbox = fx0.load();
                MeanBoxController meancon = (MeanBoxController) fx0.getController();

                if (meancon.setTag(tag)){
                    meancon.setAutoSize(this);
                    meanbox.setUserData(meancon);                
                    this.getItems().add(meanbox);
                }
                else{
                    meancon = null;
                    meanbox = null;
                    fx0 = null;
                    WinUtils.memFree();
                    return false;
                }
                
                fx0 = null;
                WinUtils.memFree();
                return true;
            }
            else if (type == PaneType.PHOBOX){
                FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("PhoBox.fxml"));
                Parent phobox = fx0.load();
                PhoBoxController phocon = (PhoBoxController) fx0.getController();

                if (phocon.setTag(tag)){
                    phobox.setUserData(phocon);
                    phocon.setAutoSize(this);
                    this.getItems().add(phobox);
                }
                else{
                    phocon = null;
                    phobox = null;
                    fx0 = null;
                    WinUtils.memFree();
                    return false;
                }
                
                fx0 = null;
                WinUtils.memFree();
                return true;
            }
            else if (type == PaneType.ANSBOX){
                FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("AnyBox.fxml"));
                Parent anybox = fx0.load();
                AnyBoxController anycon = (AnyBoxController) fx0.getController();

                if (anycon.setTag(tag)){
                    anybox.setUserData(anycon);
                    anycon.setAutoSize(this);
                    this.getItems().add(anybox);
                }
                else{
                    anycon = null;
                    anybox = null;
                    fx0 = null;
                    WinUtils.memFree();
                    return false;
                }
                
                fx0 = null;
                WinUtils.memFree();
                return true;
            }
            else if (type == PaneType.IDIOMBOX){
                FXMLLoader fx0 = new FXMLLoader(VocaCard.class.getResource("IdBox.fxml"));
                Parent anybox = fx0.load();
                IdBoxController anycon = (IdBoxController) fx0.getController();

                if (anycon.setTag(tag)){
                    anybox.setUserData(anycon);
                    anycon.setAutoSize(this);
                    this.getItems().add(anybox);
                }
                else{
                    anycon = null;
                    anybox = null;
                    fx0 = null;
                    WinUtils.memFree();
                    return false;
                }
                
                fx0 = null;
                WinUtils.memFree();
                return true;
            }
        }
        catch(Exception ex){
            return false;
        }
        
        return false;
    }
    
    public void setAutoSize(){
        this.setPrefSize(parent.getPrefWidth(), parent.getPrefHeight());
    }
    
    public int getCheckedCount(){
        int cnt = 0;
        for (Parent box : getItems()){
            if (((Boxable)box.getUserData()).isChecked())
                cnt++;
        }
        return cnt;
    }
        
    public Vector<Parent> getCheckedItems(){
        Vector<Parent> boxes = new Vector<Parent>();
        for (Parent box : getItems()){
            if (((Boxable)box.getUserData()).isChecked()){
                boxes.add(box);
            }
        }
        
        return boxes;
    }
    
    public void removeAll(){
        this.getItems().clear();
        WinUtils.memFree();
    }
    
    public void removeChecked(){
        this.getItems().removeAll(getCheckedItems());
        WinUtils.memFree();
    }
    
    public int size(){
        return getItems().size();
    }
    
    public Parent getItem(int n){
        Parent p =  getItems().get(n);
        if (!(p.getUserData() instanceof Boxable))
            return null;
        
        return p;
    }
    
    public Parent getSelectedItem(){
        int index = getSelectionModel().getSelectedIndex();
        if (index == -1)
            return null;
        
        Parent p = getItems().get(index);
        if (p == null)
            return null;
        
        if (!(p.getUserData() instanceof Boxable))
            return null;
        
        return p;
    }
    
    public String getSelectedToTag(){
        Parent seled = getSelectedItem();
        if (seled == null || !(seled.getUserData() instanceof Boxable))
            return "";
        
        return ((Boxable)(seled)).toTag();
    }
    
    public boolean isChecked(){
        for (Parent box : getItems()){
            if (((Boxable)box.getUserData()).isChecked()){
                return true;
            }
        }
        return false;
    }
    
    public boolean isSelected(){
        return (getSelectedItem() != null);
    }
    
    public String toTagAll(boolean isChecked){
        StringBuilder builder = new StringBuilder();
        
        //MEANBOX, PHOBOX, ANSBOX, IDIOMBOX, PICBOX, TXTBOX
        if (type == PaneType.MEANBOX)
            builder.append("<PTESM>\n");        
        else if (type == PaneType.PHOBOX)
            builder.append("<PHOSND>\n");
        else if (type == PaneType.ANSBOX)
            builder.append("<AMSYNYM>\n");
        else if (type == PaneType.IDIOMBOX)
            builder.append("<IDIOM>\n");
        
        if (!isChecked){
            for (Parent box : getItems()){
                if (box.getUserData() instanceof Boxable){
                    Boxable boxs = (Boxable)box.getUserData();
                    builder.append(boxs.toTag());
                    builder.append("\n");
                }
            }
        }
        else{
            for (Parent box : getCheckedItems()){
                if (box.getUserData() instanceof Boxable){
                    Boxable boxs = (Boxable)box.getUserData();
                    builder.append(boxs.toTag());
                    builder.append("\n");
                }
            }
        }
        
        if (type == PaneType.MEANBOX)
            builder.append("</PTESM>");
        else if (type == PaneType.PHOBOX)
            builder.append("</PHOSND>");
        else if (type == PaneType.ANSBOX)
            builder.append("</AMSYNYM>");
        else if (type == PaneType.IDIOMBOX)
            builder.append("</IDIOM>");
        
        return builder.toString();
    }
    
    public void checkAll(){
       for (Parent box : getItems()){
            ((Boxable)box.getUserData()).setChecking(true);
        }
    }
    
    public void uncheckAll(){
        for (Parent box : getItems()){
            ((Boxable)box.getUserData()).setChecking(false);
        }
    }
    
    public void deselect(){
        getSelectionModel().clearSelection();
        WinUtils.memFree();
    }
    
    public void distinct(){
        for (Parent box : getItems()){
            if (box instanceof Boxable){
                Boxable boxs = (Boxable)box;
            }
        }
    }
    
    public void undo(){
    }
    
    public void redo(){
        
    }
    
    public void copy(){
        final ClipboardContent con = new ClipboardContent();
        con.putString(toTagAll(true));
        
        Clipboard.getSystemClipboard().setContent(con);
    }
    
    public void cut(){
        final ClipboardContent con = new ClipboardContent();
        con.putString(toTagAll(true));
        
        Clipboard.getSystemClipboard().setContent(con);
        
        removeChecked();        
    }
    
    public void paste(){
        String pasted = Clipboard.getSystemClipboard().getString();
        
        if (type == PaneType.MEANBOX && pasted.startsWith("<PTESM>\n") && 
                pasted.endsWith("\n</PTESM>"))
        {
            String [] split = pasted.split("\n");
            for (int c=1; c<split.length-1; c++){
                addItem(split[c]);
            }
            
            split = null;
            WinUtils.memFree();
        }
    }
    
    public void clear(){
        getItems().clear();
        WinUtils.memFree();
    }
    
    public void resize(){
         setPrefSize(parent.getPrefWidth(), parent.getPrefHeight());
    }
}