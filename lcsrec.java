public class LCS {
    
    int lcsubrec(char X[], char Y[], int m, int n){
        if(m==0 || n==0) return 0;
        if(X[m-1] == Y[n-1])
            return 1 + lcsubrec(X, Y, m-1, n-1);
        else
            return Integer.max(lcsubrec(X, Y, m-1, n), lcsubrec(X, Y, m, n-1));
    }
    
    public static void main(String args[]) {
        LCS lcs = new LCS();
        String s1 = "abcdefg";
        String s2 = "xyzabc";
        int n = lcs.lcsubrec(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        System.out.println("LCS = " + n);
    }
}
