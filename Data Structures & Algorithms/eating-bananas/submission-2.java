class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //l,r,m are eating speeds min is 1 max is max num of bananas in a pile
        int l = 1, r = 0;
        for(int pile : piles){
            if(pile > r) r = pile;
        }

        while(l <= r){
            int m = l + (r - l)/2;
            if(canEat(piles, h, m)) r = m - 1; // if he can eat try lesser speed
            else l = m + 1;
        }
        return l;

    }

    static boolean canEat(int[] piles, int h, int k){
        int hrs = 0;
        for(int pile : piles){
            hrs += (int) Math.ceil((double) pile/k);
        }
        return hrs <= h;
    }
}
