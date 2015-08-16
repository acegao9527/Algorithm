package ExampleSolution.P51_P100;

public class P71_longest_common_prefix {

	public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n==0){
            return "";
        }
        if(n==1){
            return strs[0];
        }
        if(strs[0] == ""){
            return "";
        }
        int i;
        for (i = 0;i<strs[0].length();i++){
            for (int j = 1;j<n;j++){
                if(strs[j]==""){
                    return "";
                }
                if(i>=strs[j].length()){
                    return strs[0].substring(0,i);
                }
                if (strs[j].charAt(i)!=strs[0].charAt(i)){
                    if (i==0)
                        return "";
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,i);
    }
}
