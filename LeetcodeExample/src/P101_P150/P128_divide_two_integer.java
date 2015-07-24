package P101_P150;

public class P128_divide_two_integer {

	public int divide(int dividend, int divisor) {
        boolean positive = true;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0))
            positive = false;
        long did,dis;
        did = dividend>=0?(long)dividend:-(long)dividend;
        dis = divisor>=0?(long)divisor:-(long)divisor;
        int result = generateDivide(did,dis);
        return positive? result:-result;
    }
    public int generateDivide(long did, long dis) {
        if (did<dis)
            return 0;
        long tempDis = dis;
        int digit = 0;
        while ((tempDis<<1)<=did){
            tempDis = tempDis<<1;
            digit++;
        }
        return (1<<digit)+generateDivide(did-tempDis,dis);
    }
}
