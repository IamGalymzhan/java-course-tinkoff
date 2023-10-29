package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityStockMarket implements StockMarket {

    private Queue queue = new PriorityQueue<Stock>(new Comparator<Stock>() {
        @Override
        public int compare(Stock o1, Stock o2) {
            return o2.getPrice() - o1.getPrice();
        }
    });

    @Override
    public void add(Stock stock) {
        queue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        queue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return (Stock) queue.peek();
    }
}
