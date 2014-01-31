/*
 * Created on Mar 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.util;

/**
 * @author Nick
 * 
 *  
 */
public class PriceVO {

    private Double price;

    private int id;

    public PriceVO(Double price, int id) {
        super();
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}