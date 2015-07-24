package P51_P100;

public class P61_length_of_last_word {

	public int lengthOfLastWord(String s) {
        int n = s.length();
        if (n==0){
            return 0;
        }
        int result = 0;
        for (int i=n-1;i>=0;i--){
            if(s.charAt(i)==' '&&result!=0){
                break;
            }
            else if(s.charAt(i)!=' '){
                result++;
            }
        }
        return result;
    }
}
