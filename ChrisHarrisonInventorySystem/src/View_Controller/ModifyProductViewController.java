package View_Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ModifyProductViewController {
    //Global Variables
    Stage stage;
    Parent scene;

    @FXML
    private Button modifyProductSearchButton;

    @FXML
    private TextField modifyProductSearchTextField;

    @FXML
    private TableView<?> modifyProductAddTableView;

    @FXML
    private TableColumn<?, ?> modifyProductAdddPartIDTableColumn;

    @FXML
    private TableColumn<?, ?> modifyProductAddPartNameTableColumn;

    @FXML
    private TableColumn<?, ?> modifyProductAddInvLevelTableColumn;

    @FXML
    private TableColumn<?, ?> modifyProductAddPriceTableColumn;

    @FXML
    private Button modifyProductAddButton;

    @FXML
    private GridPane modifyProductDeletTableView;

    @FXML
    private TableView<?> modifyProductDeleteTableView;

    @FXML
    private TableColumn<?, ?> modifyProductDeletePartIdTableColumn;

    @FXML
    private TableColumn<?, ?> modifyProductDeletePartNameTableColumn;

    @FXML
    private TableColumn<?, ?> modifyProductDeleteInvLevelTableColumn;

    @FXML
    private TableColumn<?, ?> modifyProductDeletePriceTableColumn;

    @FXML
    private Button modifyProductDeleteButton;

    @FXML
    private Button modifyProductSaveButton;

    @FXML
    private Button modifyProductCancelButton;

    @FXML
    private TextField modifyProductIdTextField;

    @FXML
    private TextField modifyProductNameTextField;

    @FXML
    private TextField modifyProductMaxTextField;

    @FXML
    private TextField modifyProductPriceTextField;

    @FXML
    private TextField modifyProductInvTextField;

    @FXML
    private TextField modifyProductMinTextField;
    
    //Button Event Handlers
    
    @FXML
    void onActionSearchButton(ActionEvent event) {
        System.out.println("Search Button Clicked");
    }
    
    @FXML
    void onActionAddButton(ActionEvent event) {
        System.out.println("Add Button Clicked");
    }

    @FXML
    void onActionDeleteButton(ActionEvent event) {
        System.out.println("Delete Button Clicked");
    }

    @FXML
    void onActionSaveButton(ActionEvent event) {
        System.out.println("Save Button Clicked");
    }
    
    @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        stage = stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

   

}
