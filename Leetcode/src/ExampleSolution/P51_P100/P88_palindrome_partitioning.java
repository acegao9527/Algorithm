package ExampleSolution.P51_P100;

import java.util.ArrayList;

public class P88_palindrome_partitioning {

	public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> strSet = new ArrayList<String>();
        generatePartition(result, strSet, s, 0);
        return result;
    }
    public boolean isPalindrome(String s, int start, int end) {
        while (start<end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;end--;
        }
        return true;
    }
    public void generatePartition(ArrayList<ArrayList<String>> result, ArrayList<String> strSet, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(strSet));
            return;
        }
        if (start >s.length()) {
            return;
        }
        for (int i = start;i<s.length();i++){
            if (isPalindrome(s,start,i)) {
                strSet.add(s.substring(start,i+1));
                generatePartition(result, strSet, s, i+1);
                strSet.remove(strSet.size()-1);
            }
        }
    }
}
