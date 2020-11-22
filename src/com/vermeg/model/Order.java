package com.vermeg.model;

public class Order {

    private int id;
    private int quantity;
    private int unitPrice;

    public Order() {
    }

    public Order(int id, int quantity, int unitPrice) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Order(int quantity, int unitPrice) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public double calculateTotalPrice(){
        return  quantity*unitPrice;
    }

    public static double calculateTotalPrice(int qte,double unitPrice){
        return qte*unitPrice;
    }


}
