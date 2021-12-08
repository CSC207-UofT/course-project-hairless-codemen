package src.main.java.Controller;

import javax.swing.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//TODO: On UI, users should be notified that their username should be non-empty; And their password should have a length
// of at least 8; It should also contains at least one special character, one uppercase letter, one lowercase letter,
// and one digit.
public class RegexChecker {

    /**
     * Check whether the string has any information. Return False iff the string input is null or the string is empty
     * or the string only contains space. Otherwise, return True.
     *
     * @param str The string input we want to check
     */
    public static boolean ContainsInfo(String str)
    {
        return ((str != null) && (!str.matches("\\s*")));
    }


    /**
     * Check whether the string contains at least one special character. Return True iff the string is non-empty and
     * contains at least one special character. Otherwise, return False.
     *
     * @param str The string input we want to check
     */
    public static boolean ContainsSpecialChar(String str)
    {
        Pattern pattern = Pattern.compile("[^a-zA-Z\\d]");
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }


    /**
     * Check whether the string contains at least one uppercase letter. Return True iff the string is non-empty and
     * contains at least one uppercase letter. Otherwise, return False.
     *
     * @param str The string input we want to check
     */
    public static boolean ContainsUpper(String str)
    {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }


    /**
     * Check whether the string contains at least one lowercase letter. Return True iff the string is non-empty and
     * contains at least one lower letter. Otherwise, return False.
     *
     * @param str The string input we want to check
     */
    public static boolean ContainsLower(String str)
    {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }


    /**
     * Check whether the string contains at least one digit. Return True iff the string is non-empty and contains at
     * least one digit. Otherwise, return False.
     *
     * @param str The string input we want to check
     */
    public static boolean ContainsDigit(String str)
    {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }


    /**
     * Check whether the string's length is at least 8. Return True iff the length of string is at least 8. Otherwise,
     * return False.
     *
     * @param str The string input we want to check
     */
    public static boolean MinLen(String str)
    {
        return str.matches(".{8,}");
    }

    /**
     * Check whether the password matches all the requirements. Then return teh result.
     *
     * @param password The string input we want to check
     */
    public static String CheckPassword(String password){
        String res = "Your password should contain:";
        if (!ContainsInfo(password)){
            return "Sorry, your password cannot be empty!";
        }
        if (!RegexChecker.ContainsDigit(password)){
            res += "\nat least one digit";
        }
        if (!RegexChecker.ContainsUpper(password)){
            res += "\nat least one uppercase letter";
        }
        if (!RegexChecker.ContainsLower(password)){
            res += "\nat least one lowercase letter";
        }
        if (!RegexChecker.ContainsSpecialChar(password)){
            res += "\nat least one special character.";
        }
        if (!RegexChecker.MinLen(password)){
            res += "\nat least 8 characters.";
        }
        if (res.equals("Your password should contain:")){return "True";
        }
        return res;
    }
}

