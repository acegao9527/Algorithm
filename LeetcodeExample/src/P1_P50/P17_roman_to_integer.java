package P1_P50;

public class P17_roman_to_integer {

	public int romanToInt(String s) {
        int n = s.length();
        int value = 0;
        for(int i=0;i<n;i++){
            switch (s.charAt(i))
            {
                case 'M':{
                    if (i!=0){
                        if (s.charAt(i-1)=='D'){
                            value += 0;
                            break;
                        }
                        if (s.charAt(i-1)=='C'){
                            value += 800;
                            break;
                        }
                    }
                    value +=1000;
                    break;
                }
                case 'D':{
                    if (i!=0){
                        if (s.charAt(i-1)=='C'){
                            value += 300;
                            break;
                        }
                    }
                    value +=500;
                    break;
                }
                case 'C':{
                    if (i!=0){
                        if (s.charAt(i-1)=='L'){
                            value += 0;
                            break;
                        }
                        if (s.charAt(i-1)=='X'){
                            value += 80;
                            break;
                        }
                    }
                    value +=100;
                    break;
                }
                case 'L':{
                    if (i!=0){
                        if (s.charAt(i-1)=='X'){
                            value += 30;
                            break;
                        }
                    }
                    value +=50;
                    break;
                }
                case 'X':{
                    if (i!=0){
                        if (s.charAt(i-1)=='V'){
                            value += 0;
                            break;
                        }
                        if (s.charAt(i-1)=='I'){
                            value += 8;
                            break;
                        }
                    }
                    value +=10;
                    break;
                }
                case 'V':{
                    if (i!=0){
                        if (s.charAt(i-1)=='I'){
                            value += 3;
                            break;
                        }
                    }
                    value +=5;
                    break;
                }
                case 'I':{
                    value+=1;
                }
            }
        }
        return value;
    }
}
