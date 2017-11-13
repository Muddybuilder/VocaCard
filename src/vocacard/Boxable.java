/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

import javafx.scene.Parent;

/**
 *
 * @author user
 */
public interface Boxable {
    Parent clone();
    boolean setTag(String tag);
    void setChecking(boolean chk);
    boolean isChecked();
    String getValue(String key);
    String toTag();
    void setAutoSize(BoxView boxes);
    boolean isContains(String start, String end);
    boolean isContains(String find);
}