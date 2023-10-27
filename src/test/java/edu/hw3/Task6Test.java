package edu.hw3;

import edu.hw3.Task6.PriorityStockMarket;
import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    void test() {
        StockMarket stockMarket = new PriorityStockMarket();
        Stock s1 = new Stock("Apple", 100);
        Stock s2 = new Stock("Microsoft", 50);
        stockMarket.add(s1);
        stockMarket.add(s2);
        assertThat(stockMarket.mostValuableStock()).isEqualTo(s1);
        stockMarket.remove(s1);
        assertThat(stockMarket.mostValuableStock()).isEqualTo(s2);
    }
}
