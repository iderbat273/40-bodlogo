import java.util.Scanner;

public class Encryption {
    public static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int len = s.length();
        int r = (int) Math.floor(Math.sqrt(len));
        int c = (int) Math.ceil(Math.sqrt(len));
        
        if (r * c < len) {
            r++;
        }
        
        StringBuilder encrypted = new StringBuilder();
        
        for (int i = 0; i < c; i++) {
            for (int j = i; j < len; j += c) {
                encrypted.append(s.charAt(j));
            }
            encrypted.append(" ");
        }
        
        return encrypted.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(encryption(s));
    }
}
