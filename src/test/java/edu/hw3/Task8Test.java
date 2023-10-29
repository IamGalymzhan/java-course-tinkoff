package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task8Test {
    @Test
    void test() {
        Iterator it = new BackwardIterator<>(List.of(1,2,3));
        List list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next());
        }
        assertThat(list).isEqualTo(List.of(3, 2, 1));
    }
}
