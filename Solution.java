import java.util.*;
import java.io.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map = new HashMap<Character, Integer>(); 
        int count =0;
        int maxCount =0;
        int stringStart = 0;

        for(int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (maxCount < count) {
                   System.out.println("max = "+maxCount+ "and count ="+count);
                    maxCount = count;
                }
                if ( map.get(s.charAt(i)) >= stringStart) {
                    count = i - map.get(s.charAt(i));
                    System.out.println("changed count :"+count+ " char is "+s.charAt(i) + "stringStart ="+stringStart);
                    
                    stringStart = map.get(s.charAt(i))+1;
                    System.out.println("new stringStart ="+stringStart);
                    
                } else { 
                    System.out.println("Not changing count");
                    count++;
                }
                map.put(s.charAt(i),i);
            } else {
                map.put(s.charAt(i),i);

                count++;
                System.out.println("reg count :"+count+ "char is "+s.charAt(i));
            }
        }
        if (maxCount < count) {
            maxCount = count;
        }
        
        return maxCount;
    }

    public static void main(String [] args) {
        Solution x = new Solution();
        int len = x.lengthOfLongestSubstring("aa");
        System.out.println(len);
    }
}