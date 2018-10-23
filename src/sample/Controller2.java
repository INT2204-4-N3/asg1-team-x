package sample;

import cmd0.DictionaryCommandline;
import cmd0.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.AlertTest;

import java.io.IOException;
import java.util.Optional;

public class Controller2 {
    @FXML
    Button back= new Button();
    @FXML
    AlertTest alertTest= new AlertTest();
    @FXML
    private TextField addEnglish = new TextField();
    @FXML
    private TextField addVienam = new TextField();
    @FXML
    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline("C:/Users/Truong Thanh Tu/Desktop/dictionaryEV/E_V.txt");
    @FXML
    MenuButton menuButton=new MenuButton();
    String path="C:/Users/Truong Thanh Tu/Desktop/dictionaryEV/E_V.txt";
    public void changeV (ActionEvent event){
        menuButton.setText("Vietnamese");
         path="C:/Users/Truong Thanh Tu/Desktop/dictionaryEV/V_E.txt";
        dictionaryCommandline= new DictionaryCommandline(path);

    }
    public void changeE (ActionEvent event){
        menuButton.setText("English");
      path="C:/Users/Truong Thanh Tu/Desktop/dictionaryEV/E_V.txt";
        dictionaryCommandline= new DictionaryCommandline(path);

    }
    public void BackCenterAdd(ActionEvent event)throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene addscene=new Scene(add,850,653);

        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addscene);
        addscene.getStylesheets().addAll(this.getClass().getResource("CSS.css").toExternalForm());
        window.show();

    }

    public void ADD(ActionEvent event){
        Optional<ButtonType> bt = AlertTest.confirm();
        if (bt.get() == ButtonType.OK){
            AlertTest.display("ADD",dictionaryCommandline.addfile(addEnglish.getText().toLowerCase(),addVienam.getText().toLowerCase(),path));
        } else {

        }

    }}
