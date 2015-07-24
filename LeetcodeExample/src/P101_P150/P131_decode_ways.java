package P101_P150;

public class P131_decode_ways {

	public int numDecodings(String s) {
        if(s.length()==0)
            return 0;
        int[] ways = new int[s.length()+1];
        ways[0] = 1;
        if(checkValid(s.substring(0,1)))
            ways[1] = 1;
        else ways[1] = 0;
        for(int i=2;i<=s.length();i++){
            ways[i] = 0;
            if (checkValid(s.substring(i-1,i)))
                ways[i] += ways[i-1];
            if (checkValid(s.substring(i-2,i)))
                ways[i] += ways[i-2];
        }
        return ways[s.length()];
    }
    public boolean checkValid(String s){
        if (s.charAt(0)=='0')
            return false;
        int v = Integer.parseInt(s);
        if(v>=1&&v<=26)
            return true;
        return false;
    }

}
