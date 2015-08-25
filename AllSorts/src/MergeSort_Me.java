import java.util.Arrays;

/**
 * Created by wuzhi1234 on 15/8/24.
 */
public class MergeSort_Me {

    public static int[] sort(int[] nums,int low,int high){
        int mid = (high + low)/2;
        if (low<high){
            sort(nums,low,mid);
            sort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
        return nums;
    }


    public static void merge(int[] nums,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i<=mid && j<=high){
            if (nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }
        while (i<=mid){
            temp[k++]=nums[i++];
        }

        while (j<=high){
            temp[k++]=nums[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            nums[l + low]=temp[l];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        MergeSort_Me.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
