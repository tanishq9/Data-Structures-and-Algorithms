https://leetcode.com/problems/longest-word-in-dictionary-through-deleting

class Solution {
    public String findLongestWord(String s, List<String> d) {
        List<String> list=new ArrayList<>();
        for(String str:d){
            int i=0; // pointer for 's' string
            int j=0; // pointer for str string in dictionary
            while(i<s.length() && j<str.length()){
                if(s.charAt(i)==str.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            // add word to potential answer list
            if(j==str.length()){
                list.add(str);
            }
        }
        // list before sorting
        System.out.println(list);
        Collections.sort(list,new Comparator<String>(){
            public int compare(String s1,String s2){
                if(s1.length()==s2.length()){
                    return s2.compareTo(s1);
                }else{
                    return s1.length()-s2.length();
                }
            }
        });
        // list after sorting
        System.out.println(list);
        if(list.size()==0){
            return "";
        }
        return list.get(list.size()-1);   
    }
}