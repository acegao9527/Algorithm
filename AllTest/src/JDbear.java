/**
 * Created by wuzhi1234 on 15/9/18.
 */
public class JDbear {
    public int last(int N){
        int x=1;
        while (true){
            for (int j = 0; j < N; j++) {
                if (x%N==1){
                    x=x-x/N-1;
                    continue;
                }  else {
                    x++;
                }
            }
        }
    }
}
