package com.locydragon.myinv.util;

public final class Compare {
    private static final Calculator cal = new Calculator();
    public static double toInteger(String param) {
        double out = cal.calculate(param);
        cal.clear();
        return out;
    }
    /*
    >
    <
    <=
    >=
    !=
     */
    public static boolean compare(String str) {
        if (str.contains(">")) {
            String[] string = str.split(">");
            if (toInteger(string[0]) > toInteger(string[1])) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains("<")) {
            String[] string = str.split("<");
            if (toInteger(string[0]) < toInteger(string[1])) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains("<=")) {
            String[] string = str.replace("<=", "惀").split("惀");
            if (toInteger(string[0]) <= toInteger(string[1])) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains(">=")) {
            String[] string = str.replace(">=", "惀").split("惀");
            if (toInteger(string[0]) >= toInteger(string[1])) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains("!=")) {
            String[] string = str.replace("!=", "惀").split("惀");
            if (toInteger(string[0]) != toInteger(string[1])) {
                return true;
            } else {
                return false;
            }
        } else {
            try {
                throw new Exception("不等式错误.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
