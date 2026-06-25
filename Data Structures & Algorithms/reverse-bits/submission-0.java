class Solution {
    public int reverseBits(int n) {
        //take from the right of n and put from right to left of res
        int res = 0;
        for(int i = 0; i < 32; i++){
            res <<= 1; //leave a single bit place to keep adding bits from n
            res |= n & 1;
            n >>>= 1; //right (unsigned shift)
        }
        return res;
    }
}
