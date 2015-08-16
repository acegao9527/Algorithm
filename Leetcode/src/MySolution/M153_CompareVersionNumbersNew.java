package MySolution;

/**
 * Created by wuzhi1234 on 15/7/30.
 */
public class M153_CompareVersionNumbersNew {
    public int compareVersion(String version1,String version2){
        if (version1==null || version2 ==null) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int l1 = v1.length;
        int l2 = v2.length;

        int i = 0;

        while (i<l1 || i<l2){
            int x1=i<l1 ? Integer.parseInt(v1[i]) : 0;
            int x2=i<l2 ? Integer.parseInt(v2[i]) : 0;
            if (x1>x2) return 1;
            if (x1<x2) return -1;
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        M153_CompareVersionNumbersNew m = new M153_CompareVersionNumbersNew();
        int a =m.compareVersion("1.1.2","1.3.4");
        System.out.println(a);
    }
}
