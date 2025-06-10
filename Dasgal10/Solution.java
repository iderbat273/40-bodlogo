import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    private static final String[] NUMBERS = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
        "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
        "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return NUMBERS[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + NUMBERS[h];
        } else if (m == 30) {
            return "half past " + NUMBERS[h];
        } else if (m == 45) {
            return "quarter to " + NUMBERS[h % 12 + 1];
        } else if (m < 30) {
            String minuteStr = (m == 1) ? " minute " : " minutes ";
            return NUMBERS[m] + minuteStr + "past " + NUMBERS[h];
        } else {
            int remaining = 60 - m;
            String minuteStr = (remaining == 1) ? " minute " : " minutes ";
            return NUMBERS[remaining] + minuteStr + "to " + NUMBERS[h % 12 + 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}