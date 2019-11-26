package View_Controller;

import Model.Inventory;
import Model.Part;
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
    private Stage stage;
    private Parent scene;
    private Product currentProduct = new Product(0, "", 0, 0, 0, 0);
     private static int uniqueId =Inventory.getAllProducts().size();
    
    
    //FXML Buttons, Fields, and Labels

    @FXML
    private Button addProductSearchButton;

    @FXML
    private TextField addProductTextField;

    @FXML
    private TableView<Part> addPartTableView;

    @FXML
    private TableColumn<Part, Integer> addPartIDTableColumn;

    @FXML
    private TableColumn<Part, String> addPartNameTableColumn;

    @FXML
    private TableColumn<Part, Integer> addPartInvLevelTableColumn;

    @FXML
    private TableColumn<Part, Double> addPartPriceTableColumn;

    @FXML
    private Button addProductAddButton;

    @FXML
    private TableView<Part> associatedPartsTableView;

    @FXML
    private TableColumn<Part, Integer> associatedPartsIdTableColumn;

    @FXML
    private TableColumn<Part, String> associatedPartsNameTableColumn;

    @FXML
    private TableColumn<Part, Integer> associatedPartsInvLevelTableColumn;

    @FXML
    private TableColumn<Part, Double> associatedPartsPriceTableColumn;

    @FXML
    private Button deletePartButton;

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
        String searchCriteria = addProductTextField.getText().trim();
        for(Part part : Inventory.getAllParts()) {
            if(Integer.toString(part.getId()).equals(searchCriteria) || 
                    part.getName().toLowerCase().equals(searchCriteria)) {
                addPartTableView.getSelectionModel().select(part);
            }
        }
        System.out.println("Search Button clicked");
    }
    
       @FXML
    void onActionAddButton(ActionEvent event) {
        //setting up generic part that is selected when a part on the table is selected
        Part newAssociatedPart = addPartTableView.getSelectionModel().getSelectedItem();
        //adding generic part to currentPart associatedParts list
        currentProduct.addAssociatedPart(newAssociatedPart);
        
           System.out.println("Add Button Clicked");
    }

    @FXML
    void onActionDeleteButton(ActionEvent event) {
        Part partToBeDeleted = associatedPartsTableView.getSelectionModel().getSelectedItem();
        currentProduct.deleteAssociatedPart(partToBeDeleted);
        System.out.println("Delete Button Clicked");
    }

    @FXML
    void onActionSaveButton(ActionEvent event) throws IOException {
        //generating unique id
        uniqueId++;
        
        currentProduct.setId(uniqueId);
        currentProduct.setName(addProductNameTextField.getText().trim());
        currentProduct.setPrice(Double.parseDouble(addProductPriceTextField.getText()));
        currentProduct.setStock(Integer.parseInt(addProductInvTextField.getText()));
        currentProduct.setMax(Integer.parseInt(addProductMaxTextField.getText()));
        currentProduct.setMin(Integer.parseInt(addProductMinTextField.getText()));
        Inventory.addProduct(currentProduct);
        switchToMainScreen(event);
        System.out.println("Save Button Clicked");
    }
    
      @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
          switchToMainScreen(event);
    }  
    
    public void switchToMainScreen(ActionEvent event) throws IOException {
        stage = stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    @FXML 
    public void initialize() {
        //setting up addProductTableView
        addPartTableView.setItems(Inventory.getAllParts());
        
        
        //parts Table
        addPartIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        addPartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addPartInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addPartPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        //Setting up associatedProductTable
        associatedPartsTableView.setItems(currentProduct.getAllAssociatedParts());
        
        associatedPartsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartsInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
    }

}
