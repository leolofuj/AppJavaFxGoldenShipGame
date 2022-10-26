/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package appfxjogonavio;

//import AlertTime;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leonardo
 */
public class FXMLGameContController implements Initializable {
    
    TimerTask task2;
    
    EventPoints pv = new EventPoints(); 
    Stage stage;
    Timer timer = new Timer();
    int secondsPassed = 0;
    int minutesPassed = 0;
    
    @FXML
    private AnchorPane paneContent;
    @FXML
    private GridPane gridContent;
    //private Button btnNavioJogo;
    @FXML
    private ImageView imgNavio;
    @FXML
    private Button btnNavio;
    @FXML
    private Button btnNavio1;
    @FXML
    private ImageView imgNavio1;
    @FXML
    private Button btnNavio2;
    @FXML
    private ImageView imgNavio2;
    @FXML
    private Button btnNavio3;
    @FXML
    private ImageView imgNavio3;
    @FXML
    private Button btnNavio4;
    @FXML
    private ImageView imgNavio4;
    @FXML
    private Button btnNavio5;
    @FXML
    private ImageView imgNavio5;
    @FXML
    private Button btnNavio6;
    @FXML
    private ImageView imgNavio6;
    @FXML
    private Button btnNavio7;
    @FXML
    private ImageView imgNavio7;
    @FXML
    private Button btnNavio8;
    @FXML
    private ImageView imgNavio8;
    @FXML
    private Button btnNavio9;
    @FXML
    private ImageView imgNavio9;
    @FXML
    private Button btnNavio10;
    @FXML
    private ImageView imgNavio10;
    @FXML
    private Button btnNavio11;
    @FXML
    private ImageView imgNavio11;
    @FXML
    private Button btnNavio12;
    @FXML
    private ImageView imgNavio12;
    @FXML
    private Button btnNavio13;
    @FXML
    private ImageView imgNavio13;
    @FXML
    private Button btnNavio14;
    @FXML
    private ImageView imgNavio14;
    @FXML
    private Button btnNavio15;
    @FXML
    private ImageView imgNavio15;
    
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
   
    Dialog<ButtonType> dg;
    
    AppFxShipGame jgNavio = new AppFxShipGame();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try{
          // create new Dialog pane
          FXMLLoader fxmlLoader = new FXMLLoader();
          fxmlLoader.setLocation(getClass().getResource("/appfxjogonavio/FXMLDialogPane.fxml"));
          Text t = new Text("Try to accumulate as many points as possible in 30 sec\nby trying to retrieve the valuable golden ship");
          t.setId("dgText");
          try {
              DialogPane dgPane = fxmlLoader.load();
              Parent root;
              root = (Parent) dgPane;
          } catch (IOException ex) {
              System.err.println("erro " + ex);
          }
          FXMLDialogPaneController jogoControllerPane = (FXMLDialogPaneController) fxmlLoader.getController();
          dg = new Dialog<>();
          jogoControllerPane.initData(dg);
          Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
          dg.setX(bounds.getMaxX() - 450);
          dg.setY(bounds.getMinY() + 185);
          dg.setHeaderText(t.getText());
          dg.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
          dg.show();
          // Create new task
            this.task2 = new TimerTask() {
            @Override
            public void run() {
            Platform.runLater(() -> {
                // Load stage buttons
                  pv.criarBotao(btnNavio, imgNavio);
                  pv.criarBotao(btnNavio1, imgNavio1);
                  pv.criarBotao(btnNavio2, imgNavio2);
                  pv.criarBotao(btnNavio3, imgNavio3);
                  pv.criarBotao(btnNavio4, imgNavio4);
                  pv.criarBotao(btnNavio5, imgNavio5);
                  pv.criarBotao(btnNavio6, imgNavio6);
                  pv.criarBotao(btnNavio7, imgNavio7);
                  pv.criarBotao(btnNavio8, imgNavio8);
                  pv.criarBotao(btnNavio9, imgNavio9);
                  pv.criarBotao(btnNavio10, imgNavio10);
                  pv.criarBotao(btnNavio11, imgNavio11);
                  pv.criarBotao(btnNavio12, imgNavio12);
                  pv.criarBotao(btnNavio13, imgNavio13);
                  pv.criarBotao(btnNavio14, imgNavio14);
                  pv.criarBotao(btnNavio15, imgNavio15);
            });      
                 
            if(stage.isShowing()){
               secondsPassed++;
              Platform.runLater(() -> {
                String result = (pv.points < 100) ? "" + pv.points : "";
                dg.setContentText(">>>>>Time Passed : " + minutesPassed + " : " + secondsPassed + "  // points achieved: " + result);
                  
              });
            }else{
               secondsPassed = 0;
               minutesPassed = 0;
            }
            
            if(secondsPassed == 60){
               secondsPassed = 0;
               minutesPassed += 1;
          }  
             if((secondsPassed >= 30) ) {
                Platform.runLater(() -> {
                    task2.cancel();
                    alert.setTitle("Game Alert");
                    alert.setHeaderText("Golden Ship Game");
                    alert.setContentText("You lost the game..:(");
                    alert.setResizable(false);
                    Optional<ButtonType> clickedButton = alert.showAndWait();

                    if(clickedButton.get() == ButtonType.OK){
                        System.out.println("ok pressed");
                          stage.close(); 
                          dg.hide();
                          dg.close(); 
                    }
                });
            }
            if(pv.points >= 100){
             Platform.runLater(() -> {
                    task2.cancel();
                    alert.setTitle("Game Alert");
                    alert.setHeaderText("Golden Ship Game");
                    alert.setContentText("You won the game!:)");
                    alert.setResizable(false);
                    Optional<ButtonType> clickedButton = alert.showAndWait();

                    if(clickedButton.get() == ButtonType.OK){
                        System.out.println("ok pressed");
                          stage.close();
                          dg.hide();
                          dg.close(); 
                    }
                });
                        }
                    
                 }
             };
                
            }catch(Exception e){
                System.err.println("erro " + e);
            }
          
        timer.scheduleAtFixedRate(task2, 1000, 1000);

    }


    @FXML
    private void handleBtnActionGame(ActionEvent event) {
      
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public int getMinutesPassed() {
        return minutesPassed;
    }
    public void exit(ActionEvent actionEvent){
        stage.close();
        
    }

    
    void initData(Stage stage) {
        this.stage = stage;
    }

}
