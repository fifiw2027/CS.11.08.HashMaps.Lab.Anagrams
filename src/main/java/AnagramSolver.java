import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

public class AnagramSolver {

    private AnagramSolver() {
    }

    private static ArrayList<String> readFile(String filename) throws FileNotFoundException {
        File myFile = new File(filename);
        Scanner myScanner = new Scanner(myFile);
        ArrayList<String> words = new ArrayList<>();

        while (myScanner.hasNextLine()) {
            String word = myScanner.nextLine();
            words.add(word);
        }

        myScanner.close();

        return words;
    }

    public static String bubbleSort(String string) {
        String sorted = "";
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            temp.add(string.charAt(i));
        }
        Collections.sort(temp);
        for (int i = 0; i < temp.size(); i++) {
            sorted += temp.get(i);
        }
        return String.valueOf(sorted);
    }

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     *
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) throws FileNotFoundException {
        ArrayList<String> words = readFile(filename);
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();
        String key;
        ArrayList<String> curr_set;

        for (String w: words) {
            key = bubbleSort(w);
            curr_set = anagrams.get(key);
            if (curr_set == null) {
                curr_set = new ArrayList<>();
            }

            curr_set.add(w);
            anagrams.put(key, curr_set);
        }

        return anagrams;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     *
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> result = new ArrayList<>();
        int max = 0;
        for (ArrayList<String> i : anagrams.values()) {
            if(i.size() > max){
                max = i.size();
                result = i;
            }
        }
        return result;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> value;
        for (String key: anagrams.keySet()) {
            value = anagrams.get(key);
            System.out.print(key + ": ");
            System.out.println(value);
        }
    }

}