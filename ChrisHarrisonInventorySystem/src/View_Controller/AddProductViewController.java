package View_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddProductViewController {

    @FXML
    private Button addProductSearchButton;

    @FXML
    private TextField addProductTextField;

    @FXML
    private TableView<?> addProductTableView;

    @FXML
    private TableColumn<?, ?> addPartIDTableColumn;

    @FXML
    private TableColumn<?, ?> addPartNameTableColumn;

    @FXML
    private TableColumn<?, ?> addPartInvLevelTableColumn;

    @FXML
    private TableColumn<?, ?> addPartPriceTableColumn;

    @FXML
    private Button addProductAddButton;

    @FXML
    private TableView<?> deleteProductTableView;

    @FXML
    private TableColumn<?, ?> deletePartTableColumn;

    @FXML
    private TableColumn<?, ?> deletePartNameTableColumn;

    @FXML
    private TableColumn<?, ?> deleteInvLevelTableColumn;

    @FXML
    private TableColumn<?, ?> deletePriceTableColumn;

    @FXML
    private Button deleteProductButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label IdLabel;

    @FXML
    private TextField addProductIDTextField;

    @FXML
    private TextField addProductNameTextField;

    @FXML
    private TextField addProductMaxTextField;

    @FXML
    private TextField addProductPriceTextField;

    @FXML
    private TextField addProductInvTextField;

    @FXML
    private TextField addProductMinTextField;
    
    //Button Handlers
    
    @FXML
    void onActionSearchButton(ActionEvent event) {
        System.out.println("Search Button clicked");
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
    void onActionCancelButton(ActionEvent event) {
         System.out.println("Cancel Button Clicked");
    }  

}
