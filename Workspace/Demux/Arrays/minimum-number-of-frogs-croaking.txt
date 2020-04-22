https://leetcode.com/problems/minimum-number-of-frogs-croaking/

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int frogs=0,max=0;
        int[] count=new int[5];
        for(char cc:croakOfFrogs.toCharArray()){
            if(cc=='c'){
                frogs++;
                max=Math.max(max,frogs);
                count[0]++;
            }else if(cc=='r'){
                if(count[0]==0){
                    return -1;
                }
                count[1]++;
                count[0]--;
            }else if(cc=='o'){
                if(count[1]==0){
                    return -1;
                }
                count[2]++;
                count[1]--;
            }else if(cc=='a'){
                if(count[2]==0){
                    return -1;
                }
                count[3]++;
                count[2]--;
            }else if(cc=='k'){
                if(count[3]==0){
                    return -1;
                }
                count[4]++;
                count[3]--;
                frogs--;
            }
        }
        return frogs!=0?-1:max;
    }
}