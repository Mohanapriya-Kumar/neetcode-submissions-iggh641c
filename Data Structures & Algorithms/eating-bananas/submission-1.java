class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int pile : piles){
            if(pile > r) r = pile;
        }
        //we need minimum in which canEat 
        while(l <= r){
            int mid = l + (r - l)/2;
            if(canEat(piles, h, mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l; //return the minimum valid
    }
    private static boolean canEat(int[] piles, int h, int k){
        int hrs = 0;
        for(int pile : piles){
            hrs += (int) Math.ceil((double) pile/k);
        }
        return hrs <= h;   //within inclusive
        
    }
}
