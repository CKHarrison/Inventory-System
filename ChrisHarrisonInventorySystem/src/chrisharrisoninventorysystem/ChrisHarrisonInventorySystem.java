
package chrisharrisoninventorysystem;

import Model.InHousePart;
import Model.Inventory;
import Model.OutSourcedPart;
import Model.Part;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author chris
 */
public class ChrisHarrisonInventorySystem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InHousePart part1InHousePart = new InHousePart(1, 1, "Hammer", 10.99, 5, 0, 10);
        InHousePart part2InHousePart = new InHousePart(2, 2, "Nail", 0.99, 200, 50, 300);
        InHousePart part3InHousePart = new InHousePart(3, 3, "Wrench", 6.00, 15, 3, 20);
        
        Inventory.addPart(part1InHousePart);
        Inventory.addPart(part2InHousePart);
        Inventory.addPart(part3InHousePart);
        
        OutSourcedPart part1OutSourcedPart = new OutSourcedPart("Black And Decker", 4, "Plier", 5.99, 20, 10, 30);
        OutSourcedPart part2OutSourcedPart = new OutSourcedPart("Lowes", 5, "Radio", 15.99, 40, 2, 45);
        OutSourcedPart part3OutSourcedPart = new OutSourcedPart("Home Depot", 6, "Paint", 52.99, 20, 6, 32);
        
        Inventory.addPart(part1OutSourcedPart);
        Inventory.addPart(part2OutSourcedPart);
        Inventory.addPart(part3OutSourcedPart);
        
        Product product1 = new Product(1, "Car", 1500.24, 3, 0, 5);
        Product product2 = new Product(2, "Broom", 10.24, 3, 1, 7);
        Product product3 = new Product(3, "Water", 0.99, 111, 50, 5000);
        
        Inventory.addProduct(product1);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);
        
        
        
        launch(args);
    }
    
}
