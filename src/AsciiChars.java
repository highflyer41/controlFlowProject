/**
 * AsciiChars
 */
public class AsciiChars {

    public static void printNumbers() {
        System.out.println("Valid ASCII values for numbers 0-9: ");
        for (int i = 48; i <= 57; i++) {
            System.out.print(i + " ");
        }
    }

    public static void printLowerCase() {
        System.out.println("Valid ASCII values for lowercase letters: ");
        for (int i = 97; i <= 122; i++) {
            System.out.print(i + " ");
        }
    }

    public static void printUpperCase() {
        System.out.println("Valid ASCII values for uppercase letters: ");
        for (int i = 65; i <= 90; i++) {
            System.out.print(i + " ");
        }
    }
}