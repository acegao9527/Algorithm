package TestSolution;

/**
 * Created by wuzhi1234 on 15/8/24.
 */
public class T45_PlusOne {
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int carry = 0, i = digits.length-1;
        digits[i]+=1;
        while(digits[i]>=10){
            digits[i]=0;
            i--;
            if(i>=0)
                digits[i]+=1;
            else {
                carry =1;
                break;
            }
        }
        if(carry ==0) return digits;
        int[] res = new int[digits.length+1];
        for(i=0; i<digits.length;i++){
            res[i+1] = digits[i];

        }
        res[0]=1;
        return res;
    }

    public static void main(String[] args) {
        T45_PlusOne t = new T45_PlusOne();
        int[] a = {9,9,9,9,9,9};
        int[] b = t.plusOne(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
