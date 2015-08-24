package MySolution;

/**
 * Created by wuzhi1234 on 15/8/24.
 */
/*Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.*/
public class M45_PlusOne {
    public int[] plusOne(int[] digits){
        int carry = 0;
        int i = digits.length-1;
        digits[i]+=1;
        while (digits[i]>=10){
            digits[i]=0;
            i--;
            if (i>=0){
                digits[i]+=1;
            }else {
                carry=1;
                break;
            }
        }
        if (carry==0){return digits;}
        int[] res = new int[digits.length+1];
        for (int j = 0; j < digits.length - 1; j++) {
            res[j+1]=digits[j];
        }
        res[0]=1;
        return res;
    }

    public static void main(String[] args) {
        M45_PlusOne m = new M45_PlusOne();
        int[] a = {9,9,9,9,9};
        int[] b = m.plusOne(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
