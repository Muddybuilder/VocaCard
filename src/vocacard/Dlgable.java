/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocacard;

/**
 *
 * @author user
 */
public interface Dlgable {
    void setAutoSize(double halfw);
    void setBoxView(BoxView boxes);
    void showAddDlg();
    void showModifyDlg(Boxable tag);
}
