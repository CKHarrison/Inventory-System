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
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class ModifyProductViewController implements Initializable {

    @FXML
    private Button modifyProductSearchButton;
    @FXML
    private TextField modifyProductSearchTextField;
    @FXML
    private TableView<?> modifyProductAddTableView;
    @FXML
    private TableColumn<?, ?> modifyProductPartIDTableColumn;
    @FXML
    private TableColumn<?, ?> modifyProductPartNameTableColumn;
    @FXML
    private TableColumn<?, ?> modifyProductInvLevelTableColumn;
    @FXML
    private TableColumn<?, ?> modifyProductPriceTableColumn;
    @FXML
    private Button modifyProductAddButton;
    @FXML
    private GridPane modifyProductDeletTableView;
    @FXML
    private TableView<?> modifyProductDeleteTableView;
    @FXML
    private TableColumn<?, ?> modifyProductPartIdTableColumn;
    @FXML
    private Button modifyProductDeleteButton;
    @FXML
    private Button modifyProductSaveButton;
    @FXML
    private Button modifyProductCancelButton;
    @FXML
    private TextField modifyProductIdTextField;
    @FXML
    private TextField modifyProductNameTextField;
    @FXML
    private TextField modifyProductMaxTextField;
    @FXML
    private TextField modifyProductPriceTextField;
    @FXML
    private TextField modifyProductInvTextField;
    @FXML
    private TextField modifyProductMinTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
