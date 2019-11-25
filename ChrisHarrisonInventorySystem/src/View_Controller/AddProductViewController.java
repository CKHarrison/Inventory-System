package View_Controller;

import Model.Inventory;
import Model.Product;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AddProductViewController {
    //Global variables
    Stage stage;
    Parent scene;
    
    //FXML Buttons, Fields, and Labels

    @FXML
    private Button addProductSearchButton;

    @FXML
    private TextField addProductTextField;

    @FXML
    private TableView<Product> addProductTableView;

    @FXML
    private TableColumn<Product, Integer> addPartIDTableColumn;

    @FXML
    private TableColumn<Product, String> addPartNameTableColumn;

    @FXML
    private TableColumn<Product, Integer> addPartInvLevelTableColumn;

    @FXML
    private TableColumn<Product, Double> addPartPriceTableColumn;

    @FXML
    private Button addProductAddButton;

    @FXML
    private TableView<Product> deleteProductTableView;

    @FXML
    private TableColumn<Product, Integer> deletePartIdTableColumn;

    @FXML
    private TableColumn<Product, String> deletePartNameTableColumn;

    @FXML
    private TableColumn<Product, Integer> deleteInvLevelTableColumn;

    @FXML
    private TableColumn<Product, Double> deletePriceTableColumn;

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
    void onActionCancelButton(ActionEvent event) throws IOException {
        stage = stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }  
    
    @FXML 
    public void initialize() {
        //setting up addProductTableView
        addProductTableView.setItems(Inventory.getAllProducts());
        
        //addProductTable
        addPartIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        addPartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addPartInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addPartPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //Setting up deleteTable
        deleteProductTableView.setItems(Inventory.getAllProducts());
        
        deletePartIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        deletePartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        deleteInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        deletePriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
    }

}
