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
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
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
public class AddPartViewController implements Initializable {
    
    //Global Variables
    Stage stage;
    Parent scene;
    AtomicInteger generatedPartID = new AtomicInteger();
    
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
        //creating a unique id for the part id starting at 0
       
        generatedPartID.incrementAndGet();
        int uniqueID =  (int) Math.random();
        //just explanation purposes. Use a random number generator to assign id
        //int id = Integer.parseInt(addPartIdTextField.getText());

        String name = addPartNameTextField.getText().trim();
        int stock = Integer.parseInt(addPartInvTextField.getText());
        double price = Double.parseDouble(addPartPriceCostTextField.getText());
        int max = Integer.parseInt(addPartMaxTextField.getText());
        int min = Integer.parseInt(addPartMinTextField.getText());
        int machineId = 0;
        String companyName = null;
        
        boolean inHouse = addPartInHouseRadioButton.isSelected();
        
        //check to see if inHouse or outSourced is selected, if then accordingly set machineId or companyName
        if(inHouse) {
            machineId = Integer.parseInt(addPartCompanyNameOrMachineIDTextField.getText());
        } else {
            companyName = addPartCompanyNameOrMachineIDTextField.getText();
        }
        
        //saving the part object based on which button is selected
        
        if(inHouse) {
            Inventory.addPart(new InHousePart(machineId, uniqueID, name, price, stock,  min,  max));
        } else {
            Inventory.addPart(new OutSourcedPart(companyName, uniqueID, name, price, stock, min, max));
        }
        
        returnToMainMenu(event);

    }
    
      @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
          returnToMainMenu(event);
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
