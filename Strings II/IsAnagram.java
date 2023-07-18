import java.io.*;
import java.util.*;

public class IsAnagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.next().toLowerCase();
        String s2 = sc.next().toLowerCase();
        if (isAnagram(s1, s2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }

    static boolean isAnagram(String s1, String s2) {
        // <ch,count>
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> arr = new HashMap<>();
        // HashMap<Character,Integer> arr2=new HashMap<>();
        for (char ch : s1.toCharArray()) {
            if (arr.containsKey(ch)) {
                arr.put(ch, arr.get(ch) + 1);
            } else {
                arr.put(ch, 1);
            }
        }
        for (char ch : s2.toCharArray()) {
            if (!arr.containsKey(ch)) {
                return false;
            } else {
                if (arr.get(ch) == 1) {
                    arr.remove(ch);
                } else {
                    arr.put(ch, arr.get(ch) - 1);
                }
            }
        }
        return true;
    }
}
