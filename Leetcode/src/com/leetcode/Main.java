package com.leetcode;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    // https://leetcode.com/problems/first-unique-character-in-a-string/
    public static int firstUniqChar() {

        String s = "dddccdbba";
        String s2 = "loveleetcode";

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()){

            if(map.containsKey(c)){

                map.put(c, map.get(c) + 1);

            } else {

                map.put(c, 1);

            }

        }

        for (int i = 0; i < s.length(); i++) {

            if(map.get(s.charAt(i)) == 1){

                System.out.println("Trouvé avec i : " + i + " et la lettre : " + s.charAt(i) + " l'index vaut : " + s.indexOf(s.charAt(i)));

                return s.indexOf(s.charAt(i));

            }

        }

        return 0;
    }

    // https://leetcode.com/problems/jewels-and-stones/
    public static int numJewelsInStones() {

        String jewels = "aA";
        String stones = "aAAbbbb";

        int nbStones = 0;

        for(char c : stones.toCharArray()) {

            if(jewels.indexOf(c) > -1){

                nbStones++;

            }

        }

        System.out.println("Nb stones : " + nbStones);

        return nbStones;

    }

    // https://leetcode.com/problems/reverse-string/
    public static void reverseString() {

        char[] s = {'h','e','l','l','o'};

        for (int i = 0; i < s.length/2; i++) {

            char tmp = s[i];
            s[i] = s[(s.length-1-i)];
            s[s.length-1-i] = tmp;

        }

        System.out.println(Arrays.toString(s));

    }

    // https://leetcode.com/problems/valid-palindrome/
    public static boolean isPalindrome() {

        String s = "A man, a plan, a canal: Panama";

        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(s);

        String sReversed = matcher.replaceAll("").toLowerCase();

        StringBuilder reversedString = new StringBuilder(sReversed);

        reversedString.reverse();

        if(sReversed.equals(reversedString.toString())){

            return true;

        } else {

            return false;

        }

    }

    public static void main(String[] args) throws IOException {

        // int result = firstUniqChar();
        // int result = numJewelsInStones();
        // reverseString();
        boolean bool = isPalindrome();
        System.out.println(bool);
    }


}
