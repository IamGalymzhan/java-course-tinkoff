package edu.hw1;

public class Task5 {
    private Task5() {

    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeDescendant(int num) {
        String numString = Integer.toString(Math.abs(num));
        if (numString.length() == 1) {
            return false;
        }
        if (isPalindrome(numString)) {
            return true;
        }
        String numDescedant = "";
        for (int i = 0; i < numString.length(); i += 2) {
            if (i == numString.length() - 1) {
                numDescedant += (numString.charAt(i) - '0');
                continue;
            }
            numDescedant += (numString.charAt(i) - '0') + (numString.charAt(i + 1) - '0');
        }
        return isPalindromeDescendant(Integer.parseInt(numDescedant));
    }
}
