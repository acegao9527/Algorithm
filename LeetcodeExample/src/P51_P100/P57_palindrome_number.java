package P51_P100;

public class P57_palindrome_number {

	public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        int highest = (int)Math.pow(10,(int)Math.log10(x));
        while(x>0){
            if (x/highest!=x%10){
                return false;
            }
            x-=x%10*highest;
            x/=10;
            highest/=100;
        }
        return true;
    }
}
