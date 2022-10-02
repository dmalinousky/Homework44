import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework44Main {
    public static void main(String[] args) throws IOException {
        task1Method();
        task2Method();
    }

    public static void task1Method() {
        String phoneFormat1 = "+375291234567";
        System.out.println(phoneFormat1.replaceAll("(^\\+375)([0-9]{2})([0-9]{3})([0-9]{2})([0-9]{2})", "$1($2)***-$4-$5"));

        String phoneFormat2 = "80441234567";
        System.out.println(phoneFormat2.replaceAll("(^8)([0-9]{3})([0-9]{3})([0-9]{2})([0-9]{2})", "$1($2)***-$4-$5"));
    }

    public static void task2Method() throws IOException {
        /* Mask examples:
        Abc_1234_1234.exe
        abc_1234_1234.java
        Abc_1234.properties
        abc_1234.xml
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Provide your mask example:");
        String mask = reader.readLine();

        // Adequate variant (chat & last lesson examples)
        Pattern pattern = Pattern.compile("([A-Za-z])+(_)(.*_)?(.+)\\.([a-z]+)");
        Matcher matcher = pattern.matcher(mask);
        System.out.println(matcher.matches() ? "Mask was accepted!" : "Mask wasn't accepted! Try again!");

        /* Inadequate variant
        Pattern pattern = Pattern.compile("(.)+\\.([a-z]+)");
        Matcher matcher = pattern.matcher(mask);
        System.out.println(matcher.matches() ? "Mask was accepted!" : "Mask wasn't accepted! Try again!");
        */
    }
}
