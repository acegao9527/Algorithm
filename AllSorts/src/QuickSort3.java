import java.util.Arrays;

/**
 * Created by wuzhi1234 on 15/8/24.
 */
public class QuickSort3 {
    /**
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     * 时间复杂度为O(nlog n)
     * 不稳定排序方式
     *
     * @param nums 待排序数组
     * @return 输出有序数组
     */
    public static int[] sort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);
            //左边
            sort(nums, low, mid - 1);
            //右边
            sort(nums, mid + 1, high);
        }
        return nums;
    }

    public static int partition(int[] nums, int low, int high) {
        int key = nums[low];//基准数
        int i = low;//左指针
        int j = high;//右指针

        if (low < high) {
            while (i < j) {
                //形象点可以理解为,右指针左移
                while (i < j && nums[j] >= key) {
                    j--;
                }

                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                //形象点可以理解为,左指针右移
                while (i < j && nums[i] <= key) {
                    i++;
                }

                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }

            //把key填入最后的位置,即基准数位
            nums[i] = key;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};

        QuickSort3.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
