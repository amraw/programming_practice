package pattern_matching;
import java.util.*;

public class KMP {
    public static List<Integer> findPattern(String pattern, String text){
        int []lps = computeLPSArray(pattern);
        List<Integer> matchIndex = new ArrayList<>();
        int patternIndex = 0;
        int textIndex = 0;
        while(textIndex < text.length())
        {
            if(pattern.charAt(patternIndex) == text.charAt(textIndex))
            {
                patternIndex++;
                textIndex++;
            }
            if(patternIndex == pattern.length())
            {
                matchIndex.add(textIndex - patternIndex);
                patternIndex = lps[patternIndex-1];
            }
            else if( textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex))
            {
                if(patternIndex != 0)
                {
                    patternIndex = lps[patternIndex-1];
                }
                else
                {
                    textIndex++;
                }
            }
        }
        return matchIndex;
    }

    public static int[] computeLPSArray(String pattern)
    {
        int []lps = new int[pattern.length()];
        int index = 0;
        lps[0] = 0;
        int i = 1;
        while( i < pattern.length())
        {

            if(pattern.charAt(index) == pattern.charAt(i))
            {
                index++;
                lps[i] = index;
                i++;
            }
            else
            {
                if(index !=0)
                {
                    index = lps[index-1];
                }
                else
                {
                    lps[i] = index;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String []args)
    {
        String pattern = "AAAA";
        String text = "AAAAABAAABA";
        for(int match: findPattern(pattern, text))
        {
            System.out.println("Match: "+match);
        }
    }
}
