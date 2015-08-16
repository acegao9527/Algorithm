package ExampleSolution.P101_P150;

import java.util.Set;

public class P124_word_break {
	public boolean wordBreak(String s, Set<String> dict) {
        if(s==null){
            return true;
        }
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        for (int i=1;i<s.length()+1;i++){
            result[i] = false;
        }
        for (int i=0;i<s.length();i++){
            if (result[i])
                for(int j=i+1;j<=s.length();j++){
                    if (dict.contains(s.substring(i,j)))
                        result[j] =true;
                }
        }
        return result[s.length()];
    }
}