package edu.hw7;

import edu.hw7.Task3.MapPersonDatabase;
import edu.hw7.Task3.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ThreadLocalRandom;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Common case")
    void test() {
        MapPersonDatabase mapPersonDatabase = new MapPersonDatabase();
        Thread thread1  = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                mapPersonDatabase.add(new Person(ThreadLocalRandom.current().nextInt(10000),
                    "Name", "Address", "Phone"
                ));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int namesFound = 0;
                int addressesFound = 0;
                int phonesFound = 0;
                synchronized (mapPersonDatabase) {
                    namesFound = mapPersonDatabase.findByName("Name").size();
                    addressesFound = mapPersonDatabase.findByAddress("Address").size();
                    phonesFound = mapPersonDatabase.findByPhone("Phone").size();
                }
                assertThat(namesFound).isEqualTo(addressesFound);
                assertThat(namesFound).isEqualTo(phonesFound);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(mapPersonDatabase.findByName("Name").size()).isEqualTo(1000);
    }
}
