class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false, y = false, z = false;
        for(int t[] : triplets){
            //if one of the cordinates is greater than target which means it has no contribution towards the target
            //meaning we can't assume true if any other coordinate is present in that uncontriuted triplet
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            if(t[0] == target[0]) x = true;
            if(t[1] == target[1]) y = true;
            if(t[2] == target[2]) z = true;
        }
        return x && y && z;
    }
}
