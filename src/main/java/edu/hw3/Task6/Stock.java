package edu.hw3.Task6;

import java.util.Objects;

public class Stock {
    private String title;
    private int price;

    public Stock(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        return price == stock.price && Objects.equals(title, stock.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}
