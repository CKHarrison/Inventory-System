package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    // create a list of parts that were deleted to restore if the user cancels
    //out of modifyProduct
    ObservableList<Part> deletedPartsList = FXCollections.observableArrayList();
    //original list of associated parts
    ObservableList<Part> originalAssociatedPartsList = FXCollections.observableArrayList();

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
        searchPart(event);
    }
    
    @FXML
    void onActionAddButton(ActionEvent event) {
        Part newPart = modifyPartAddTableView.getSelectionModel().getSelectedItem();
        if(productToModify.getAllAssociatedParts().contains(newPart)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Cannot add duplicate parts.");
            alert.showAndWait();
        } else {
            productToModify.addAssociatedPart(newPart);
        }
    }

    @FXML
    void onActionDeleteButton(ActionEvent event) {
        //if nothing is selected show error
        Part partToBeDeleted = modifyAssociatedPartsTableView.getSelectionModel().getSelectedItem();
        
        if(productToModify.getAllAssociatedParts().isEmpty() || partToBeDeleted == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurrred");
            alert.setContentText("Please select a part to be deleted");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this part?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                //populate deletedPartsList
                deletedPartsList.add(partToBeDeleted);
                
               //delete the part from the product
                productToModify.deleteAssociatedPart(partToBeDeleted);
            }  
        }
    }

    @FXML
    void onActionSaveButton(ActionEvent event) throws IOException {
        
        try {
            //setting all of the info to the product
            productToModify.setName(modifyProductNameTextField.getText().trim());
            productToModify.setPrice(Double.parseDouble(modifyProductPriceTextField.getText()));
            productToModify.setStock(Integer.parseInt(modifyProductInvTextField.getText()));
            productToModify.setMax(Integer.parseInt(modifyProductMaxTextField.getText()));
            productToModify.setMin(Integer.parseInt(modifyProductMinTextField.getText()));
            
          
            
            //make sure there is at least one associated part
            if(productToModify.getAllAssociatedParts().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("There must be at least one part associated with this product.");
                alert.showAndWait();
                return;
            }
            
            //making sure the inventory levels are within max and min range
            //minimum value cannot be less than 0
            if(productToModify.getStock() > productToModify.getMax()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Inventory cannot be greater than max value.");
                alert.showAndWait();
                return;
            } else if(productToModify.getStock() < productToModify.getMin()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Inventory cannot be less than the minimum value.");
                alert.showAndWait();
                return;
            } else if(productToModify.getMin() < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("The minimum inventory level must be 0 or greater.");
                alert.showAndWait();
                return;
            }
            
            //making sure that the total price of the product is at least equal to the total price of all associated products
            
              //getting the price of all the associatedProducts
            double totalPartPrice =0;
            for(Part part : productToModify.getAllAssociatedParts()) {
                totalPartPrice += part.getPrice();
            }
            
            if(productToModify.getPrice() < totalPartPrice) {
                DecimalFormat formattedPrice = new DecimalFormat("#.##");
                String price = formattedPrice.format(totalPartPrice);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("The price of the product must be at least equal to the sum of the part's price: $" + price);                
                alert.showAndWait();
                return;
            }

            //looking up the old product based on id
           Product oldProduct = Inventory.lookupProduct(productToModify.getId());
           //finding the index of the old product in the inventory list
           int index = Inventory.getAllProducts().indexOf(oldProduct);
           //updating to the new product 
           Inventory.updateProduct(index, productToModify);

           switchToMainScreen(event);
            
        } catch (NumberFormatException e) {
              Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please enter a valid value for each Text Field");
            alert.showAndWait();
        }
    }
    
    @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "The product will not be saved, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            switchToMainScreen(event);
             //if an original part has been deleted add it back
            //check to see if the deleted list contains an original part
            for(Part part : deletedPartsList) {
                if(originalAssociatedPartsList.contains(part)){
                    productToModify.addAssociatedPart(part);
                }
            }
        } 
    }
    
    public void sendProduct(Product sentProduct) {
      productToModify = sentProduct;
      //add original associated parts to originalAssociatedPartsList
      for(Part part : sentProduct.getAllAssociatedParts()) {
          originalAssociatedPartsList.add(part);
      }
        //populating the fields with the info from the product
        modifyProductIdTextField.setText(Integer.toString(sentProduct.getId()));
        modifyProductNameTextField.setText(sentProduct.getName());
        modifyProductMaxTextField.setText(Integer.toString(sentProduct.getMax()));
        modifyProductPriceTextField.setText(Double.toString(sentProduct.getPrice()));
        modifyProductInvTextField.setText(Integer.toString(sentProduct.getStock()));
        modifyProductMinTextField.setText(Integer.toString(sentProduct.getMin()));     
        
        //setting up the table view to see all of the associated products
         modifyAssociatedPartsTableView.setItems(productToModify.getAllAssociatedParts());
        
        modifyAssociatedPartsIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyAssociatedPartsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyAssociatedPartsInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyAssociatedPartsPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    
     public void switchToMainScreen(ActionEvent event) throws IOException{
         stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
     
    public void searchPart(ActionEvent event) {
        //resetting if the search field is empty
        String searchCriteria = modifyProductPartSearchTextField.getText().trim();
        if(searchCriteria.isEmpty()) {
            modifyPartAddTableView.setItems(Inventory.getAllParts());
            return;
        }

        //search for id by parsing the searchCriteria to int
        try {
            //flagging whether the part was found
            boolean foundFlag = false;
            int searchInt = Integer.parseInt(searchCriteria);
            for(Part part : Inventory.getAllParts()) {
                if(part.getId() == (searchInt)) {
                     ObservableList<Part> tempList = FXCollections.observableArrayList();
                    tempList.add(part);
                    modifyPartAddTableView.setItems(tempList);
                    modifyPartAddTableView.getSelectionModel().select(part);
                    foundFlag = true;
                    return;
               } 
                
            }
            //if the part wasn't found
            if(foundFlag == false) {                
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setContentText("No part matches that search.");
                    modifyPartAddTableView.setItems(Inventory.getAllParts());
                    modifyProductPartSearchTextField.clear();
                    alert.showAndWait(); 
                    return;
            }
            //if that errors out catch it and search by name
        } catch(NumberFormatException e) { 
            ObservableList<Part> foundParts = FXCollections.observableArrayList();
           try {
                foundParts.addAll(Inventory.lookupPart(searchCriteria));
            modifyPartAddTableView.setItems(foundParts);
            modifyPartAddTableView.getSelectionModel().select(0);

            /*if that doesn't work, the part doesn't exist, prevent crash by catching it 
            * alerting the user to the invalid search, and resetting the whole thing
            * this took way too long to figure out
            */
           } catch(NullPointerException exception) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("No part matches that search.");
                modifyPartAddTableView.setItems(Inventory.getAllParts());
                modifyProductPartSearchTextField.clear();
                alert.showAndWait();
           }  
        }             
    }
     
    @FXML
    public void initialize(){
        
        //disable the id field
        modifyProductIdTextField.setDisable(true);
        
        //Return a list of all products to the add Table View
        modifyPartAddTableView.setItems(Inventory.getAllParts());
        
        //addProductTable
        modifyPartAddPartIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyPartAddPartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyPartAddInvLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyPartAddPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

}
