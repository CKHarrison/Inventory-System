/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.ObservableList;

/**
 *
 * @author chris
 */
public class Product extends Part {
    private ObservableList<Part> associatedParts;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Product(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public int getId() {
       return this.id;
    }

    @Override
    public String getName() {
        return this.name;
      }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getStock() {
        return this.stock;
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max;
    }
    
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }
    
    public void deleteAssociatedPart(Part associatedPart) {
        associatedParts.remove(associatedPart);
    }
    
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
       
    
}
