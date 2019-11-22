/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author chris
 */
public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }
    
    
    public abstract void setId(int id);
    public abstract void setName(String name);
    public abstract void setPrice(double price);
    public abstract void setStock(int stock);
    public abstract void setMin(int min);
    public abstract void setMax(int max);
    public abstract int getId();
    public abstract String getName();
    public abstract double getPrice();
    public abstract int getStock();
    public abstract int getMin();
    public abstract int getMax();
    
    
}
