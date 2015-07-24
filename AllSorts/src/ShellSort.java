/**
 * Created by wuzhi1234 on 15/7/24.
 */
/*
基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，
即所有记录放在同一组中进行直接插入排序为止。

希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强
 版的插入排序
 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
*/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{44,33,99,10,30,20,59,78,23,48};
        System.out.print("排序前：");
        for(int o: arr) {
            System.out.print(o+" ");
        }
        System.out.println();
        shellSort(arr);
        System.out.print("排序后：");
        for(int o: arr) {
            System.out.print(o+" ");
        }
        System.out.println();
    }
    private static void shellSort(int[] arr) {

        int j;
        int len = arr.length;
        //选定分组的间隔，依次按照每次的间隔进行分组，只比插入排序多这个步骤
        for(int val=len/2; val>0; val/=2) {
            //下面是对本次的所有分组做直接插入排序，对于val个组挨个和他之前间隔为val的数作比较
            for(int i=val; i<len; i++) {
                int temp = arr[i];
                /*
                 * 为什么每次都用temp比较呢？
                 * 因为直接插入就是找到temp的合适位置。
                 * temp是为了存储当前想要找到它合适位置的数值
                 * 为什么temp<arr[j-val]这个条件可以放在for内呢？
                 * 因为原来的组内数据已经有序，找到位置就停止便是。
                 * 不甚理解的去看直接插入排序吧。
                 */
                //插入排序的核心步骤
                for(j=i; j>=val&&temp<arr[j-val]; j-=val) {
                    /*
                     * 为什么是arr[j-val]不是arr[j]呢？
                     * 因为j=i开始的，而且条件是j>=val&&temp<arr[j-val]
                     */
                    arr[j] = arr[j-val];
                }
                /*
                 * 注意不是arr[i] = temp
                 * 直接插入排序也是这样的。
                 * 为什么呢？
                 * 因为j是位置，i是待插入元素
                 */
                arr[j] = temp;
            }
        }
    }
}
