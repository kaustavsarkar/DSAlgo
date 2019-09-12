package download.dsalgo.green.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kaustav Sarkar
 * @created: 9/11/2019
 */
public class MinNumberPatern {
    public static void main(String[] args) {
        String string = "DDIDDIID";
                //"DDIDDIID";
                //"IIDDD";
                //"DD";
                //"D";

        System.out.println(new MinNumberPatern().minNumPattern(string));
    }
    public String minNumPattern(String string) {
        if(string == null || string.isEmpty()) return "";
        List<Integer> numList = new ArrayList<>();
        for(int num = 1; num <= string.length() + 1; num++) {
            numList.add(num);
        }
        int[] result = new int[numList.size()];
        int resultCounter = 0;
        for(int index =0; index < string.length(); index++) {
            char pattern = string.charAt(index);
            //count patterns
            int count = 1;
            while(index + count < string.length() &&
                    pattern == string.charAt(index+count)) {
                count++;
            }
            index = index+ count;
            if(pattern == 'D') {
                while(count > 0) {
                    result[resultCounter++] = numList.remove(count--);
                }
            } else {
                result[resultCounter++] = numList.remove(0);
            }
        }
        while(!numList.isEmpty()) {
            result[resultCounter++] = numList.remove(0);
        }

        StringBuilder builder = new StringBuilder();
        for(int num : result) {
            builder.append(num);
        }
        return builder.toString();
    }
    String _getMinNumberForPattern(String seq)
    {
        int n = seq.length();

//        if (n >= 9)
//            return "-1";

        char result[] = new char[n + 1];

        int count = 1;

        // The loop runs for each input character as well as
        // one additional time for assigning rank to each remaining characters
        for (int i = 0; i <= n; i++)
        {
            if (i == n || seq.charAt(i) == 'I')
            {
                for (int j = i - 1; j >= -1; j--)
                {
                    result[j + 1] = (char) ((int) '0' + count++);
                    if (j >= 0 && seq.charAt(j) == 'I')
                        break;
                }
            }
        }
        return new String(result);
    }
    public String _minNumPattern(String string) {

        if(string == null || string.isEmpty()) return "";

        int stringCounter = 0;
        int numberCounter = 1;
        char[] result = new char[string.length() + 1];
        int resultCounter = 0;

        for(int index = 0; index <= string.length(); index++) {

            if(index == string.length() || string.charAt(index) == 'I') {
                result[resultCounter++] = (char)(numberCounter++ + '0');
            }

        }

        return String.valueOf(result);
    }
}
