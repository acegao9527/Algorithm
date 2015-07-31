/**
 * Created by wuzhi1234 on 15/7/31.
 */
/*选择排序也是比较简单的一种排序方法，原理也比较容易理解，它与冒泡排序的比较次数相同，
但选择排序的交换次数少于冒泡排序。冒泡排序是在每次比较之后，若比较的两个元素顺序与待排序顺序相反，
则要进行交换，而选择排序在每次遍历过程中只记录下来最小的一个元素的下标，待全部比较结束之后，
将最小的元素与未排序的那部分序列的最前面一个元素交换，这样就降低了交换的次数，提高了排序效率。
*/
public class ChoseSort {
    //constructor without parameters
    public ChoseSort(){};

    //constructor with parameters
    public int[] ChoseSort(int[] intArr){
        for(int i=0;i<intArr.length;i++){
            //lowIndex用来指向当前循环找到的最小值
            int lowIndex = i;
            //将所有值与lowIndex索引上的值比较，更小就将lowIndex指向更小值的位置
            for(int j=i+1;j<intArr.length;j++){
                if(intArr[j]<intArr[lowIndex]){
                    lowIndex = j;
                }
            }

            //将未排序的第一个与它后面序列中的最小的一个 元素交换，也就是将最小的元素放在最前端
            int temp = intArr[i];
            intArr[i] = intArr[lowIndex];
            intArr[lowIndex] = temp;
        }

        return intArr;
    }

    public static void main(String[] args) {
        ChoseSort choseSort = new ChoseSort();
        int[] intArr = {5,6,9,2,4,3,8};
        int[] intArrAfterSort = choseSort.ChoseSort(intArr);
        for(int arrItem:intArrAfterSort){
            System.out.print(arrItem+" ");
        }
    }
}