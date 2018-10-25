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

import java.io.IOException;
import java.util.Optional;

public class Controller3 {
    @FXML
    AlertTest alertTest= new AlertTest();
    @FXML
    Button back= new Button();
    @FXML
    TextField English= new TextField();
    @FXML
    DictionaryCommandline dictionaryCommandline= new DictionaryCommandline("E_V.txt");
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

    public void BackDelete(ActionEvent event)throws IOException {
        Parent delete = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene deletescene=new Scene(delete,850,653);

        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(deletescene);
        delete.getStylesheets().addAll(this.getClass().getResource("CSS.css").toExternalForm());
        window.show();

    }
    public void DELETE(ActionEvent event){
        Optional<ButtonType> bt = AlertTest.confirm();
        if (bt.get() == ButtonType.OK){
            AlertTest.display("Delete",dictionaryCommandline.delete(English.getText().toLowerCase(),path));
        } else {

        }
    }
}
