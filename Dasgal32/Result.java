public class Result {
    public static String timeInWords(int h, int m) {
    
    String[] words = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
            "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine" };

    if (m == 0)
        return words[h] + " o' clock";
    else if (m == 15)
        return "quarter past " + words[h];
    else if (m == 30)
        return "half past " + words[h];
    else if (m == 45)
        return "quarter to " + words[h + 1];
    else if (m < 30)
        return words[m] + (m == 1 ? " minute past " : " minutes past ") + words[h];
    else
        return words[60 - m] + (m == 59 ? " minute to " : " minutes to ") + words[h + 1];

    }
}