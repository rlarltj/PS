import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack();
        
        st.push(s.charAt(0));
        
        if(s.length() == 1) return 0;
        
        for(int i = 1; i<s.length(); i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }
            
            if(st.peek() == s.charAt(i)){
                st.pop(); 
                continue;
            }
            
            st.push(s.charAt(i));
        }
        
        if(st.isEmpty()){
            return 1;
        }
        
        return 0;
    }
}