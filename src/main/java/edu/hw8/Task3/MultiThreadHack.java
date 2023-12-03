package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultiThreadHack implements Hack {
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 6;
    private static final int THREADS = 4;
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    private AtomicBoolean isHacking = new AtomicBoolean(false);
    private Map<String, String> hashToUser;
    private Map<String, String> userToPass;

    private String nextPassword() {
        return "";
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
        isHacking.set(true);
        for (int i = 0; i < THREADS; i++) {
            executor.submit(() -> {
                String pass = nextPassword();
                String hash = hash(pass);
                if (hashToUser.containsKey(hash)) {
                    userToPass.put(pass, hashToUser.get(hash));
                }
            });
        }
        return null;
    }
}
