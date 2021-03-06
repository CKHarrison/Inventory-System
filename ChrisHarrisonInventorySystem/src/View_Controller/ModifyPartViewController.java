/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutSourcedPart;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class ModifyPartViewController implements Initializable {
    //Global Variables
    
    private Stage stage;
    private Parent scene;
    private int id;
    
    //FX:ids

    @FXML
    private RadioButton modifyPartInHouseRadioButton;
    @FXML
    private RadioButton modifyPartOutSourcedRadioButton;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label invLabel;
    @FXML
    private Label priceCostLabel;
    @FXML
    private TextField modifyPartIdTextField;
    @FXML
    private TextField modifyPartNameTextField;
    @FXML
    private TextField modifyPartInvTextField;
    @FXML
    private TextField modifyPartPriceCostTextField;
    @FXML
    private Label maxLabel;
    @FXML
    private Label minLabel;
    @FXML
    private TextField modifyPartMaxTextField;
    @FXML
    private TextField modifyPartMinTextField;
    @FXML
    private Label modifyPartCompanyNameOrMachineIDLabel;
    @FXML
    private TextField modifyPartCompanyNameOrMachineIDTextField;
    @FXML
    private Button modifyPartSaveButton;
    @FXML
    private Button modifyPartCancelButton;
    
    //Button Event Handlers
    
    //Radio Buttons
    @FXML
    void onActionInhouseButton(ActionEvent event) {
        modifyPartCompanyNameOrMachineIDLabel.setText("Machine Id");
        modifyPartCompanyNameOrMachineIDTextField.clear();
        modifyPartCompanyNameOrMachineIDTextField.setPromptText("Please Enter A Number");
        
    }
    
    @FXML
    void onActionOutsourcedButton(ActionEvent event) {
        modifyPartCompanyNameOrMachineIDLabel.setText("Company Name");
        modifyPartCompanyNameOrMachineIDTextField.clear();
        modifyPartCompanyNameOrMachineIDTextField.setPromptText("Please Enter Company Name");
    }
    
    //Save and Cancel Buttons
    
    @FXML
    void onActionSaveButton(ActionEvent event) throws IOException {
        
        //ID comes from the recieved part id
        
        String name = modifyPartNameTextField.getText().trim();
        int stock = Integer.parseInt(modifyPartInvTextField.getText());
        double price = Double.parseDouble(modifyPartPriceCostTextField.getText());
        int max = Integer.parseInt(modifyPartMaxTextField.getText());
        int min = Integer.parseInt(modifyPartMinTextField.getText());
        int machineId = 0;
        String companyName = null;
        
        //Checking validations
            //inventory must be within the range of the max and min
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
        
            //valdiations passed saving the part
        boolean inHouse = modifyPartInHouseRadioButton.isSelected();
        
        //check to see if inHouse or outSourced is selected, if then accordingly set machineId or companyName
        if(inHouse) {
            machineId = Integer.parseInt(modifyPartCompanyNameOrMachineIDTextField.getText());
            if(machineId < 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Machine ID must be a positive number");
                alert.showAndWait();
                return;    
            }
        } else {
            companyName = modifyPartCompanyNameOrMachineIDTextField.getText();
        }
        
        //updating the part object based on which button is selected
        
        if(inHouse) {
            //new updated part to store in the inventory
            Part modifiedPart = new InHousePart(machineId, id, name, price, stock, min, max);
            //first lookup the old part based on id
            Part oldPart = Inventory.lookupPart(modifiedPart.getId());
            //find the index of that part in the inventory array
            int index = Inventory.getAllParts().indexOf(oldPart);
            //update part in the inventory
            Inventory.updatePart(index, modifiedPart);
        } else {
            Part modifiedPart = new OutSourcedPart(companyName, id, name, price, stock, min, max);
            Part oldPart = Inventory.lookupPart(id);
            int index = Inventory.getAllParts().indexOf(oldPart);
            Inventory.updatePart(index, modifiedPart);
        }
        //back to main window
        showMainScreen(event);
    }
    
    @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        showMainScreen(event);
    }   

    public void sendPart(Part recievedPart) {
        id = recievedPart.getId();
        modifyPartIdTextField.setText(Integer.toString(recievedPart.getId()));
        modifyPartNameTextField.setText(recievedPart.getName());
        modifyPartInvTextField.setText(Integer.toString(recievedPart.getStock()));
        modifyPartPriceCostTextField.setText(Double.toString(recievedPart.getPrice()));
        modifyPartMaxTextField.setText(Integer.toString(recievedPart.getMax()));
        modifyPartMinTextField.setText(Integer.toString(recievedPart.getMin()));
        if(recievedPart instanceof Model.InHousePart) {
            modifyPartInHouseRadioButton.setSelected(true);
            modifyPartCompanyNameOrMachineIDLabel.setText("Machine Id");
            //casting to InHousePart to get the machine id, and then parsing it into a string
            modifyPartCompanyNameOrMachineIDTextField.setText(Integer.toString(((InHousePart) recievedPart).getMachineId()));
            
        } else {
            modifyPartOutSourcedRadioButton.setSelected(true);
            modifyPartCompanyNameOrMachineIDLabel.setText("Company Name");
            //casting to OutSourcedPart to get the company name
            modifyPartCompanyNameOrMachineIDTextField.setText(((OutSourcedPart) recievedPart).getCompanyName());
            
        }
        
        
    }
    
    public void showMainScreen(ActionEvent event) throws IOException{
         stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }


    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
//        
       modifyPartIdTextField.setDisable(true);
        
    }
    
}
