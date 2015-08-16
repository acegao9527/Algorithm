package ExampleSolution.P101_P150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P134_word_ladder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.length()!=end.length())
            return 0;
        if(start.length()==0)
            return 0;
        int distance = 1;
        Queue<String> cur = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        cur.offer(start);
        while(cur.size()!=0&&dict.size()>0) {
            while(cur.size()!=0){
                String check = cur.poll();
                if(check.length()>0){
                    char[] chr = check.toCharArray();
                    for (int i =0;i<check.length();i++){
                        for (char c ='a';c<='z';c++){
                            char temp = chr[i];
                            chr[i] = c;
                            String newW = new String(chr);
                            if (dict.contains(newW)){
                        	    next.offer(newW);
                        	    dict.remove(newW);
                            }
                            if(newW.equals(end)){
                        	    return distance+1;
                            }
                            chr[i] = temp;
                        }
                    }
                }
            }
            cur.addAll(next);
            next.clear();
            distance++;
        }
        return 0;
    }

}
