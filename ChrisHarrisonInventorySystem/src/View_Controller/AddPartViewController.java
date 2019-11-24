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
public class AddPartViewController implements Initializable {
    
    //Global Variables
    Stage stage;
    Parent scene;

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
    private TextField addPartIdTextArea;
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
        System.out.println("InHouse Button Clicked");
    }

    @FXML
    void onActionOutsourcedButton(ActionEvent event) {
        System.out.println("OutSourcedButton Clicked");
    }

    @FXML
    void onActionSavedButton(ActionEvent event) {
        System.out.println("Save Button Clicked");
    }
    
      @FXML
    void onActionCancelButton(ActionEvent event) throws IOException {
        stage = (Stage) (((Button)event.getSource()).getScene().getWindow());
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
