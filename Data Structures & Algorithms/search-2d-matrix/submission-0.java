class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nr = matrix.length, nc = matrix[0].length;
        int l = 0, r = nc*nr - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            int row = m/nc, col = m%nc;
            if(matrix[row][col] > target) r = m - 1;
            else if(matrix[row][col] < target) l = m + 1;
            else return true;
        }
        return false;
    }
}
