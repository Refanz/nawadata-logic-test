import java.util.Scanner;

public class SortCharacter {

    public static String replaceWhitespaces(String word) {
        return word.toLowerCase().trim().replace(" ", "");
    }

    public static String[] convertWordToArray(String word) {
        return replaceWhitespaces(word).split("");
    }

    public static String sortedWord(String word) {
        String[] wordArr = convertWordToArray(word);

        String data = "";

        for (int i = 0; i < wordArr.length; i++) {

            if (data.length() == wordArr.length) break;

            data += wordArr[i];

            for (int j = i + 1; j < wordArr.length; j++) {
                if (wordArr[i].equals(wordArr[j])) {
                    data += wordArr[j];
                    break;
                }
            }
        }

        return data;
    }

    public static String procVowel(String param) {
        String[] word = convertWordToArray(param);
        String vowels = "aiueo";

        String result = "";

        for (int i = 0; i < word.length; i++) {
            if (vowels.contains(word[i])) {
                result += word[i];
            }
        }

        return sortedWord(result);
    }

    public static String procConsonant(String param) {
        String[] word = convertWordToArray(param);
        String vowels = "aiueo";

        String result = "";

        for (int i = 0; i < word.length; i++) {
            if (!vowels.contains(word[i])) {
                result += word[i];
            }
        }

        return sortedWord(result);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input one line of words (S): ");
        String word = input.nextLine();

        System.out.println("Vowel Characters : ");
        System.out.println(procVowel(word));

        System.out.println("Consonant Characters : ");
        System.out.println(procConsonant(word));
    }
}
