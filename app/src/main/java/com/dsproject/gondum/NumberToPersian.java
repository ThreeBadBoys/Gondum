package com.dsproject.gondum;

import java.util.ArrayList;

public class NumberToPersian {
    private static ArrayList<String> persianNumbers = new ArrayList<>();
    private static ArrayList<String> englishNumbers = new ArrayList<>();

    static String toPersianNumber(String text) {
        if (text.equals("")) {
            return "";
        } else {
            persianNumbers.add("۰");
            persianNumbers.add("۱");
            persianNumbers.add("۲");
            persianNumbers.add("۳");
            persianNumbers.add("۴");
            persianNumbers.add("۵");
            persianNumbers.add("۶");
            persianNumbers.add("۷");
            persianNumbers.add("۸");
            persianNumbers.add("۹");
            englishNumbers.add("0");
            englishNumbers.add("1");
            englishNumbers.add("2");
            englishNumbers.add("3");
            englishNumbers.add("4");
            englishNumbers.add("5");
            englishNumbers.add("6");
            englishNumbers.add("7");
            englishNumbers.add("8");
            englishNumbers.add("9");
            StringBuilder out = new StringBuilder();
            int length = text.length();
            for (int i = 0; i < length; i++) {
                char c = text.charAt(i);
                if (englishNumbers.contains(Character.toString(c))) {
                    int number = Integer.parseInt(Character.toString(c));
                    out.append(persianNumbers.get(number));

                } else if (c == '٫') {
                    out.append(Character.toString('،'));
                } else {
                    out.append(Character.toString(c));
                }
            }
            persianNumbers.clear();
            englishNumbers.clear();
            return out.toString();
        }
    }
}
