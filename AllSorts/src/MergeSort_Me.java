import java.util.Arrays;

/**
 * Created by wuzhi1234 on 15/8/24.
 */
public class MergeSort_Me {
    public int[] Sort(int[] nums,int low,int high){
        int mid = (high + low)/2;
        while (low<high){
            Sort(nums,low,mid);
            Sort(nums,mid+1,high);
            Merge(nums,low,mid,high);
        }
        return nums;
    }

    public int[] Merge(int[] nums,int low,int mid,int high){
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

        for (int l = 0; l < high - low; l++) {
            nums[l + low]=temp[l];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        MergeSort_Me m = new MergeSort_Me();
        m.Sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
