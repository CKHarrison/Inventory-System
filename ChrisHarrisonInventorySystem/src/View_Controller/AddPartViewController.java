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
public class AddPartViewController implements Initializable {

    @FXML
    private RadioButton addPartInHouseRadioButton;
    @FXML
    private RadioButton addPartOutsourcedRadioButton;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label invLabel;
    @FXML
    private Label priceCostLabel;
    @FXML
    private TextField idTextArea;
    @FXML
    private TextField nameTextArea;
    @FXML
    private TextField invTextArea;
    @FXML
    private TextField priceCostTextArea;
    @FXML
    private Label addPartMaxLabel;
    @FXML
    private Label addPartMinLabel;
    @FXML
    private TextField addPartMaxTextArea;
    @FXML
    private TextField addPartMinTextArea;
    @FXML
    private Label addPartCompanyNameOrMachineIDLabel;
    @FXML
    private TextField addPartCompanyNameOrMachineIDTextField;
    @FXML
    private Button addPartSaveButton;
    @FXML
    private Button addPartCancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
