public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n=A.size();
        Stack<Integer> stack=new Stack<>();
        // left array stores the next smaller element's index on the left of the current element
        int[] left=new int[n];
        stack.push(0);
        left[0]=-1;
        for(int i=1;i<A.size();i++){
            while(stack.size()>0 && A.get(i)<=A.get(stack.peek())){
                stack.pop();
            }
            left[i]=stack.size()>0?stack.peek():-1;
            stack.push(i);
        }
        stack=new Stack<>();
        stack.push(n-1);
        int[] right=new int[n];
        right[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && A.get(i)<=A.get(stack.peek())){
                stack.pop();
            }
            right[i]=stack.size()>0?stack.peek():n;
            stack.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            // considering every element as the potential building
            // and finding the max area using the left and right just min boundaries
            max=Math.max(max,(right[i]-1-(left[i]+1)+1)*A.get(i));   
        }
        return max;
    }
}
