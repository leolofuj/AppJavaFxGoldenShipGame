/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appfxjogonavio;

import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author leonardo
 */
public class EventPoints {
    
    Button button;
    
    ImageView imgView;
    
    public int points = 0;
    
    String colorUrl = "";
    
    Random r = new Random();
    
    Random r2 = new Random();
    
    Random r3 = new Random();
    
    // Imgs url
    public String[] varColors = {
        "/appfxjogonavio/img/navio_azul.png",
        "/appfxjogonavio/img/navio_laranja.png",
        "/appfxjogonavio/img/navio_roxo.png",
        "/appfxjogonavio/img/navio_verde.png",
        "/appfxjogonavio/img/navio_rubro.png",
        "/appfxjogonavio/img/navio_carmim.png",
        "/appfxjogonavio/img/navio_ouro.png"
    }; 

    public EventPoints() {

    }
    
    // Create img button using randomly images
    public String criarBotao(Button button, ImageView imgView){
  
      String corSelecionada = loadRandomImages(varColors).getUrl();
         
        imgView.setImage(new Image(corSelecionada));
          try{
          button.setOnMousePressed((MouseEvent e) -> {
              colorUrl = imgView.getImage().getUrl();
             System.out.println("pontos = " + gamePoints(colorUrl));

          });
          }catch(Exception e){
              System.err.println("erro = " + e);
          }
      
      button.getStylesheets().add(getClass().getResource("Content.css").toExternalForm());
      
      return colorUrl;

  }
    
    public ImageView getimgView() {
        return imgView;
    }

    public Button getButton() {
        return button;
    }

    public int getPoints() {
        return points;
    }

    public int setPontos(int points) {
        this.points = points;
        return points;
    }


    public String getColorUrl() {
        return colorUrl;
    }
   // Load images Randomly
    private Image loadRandomImages(String[] str) {
      int countImages = str.length;
      int imageNumber = (int) (Math.random() * countImages);
      if(imageNumber == 6){
          if(r.nextBoolean() && r2.nextBoolean() && r3.nextBoolean()){
              imageNumber = 6;
          }else{
              imageNumber = (int) (Math.random() * varColors.length - 1);
          }
      }
       String image = str[imageNumber];
        return new Image(image);
    }
    // return points based on image clicked
    public int gamePoints(String s) {
    int pontosSomar = 0;
    switch (s) {
        case "file:/C:/Users/leonardo/Documents/NetBeansProjects/AppFxJogoNavio/build/classes/appfxjogonavio/img/navio_azul.png":
            pontosSomar = 2;
            break;
        case "file:/C:/Users/leonardo/Documents/NetBeansProjects/AppFxJogoNavio/build/classes/appfxjogonavio/img/navio_laranja.png":
            pontosSomar = -5;
            break;
        case "file:/C:/Users/leonardo/Documents/NetBeansProjects/AppFxJogoNavio/build/classes/appfxjogonavio/img/navio_roxo.png":
            pontosSomar = -3;
            break;
        case "file:/C:/Users/leonardo/Documents/NetBeansProjects/AppFxJogoNavio/build/classes/appfxjogonavio/img/navio_verde.png":
            pontosSomar = 5;
            break;
        case "file:/C:/Users/leonardo/Documents/NetBeansProjects/AppFxJogoNavio/build/classes/appfxjogonavio/img/navio_rubro.png":
            pontosSomar = 6;
            break;
        case "file:/C:/Users/leonardo/Documents/NetBeansProjects/AppFxJogoNavio/build/classes/appfxjogonavio/img/navio_carmim.png":
            pontosSomar = -7;
            break;
        case "file:/C:/Users/leonardo/Documents/NetBeansProjects/AppFxJogoNavio/build/classes/appfxjogonavio/img/navio_ouro.png":
            pontosSomar = 18;
            break;
        default:
            pontosSomar = 0;
            break;
    }
    
    points += pontosSomar;

   return points;
  }
    
    
    
   
}
