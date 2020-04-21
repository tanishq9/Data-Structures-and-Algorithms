https://leetcode.com/problems/longest-word-in-dictionary

class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set=new HashSet<>();
        for(String word:words){set.add(word);}
        List<String> list=new ArrayList<>();
        // check if set consists of all prefixes of the word
        for(String word:words){
            String current=word;
            boolean flag=true;
            while(current.length()!=1){
                current=current.substring(0,current.length()-1);
                if(!set.contains(current)){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                list.add(word);
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
        return list.get(list.size()-1);
    }
}