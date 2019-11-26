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
import javafx.stage.Stage;

public class ModifyProductViewController {
    //Global Variables
    private Stage stage;
    private Parent scene;
    private Product productToModify;
    private int id;

    @FXML
    private Button modifyProductPartSearchButton;

    @FXML
    private TextField modifyProductPartSearchTextField;

    @FXML
    private TableView<Part> modifyPartAddTableView;

    @FXML
    private TableColumn<Part, Integer> modifyPartAddPartIDTableColumn;

    @FXML
    private TableColumn<Part, String> modifyPartAddPartNameTableColumn;

    @FXML
    private TableColumn<Part, Integer> modifyPartAddInvLevelTableColumn;

    @FXML
    private TableColumn<Part, Double> modifyPartAddPriceTableColumn;

    @FXML
    private Button modifyProductPartAddButton;

    @FXML
    private TableView<Part> modifyAssociatedPartsTableView;

    @FXML
    private TableColumn<Part, Integer> modifyAssociatedPartsIdTableColumn;

    @FXML
    private TableColumn<Part, String> modifyAssociatedPartsNameTableColumn;

    @FXML
    private TableColumn<Part, Integer> modifyAssociatedPartsInvLevelTableColumn;

    @FXML
    private TableColumn<Part, Double> modifyAssociatedPartsPriceTableColumn;

    @FXML
    private Button modifyAssociatedPartsDeleteButton;

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
        String searchCriteria = modifyProductPartSearchTextField.getText().trim();
        for(Part part : Inventory.getAllParts()) {
            if(Integer.toString(part.getId()).equals(searchCriteria) || 
                    part.getName().toLowerCase().equals(searchCriteria)) {
                modifyPartAddTableView.getSelectionModel().select(part);
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
    
    public void sendProduct(Product sentProduct) {
        productToModify = sentProduct;
    }
    
    
    
    @FXML
    public void initialize(){
        
//        System.out.println(productToModify.getId());
        
        
        //Return a list of all products to the add Table View
        modifyPartAddTableView.setItems(Inventory.getAllParts());
        
        //addProductTable
        modifyPartAddPartIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyPartAddPartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyPartAddInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyPartAddPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //Setting up deleteTable
//        modifyAssociatedPartsTableView.setItems(productToModify.getAllAssociatedParts());
        modifyAssociatedPartsTableView.setItems(Inventory.getAllParts());
        
        modifyAssociatedPartsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyAssociatedPartsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyAssociatedPartsInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyAssociatedPartsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

}
