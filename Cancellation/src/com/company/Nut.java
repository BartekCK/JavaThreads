package com.company;

public class Nut {
    private volatile static int count=0;
    private int myCount;
    private int price;

    public Nut() {
        myCount = count;
        count++;
    }

    public Nut(int price) {
        super();
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Nut{" +
                "price = "  + price + " Count = " + myCount +
                '}';
    }
}
