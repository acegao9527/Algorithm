package P101_P150;

public class P111_sqrt {

	public int sqrt(int x) {
        if (x<=0)
            return 0;
        if (x <4){
            return 1;
        }
        int start = 1,end = x/2;
        while(start<=end){
            long mid = (start+end)/2;
            if (mid*mid == x)
                return (int)mid;
            else if (mid*mid>x){
                end = (int)mid-1;
            }
            else {
                start = (int)mid+1;
            }
        }
        return (start+end)/2;
    }
}
