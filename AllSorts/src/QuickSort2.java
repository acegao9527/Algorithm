/**
 * Created by wuzhi1234 on 15/8/1.
 */
/*
1.快速排序 对冒泡排序的一种改进，若初始记录序列按关键字有序或基本有序，蜕化为冒泡排序。
  使用的是递归原理，在所有同数量级O(n longn) 的排序方法中，其平均性能最好。
  就平均时间而言，是目前被认为最好的一种内部排序方法
2.基本思想是：通过一躺排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
  然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
3.三个指针: 第一个指针称为pivotkey指针（枢轴），第二个指针和第三个指针分别为left指针和right指针，
  分别指向最左边的值和最右边的值。left指针和right指针从两边同时向中间逼近，
  在逼近的过程中不停的与枢轴比较，将比枢轴小的元素移到低端，将比枢轴大的元素移到高端，
  枢轴选定后永远不变，最终在中间，前小后大。
需要两个函数：
① 递归函数  public static void quickSort(int[]n ,int left,int right)
② 分割函数（一趟快速排序函数） public static int partition(int[]n ,int left,int right)
*/

public class QuickSort2 {
    public static void main(String[] args) {
        int [] array = {49,38,65,97,76,13,27};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    /*先按照数组为数据原型写出算法，再写出扩展性算法。数组{49,38,65,97,76,13,27}
     * */
    public static void quickSort(int[]n ,int left,int right){
        int pivot;
        if (left < right) {
            //pivot作为枢轴，较之小的元素在左，较之大的元素在右
            pivot = partition(n, left, right);
            //对左右数组递归调用快速排序，直到顺序完全正确
            quickSort(n, left, pivot - 1);
            quickSort(n, pivot + 1, right);
        }
    }

    public static int partition(int[]n ,int left,int right){
        int pivotkey = n[left];
        //枢轴选定后永远不变，最终在中间，前小后大
        while (left < right) {
            while (left < right && n[right] >= pivotkey) --right;
            //将比枢轴小的元素移到低端，此时right位相当于空，等待低位比pivotkey大的数补上
            n[left] = n[right];
            while (left < right && n[left] <= pivotkey) ++left;
            //将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivotkey小的数补上
            n[right] = n[left];
        }
        //当left == right，完成一趟快速排序，此时left位相当于空，等待pivotkey补上
        n[left] = pivotkey;
        return left;
    }
}
