package P1_P50;

public class P40_container_with_most_water {

    public int maxArea(int[] height) {
        int l = height.length;
        if (l<2){
            return 0;
        }
        int front = 0;
        int end = l-1;
        int result = 0;
        while (front<end){
            int value = (height[front]<height[end]?height[front]:height[end])*(end-front);
            if (value >result){
                result = value;
            }
            if(height[front]<height[end]){
                front++;
            }
            else{
                end--;
            }
        }
        return result;
    }
}
