public class Solution {
    public int[] order(int[] A, int[] B) {
        // Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        int[][] people=new int[A.length][2];
        for(int i=0;i<A.length;i++){
            people[i][0]=A[i]; // height
            people[i][1]=B[i]; // front
        }
        // 1. Arrange all the person based on the heights sorted in decreasing order and if two or more person has same heights then compare their K values in assending order.
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] e1,int[] e2){
                if(e1[0]<e2[0]){
                    return 1;
                }else if(e1[0]>e2[0]){
                    return -1;
                }else{
                    return e1[1]-e2[1];
                }
            }
        });
        // Below is the output of Step 1
        // Sort based on height and K value : [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        
        
        // 2. Insert one by one based on K value in the queue
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            list.add(people[i][1],people[i][0]);
        }
        int[] result=new int[list.size()];
        int index=0;
        for(int e:list){
            result[index++]=e;
        }
        
        // Below is the output of Step 2
        // [[5,0], [7,0], [5, 2], [6, 1],[4, 4], [7,1]]
        return result;
    }
}
