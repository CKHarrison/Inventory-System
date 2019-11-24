
package Model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author chris
 */
public class Inventory {
    @FXML private static ObservableList<Part> allParts;
    @FXML private static ObservableList<Product> allProducts;

//    public Inventory(ObservableList<Part> allParts, ObservableList<Product> allProducts) {
//        this.allParts = allParts;
//        this.allProducts = allProducts;
//    }
    
    
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }
    
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }
    
    /*search through parts list and find part who's id matches specified 
     * parameter, if no part is found, return null 
    */
    public static Part lookupPart(int partId) {
        for(Part part : allParts) {
            if(part.getId() == partId) {
                return part;
            } 
        }
        return null;
    }
    
    /* search through parts list and find the part's name that matches 
    * the specified name string parameter. Ensures accuracy by making all
    * letters lowercase
    * if no part is found, return null
    */
    public static ObservableList<Part> lookupPart(String partName) {
        //creating new observable array to hold all of the found parts
        ObservableList<Part> foundPartList = FXCollections.observableArrayList();
        for(Part part : allParts) {
            if(part.getName().toLowerCase().equals(partName.toLowerCase())){
                foundPartList.add(part);
            }
                
        }
        //Making sure the application will not error out if the list is empty
        if(foundPartList.isEmpty()) {
            return null;
        } else {
            return foundPartList;
        }
    }
    
    //same search method as the lookupPart based on the product id
    public static Product lookProduct(int productId) {
        for(Product product : allProducts) {
            if(product.getId() == productId){
                return product;
            }
        }
        return null;
    }
    
    //Matches the logic of the observable list lookupPart method
    
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> foundProductsList = FXCollections.observableArrayList();
        for(Product product : allProducts) {
            if(product.getName().toLowerCase().equals(productName.toLowerCase())) {
                foundProductsList.add(product);
            }
        }
        if(foundProductsList.isEmpty()) {
            return null;
        } else {
            return foundProductsList;
        }
    }
    
    /*
     * remove part at the specified index
    * insert part at specified index with selected part
    */
    public static void updatePart(int index, Part selectedPart) {
        allParts.remove(index);
        allParts.add(index, selectedPart);
    }
    
     /*
     * remove product at the specified index
    * insert product at specified index with selected product
    */
    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.remove(index);
        allProducts.add(index, selectedProduct);
    }
    
    
    public static void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }
    
    public static void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
    
    
    
}
