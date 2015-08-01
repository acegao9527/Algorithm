/**
 * Created by wuzhi1234 on 15/7/24.
 */
/*url:  http://blog.csdn.net/morewindows/article/details/6684558
对挖坑填数进行总结

1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。

2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。

3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。

4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。*/
//快速排序
public class QuickSort {
    public static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                // 从右向左找第一个小于x的数
                while(i < j && s[j] >= x)
                    j--;
                //判断到底是因为什么原因跳出循环
                if(i < j)
                    //i位置已经被暂存了，现在填进s[j]
                    s[i++] = s[j];
                // 从左向右找第一个大于等于x的数
                while(i < j && s[i] < x)
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
    public static void main(String[] args) {
        int quick[]={3,5,8,4,0,3,7,8};
        quick_sort(quick,0,7);
        //System.out.println(Arrays.asList(quick));
        // 这种方法也是可以输出字符串数组可能比较方便，需在在之前导入import java.util.Arrays;
        for(int i=0;i<quick.length;i++){
            System.out.println(quick[i]);
        }
    }
}
