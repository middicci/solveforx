public class STEPS {
    int countWaysDP(int n){
        int table[] = new int[n+1];
        for(int i=0; i<=n; i++){
            
                if(i == 0 || i == 1)
                    table[i] = 1;
                else if(i==2)
                    table[i] = 2;
                else
                    table[i] = table[i-1] + table[i-2] + table[i-3];
        }
        return table[n];
    }
    public static void main(String args[]) {
       STEPS st = new STEPS();
       int n = st.countWaysDP(5);
       System.out.println("Count ways = " + n);
    }
}
