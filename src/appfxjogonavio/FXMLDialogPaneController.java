/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package appfxjogonavio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author leonardo
 */
public class FXMLDialogPaneController implements Initializable {

    @FXML
    private Label ldlGameTitle;
    @FXML
    private Label lblGameText;
    
    Dialog<ButtonType> dg = new Dialog<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 
    
    public void exit(ActionEvent actionEvent){
        dg.close();
        
    }

    public void initData(Dialog<ButtonType> dg) {
        this.dg = dg;
           
    }

    public Dialog<ButtonType> getDg() {
        return dg;
    }

    public void setDg(Dialog<ButtonType> dg) {
        this.dg = dg;
    }
    
    
    
    
}
