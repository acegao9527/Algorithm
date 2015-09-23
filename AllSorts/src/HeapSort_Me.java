/**
 * Created by wuzhi1234 on 15/9/23.
 */
public class HeapSort_Me {

    public static void swap(int[] data,int i,int j){
        if (i==j){
            return;
        }
        data[i]=data[i]+data[j];
        data[j]=data[i]-data[j];
        data[i]=data[i]-data[j];
    }

    public static void createMaxheap(int[] data,int lastindex){
        for (int i = (lastindex-1)/2; i >=0 ; i--) {
            int k =i;
            while (2*k+1<=lastindex){
                int biggerindex = 2*k+1;
                if (biggerindex<lastindex){
                    if (data[biggerindex]<data[biggerindex+1]){
                        biggerindex=biggerindex+1;
                    }
                }
                if (data[k]<data[biggerindex]){
                    swap(data,k,biggerindex);
                }else {
                    break;
                }
            }
        }
    }

    public static void heapsort(int[] data){
        for (int i =0; i <data.length ; i++) {
            createMaxheap(data,data.length-1-i);
            swap(data,0,data.length-1-i);
            print(data);
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data5);
        heapsort(data5);
        System.out.println("排序后的数组：");
        print(data5);
    }

}
