package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateException<flag> {

    private static final String REQUIRED_STRING_REGEX = "^\\w+$";
    private static final String XETAI_REGEX = "^\\d{2}C-\\d{3}\\.\\d{2}$";
    private static final String OTO_REGEX = "^\\d{2}Y-\\d{3}\\.\\d{2}$";
    private static final String XEDAP_REGEX = "^\\d{2}-[A-Z]\\d-\\d{3}\\.\\d{2}$";

    public static boolean isValidateStandard(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Đầu vào không phù hợp" + regex);

        }
        return !flag;
    }
}
