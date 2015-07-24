package P101_P150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class P102_anagrams_IMP {

	public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for (int i=0;i<strs.length;i++){
            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if(map.containsKey(sorted)){
                map.get(sorted).add(strs[i]);
            }
            else {
            	ArrayList<String> mapArray = new ArrayList<String>();
            	mapArray.add(strs[i]);
            	map.put(sorted, mapArray);
            }
        }
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
        	String key = iter.next();
        	ArrayList<String> mapArray = map.get(key);
        	if(mapArray.size()>1){
        		for (String s : mapArray){
        			result.add(s);
        		}
        	}
        }
        return result;
    }
}
