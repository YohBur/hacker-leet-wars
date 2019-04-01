package com.hackerrank;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    // https://www.hackerrank.com/challenges/sock-merchant
    static int sockMerchant() {

        int n = 7; // Nb chaussettes

        int[] ar = {1, 1, 1, 3, 4, 3, 2}; // Chaussettes

        int nbPairs = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : ar) {

            if (map.containsKey(i)) {

                map.put(i, map.get(i) + 1);

            } else {

                map.put(i, 1);

            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry<Integer, Integer> entry = it.next();

            if (entry.getValue() / 2 >= 1) {

                nbPairs += entry.getValue() / 2;

            }

        }

        System.out.println("J'ai : " + nbPairs + " paires");


        return nbPairs;

    }


    // https://www.hackerrank.com/challenges/counting-valleys/
    static int countingValleys() {

        int n = 8; // Nb traversées
        String s = "UDDDUDUU"; // Environnements traversés

        int nbValley = 0;
        int altitude = 0;

        for (char c : s.toCharArray()) {

            if (c == 'D') {

                altitude--;

            } else if (c == 'U') {

                altitude++;
            }

            if (altitude == 0 && c == 'U') {

                nbValley++;

            }

        }


        return nbValley;


    }

    // https://www.hackerrank.com/challenges/jumping-on-the-clouds/
    static int jumpingOnClouds() {

        int[] c = {0, 0, 0, 1, 0, 0};
        //int[] c = {0,0,1,0,0,1,0};
        //int[] c2 = {0,0,0,0,1,0};

        int nbJumps = 0;

        for (int i = 0; i < c.length - 1; i++) {

            if (i + 2 > c.length - 1) {

                nbJumps++;
                break;
            }

            if (c[i + 2] != 1) {

                nbJumps++;
                i++;

            } else if (c[i + 1] != 1) {

                nbJumps++;

            }

        }

        return nbJumps;
    }

    // https://www.hackerrank.com/challenges/equality-in-a-array/
    static int equalizeArray() {

        int[] arr = {3, 3, 2, 1, 3};

        Map<Integer, Integer> map = new HashMap<>();

        // Il s'agit de trouver le plus grand nombre d'occurence d'une valeur.
        // On compte toutes les occurences de tous les élements du tableau

        for (int i : arr) {

            if (map.containsKey(i)) {

                map.put(i, map.get(i) + 1);

            } else {

                map.put(i, 1);

            }
        }

        int highestOccurence = 0;

        // Puis nous parcourons notre liste de (valeur, nbOccurences) pour déterminer laquelle dispose du plus grand nombre d'occurences.

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > highestOccurence) {

                highestOccurence = entry.getValue();

            }

        }

        // On déduit le nb d'occurence de l'élément le plus présent avec le nb total d'élément du tableau pour déterminer le nb d'élément à ne PAS conserver
        return arr.length - highestOccurence;

    }

    // https://www.hackerrank.com/challenges/repeated-string/
    static long repeatedString() {

        //  long a = 10;

        long n = 561984209086L;
        String s = "ebcdddafdfeffaddbceddebafbbebebbbcefcbcdfbaabecfaaeeaaffdfccffbdeeaabcfeecfcecbfebacefebdfaeedadebdf";

        long nbAs = 0;

        for (char c : s.toCharArray()) {

            if (c == 'a') {

                nbAs++;

            }

        }

        long nbPaquets = n / s.length();
        long reste = n % s.length();

        int nbAsReste = 0;

        for (int i = 0; i < reste; i++) {

            if (s.charAt(i) == 'a') {

                nbAsReste++;

            }

        }

        return nbAs * nbPaquets + nbAsReste;

    }

    static int hourglassSum() {

        /*int[][] arr = {
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0}, 
                {0,0,2,4,4,0}, 
                {0,0,0,2,0,0}, 
                {0,0,1,2,4,0}
        };*/

        /*int[][] arr = {
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,9,2,-4,-4,0},
                {0,0,0,-2,0,0},
                {0,0,-1,-2,-4,0}
        };*/

        int[][] arr = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}
        };


        int highestHourglass = -100;

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = 0; j < arr.length - 2; j++) {

                if (arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2] > highestHourglass) {

                    highestHourglass = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                }


            }

        }

        return highestHourglass;
    }

    // https://www.hackerrank.com/challenges/ctci-array-left-rotation/
    static int[] rotLeft() {

        // Ici modulo utilisé pour ne pas sortir de la range du tableau (qui est de 5)

        int[] a = {1, 2, 3, 4, 5};
        int d = 4; // Nb rotation

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            result[i] = a[(i + d) % a.length];

        }

        return result;

        // Proposition originale qui ne fonctionne pas pour le TC 8/9 car trop long et non optimisé

        /*LinkedList<Integer> list = new LinkedList<>();

        for (int num : a){

            list.add(num);

        }

        for (int i = 0; i < d; i++) {

            Integer toTheEndOfList = list.pop();
            list.add(toTheEndOfList);
        }

        int result[] = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {

            result[i] = list.get(i);
        }*/


    }

    // https://www.youtube.com/watch?v=GJdiM-muYqc&list=WL&index=4&t=0s
    static char firstRecurringChar() {

        String s = "DFGEYRLQPND";

        // V1 avec HashMap

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {

            if (map.putIfAbsent(c, 1) != null) {

                System.out.println("V1 : First recurrent char : " + c);

                return c;

            }

        }

        // V2 Avec HashSet qui n'autorise pas d'élement dupliqué

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {

            if (set.add(c) == false) {

                System.out.println("V2 : First recurrent char : " + c);

                return c;
            }

        }

        return 'A';

    }

    // https://www.hackerrank.com/challenges/ctci-ransom-note/
    static void checkMagazine() {

        /*String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "today"};*/

        /*String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};*/

        String[] magazine = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        String[] note = {"ive", "got", "some", "coconuts"};


        Map<String, Integer> noteMap = new HashMap<>();
        Map<String, Integer> magazineMap = new HashMap<>();

        for (String s : note) {

            if (noteMap.containsKey(s)) {

                noteMap.put(s, noteMap.get(s) + 1);

            } else {

                noteMap.put(s, 1);
            }

        }

        for (String s : magazine) {

            if (magazineMap.containsKey(s)) {

                magazineMap.put(s, magazineMap.get(s) + 1);

            } else {

                magazineMap.put(s, 1);
            }

        }

        for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {

            if (!magazineMap.containsKey(entry.getKey()) || magazineMap.get(entry.getKey()) < entry.getValue()) {

                System.out.println("No");
                return;

            }

        }

        System.out.println("Yes");


    }

    // https://www.hackerrank.com/challenges/two-strings/
    static String twoStrings() {

        String s1 = "aardvark";
        String s2 = "apple";

        Set<Character> s1Set = new HashSet<>();

        for (char c : s1.toCharArray()) {

            s1Set.add(c);

        }

        for (char c : s2.toCharArray()) {

            if (s1Set.contains(c)) {

                return "YES";
            }

        }

        return "NO";

    }

    // https://www.hackerrank.com/challenges/ctci-bubble-sort/
    static void countSwaps() {

        int[] a = {3, 2, 1};
        int nbSwaps = 0;

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int oldValue = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = oldValue;
                    nbSwaps++;
                }
            }

        }

        System.out.println("Array is sorted in " + nbSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);

    }

    // https://www.hackerrank.com/challenges/mark-and-toys/
    static int maximumToys() {

        int[] prices = {1, 12, 5, 111, 200, 1000, 10};
        int k = 50;
        int nbToys = 0;

        Arrays.sort(prices);

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < k) {

                k = k - prices[i];
                nbToys++;
            }

        }

        System.out.println("Il peut acheter : " + nbToys);

        return 1;

    }

    // https://www.hackerrank.com/challenges/alternating-characters/
    static int alternatingCharacters() {

        String s = "AAABBBAABB";

        int nbDeletions = 0;

        for (int j = 0; j < s.length() - 1; j++) {

            if (s.charAt(j) == s.charAt(j + 1)) {

                nbDeletions++;
            }

        }

        System.out.println("Nb deletion : " + nbDeletions);

        return nbDeletions;


    }

    // https://www.hackerrank.com/challenges/ctci-making-anagrams/
    static int makeAnagram() {

        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        int nbDeletions = 0;

        int[] counterA = new int[26];
        int[] counterB = new int[26];

        for (char c : a.toCharArray()) {

            // Cast de la lettre acutelle vers son code ASCII puis on soustrait la valeur de 'a', première lettre alphanet pour obtenir sa position et son nombre dans le tableau des occurences
            int position = (int) c - 'a';
            counterA[position] = counterA[position] + 1;

        }

        for (char c : b.toCharArray()) {

            int position = (int) c - 'a';
            counterB[position] = counterB[position] + 1;

        }

        for (int i = 0; i < 26; i++) {

            nbDeletions += Math.abs(counterA[i] - counterB[i]);

        }

        System.out.println("Nb deletion : " + nbDeletions);

        return nbDeletions;

    }

    // https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/
    static int minimumAbsoluteDifference() {

        int[] arr = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        //int[] arr = {1, -3, 71, 68, 17};

        Arrays.sort(arr);

        int minimum = Math.abs(arr[0] - arr[1]);

        for (int i = 0; i < arr.length - 1; i++) {

            if (Math.abs(arr[i] - arr[i + 1]) < minimum) {

                minimum = Math.abs(arr[i] - arr[i + 1]);

            }

        }

        System.out.println("Le minimum est : " + minimum);

        return minimum;

    }

    // https://www.hackerrank.com/challenges/luck-balance/
    static int luckBalance() {

        int k = 3;
        int[][] contests = {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}};
        //int[][] contests = {{5, 1}, {1, 1}, {4, 0}};
        int luck = 0;


        Arrays.sort(contests, Comparator.comparingInt(a -> a[0]));

        System.out.println("Trié : " + Arrays.deepToString(contests));

        for (int i = contests.length-1; i >= 0; i--) {

           // for (int j = 0; j <= 1; j++) {

                if(contests[i][1] == 0){

                    luck += contests[i][0];

                } else if (contests[i][1] == 1 && k != 0){

                    luck += contests[i][0];
                    k--;

            } else  {

                    luck -= contests[i][0];

            }

         //   }

        }

        System.out.println("Chance accumulee : " + luck);

        return luck;

    }


    public static void main(String[] args) throws IOException {

        // int result = sockMerchant();
        // int result = countingValleys();
        // int result = jumpingOnClouds();
        // int result = equalizeArray();
        // long result = repeatedString();
        // int result = hourglassSum();
        // int[] result = rotLeft();
        // char result = firstRecurringChar();
        // checkMagazine();
        // System.out.println(twoStrings());
        // countSwaps();
        // int result = maximumToys();
        // int result = alternatingCharacters();
        // int result = makeAnagram();
        // int result = minimumAbsoluteDifference();
        int result = luckBalance();


    }

}