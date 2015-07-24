/*求一个串中出现的第一个最长重复子串
采用顺序结构存储串，编写一个程序，求串s中出现的第一个最长重复子串的下标和长度。*/
import java.util.Arrays;   
import java.util.Collections;   
import java.util.List;   
  
  
public class MaxPrefix {   
  
       
    public static void main(String[] args) {   
        String str="abbdabcdabc";   
        //String str="ababa";   
        MaxPrefix mp=new MaxPrefix();   
        mp.findMaxPrefix2(str);   
    }   
       
    /*  
     * 1.find a[j]=a[i].(i<j)  
     * 2.k=i.(k++,j++)until a[k]!=a[j].count the length;if count>prefixLen,prefixLen=count. update the startIndex.  
     * 3.next i  
     */  
    public void findMaxPrefix(String str){   
        char[] chars=str.toCharArray();   
        int len=str.length();   
        int startIndex=0;   
        int prefixLen=0;   
        boolean found=false;   
        for(int i=0;i<len;i++){   
            int j=i+1;   
            for(;j<len;j++){   
                if(chars[j]==chars[i]){   //如果在i之后找到与他相同的一个字母，就去比较接下来的字母，则置found为true
                    found=true;   // 这里真的没问题么？如果在这个相同字母之后又出现这个字母呢
                    break;   
                }   
            }   
            if(found){   //在每次出现首字母相同的时候，就去比较他们接下来的字母，直到比到出现不相同的值
                int count=0;   
                int k=i;   
                while(k<len&&j<len&&chars[k]==chars[j]){   
                    k++;   
                    j++;   
                    count++;   
                }   
                if(count>prefixLen){   
                    startIndex=k-count;   
                    prefixLen=count;   
                }   
            }   
        }   
        if(prefixLen!=0){   
            System.out.println(prefixLen+",startIndex="+startIndex);   
            for(int i=0;i<prefixLen;i++){   
                System.out.print(chars[startIndex+i]);   
            }   
        }else{   
            System.out.println("no duplicate char ");   
        }   
    }   
       
    /*  
     * 使用后缀数组，具体思路参见http://blog.csdn.net/iamskying/article/details/4759485  
     * 不过  
     * 1.这个思路在生成后缀数组时，用“暴力”生成：先取最后1个元素，然后取最后2个元素、最后3个元素...  
     * 据说可以通过倍增算法和DC3算法，不过没研究过...  
     * 2.下面这个结论我不明白，后缀数组的原理还没研究过-->  
     * “将所有后缀数组按字典顺序排序后，两个相邻位置的后缀数组比较，取其最长公共前缀，即为所求字符串s的最长可重叠重复子串”  
     */  
    public void findMaxPrefix2(String str){   
        String[] suffixArray=generateSuffixArray(str);   
        //string sort   
        List<String> list = (List<String>) Arrays.asList(suffixArray);   
        Collections.sort(list);   
           
        //两个相邻位置的后缀数组比较，取其最长公共前缀   
        //int startIndex=0;//只有第一个字符相同时，才有“公共前缀”   
        int prefixLen=-1;   
        int index=-1;   
        for(int i=0,len=suffixArray.length;i<len-1;i++){   
            char[] str1=suffixArray[i].toCharArray();   
            char[] str2=suffixArray[i+1].toCharArray();   
            int k1=0,k2=0;   
            int len1=str1.length,len2=str2.length;   
            int count=0;   
            if(str1[0]==str2[0]){//只有第一个字符相同时，才有“公共前缀”   
                while(k1<len1&&k2<len2&&str1[k1]==str2[k2]){   
                    k1++;   
                    k2++;   
                    count++;   
                }   
                if(count>prefixLen){   
                    prefixLen=count;   
                    index=i;   
                }   
            }   
        }   
        if(index!=-1){   
            String str3=suffixArray[index];   
            System.out.println("max SubString is "+str3.substring(0,prefixLen));   
        }else{   
            System.out.println("no duplicate char ");   
        }   
           
    }   
    public String[] generateSuffixArray(String str){   
        int len=str.length();   
        String[] suffixArray=new String[len];   
        for(int i=0;i<len;i++){   
            int endIndex=len;   
            int beginIndex=len-1-i;   
            suffixArray[i]=str.substring(beginIndex, endIndex);   
        }   
        return suffixArray;   
    }   
}  
