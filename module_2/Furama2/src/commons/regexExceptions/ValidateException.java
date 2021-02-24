package commons.regexExceptions;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateException<flag> {
    public static final String REGEX_ID = "(SV)(VL|HO|RO)-[\\d]{4}";
    public static final String REGEX_SERVICE_NAME = "[A-Z][a-z]*";

    public static final String REGEX_FULL_NAME="";
    public static final String REGEX_EMAIL="([\\w]+@[a-z]+.(com|vn))";
    public static final String REGEX_GENDER="(Male|Female|Unknowns)";
    public static final String REGEX_ID_CARD="([0-9]{3}-[0-9]{3}-[0-9]{3})";
    public static final String REGEX_BIRTH="\\d{2}/\\d{2}/\\d{4}";
    public static final String REGEX_PHONE_NUMBER="(\\+84|0)[0-9]{9}";
    public static final String REGEX_TYPE_CUSTOMER="(Diamond|Plutonium|Gold|Silver|Member)";
    public static Pattern pattern;
    public static Matcher matcher;

    public static boolean isValidateStandard(String string, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(string);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Input not match" + regex);

        }
        return !flag;
    }

    public static boolean isMoreThan(double number, double numberCheck) {
        boolean flag = number > numberCheck;
        if (!flag) {
            System.out.println("Input number > 30m2: " + numberCheck);
        }
        return !flag;
    }

    public static boolean isMoreThan(double number, double startNumberCheck, double endNumberCheck) {
        boolean flag = number > startNumberCheck && number < endNumberCheck;
        if (!flag) {
            System.out.println("Input not match: " + startNumberCheck + "  ,  " + endNumberCheck);
        }
        return !flag;
    }

    public static boolean isExtraService(String extraService) {
        String[] list = {"massage", "karaoke", "food", "drink", "car"};
        boolean flag = Arrays.asList(list).contains(extraService);
        if (!flag) {
            System.out.println("extra server not list(\"massage\", \"karaoke\", \"food\", \"drink\", \"car\")");
        }
        return flag;
    }
}