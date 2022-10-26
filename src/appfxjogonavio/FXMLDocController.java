/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package appfxjogonavio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leonardo
 */
public class FXMLDocController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnDoJogo;
    
    Stage stage;
    Stage stage2;
    
    EventPoints pv = new EventPoints(); 
    
    Scene scene;
    Scene scene2;
    
    Timer timer2 = new Timer();
    
    TimerTask task;
    
    int tempo = 0;
    
    Dialog<ButtonType> dg;
    //FXMLJogoContController jogoControl= new FXMLGameContController();
    //PontosEvento pv = new EventPoints(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleBtnNewWindow(ActionEvent event) throws IOException {
            stage = new Stage();
            

            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/appfxjogonavio/FXMLGameCont.fxml"));
           
            Parent root;
            root = (Parent) fxmlLoader.load();
            FXMLGameContController jogoController = (FXMLGameContController) fxmlLoader.getController();
            jogoController.initData(stage);
            scene = new Scene(root, 800, 600);
            String css = this.getClass().getResource("Content.css").toExternalForm(); 
            scene.getStylesheets().add(css);
            stage.setTitle("Golden ship game");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(btnDoJogo.getScene().getWindow());

            stage.show();

    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }
    
    
}
