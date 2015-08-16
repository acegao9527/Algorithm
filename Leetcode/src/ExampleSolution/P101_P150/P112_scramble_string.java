package ExampleSolution.P101_P150;

public class P112_scramble_string {

	public boolean isScramble(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (s1.equals(s2)||l1!=l2)
            return false;
        if (l1==2&&s1.charAt(0)==s2.charAt(1)&&s1.charAt(1)==s2.charAt(0)){
            return true;
        }
        for (int i =1;i<l1;i++) {
            String sub1_1 = s1.substring(0,i);
            String sub1_2 = s1.substring(i,l1);
            String sub2_1 = s2.substring(0,i);
            String sub2_2 = s2.substring(i,l1);
            if((sub1_1.equals(sub2_1)||isScramble(sub1_1,sub2_1))&&
                (sub1_2.equals(sub2_2)||isScramble(sub1_2,sub2_2)))
                return true;
        }
        return false;
    }
}
