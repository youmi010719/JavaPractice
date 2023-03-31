package VariableLearn.com.Var;

public class IntNum {
        public static  void main(String[] args){
            int[][] scores = {
                    {82,55,58},
                    {87,65,98},
                    {45,98,65},
                    {58,65,98},
            };
            double average = 0;
            int m = scores.length,n = scores[0].length;
            for(int i = 0 ; i< m; i++){
                for (int j =0 ;j<n;j++){
                    average += scores[i][j];
                }
            }
            average /= (m * n);

            System.out.println(average);

        }

}
