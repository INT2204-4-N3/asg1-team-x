package sample;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import cmd0.DictionaryCommandline;
import cmd0.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.io.*;
import javafx.stage.Stage;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sample.Audio.Trying_Different_Languages;

import javax.swing.*;
import javax.swing.text.View;
import java.io.IOException;
import java.io.InputStream;
import static java.nio.charset.StandardCharsets.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.PhantomReference;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    @FXML
    private Button search = new Button();
    @FXML
    private Button Speech = new Button();
    @FXML
    public TextField input = new TextField();
    @FXML
    private ListView output = new ListView<String>();
    @FXML
    private WebView outputlook = new WebView();
    @FXML
    private Button del = new Button();
    @FXML
    public String k = "kevin";
    @FXML
    private Button sentence = new Button();
    @FXML
    ImageView audio = new ImageView();
    @FXML
    ImageView tim = new ImageView();
    @FXML
    Button changeV= new Button();
    @FXML
    Button changeE= new Button();
    @FXML
    MenuButton menuButton= new MenuButton();

    @FXML
    String a = "";

    String lang="en";
    String to="vi";

    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline("E_V.txt");


    public void changeV (ActionEvent event){
        menuButton.setText("Vietnamese");
        String path="V_E.txt";
        dictionaryCommandline= new DictionaryCommandline(path);
        lang="vi";
        to="en";
    }
    public void changeE (ActionEvent event){
        menuButton.setText("English");
        String path="E_V.txt";
        dictionaryCommandline= new DictionaryCommandline(path);
        lang="en";
        to="vi";
    }


    @FXML
    public void handle(KeyEvent event) {
        output.getItems().setAll(dictionaryCommandline.dictionarySearcher(input.getText().toLowerCase()));

    }



    @FXML
    public void handleMouseClick(MouseEvent arg0) {

        a = output.getSelectionModel().getSelectedItem().toString();
        input.setText(a);
    }


    @FXML
    public void Search(ActionEvent event) {
        WebEngine webEngine = outputlook.getEngine();
        if (dictionaryCommandline.dictionaryAdvanced(input.getText().toLowerCase()) != null) {
            webEngine.loadContent(dictionaryCommandline.dictionaryAdvanced(input.getText().toLowerCase()));
            System.setProperty("file.encoding","UTF8");
        } else{
            try {

                byte t[]=dictionaryCommandline.api(lang, to, input.getText().toLowerCase()).getBytes();
               String data= new String(t,"UTF-8");
                System.out.println(data);
                webEngine.loadContent(data);
            } catch (Exception ex) {
                ex.printStackTrace();

            }



    }
    }
    @FXML
    public void speech(ActionEvent event) {

            Trying_Different_Languages tdl = new Trying_Different_Languages(input.getText());
        }



    public void SceneAdd(ActionEvent event) throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("ADD.fxml"));
        Scene addscene = new Scene(add);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addscene);
      addscene.getStylesheets().addAll(this.getClass().getResource("CSS.css").toExternalForm());
        window.show();

    }

    public void SceneDelete(ActionEvent event) throws IOException {
        Parent delete = FXMLLoader.load(getClass().getResource("delete.fxml"));
        Scene addscene = new Scene(delete);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addscene);
        addscene.getStylesheets().addAll(this.getClass().getResource("CSS.css").toExternalForm());
        window.show();

    }
    public void SceneEdit(ActionEvent event) throws IOException {
        Parent delete = FXMLLoader.load(getClass().getResource("Edit.fxml"));
        Scene addscene = new Scene(delete);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addscene);
        addscene.getStylesheets().addAll(this.getClass().getResource("CSS.css").toExternalForm());
        window.show();

    }

}



