package sample;

import cmd0.DictionaryCommandline;
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

import java.io.IOException;
import java.util.Optional;

public class Edit {  @FXML
    Button back= new Button();
    @FXML
    AlertTest alertTest= new AlertTest();
    @FXML
    private TextField editEnglish = new TextField();
    @FXML
    private TextField editVienam = new TextField();
    @FXML
    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline("E_V.txt");
    @FXML
    MenuButton menuButton=new MenuButton();
    String path="E_V.txt";
    public void changeV (ActionEvent event){
        menuButton.setText("Vietnamese");
        path="V_E.txt";
        dictionaryCommandline= new DictionaryCommandline(path);

    }
    public void changeE (ActionEvent event){
        menuButton.setText("English");
        path="E_V.txt";
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

    public void Edit(ActionEvent event){


        Optional<ButtonType> bt = AlertTest.confirm();
        if (bt.get() == ButtonType.OK){
           AlertTest.display("Edit",dictionaryCommandline.edit(editEnglish.getText(),editVienam.getText().toLowerCase(),path));
        } else {

        }

    }}


