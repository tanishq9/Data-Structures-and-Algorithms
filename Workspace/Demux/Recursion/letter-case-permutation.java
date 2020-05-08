https://leetcode.com/problems/letter-case-permutation

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        fun(S,0,new StringBuilder(),list);
        return list;            
    }
    void fun(String str, int index, StringBuilder sb, List<String> list){
        if(index==str.length()){
            list.add(sb.toString());
            System.out.println(sb.toString());
            return;
        }
        
        // decision : take letter 
        char currentCharacter = str.charAt(index);
        // keep the same
        if(Character.isLetter(currentCharacter)){
            int asciiValue = (int)currentCharacter;
            // keep the same : don't change
            sb.append(currentCharacter);
            fun(str,index+1,sb,list);
            sb.deleteCharAt(sb.length()-1);
            
            // change to big if small and change to small if big
            if(65<=asciiValue && asciiValue<=92){
                asciiValue += 32; 
                // small letter
                sb.append((char)asciiValue);
                fun(str,index+1,sb,list);
                sb.deleteCharAt(sb.length()-1);
            }else{
                asciiValue -= 32; 
                // big letter
                sb.append((char)asciiValue);
                fun(str,index+1,sb,list);
                sb.deleteCharAt(sb.length()-1);
            }
        }else{
            sb.append(currentCharacter);
            fun(str,index+1,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
        
                
    }
}