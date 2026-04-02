class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nr = matrix.length, nc = matrix[0].length;
        int l = 0, r = (nr*nc) - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            int row = mid / nc;//row number will be multiple of col num
            int col = mid % nc;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
