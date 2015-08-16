package ExampleSolution.P51_P100;

public class P100_longest_substring_without_repeating_characters {

	public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int [] letters = new int[26];
        for (int i = 0;i<26;i++){
            letters[i] = -1;
        }
        int length = 0;
        int maxlength = 0;
        for (int i=0;i<len;i++){
            int num = s.charAt(i)-'a';
            if (letters[num] !=-1){
                if(length>maxlength){
                    maxlength = length;
                }
                for (int j = i-length;j<letters[num];j++){
                    letters[s.charAt(j)-'a'] = -1;
                }
                length = i-letters[num];
                letters[num] = i;
            }
            else{
                letters[num] = i;
                length++;
            }
        }
        return Math.max(maxlength,length);
    }
	
}
