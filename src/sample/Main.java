package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Dictionary");
            Scene scene= new Scene(root,  850,653);
            scene.getStylesheets().addAll(this.getClass().getResource("CSS.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
           // System.setProperty("file.encoding","UTF8");
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
         /*   String path = getClass().getResource("../translate_tts.mp3").toString();
            Media media = new Media(path);
            MediaPlayer player = new MediaPlayer(media);
            player.play();
*/
    }
}

