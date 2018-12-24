import java.util.*;

public class EDIT {
    
    int min(int x, int y, int z){
        if (x <= y && x <= z) return x;
        if(y <= x && y <= z) return y;
        return z;
        
    }
    
    int minDistance(String str1, String str2, int m, int n){
        if(m==0) return n;
        if(n==0) return m;
        
        if(str1.charAt(m-1)  == str2.charAt(n-1))
            return minDistance(str1, str2, m-1, n-1);
        
        return 1 + min( minDistance(str1, str2, m, n-1),
                        minDistance(str1, str2, m-1, n),
                        minDistance(str1, str2, m-1, n-1));
        
    }
    
    public static void main(String args[]) {
       EDIT e = new EDIT();
       int s = e.minDistance("abc", "abc", 3, 3);

        System.out.println("Edit Distance = " + s);
    }
}
