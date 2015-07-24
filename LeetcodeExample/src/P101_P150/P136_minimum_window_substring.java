package P101_P150;

public class P136_minimum_window_substring {

	public String minWindow(String S, String T) {
        if(T==""||S.length()<T.length())
            return "";
        int[] hasChar = new int[256];
        int[] appChar = new int[256];
        String ret = "";
        int appCount = 0;
        int min = S.length()+1;
        int start = 0;
        for(int i = 0; i<26;i++) {
            hasChar[i]=0;
            appChar[i] = 0;
        }
        for(int i = 0 ;i<T.length();i++) {
            hasChar[(int)(T.charAt(i))]++;
        }
        for(int i = 0;i<S.length();i++) {
            int val = (int)(S.charAt(i));
            if(hasChar[val]>0){
                appChar[val]++;
                if(appChar[val]<=hasChar[val])
                    appCount++;
            }
            if(appCount==T.length()){
                for(int j=start;j<=i;j++) {
                    int val1 = (int)(S.charAt(j));
                    if(hasChar[val1]>0){
                        appChar[val1]--;
                        if(appChar[val1]<hasChar[val1]){
                            appCount--;
                            start = j+1;
                            if(min>i-j+1){
                                ret = S.substring(j,i+1);
                                min = i-j+1;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

}
