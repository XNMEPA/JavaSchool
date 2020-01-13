package ru.malychev.jstasks;

import java.util.Comparator;

public class LengthStringComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
        if (str1.length() == str2.length()) return str1.compareTo(str2);
        return str1.length() > str2.length() ? 1 : -1;
    }
}
