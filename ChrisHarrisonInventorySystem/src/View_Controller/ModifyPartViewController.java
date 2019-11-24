/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class ModifyPartViewController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
