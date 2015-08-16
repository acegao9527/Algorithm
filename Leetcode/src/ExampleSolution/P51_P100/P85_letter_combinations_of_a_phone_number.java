package ExampleSolution.P51_P100;

import java.util.ArrayList;

public class P85_letter_combinations_of_a_phone_number {

	public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits.length() ==0) {
            result.add("");
            return result;
        }
        String []dictionary = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index = digits.charAt(0) -'0';
        ArrayList<String> subResult = letterCombinations(digits.substring(1,digits.length()));
        for (int i = 0;i<subResult.size();i++){
            for (int j = 0;j<dictionary[index].length();j++){
                String temp = "";
                temp += dictionary[index].charAt(j);
                temp += subResult.get(i);
                result.add(temp);
            }
        }
        return result;
    }
}
