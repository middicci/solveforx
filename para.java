import java.util.*;

public class Para {
    
    public static boolean balancePara(String s){
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("(",")");
        hmap.put("[","]");
        hmap.put("{","}");
        Deque<String> stack = new ArrayDeque<String>();
        for(int i=0; i<s.length();i++){
            if (isOpen(s.charAt(i))){
                stack.push(Character.toString(s.charAt(i)));
            } else if (isClosed(s.charAt(i))){
                String c = stack.pop();
                if(!hmap.get(c).equals(Character.toString(s.charAt(i)))){
                    return false;
                }
                
            }
        }
        
        return stack.isEmpty();
        
    }
    
    public static boolean isOpen(char c){
        if(c == '(' || c == '{' || c == '[')
            return true;
        return false;
    }
    
    public static boolean isClosed(char c){
        if(c == ')' || c == '}' || c == ']')
            return true;
        return false;
    }
    
    public static void main(String args[]){
        Para p = new Para();
        System.out.println("Balanced " + p.balancePara("((())){}{}[]") );
    }
}