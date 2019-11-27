/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutSourcedPart;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class AddPartViewController implements Initializable {
    
    //Global Variables
    private Stage stage;
    private Parent scene;
    private static int uniqueId =Inventory.getAllParts().size();
    
    //FXML Buttons, Fields, and Labels
    @FXML
    private RadioButton addPartInHouseRadioButton;
    @FXML
    private RadioButton addPartOutSourcedRadioButton;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label invLabel;
    @FXML
    private Label priceCostLabel;
    @FXML
    private TextField addPartIdTextField;
    @FXML
    private TextField addPartNameTextField;
    @FXML
    private TextField addPartInvTextField;
    @FXML
    private TextField addPartPriceCostTextField;
    @FXML
    private Label maxLabel;
    @FXML
    private Label minLabel;
    @FXML
    private TextField addPartMaxTextField;
    @FXML
    private TextField addPartMinTextField;
    @FXML
    private Label addPartCompanyNameOrMachineID;
    @FXML
    private TextField addPartCompanyNameOrMachineIDTextField;
    @FXML
    private Button addPartSaveButton;
    @FXML
    private Button addPartCancelButton;

    @FXML
    void onActionInHouseButton(ActionEvent event) {
        addPartCompanyNameOrMachineID.setText("Machine Id");
        addPartCompanyNameOrMachineIDTextField.setPromptText("Please Enter A Number");
    }

    @FXML
    void onActionOutsourcedButton(ActionEvent event) {
        addPartCompanyNameOrMachineID.setText("Company Name");
        addPartCompanyNameOrMachineIDTextField.setPromptText("Please Enter Company Name");
    }

    @FXML
    void onActionSavedButton(ActionEvent event) throws IOException {
        //creating a unique id for the part id starting at 1 using global static variable
        uniqueId++;
        
        try {
            
             String name = addPartNameTextField.getText().trim();
            int stock = Integer.parseInt(addPartInvTextField.getText());
            double price = Double.parseDouble(addPartPriceCostTextField.getText());
            int max = Integer.parseInt(addPartMaxTextField.getText());
            int min = Integer.parseInt(addPartMinTextField.getText());
            int machineId = 0;
            String companyName = null;
            
            //Checking validations
            //inventory greater than max
            if(!(stock <= max && stock >= min)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("The inventory must be within the minimum level and maximum level.");
                alert.showAndWait();
                return;       
            }
            
            //checking if minimum or maximum is invalid
            if(min > max) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("The minimum inventory level cannot be greater than the maximum level.");
                alert.showAndWait();
                return;                
            }
            
            if(max < min) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("The maximum inventory level cannot be smaller than the minimum level.");
                alert.showAndWait();
                return;                
            }
            
            //checking to make sure minimum is not less than 0
            if(min < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("the minimum inventory level must be at least 0.");
                alert.showAndWait();
                return; 
            }
            
            if(price < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Price cannot be a negative number.");
                alert.showAndWait();   
                return;
            }
            
            if(min < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Minimum Inventory level cannot be a negative number.");
                alert.showAndWait();
                return;
            }
            
            
                
            

            //if valdiations pass, save the part as long as machine id > 0
            boolean inHouse = addPartInHouseRadioButton.isSelected();

            //check to see if inHouse or outSourced is selected, if then accordingly set machineId or companyName
            if(inHouse) {
                machineId = Integer.parseInt(addPartCompanyNameOrMachineIDTextField.getText());
                if(machineId < 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setContentText("Machine ID must be a positive number");
                    alert.showAndWait();
                    return;    
                }
               
                                
            } else {
                companyName = addPartCompanyNameOrMachineIDTextField.getText();
            }

            //saving the part object based on which button is selected

            if(inHouse) {
                Inventory.addPart(new InHousePart(machineId, uniqueId, name, price, stock,  min,  max));
            } else {
                Inventory.addPart(new OutSourcedPart(companyName, uniqueId, name, price, stock, min, max));
            }

            returnToMainMenu(event);
            
        } catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please enter a valid value for each Text Field\n" +
                    "\n" +
                    "The name must be a string.\n" +
                    "The inventory level must be a valid integer 0 or above.\n" +
                    "The price must be a non-negative number.\n" +
                    "The stock must be a non-negative Integer\n" +
                    "The machine ID must be an integer\n" +
                    "The company name must be a string");
            alert.showAndWait();
            
//            System.out.println("Please enter valid values in text fields!");
//            System.out.println("Exception: " + e);
//            System.out.println("Exception: " + e.getMessage());
        }
    }
    
      @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "The Part will not be saved, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            returnToMainMenu(event);
        }
        
    }
    
    //method to return to the main screen
    public void returnToMainMenu(ActionEvent event) throws IOException {
        stage = (Stage) (((Button)event.getSource()).getScene().getWindow());
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
   
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //set InHouse radio button to default selected
        addPartInHouseRadioButton.setSelected(true);
         addPartCompanyNameOrMachineID.setText("Machine Id");
        addPartCompanyNameOrMachineIDTextField.setPromptText("Please Enter A Number");
        
    }    
    
}
