package src.test.java.Controller;

import org.junit.jupiter.api.Test;
import src.main.java.Controller.RegexChecker;
import static org.junit.jupiter.api.Assertions.*;

public class RegexCheckerTest {


    @Test
    public void TestContainsInfo(){
        String str1 = "";
        String str2 = "Something";
        assertFalse(RegexChecker.ContainsInfo(str1));
        assertTrue(RegexChecker.ContainsInfo(str2));
    }

    @Test
    public void TestContainsSpecialChar(){
        String str1 = "Something";
        String str2 = "$Something$";
        assertFalse(RegexChecker.ContainsSpecialChar(str1));
        assertTrue(RegexChecker.ContainsSpecialChar(str2));
    }

    @Test
    public void TestContainsUpper(){
        String str1 = "something";
        String str2 = "Something";
        assertFalse(RegexChecker.ContainsUpper(str1));
        assertTrue(RegexChecker.ContainsUpper(str2));
    }

    @Test
    public void TestContainsLower(){
        String str1 = "SOMETHING";
        String str2 = "Something";
        assertFalse(RegexChecker.ContainsLower(str1));
        assertTrue(RegexChecker.ContainsLower(str2));
    }


    @Test
    public void TestContainsDigit(){
        String str1 = "Something";
        String str2 = "Someth1ng";
        assertFalse(RegexChecker.ContainsDigit(str1));
        assertTrue(RegexChecker.ContainsDigit(str2));
    }

    @Test
    public void TestMinLen(){
        String str1 = "Some";
        String str2 = "Something";
        assertFalse(RegexChecker.MinLen(str1));
        assertTrue(RegexChecker.MinLen(str2));
    }

    @Test
    public void TestCheckPassword(){
        String str1 = "$Someth1ng$";
        String str2 = "Something";
        assertEquals("True", RegexChecker.CheckPassword(str1));
        assertEquals("Your password should contain:\nat least one digit\nat least one special character.",
                RegexChecker.CheckPassword(str2));
    }



}
