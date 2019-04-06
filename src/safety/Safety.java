package safety;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Safety extends Application {
    
    public static Stage stage = null;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/safety/view/PaginaInicialAdmin.fxml"));



        Scene scene = new Scene(root);

        stage.setScene(scene);
       // stage.setFullScreen(true);
        Safety.stage = stage;
        stage.show();
    }

    /*public static Stage getStage() {
        return stage;
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        launch(args);
    }

}
