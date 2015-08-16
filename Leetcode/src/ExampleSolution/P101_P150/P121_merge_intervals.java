package ExampleSolution.P101_P150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P121_merge_intervals {

	public class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval obj1, Interval obj2) {
                    if (obj1.start>obj2.start)
                        return 1;
                    if (obj1.start<obj2.start)
                        return -1;
                    return 0;
            }});
        int index = 0;
        while (index<intervals.size()){
            int start = intervals.get(index).start;
            int end = intervals.get(index).end;
            int j = index+1;
            while (j<intervals.size()&&intervals.get(j).start<=end){
                end = Math.max(end,intervals.get(j).end);
                j++;
            }
            result.add(new Interval(start,end));
            index = j;
        }
        return result;
    }
}
