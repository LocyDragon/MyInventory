package com.locydragon.myinv.util;

public final class Compare {
    private static final Calculator cal = new Calculator();
    public static double toInteger(String param) {
        double out = cal.calculate(param);
        cal.clear();
        return out;
    }

    private static boolean isInt(String param) {
        try {
            toInteger(param);
            return true;
        } catch (Exception e) {
            return false;
        }
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
            if (toInteger(string[0].trim()) > toInteger(string[1].trim())) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains("<")) {
            String[] string = str.split("<");
            if (toInteger(string[0].trim()) < toInteger(string[1].trim())) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains("<=")) {
            String[] string = str.replace("<=", "惀").split("惀");
            if (toInteger(string[0].trim()) <= toInteger(string[1].trim())) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains(">=")) {
            String[] string = str.replace(">=", "惀").split("惀");
            if (toInteger(string[0].trim()) >= toInteger(string[1].trim())) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains("!=")) {
            String[] string = str.replace("!=", "惀").split("惀");
            if (toInteger(string[0].trim()) != toInteger(string[1].trim())) {
                return true;
            } else {
                return false;
            }
        } else if (str.contains("=")) {
            String[] params = str.split("=");
            boolean first_isInt = isInt(params[0].trim());
            boolean second_isInt = isInt(params[1].trim());
            if (!first_isInt && !second_isInt) {
                if (params[0].trim().equals(params[1].trim())) {
                    return true;
                } else {
                    return false;
                }
            } else if (first_isInt && second_isInt){
                if (toInteger(params[0].trim()) == toInteger(params[1].trim())) {
                    return true;
                } else {
                    return false;
                }
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
