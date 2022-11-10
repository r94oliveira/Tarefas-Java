import java.util.*;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class T03E05 {
    public static String removerAcentos(String str) {
        String normalizer = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }

    public static boolean Palindromo(String palavra){
        int char1 = 0;
        int char2 = palavra.length() - 1;

        while (char2 > char1) {
                if (palavra.charAt(char1) != palavra.charAt(char2)) {
                        return false;
                }
                ++char1;
                --char2;
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String palavra = "";
        boolean palindromo = false;

        System.out.printf("\nDigite uma palavra para verificar se eh palindromo: ");
        palavra = sc.nextLine();

        System.out.printf("\nA palavra digitada eh: \"%s\"!\n", palavra);

        palavra = removerAcentos(palavra.toLowerCase());
        palavra = palavra.replaceAll("[^a-z]+", "");

        palindromo = Palindromo(palavra);

        System.out.printf("\n---------------------------------------------");
        if (palindromo) {
                System.out.printf("\nA palavra digitada \"%s\" eh palindromo!\n", palavra);
        } else {
                System.out.printf("\nA palavra digitada \"%s\" NAO eh palindromo!\n", palavra);
        }
        System.out.printf("---------------------------------------------\n\n");
    }
}
