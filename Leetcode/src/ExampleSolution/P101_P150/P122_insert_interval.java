package ExampleSolution.P101_P150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P122_insert_interval {

	public class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2){
                if (o1.start>o2.start)
                    return 1;
                if (o1.start<o2.start)
                    return -1;
                return 0;
            }
        });
        int index = 0;
        boolean found = false;
        boolean inserted = false;
        int start = 0;
        while (index<intervals.size()){
            Interval check = intervals.get(index);
            if (inserted) {
                result.add(check);
                index++;
            }
            else if (!found){
                if (check.end<newInterval.start){
                    result.add(check);
                    index++;
                }
                else if (check.start >newInterval.end) {
                    result.add(newInterval);
                    result.add(check);
                    inserted = true;
                    index++;
                }
                else {
                    found = true;
                    start = Math.min(check.start,newInterval.start);
                    if (check.end>=newInterval.end) {
                        inserted = true;
                        result.add(new Interval(start,check.end));
                    }
                    index++;
                }
            }
            else {
                if (newInterval.end<check.start){
                    inserted = true;
                    result.add(new Interval(start,newInterval.end));
                    result.add(check);
                    index++;
                }
                else if (newInterval.end>check.end) {
                    index++;
                }
                else {
                    inserted = true;
                    result.add(new Interval(start,check.end));
                    index++;
                }
            }
        }
        if(!inserted)
            if (!found)
                result.add(newInterval);
            else {
                result.add(new Interval(start,newInterval.end));
            }
        return result;
    }
}
