public class LCS {
    
    int lcsubrec(char X[], char Y[], int m, int n, int count){
        if(m==0 || n==0) return count;
        if(X[m-1] == Y[n-1])
            return lcsubrec(X, Y, m-1, n-1, count + 1);
        else
            return Integer.max(count, Integer.max(lcsubrec(X, Y, m-1, n, 0), lcsubrec(X, Y, m, n-1, 0)));
    }
    
    public static void main(String args[]) {
        LCS lcs = new LCS();
        String s1 = "abcdefg";
        String s2 = "xyzabcd";
        int n = lcs.lcsubrec(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), 0);
        System.out.println("LCS = " + n);
    }
}
