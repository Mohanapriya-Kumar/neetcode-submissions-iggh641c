class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totCost = 0, totGas = 0;
        int start = 0, tank = 0;
        for(int i = 0; i < gas.length; i++){
            totCost += cost[i];
            totGas += gas[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        if(totCost > totGas) return -1;
        return start;
    }
}
