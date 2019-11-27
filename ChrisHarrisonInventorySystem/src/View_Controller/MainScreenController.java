/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

/**
 * FXML Controller class
 *
 * @author chris
 */
public class MainScreenController implements Initializable {
    
    
    private Stage stage;
    private Parent scene;
    
    //FXML Buttons, Fields, labels

    @FXML
    private Button partsSearchButton;
    @FXML
    private TextField partsSearchTextField;
    @FXML
    private TableView<Part> partTableView;
    @FXML
    private TableColumn<Part, Integer> partIdTableColumn;
    @FXML
    private TableColumn<Part, String> partNameTableColumn;
    @FXML
    private TableColumn<Part, Integer> partInventoryLabelTableColumn;
    @FXML
    private TableColumn<Part, Double> partPricePerUnitTableColumn;
    @FXML
    private Button partAddButton;
    @FXML
    private Button partModifyButton;
    @FXML
    private Button partDeleteButton;
    @FXML
    private Button productSearchButton;
    @FXML
    private TextField productSearchField;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> productIDTableColumn;
    @FXML
    private TableColumn<Product, String> productNameTableColumn;
    @FXML
    private TableColumn<Product, Integer> productInventoryLevelTableColumn;
    @FXML
    private TableColumn<Product, Double> productPricePerUnitTableColumn;
    @FXML
    private Button addProductButton;
    @FXML
    private Button modifyProductButton;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button exitButton;
    
    //Button Event Handlers
    
    //Part Handlers
    
    @FXML
    void onActionSearchPartButton(ActionEvent event) {
        searchPart(event);
    }
    
    
    @FXML
    void onActionAddPartButton(ActionEvent event) throws IOException {

        switchScene(event, "AddPartView");
    }
    
    
    //Switch Scene to modifyPartView 
     @FXML
    void onActionModifyPartButton(ActionEvent event) throws IOException {
        
        try {
            
            FXMLLoader loader = new FXMLLoader();
        //setting location to ModifyPartView
        loader.setLocation(getClass().getResource("/View_Controller/ModifyPartView.fxml"));
        loader.load();
        
        ModifyPartViewController modifyPartVC = loader.getController();
        Part partToSend = partTableView.getSelectionModel().getSelectedItem();
        //send part to ModifyPartViewController
        modifyPartVC.sendPart(partToSend);           
        
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
            
        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occured");
            alert.setContentText("Please select a part to modify.");
            alert.showAndWait();
        }
    }
    
     @FXML
    void onActionDeletePartButton(ActionEvent event) {
        
        
         Part partToBeDeleted = partTableView.getSelectionModel().getSelectedItem();
         if(partToBeDeleted == null) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occured");
            alert.setContentText("Please select a part to delete.");
            alert.showAndWait();
         } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this part?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                partToBeDeleted = partTableView.getSelectionModel().getSelectedItem();
                Inventory.deletePart(partToBeDeleted);
                //updateTable view
                partTableView.setItems(Inventory.getAllParts());
            }  
         }  
    }
    
    //Product Button Handlers
      @FXML
    void onActionSearchProductButton(ActionEvent event) {
        String searchCriteria = productSearchField.getText().trim();
        
        
        
        
        
        
        //old search method
//        for(Product product : Inventory.getAllProducts()) {
//            if(Integer.toString(product.getId()).equals(searchCriteria)
//                    || product.getName().toLowerCase().contains(searchCriteria.toLowerCase())) {
//                productTableView.getSelectionModel().select(product);
//            }
//        }
    }

    @FXML
    void onActionAddProductButton(ActionEvent event) throws IOException {
        switchScene(event, "AddProductView");
    }
    
     @FXML
    void onActionModifyProductButton(ActionEvent event) throws IOException {
        
        try {
            FXMLLoader loader = new FXMLLoader();
            //setting location to ModifyPartView
            loader.setLocation(getClass().getResource("/View_Controller/ModifyProductView.fxml"));
            loader.load();

            ModifyProductViewController modifyProductVC = loader.getController();
            Product productToSend = productTableView.getSelectionModel().getSelectedItem();

            //send part to ModifyPartViewController
            modifyProductVC.sendProduct(productToSend);

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();

            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
            
        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occured");
            alert.setContentText("Please select a product to modify.");
            alert.showAndWait();
        }
    }

    @FXML
    void onActionDeleteProductButton(ActionEvent event) {
        Product productToBeDeleted = productTableView.getSelectionModel().getSelectedItem();
        if(productToBeDeleted == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occured");
            alert.setContentText("Please select a product to delete.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                Inventory.deleteProduct(productToBeDeleted);
                //update tableview
                productTableView.setItems(Inventory.getAllProducts());
            }
        
        }
    }

   //Exit Button
        @FXML
    void OnActionExitButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        }        
        
    }
    
    //custom methods to prevent retyping code
    
        //Switch Scene method 
    public void switchScene(ActionEvent event, String sceneName) throws IOException {
        //switching the stage to the AddPartView
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        //loading the resource
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/" 
                + sceneName + ".fxml"));
        //switching the scene to a new stage
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    //Product search method
    
    public void searchPart(ActionEvent event) {
        //resetting if the search field is empty
        String searchCriteria = partsSearchTextField.getText().trim();
        if(searchCriteria.isEmpty()) {
            partTableView.setItems(Inventory.getAllParts());
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
                    partTableView.setItems(tempList);
                    partTableView.getSelectionModel().select(part);
                    foundFlag = true;
                    return;
               } 
                
            }
            //if the part wasn't found
            if(foundFlag == false) {                
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setContentText("No product matches that search.");
                    partTableView.setItems(Inventory.getAllParts());
                    partsSearchTextField.clear();
                    alert.showAndWait(); 
                    return;
            }
            //if that errors out catch it and search by name
        } catch(NumberFormatException e) { 
            ObservableList<Part> foundParts = FXCollections.observableArrayList();
           try {
                foundParts.addAll(Inventory.lookupPart(searchCriteria));
            partTableView.setItems(foundParts);
            partTableView.getSelectionModel().select(0);

            /*if that doesn't work, the part doesn't exist, prevent crash by catching it 
            * alerting the user to the invalid search, and resetting the whole thing
            * this took way too long to figure out
            */
           } catch(NullPointerException exception) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("No product matches that search.");
                partTableView.setItems(Inventory.getAllParts());
                partsSearchTextField.clear();
                alert.showAndWait();
           }  
        }             
    }

    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //return a list of all parts and setting it to the partTableView
        partTableView.setItems(Inventory.getAllParts());
        
        //setting data to the respective columns
        partIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryLabelTableColumn.setCellValueFactory(new PropertyValueFactory("stock"));
        partPricePerUnitTableColumn.setCellValueFactory(new PropertyValueFactory("price"));
        
        //Displaying all data to the product table view
        productTableView.setItems(Inventory.getAllProducts());
        
        //setting data to the respective columns
        productIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPricePerUnitTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        
        System.out.println(Inventory.lookupPart("ai").size());
        
         for(Part part : Inventory.lookupPart("ai")) {
            System.out.println(part.getName());
        }
        
    }
}
