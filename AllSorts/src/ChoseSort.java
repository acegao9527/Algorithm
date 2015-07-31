/**
 * Created by wuzhi1234 on 15/7/31.
 */
public class ChoseSort {
    //constructor without parameters
    public ChoseSort(){};

    //constructor with parameters
    public int[] ChoseSort(int[] intArr){
        for(int i=0;i<intArr.length;i++){
            int lowIndex = i;

            for(int j=i+1;j<intArr.length;j++){
                if(intArr[j]<intArr[lowIndex]){
                    lowIndex = j;
                }
            }

            //将当前第一个元素与它后面序列中的最小的一个 元素交换，也就是将最小的元素放在最前端
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