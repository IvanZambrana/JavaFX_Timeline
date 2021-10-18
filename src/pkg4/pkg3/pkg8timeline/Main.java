package pkg4.pkg3.pkg8timeline;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Iván Zambrana Naranjo
 */
public class Main extends Application {
    
    public static double ballSpeed= 1;
    @Override
    public void start(Stage primaryStage) {
        //Tittle
        primaryStage.setTitle("Timeline");
      
        Group pane = new Group();
        // Bola que se usará para la animación
        Circle ball = new Circle(10);
        ball.setTranslateX(300 * 0.5);
        ball.setTranslateY(250 * 0.5);
        pane.getChildren().addAll(ball);

        // Etiqueta que mostrará el valor de frames por segundo (FPS)
        Label label = new Label();
        label.setTranslateX(10);
        label.setTranslateY(10);
        pane.getChildren().addAll(label);
        Scene scene = new Scene(pane, 300, 250);

        //Escuchador a incluir en el bucle de Timeline
        EventHandler<ActionEvent> eH = e->{
            // Mostrar la frecuencia de refresco FPS
            PerformanceTracker perfTracker=
            PerformanceTracker.getSceneTracker(scene);
            label.setText("FPS (Timeline) = "+perfTracker.getInstantFPS());

            // Cambiar la dirección de la bola si llega a los extremos
            if(ball.getTranslateX()< 0 || ball.getTranslateX()> 300){
                ballSpeed*=-1;
            }
            ball.setTranslateX(ball.getTranslateX()+ballSpeed);
        };
        //Pane root = new Pane();
        //root.getChildren().add(ball);

        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
