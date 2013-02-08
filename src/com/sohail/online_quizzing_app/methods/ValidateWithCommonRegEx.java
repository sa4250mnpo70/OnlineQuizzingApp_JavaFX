/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.methods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author SOHAIL
 */
public class ValidateWithCommonRegEx {

    private final String DOMAIN_REGEX = "ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cs|cu|cv|cx|cy|cz|dd|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|me|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|su|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|yu|za|zm|zw|aero|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|post|pro|tel|travel";

    public ValidateWithCommonRegEx() {
    }

    /**
     * Match a given string with common type of expressions, such as:
     * EMAIL,strong PASSWORD, URL, NAME, DATE, DOB, ALPHAbetic characters only,
     * NUMERIC characters only, ALPHA_NUMERIC characters, PUNCTUATIONS only etc
     *
     * @param VALIDATOR_TYPE
     * @param CASE_SENSITIVITY
     * @param INPUT
     * @return
     */
    public boolean ValidateWithCommonRegEx(final String VALIDATOR_TYPE,
            final boolean CASE_SENSITIVITY, final String INPUT) {

        Pattern regex = null;
        Matcher emailMatcher = null;

        final String EMAIL_REGEX = "^[\\w.%+\\-]+@[\\w.\\-]+\\.(" + DOMAIN_REGEX + ")$";
        final String USERNAME_REGEX = "^\\w{6,20}$";
        final String PASSWORD_REGEX = "^(?=.*[~!@$%^&*()_+\\-=\\|}{:;<>?/])(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])\\S{8,20}$";
        final String URL_REGEX = null;
        final String NAME_REGEX = null;
        final String DATE_REGEX = null;
        final String DOB_REGEX = null;
        final String ALPHA_REGEX = null;
        final String NUMERIC_REGEX = null;
        final String ALPHA_NUMERIC_REGEX = null;
        final String PUNCTUATIONS_REGEX = null;

        switch (VALIDATOR_TYPE.toUpperCase()) {
            case "EMAIL":
                if (CASE_SENSITIVITY) {
                    regex = Pattern.compile(EMAIL_REGEX);
                } else {
                    regex = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
                }
                break;
            case "USERNAME":
                if (CASE_SENSITIVITY) {
                    regex = Pattern.compile(USERNAME_REGEX);
                } else {
                    regex = Pattern.compile(USERNAME_REGEX, Pattern.CASE_INSENSITIVE);
                }
                break;
            case "PASSWORD":
                regex = Pattern.compile(PASSWORD_REGEX);
                break;
            case "URL":
                if (CASE_SENSITIVITY) {
                    regex = Pattern.compile(URL_REGEX);
                } else {
                    regex = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE);
                }
                break;
            case "NAME":
                if (CASE_SENSITIVITY) {
                    regex = Pattern.compile(NAME_REGEX);
                } else {
                    regex = Pattern.compile(NAME_REGEX, Pattern.CASE_INSENSITIVE);
                }
                break;
            case "DATE":
                regex = Pattern.compile(DATE_REGEX);
                break;
            case "DOB":
                regex = Pattern.compile(DOB_REGEX);
                break;
            case "ALPHA":
                if (CASE_SENSITIVITY) {
                    regex = Pattern.compile(ALPHA_REGEX);
                } else {
                    regex = Pattern.compile(ALPHA_REGEX, Pattern.CASE_INSENSITIVE);
                }
                break;
            case "NUMERIC":
                regex = Pattern.compile(NUMERIC_REGEX);
                break;
            case "ALPHA_NUMERIC":
                if (CASE_SENSITIVITY) {
                    regex = Pattern.compile(ALPHA_NUMERIC_REGEX);
                } else {
                    regex = Pattern.compile(ALPHA_NUMERIC_REGEX, Pattern.CASE_INSENSITIVE);
                }
                break;
            case "PUNCTUATIONS":
                regex = Pattern.compile(PUNCTUATIONS_REGEX);
                break;
            default:
                throw new AssertionError();
        }

        emailMatcher = regex.matcher(INPUT);

        if (!emailMatcher.find()) {
            return false;
        } else {
            return true;
        }
    }
}
