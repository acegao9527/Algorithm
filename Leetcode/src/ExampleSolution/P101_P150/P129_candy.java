package ExampleSolution.P101_P150;


public class P129_candy {

	public int candy(int[] ratings) {
        int len = ratings.length;
        if (len==0)
            return 0;
        int[] candys = new int [len];
        for(int i =0;i<len;i++)
            candys[i]=1;
        for(int i =1;i<len;i++)
            if(ratings[i]>ratings[i-1])
                candys[i] = candys[i-1]+1;
        for(int i=len-2;i>=0;i--)
            if(ratings[i]>ratings[i+1]&&candys[i]<=candys[i+1])
                candys[i] = candys[i+1]+1;
        int result = 0;
        for(int i =0;i<len;i++)
            result+=candys[i];
        return result;
    }

}
