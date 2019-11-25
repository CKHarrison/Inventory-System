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
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    //global variables
    Stage stage;
    Parent scene;
    
    
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
        
        String searchCriteria = partsSearchTextField.getText().trim();
        for(Part part : Inventory.getAllParts()) {
            if(Integer.toString(part.getId()).equals(searchCriteria) || 
                    part.getName().toLowerCase().equals(searchCriteria)) {
                partTableView.getSelectionModel().select(part);
            }
        }
    }
    
    @FXML
    void onActionAddPartButton(ActionEvent event) throws IOException {

        switchScene(event, "AddPartView");
        
        System.out.println("Add Part Button Clicked");
    }
    
    
    //Switch Scene to modifyPartView 
     @FXML
    void onActionModifyPartButton(ActionEvent event) throws IOException {
         switchScene(event, "ModifyPartView");
    }
    
     @FXML
    void onActionDeletePartButton(ActionEvent event) {
        Part partToBeDeleted = partTableView.getSelectionModel().getSelectedItem();
        Inventory.deletePart(partToBeDeleted);
        
         System.out.println("Delete Button Clicked");
    }
    
    //Product Button Handlers
      @FXML
    void onActionSearchProductButton(ActionEvent event) {
        String searchCriteria = productSearchField.getText().trim();
        for(Product product : Inventory.getAllProducts()) {
            if(Integer.toString(product.getId()).equals(searchCriteria)
                    || product.getName().toLowerCase().equals(searchCriteria.toLowerCase())) {
                productTableView.getSelectionModel().select(product);
            }
        }
    }

    @FXML
    void onActionAddProductButton(ActionEvent event) throws IOException {
        switchScene(event, "AddProductView");
    }
    
     @FXML
    void onActionModifyProductButton(ActionEvent event) throws IOException {
         switchScene(event, "ModifyProductView");
    }

    @FXML
    void onActionDeleteProductButton(ActionEvent event) {
        Product productToBeDeleted = productTableView.getSelectionModel().getSelectedItem();
        Inventory.deleteProduct(productToBeDeleted);
    }

   //Exit Button
        @FXML
    void OnActionExitButton(ActionEvent event) {
        System.exit(0);
    }
    
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
        
        
    }    
    
}
