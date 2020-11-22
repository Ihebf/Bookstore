package com.vermeg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Order {

    private int id;
    private int quantity;
    private int unitPrice;

    public double calculateTotalPrice(){
        return  quantity*unitPrice;
    }
    public static double calculateTotalPrice(int qte,double unitPrice){
        return qte*unitPrice;
    }


}
