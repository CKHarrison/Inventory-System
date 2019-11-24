/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private TableView<?> partTableView;
    @FXML
    private TableColumn<?, ?> partIdTableColumn;
    @FXML
    private TableColumn<?, ?> partNameTableColumn;
    @FXML
    private TableColumn<?, ?> partInventoryLabelTableColumn;
    @FXML
    private TableColumn<?, ?> partPricePerUnitTableColumn;
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
    private TableView<?> productTabelView;
    @FXML
    private TableColumn<?, ?> productIDTableColumn;
    @FXML
    private TableColumn<?, ?> productNameTableColumn;
    @FXML
    private TableColumn<?, ?> productInventoryLevelTableColumn;
    @FXML
    private TableColumn<?, ?> ProductPricePerUnitTableColumn;
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
        System.out.println("Search Part Button Clicked");
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
         System.out.println("Delete Button Clicked");
    }
    
    //Product Button Handlers
      @FXML
    void onActionSearchProductButton(ActionEvent event) {
       
          System.out.println("Search Product Button Clicked");
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
        System.out.println("Delete Product Button Clicked");
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
