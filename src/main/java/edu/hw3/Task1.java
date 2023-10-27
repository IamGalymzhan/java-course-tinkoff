package edu.hw3;

public class Task1 {

    private Task1() {
    }

    final static int ALPHABET_SIZE = 26;

    private static char mirrorSymbol(char symbol) {
        if (symbol >= 'a' && symbol <= 'z') {
            return (char) (ALPHABET_SIZE - 1 - symbol + 'a' * 2);
        } else if (symbol >= 'A' && symbol <= 'Z') {
            return (char) (ALPHABET_SIZE - 1 - symbol + 'A' * 2);
        }
        return symbol;
    }

    public static String atbash(String text) {
        String result = "";

        for (int i = 0; i < text.length(); ++i) {
            result += mirrorSymbol(text.charAt(i));
        }

        return result;
    }
}

