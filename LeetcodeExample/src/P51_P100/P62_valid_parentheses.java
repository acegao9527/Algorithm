package P51_P100;

import java.util.Stack;

public class P62_valid_parentheses {

	public boolean isValid(String s) {
        Stack<Character> text = new Stack<Character>();
        int n = s.length();
        for (int i=0;i<n;i++){
            char temp = s.charAt(i);
            if(text.size()==0){
                text.push(temp);
            }
            else if (temp==')'||temp==']'||temp=='}'){
                switch (text.pop()){
                    case '(':
                        if (temp!=')')
                            return false;
                        break;
                    case '[':
                        if (temp!=']')
                            return false;
                        break;
                    case '{':
                        if (temp!='}')
                            return false;
                }
            }
            else {
                text.push(temp);
            }
        }
        if(text.size()!=0){
            return false;
        }
        return true;
    }
}
