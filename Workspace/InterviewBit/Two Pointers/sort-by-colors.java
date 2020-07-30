public class Solution {
    public void sortColors(ArrayList<Integer> a) {
        // By Counting Sort
        int[] arr=new int[3];
        for(int i=0;i<a.size();i++){
            arr[a.get(i)]++;
        }
        int indexMainArray=0,indexCountArray=0;
        while(indexMainArray<a.size()){
            int freq=arr[indexCountArray];
            while(freq-->0){
                a.set(indexMainArray++,indexCountArray);
            }
            indexCountArray++;
        }
    }
}
