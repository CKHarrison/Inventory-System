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
//    private static Part partToBeModified;
    private Part modifiedPart;
    
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
        modifyPartCompanyNameOrMachineIDTextField.setPromptText("Please Enter A Number");
        
    }
    
    @FXML
    void onActionOutsourcedButton(ActionEvent event) {
        modifyPartCompanyNameOrMachineIDLabel.setText("Company Name");
        modifyPartCompanyNameOrMachineIDTextField.setPromptText("Please Enter Company Name");
    }
    
    //Save and Cancel Buttons
    
    @FXML
    void onActionSaveButton(ActionEvent event) {
        System.out.println("Save Button Clicked");
    }
    
    @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }   

    public void sendPart(Part recievedPart) {
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
  
    //update method
    public boolean update(int id, Part part) {
        int index = -1;
        for(Part searchPart : Inventory.getAllParts()) {
            index++;
            if(searchPart.getId() == id) {
                Inventory.getAllParts().set(index, part);
                return true;
            }
        }
        return false;
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
