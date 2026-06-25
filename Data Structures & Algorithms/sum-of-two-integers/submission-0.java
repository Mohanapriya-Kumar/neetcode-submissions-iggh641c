class Solution {
    public int getSum(int a, int b) {
        //sum is ^ and carry is left shft if &
        while(b != 0){ //loop until no carry
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b  = carry;
        }
        return a;
    }
}
