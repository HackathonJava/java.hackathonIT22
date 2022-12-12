import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Shifr {
    public static void main(String[] args) {
        try {
//            MessageDigest digester = MessageDigest.getInstance("SHA-1");
            MessageDigest digester = MessageDigest.getInstance("MD5");
            byte[] input = "Java".getBytes();
            byte[] digest = digester.digest(input);
            String a = Arrays.toString(digest);
            System.out.println(a);
            System.out.println("\nGo: ");
            Scanner scanner = new Scanner(System.in);
            String n = scanner.nextLine ();
            byte[] input2 = n.getBytes();
            byte[] digest2 = digester.digest(input2);
            String b = Arrays.toString(digest2);
            if(a.equals(b)) System.out.println("Yes");
            else System.out.println("No");

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }

    }
}
