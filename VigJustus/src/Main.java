import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("phrase eingeben");
        String phrase = sc.next();

        System.out.println("verschluesselungscode eingeben");
        String key = sc.next();

        String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z" };

        String[] phrasenArray = phrase.split("(?!^)");
        String[] keyArray = key.split("(?!^)");

        int length = phrasenArray.length;

        for (int counter = 0; length > counter; counter++) {
            int abcCounter = 0;
            int abcdCounter = 0;

            while (!phrasenArray[counter].equals(abc[abcCounter])) {
                abcCounter++;
            }
            while (!keyArray[counter].equals(abc[abcdCounter])) {
                abcdCounter++;
            }

            String encryptedCharacter= abc[(abcCounter + abcdCounter) % 26];
            System.out.println("encrypted: " + encryptedCharacter);

        }

    }
}