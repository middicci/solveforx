public class STEPS {
    int countWays(int n){
        if(n == 0 || n == 1) 
            return 1;
        else if(n == 2) 
            return 2;
        else
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
            
    }
    public static void main(String args[]) {
       STEPS st = new STEPS();
       int n = st.countWays(4);
       System.out.println("Count ways = " + n);
    }
}
