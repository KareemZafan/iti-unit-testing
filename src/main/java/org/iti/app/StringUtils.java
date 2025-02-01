package org.iti.app;

public class StringUtils {

    public boolean isPalindrome(String text){
        return text.equals(new StringBuilder(text).reverse().toString());
    }
}
