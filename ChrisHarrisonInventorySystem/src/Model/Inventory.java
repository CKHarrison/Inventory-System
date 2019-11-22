/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    @FXML private ObservableList<Part> allParts;
    @FXML private ObservableList<Product> allProducts;

    public Inventory(ObservableList<Part> allParts, ObservableList<Product> allProducts) {
        this.allParts = allParts;
        this.allProducts = allProducts;
    }
    
    
    public void addPart(Part newPart) {
        allParts.add(newPart);
    }
    
    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }
    
    /*search through parts list and find part who's id matches specified 
     * parameter, if no part is found, return null 
    */
    public Part lookupPart(int partId) {
        for(Part part : allParts) {
            if(part.id == partId) {
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
    public ObservableList<Part> lookupPart(String partName) {
        //creating new observable array to hold all of the found parts
        ObservableList<Part> foundPartList = FXCollections.observableArrayList();
        for(Part part : allParts) {
            if(part.name.toLowerCase() == partName.toLowerCase()){
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
    public Product lookProduct(int productId) {
        for(Product product : allProducts) {
            if(product.id == productId){
                return product;
            }
        }
        return null;
    }
    
    //Matches the logic of the observable list lookupPart method
    
    public ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> foundProductsList = FXCollections.observableArrayList();
        for(Product product : allProducts) {
            if(product.name.toLowerCase() == productName.toLowerCase()) {
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
    public void updatePart(int index, Part selectedPart) {
        allParts.remove(index);
        allParts.add(index, selectedPart);
    }
    
     /*
     * remove product at the specified index
    * insert product at specified index with selected product
    */
    public void updateProduct(int index, Product selectedProduct) {
        allProducts.remove(index);
        allProducts.add(index, selectedProduct);
    }
    
    
    public void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }
    
    public void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
    }

    public ObservableList<Part> getAllParts() {
        return allParts;
    }

    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }
    
    
    
}
