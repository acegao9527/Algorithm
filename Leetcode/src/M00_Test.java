/**
 * Created by wuzhi1234 on 15/7/29.
 */
public class M00_Test {
    public static void main(String[] args) {
        String version1 = "1.0";
        String[] v1 = version1.split("\\.");
        for (int i = 0; i <v1.length ; i++) {
            System.out.println(v1[i]);
        }
        if (version1.contains(".")){
            System.out.println("exist point");
        }
//        if (version1.contains(".") && version2.contains(".")) {
//
//            if (Integer.parseInt(v1[0]) == Integer.parseInt(v2[0])){
//                System.out.println("0");
//            }
//        }
    }
}
