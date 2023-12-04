package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class OneThreadHack implements Hack {
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 5;
    private static final int THREADS = 4;
    private boolean isHacking = false;
    private Map<String, String> hashToUser;
    private Map<String, String> userToPass;

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int ALPH_SIZE = 36;
    private int key = 0;
    private int len = MIN_LENGTH;

    private String nextPassword() {
        int curLen = len;
        int curKey = key++;
        if (key >= (int) Math.pow(ALPH_SIZE, len)) {
            len++;
            key = 0;
        }
        if (len > MAX_LENGTH) {
            return null;
        }
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
        this.hashToUser = hashToUser;
        this.userToPass = new HashMap<>();
        isHacking = true;
        while (isHacking) {
            String pass = nextPassword();
            if (pass == null) {
                isHacking = false;
                break;
            }
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
