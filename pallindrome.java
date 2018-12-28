//O(n) solution
public class Pallindrome {
    
    boolean isPallindrome(String str, int l, int h){
        char arr[] = str.toCharArray();
        
        while(l < h){
            
            while(!Character.isLetterOrDigit(arr[l]))
                l++;
                
            while(!Character.isLetterOrDigit(arr[h]))
                h--;
                
            if(arr[l] != arr[h])
                return false;
            l++;
            h--;
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        String s = "1?1goo;oo og11 ";
        Pallindrome p = new Pallindrome();
        System.out.println(s+ " is Pallindrome? : " + p.isPallindrome(s, 0, s.length() - 1));
    }
}
