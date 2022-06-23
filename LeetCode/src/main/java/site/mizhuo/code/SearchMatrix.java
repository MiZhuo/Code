package site.mizhuo.code;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for(int i = 0;i < matrix.length;i++){
            if(target == matrix[i][matrix[i].length - 1]){
                return true;
            }
            if(target < matrix[i][matrix[i].length - 1]){
                for(int a : matrix[i]){
                    if(a == target){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
