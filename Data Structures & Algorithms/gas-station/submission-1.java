class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totcost = 0, totgas = 0;
        int start = 0, tank = 0;
        for(int i = 0; i < gas.length; i++){
            totcost += cost[i];
            totgas += gas[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                start = i + 1;
            }
        }
        if(totcost > totgas) return -1;
        return start;
    }
}
