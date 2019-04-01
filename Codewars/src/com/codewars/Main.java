package com.codewars;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    public static void main(String[] args) throws ParseException {
       ArrayList<Date> arr = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("HH:MM:SS");

       String a = "02:54:33";
       String b = "01:04:30";

       arr.add(format.parse(a));
       arr.add(format.parse(b));

       String lowest = format.format(Collections.min(arr));

       System.out.println(lowest);

    }

    public int solution(int number) {
        int sum = 0;

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {

                System.out.println(i + " est un multiple de 3 ou 5");

                sum += i;
            }
        }
        return sum;
    }

    public static int findEvenIndex(int[] arr) {

        // https://www.codewars.com/kata/514b92a657cdc65150000006

        for (int index = 0; index < arr.length; index++) {

            int right = 0;
            int left = 0;

            for (int i = 0; i < index; i++) {

                left += arr[i];

            }

            for (int i = index + 1; i < arr.length; i++) {

                right += arr[i];

            }

            if (left == right) {

                return index;

            }

        }

        return -1;

    }

    public static boolean validatePin(String pin) {

        // https://www.codewars.com/kata/55f8a9c06c018a0d6e000132

        if (pin.matches("(\\d{6})|(\\d{4})")) {
            return true;
        } else {
            return false;
        }
    }

    public static double findUniq(double arr[]) {

        // https://www.codewars.com/kata/585d7d5adb20cf33cb000235

        Arrays.sort(arr);

        if (arr[0] != arr[1] && arr[0] != arr[arr.length - 1]) {

            return arr[0];

        } else if (arr[1] != arr[0] && arr[1] != arr[arr.length - 1]) {

            return arr[1];

        } else if (arr[arr.length - 1] != arr[0] && arr[arr.length - 1] != arr[1]) {

            return arr[arr.length - 1];

        }

        return 0;
    }

    public static int bouncingBall(double h, double bounce, double window) {

        // https://www.codewars.com/kata/5544c7a5cb454edb3c000047

        int mamanVoitLaBalle = 0;

        if (h > 0 && (bounce > 0 && bounce < 1) && window < h) {

            mamanVoitLaBalle++;

            double ballHeight = h * bounce;

            while (ballHeight > window) {
                mamanVoitLaBalle++;
                ballHeight *= bounce;

            }
            return mamanVoitLaBalle * 2 - 1;
        }

        return -1;

    }


    public static boolean scramble(String str1, String str2) {

        // https://www.codewars.com/kata/scramblies/train/java

        Map<Character, Integer> firstStringOccurences = countOccurences(str1);
        Map<Character, Integer> secondStringOccurences = countOccurences(str2);

        int occurencesCorrect = 0;

        for (char key : firstStringOccurences.keySet()) {
            if (secondStringOccurences.containsKey(key)) {
                if (firstStringOccurences.get(key) >= (secondStringOccurences.get(key))) {
                    occurencesCorrect += secondStringOccurences.get(key);
                }
            }
        }

        return occurencesCorrect == str2.length() ? true : false;
    }

    public static Map<Character, Integer> countOccurences(String str) {

        // https://www.codewars.com/kata/scramblies/train/java

        char[] chars = str.toCharArray();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {

        // https://www.codewars.com/kata/the-supermarket-queue/train/java

        int[] sortedArray = Arrays.copyOfRange(customers, 0, n);
        Arrays.sort(sortedArray);

        for (int i = n; i < customers.length; i++) {
            sortedArray[0] += customers[i];
            Arrays.sort(sortedArray);
        }
        return Arrays.stream(sortedArray).max().getAsInt();
    }

    public static boolean isValid(char[] walk) {

        // https://www.codewars.com/kata/take-a-ten-minute-walk/train/java

        int walkValue = 0;

        if(walk.length != 10){
            return false;
        } else {

            for(char c : walk){

                if(c == 'n' || c == 'w'){

                    walkValue++;

                } else {

                    walkValue--;

                }

            }

            return walkValue == 0 ? true : false;

        }

    }

    public static String order(String words) {

        //https://www.codewars.com/kata/your-order-please/train/java

        if(words.isEmpty())
            return words;

        String[] wordsArray = words.split(" ");
        StringBuilder str = new StringBuilder();

        for(int i = 1; i < wordsArray.length + 1; i++){

            for (String word : wordsArray){

                if(word.contains(Integer.toString(i))){

                    str.append(word);
                    str.append(" ");

                }

            }


        }

        return str.toString().trim();

    }


    public static String[] dirReduc(String[] arr) {

        // https://www.codewars.com/kata/directions-reduction/train/java

        List<String> arrEdit = new ArrayList<>(Arrays.asList(arr));

            for (int i = 1; i < arrEdit.size(); i++) {

                if(("NORTH".equals(arrEdit.get(i)) && "SOUTH".equals(arrEdit.get(i-1))
                        || ("SOUTH".equals(arrEdit.get(i)) && "NORTH".equals(arrEdit.get(i-1)))
                        || "EAST".equals(arrEdit.get(i)) && "WEST".equals(arrEdit.get(i-1))
                        || ("WEST".equals(arrEdit.get(i)) && "EAST".equals(arrEdit.get(i-1))))){

                    arrEdit.remove(i);
                    arrEdit.remove(i-1);

                    i = 0;
                }
            }

        return arrEdit.toArray(new String[arrEdit.size()]);
    }

    public static Integer chooseBestSum(int maxDistance, int nbTownToVisit, List<Integer> distances) {
        // https://www.codewars.com/kata/best-travel/train/java

        int currentIterValue = 0;
        int maxValue = 0;

        for (int i = 0; i < distances.size(); i++) {

            currentIterValue += distances.get(i);

            for (int j = i + 1; j < i + nbTownToVisit; j++) {

                currentIterValue += distances.get(j);

            }

            if(currentIterValue > maxValue && currentIterValue <= maxDistance){

                maxValue = currentIterValue;

            } else {

                currentIterValue = 0;
            }

        }

        return maxValue;
    }

}