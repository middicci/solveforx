public class LSUB {
    
    int lsub(char X[], char Y[], int m, int n){
        
        
        int l[][] = new int[m+1][n+1];
        int result = 0;
        
        for(int i=0; i<=m; i++)
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)
                    l[i][j] = 0;
                else if(X[i-1] == Y[j-1]){
                    l[i][j] = 1 + l[i-1][j-1];
                }
                else
                    l[i][j] = Integer.max(l[i-1][j], l[i][j-1]);
            }
        
        return l[m][n];
    }
    
    public static void main(String args[]) {
        String s1 = "tumeromole";
        String s2 = "mer";
        
        LSUB ls = new LSUB();
        int n = ls.lsub(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());

        System.out.println("Length of common sub string " + n);
    }
}
