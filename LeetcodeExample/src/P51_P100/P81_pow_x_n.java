package P51_P100;

public class P81_pow_x_n {

	public double pow(double x, int n) {
        double result = 1;
        if (n>1||n<-1){
            result = pow(x*x,n/2);
            if(n%2 == 1){
                result *=x;
            }
            else if(n%2 == -1){
                result /=x;
            }
        }
        else if (n==1){
            return x;
        }
        else if (n==-1){
            return 1/x;
        }
        return result;
    }
}
