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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class AddProductViewController implements Initializable {

    @FXML
    private Button addProductSearchButton;
    @FXML
    private TextField addProductTextField;
    @FXML
    private TableView<?> addProductTableView;
    @FXML
    private TableColumn<?, ?> addPartIDTableColumn;
    @FXML
    private TableColumn<?, ?> addPartNameTableColumn;
    @FXML
    private TableColumn<?, ?> addPartInvLevelTableColumn;
    @FXML
    private TableColumn<?, ?> addPartPriceTableColumn;
    @FXML
    private Button addProductAddButton;
    @FXML
    private TableView<?> deleteProductTableView;
    @FXML
    private TableColumn<?, ?> deletePartTableColumn;
    @FXML
    private TableColumn<?, ?> deletePartNameTableColumn;
    @FXML
    private TableColumn<?, ?> deleteInvLevelTableColumn;
    @FXML
    private TableColumn<?, ?> deletePriceTableColumn;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label IdLabel;
    @FXML
    private TextField addProductIDTextField;
    @FXML
    private TextField addProductNameTextField;
    @FXML
    private TextField addProductMaxTextField;
    @FXML
    private TextField addProductPriceTextField;
    @FXML
    private TextField addProductInvTextField;
    @FXML
    private TextField addProductMinTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
