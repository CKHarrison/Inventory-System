/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    public ObservableList<Part> LookupPart(String partName) {
        for(Part part : allParts) {
            if(part.name.toLowerCase() == partName.toLowerCase())
                return allParts.get(part);
        }
        return null;
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
    
    public ObservableList<Product> lookupProduct(String productName) {
        for(Product product : allProducts) {
            if(product.name.toLowerCase() == productName.toLowerCase()) {
                return allProducts.get(product);
            } 
        }
        return null;
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
