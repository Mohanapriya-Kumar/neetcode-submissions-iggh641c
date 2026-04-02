class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;//min k
        int r = 0; //max k is the max of piles
        for(int pile : piles){
            if(pile > r) r = pile;
        }

        while(l <= r){
            int m = l + (r - l)/2;
            if(canEat(piles, h, m)) r = m - 1;
            else l = m + 1;
        }
        return l;
        
    }

    private static boolean canEat(int[] piles, int h, int k){
        int hrs = 0;
        for(int pile : piles){
            hrs += (int) Math.ceil((double)pile/k);
        }
        return hrs <= h;
    }
}
