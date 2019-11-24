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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class MainScreenController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
