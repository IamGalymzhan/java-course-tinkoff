package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OndThreadHack implements Hack {
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 6;
    private static final int THREADS = 4;
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    private boolean isHacking = false;
    private Map<String, String> hashToUser;
    private Map<String, String> userToPass;

    private String alphabet = "abcdefghijklmnopqrstuvz0123456789";
    private List<Integer> curPass = new CopyOnWriteArrayList<>();

    private String nextPassword() {
        return null;
    }

    private String hash(String pass) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(pass.getBytes());
            return new String(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> hack(Map<String, String> hashToUser) {
        this.hashToUser = hashToUser;
        this.userToPass = new ConcurrentHashMap<>();
        isHacking = true;
        while (isHacking) {
            String pass = nextPassword();
            String hash = hash(pass);
            if (hashToUser.containsKey(hash)) {
                userToPass.put(pass, hashToUser.get(hash));
                if (userToPass.size() == hashToUser.size()) {
                    isHacking = false;
                }
            }
        }
        return userToPass;
    }
}
