package TestSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuzhi1234 on 15/8/16.
 */
public class T10_TwoSumIII {
    private Map<Integer,Integer> table = new HashMap<>();
    public void add(int input){
        int count = table.containsKey(input)?table.get(input):0;
        table.put(input,count+1);
    }
    public boolean find(int value){
        for (Map.Entry<Integer,Integer> entry : table.entrySet()){
            int num = entry.getKey();
            int y = value - num;
            if(y==num){
                if (entry.getValue()>=2)
                    return true;
            }else if (table.containsKey(y)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T10_TwoSumIII t = new T10_TwoSumIII();
        t.add(1);
        t.add(4);
        t.add(4);
        t.add(6);
        boolean a = t.find(11);
        System.out.println(a);

    }
}
