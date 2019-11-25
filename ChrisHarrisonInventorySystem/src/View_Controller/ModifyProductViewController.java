package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Part> modifyProductAddTableView;

    @FXML
    private TableColumn<Part, Integer> modifyProductAdddPartIDTableColumn;

    @FXML
    private TableColumn<Part, String> modifyProductAddPartNameTableColumn;

    @FXML
    private TableColumn<Part, Integer> modifyProductAddInvLevelTableColumn;

    @FXML
    private TableColumn<Part, Double> modifyProductAddPriceTableColumn;

    @FXML
    private Button modifyProductAddButton;

    @FXML
    private TableView<Product> modifyProductDeleteTableView;

    @FXML
    private TableColumn<Product, Integer> modifyProductDeletePartIdTableColumn;

    @FXML
    private TableColumn<Product, String> modifyProductDeletePartNameTableColumn;

    @FXML
    private TableColumn<Product, Integer> modifyProductDeleteInvLevelTableColumn;

    @FXML
    private TableColumn<Product, Double> modifyProductDeletePriceTableColumn;

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
        String searchCriteria = modifyProductSearchTextField.getText().trim();
        for(Part part : Inventory.getAllParts()) {
            if(Integer.toString(part.getId()).equals(searchCriteria) || 
                    part.getName().toLowerCase().equals(searchCriteria)) {
                modifyProductAddTableView.getSelectionModel().select(part);
            }
        }
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
        //Return a list of all products to the add Table View
        modifyProductAddTableView.setItems(Inventory.getAllParts());
        
        //addProductTable
        modifyProductAdddPartIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyProductAddPartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyProductAddInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyProductAddPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //Setting up deleteTable
        modifyProductDeleteTableView.setItems(Inventory.getAllProducts());
        
        modifyProductDeletePartIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyProductDeletePartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyProductDeleteInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyProductDeletePriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

}
