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
    
    Stage stage;
    Parent scene;
    
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
    private TextField modifyPartTextField;
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
        System.out.println("In-House Button Clicked");
    }
    
    @FXML
    void onActionOutsourcedButton(ActionEvent event) {
         System.out.println("Outsourced Button Clicked");
    }
    
    //Save and Cancel Buttons
    
    @FXML
    void onActionSaveButton(ActionEvent event) {
        System.out.println("Save Button Clicked");
    }
    
    @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        stage = stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
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
