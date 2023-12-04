package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadHack implements Hack {
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 5;
    private static final int THREADS = 4;
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    private AtomicBoolean isHacking = new AtomicBoolean(false);
    private Map<String, String> passToUser;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int ALPH_SIZE = 36;
    private Lock lock = new ReentrantLock();
    private CountDownLatch latch;
    private int key = 0;
    private int len = MIN_LENGTH;

    private String nextPassword() {
        lock.lock();
        int curLen = len;
        int curKey = key++;
        if (key >= (int) Math.pow(ALPH_SIZE, len)) {
            len++;
            key = 0;
        }
        if (len > MAX_LENGTH) {
            lock.unlock();
            return null;
        }
        lock.unlock();
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < curLen; i++) {
            pass.append(ALPHABET.charAt(curKey % ALPH_SIZE));
            curKey /= ALPH_SIZE;
        }
        return pass.reverse().toString();
    }

    public static String hash(String pass) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(pass.getBytes());
            return new String(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> hack(Map<String, String> hashToUser) {
        this.passToUser = new ConcurrentHashMap<>();
        latch = new CountDownLatch(hashToUser.size());
        isHacking.set(true);
        for (int i = 0; i < THREADS; i++) {
            executor.submit(() -> {
                while (isHacking.get() && latch.getCount() > 0) {
                    String pass = nextPassword();
                    if (pass == null) {
                        isHacking.set(false);
                        break;
                    }
                    String hash = hash(pass);
                    if (hashToUser.containsKey(hash)) {
                        passToUser.put(pass, hashToUser.get(hash));
                        latch.countDown();
                    }
                }
            });
        }
        executor.shutdown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return passToUser;
    }

}
