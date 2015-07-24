package P1_P50;

public class P45_plus_one {

    public int[] plusOne(int[] digits) {
        int i = digits.length;
        if(i==0){
            return digits;
        }
        boolean inc =true;
        for (;i>0;i--){
            if (digits[i-1]==9&&inc){
                digits[i-1] = 0;
            }
            else if (inc){
                digits[i-1]++;
                inc = false;
                return digits;
            }
            else {
                return digits;
            }
        }
        if(i==0&&inc){
            int []result = new int[digits.length+1];
            result[0] = 1;
            for (int j=0;j<digits.length;j++){
                result[j+1] = digits[j];
            }
            return result;
        }
        return digits;
    }
}
