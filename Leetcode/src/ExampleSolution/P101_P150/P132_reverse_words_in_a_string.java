package ExampleSolution.P101_P150;

public class P132_reverse_words_in_a_string {

	public String reverseWords(String s) {
        s = s.trim();
        String word = "";
        String ret = "";
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) == ' '){
                if(word != "") {
                    ret += word +" ";
                    word = "";
                }
            }
            else
                word = s.charAt(i)+word;
        }
        if(word != "") {
            ret += word +" ";
        }
        return (ret !=""?ret.substring(0,ret.length()-1):"");
    }
}
