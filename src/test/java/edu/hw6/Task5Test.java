package edu.hw6;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    void test() {
        long[] ids = HackerNews.hackerNewsTopStories();
        assertThat(ids).isNotEmpty();
        String newsName = HackerNews.news(ids[0]);
        assertThat(newsName).isNotEqualTo("");
    }
}
