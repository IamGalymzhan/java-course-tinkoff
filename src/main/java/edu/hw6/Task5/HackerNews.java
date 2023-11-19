package edu.hw6.Task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private HackerNews() {
    }

    private static long[] toArray(String string) {
        return Arrays.stream(string.substring(1, string.length() - 1).split(","))
            .mapToLong(Long::valueOf)
            .toArray();
    }

    public static long[] hackerNewsTopStories() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://hacker-news.firebaseio.com/v0/topstories.json"))
            .GET()
            .build();
        try (HttpClient httpClient = HttpClient.newBuilder().build()) {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return toArray(response.body());

        } catch (Exception e) {
            return new long[0];
        }
    }

    private static String parseTitle(String string) {
        Matcher matcher = Pattern.compile("\"title\":\"(.*?)\"").matcher(string);
        return matcher.find() ? matcher.group(1) : "";
    }

    public static String news(long id) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
            .GET()
            .build();
        try (HttpClient httpClient = HttpClient.newBuilder().build()) {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return parseTitle(response.body());

        } catch (Exception e) {
            return "";
        }
    }
}
