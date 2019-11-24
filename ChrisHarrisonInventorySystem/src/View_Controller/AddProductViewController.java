package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddProductViewController {

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

}
