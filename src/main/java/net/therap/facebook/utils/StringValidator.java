package net.therap.facebook.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    private static final StringValidator stringValidator = new StringValidator();
    private Pattern pattern;
    private Matcher matcher;

    private StringValidator() {

    }

    public static StringValidator getInstance() {
        return stringValidator;
    }

    public boolean validateString(String text, String patrn) {
        pattern = Pattern.compile(patrn);
        matcher = pattern.matcher(text);
        return matcher.matches();
    }
}

