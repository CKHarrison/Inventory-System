package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        if(currentProduct.getAllAssociatedParts().contains(newAssociatedPart)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Cannot add duplicate parts.");
            alert.showAndWait();
        } else {
            
            //adding generic part to currentPart associatedParts list
            currentProduct.addAssociatedPart(newAssociatedPart);
        }
    }

    @FXML
    void onActionDeleteButton(ActionEvent event) {
        //if nothing is selected show error
        Part partToBeDeleted = associatedPartsTableView.getSelectionModel().getSelectedItem();
        
        if(currentProduct.getAllAssociatedParts().isEmpty() || partToBeDeleted == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurrred");
            alert.setContentText("Please select a part to be deleted");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this part?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {            
            currentProduct.deleteAssociatedPart(partToBeDeleted);
            }  
        }
        
        
    }

    @FXML
    void onActionSaveButton(ActionEvent event) throws IOException {
        //generating unique id
        uniqueId++;
        
        try{
            currentProduct.setId(uniqueId);
            currentProduct.setName(addProductNameTextField.getText().trim());
            currentProduct.setPrice(Double.parseDouble(addProductPriceTextField.getText()));
            currentProduct.setStock(Integer.parseInt(addProductInvTextField.getText()));
            currentProduct.setMax(Integer.parseInt(addProductMaxTextField.getText()));
            currentProduct.setMin(Integer.parseInt(addProductMinTextField.getText()));
            
            double totalPartPrice =0;
            for(Part part : currentProduct.getAllAssociatedParts()) {
                totalPartPrice += part.getPrice();
            }
            
            
            
            //making sure there is one or more part associated with the product
            if(currentProduct.getAllAssociatedParts().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("There must be at least one part associated with this product.");
                alert.showAndWait();
                return;
            }
            
            //making sure the inventory levels are within max and min range
            //minimum value cannot be less than 0
            if(currentProduct.getStock() > currentProduct.getMax()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Inventory cannot be greater than max value.");
                alert.showAndWait();
                return;
            } else if(currentProduct.getStock() < currentProduct.getMin()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Inventory cannot be less than the minimum value.");
                alert.showAndWait();
                return;
            } else if(currentProduct.getMin() < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("The minimum inventory level must be 0 or greater.");
                alert.showAndWait();
                return;
            }
            
            //making sure that the total price of the product is at least equal to the total price of all associated products
            if(currentProduct.getPrice() < totalPartPrice) {
                DecimalFormat formattedPrice = new DecimalFormat("#.##");
                String price = formattedPrice.format(totalPartPrice);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("The price of the product must be at least equal to the sum of the part's price: $" + price);                
                alert.showAndWait();
            }
            
            
            
            else {
                Inventory.addProduct(currentProduct);
                switchToMainScreen(event);
            }
        } catch (NumberFormatException e) {
              Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please enter a valid value for each Text Field");
            alert.showAndWait();
        }
      
    }
    
      @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "The Part will not be saved, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            switchToMainScreen(event);
        }         
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
