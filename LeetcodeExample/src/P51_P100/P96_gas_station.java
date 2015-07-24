package P51_P100;

public class P96_gas_station {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] remain = new int[len];
        for (int i = 0;i<len;i++){
            remain[i] = gas[i]-cost[i];
        }
        int totalRemain = 0, sum = 0,startIndex = 0;
        for (int i = 0;i<len;i++){
            totalRemain +=remain[i];
            sum+= remain[i];
            if (sum<0){
                sum = 0;
                startIndex = i+1;
            }
        }
        if (totalRemain>=0){
            return startIndex;
        }
        else {
            return -1;
        }
    }
}
