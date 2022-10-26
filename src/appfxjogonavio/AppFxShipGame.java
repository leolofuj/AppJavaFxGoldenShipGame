/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package appfxjogonavio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author leonardo
 */
public class AppFxShipGame extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    try{

     FXMLLoader fxmlLoader=  new FXMLLoader(this.getClass().getResource("/appfxjogonavio/FXMLDoc.fxml"));
     System.out.println("appfxjogonavio.AppFxJogoNavio.start() " + fxmlLoader.getLocation());     //FXMLLoader.load(getClass().getResource("/appdojogo/FXMLDocument.fxml"));
     Parent root = (Parent) fxmlLoader.load ();
     Scene scene = new Scene(root, 800, 600);
     stage.setTitle("Golden Ship Game");
     stage.setScene(scene);
     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
         @Override
         public void handle(WindowEvent event) {
             try {
                 System.exit(0);
             } catch (Exception ex) {
                 Logger.getLogger(AppFxShipGame.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
            });
        stage.show();

        }catch(Exception e){
            System.err.println("erro: " + e);
        }
    }

   
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
