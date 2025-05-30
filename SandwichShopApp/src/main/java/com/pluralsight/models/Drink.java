package com.pluralsight.models;

import com.pluralsight.enums.DrinkType;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.IceType;

public class Drink extends MenuItem {
    private DrinkSize size;
    private DrinkType drinkType;
    private IceType iceType;

    public Drink(DrinkSize size, DrinkType drinkType, IceType iceType) {
        super(size.toString() + " " + drinkType.toString()+ " " +iceType.toString(), size.getPrice());
        this.size = size;
        this.drinkType = drinkType;
        this.iceType = iceType;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public IceType getIceType() {
        return iceType;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getDetails() {
        return String.format("%s (%s) - $%.2f", drinkType, size,getPrice());
    }
}
