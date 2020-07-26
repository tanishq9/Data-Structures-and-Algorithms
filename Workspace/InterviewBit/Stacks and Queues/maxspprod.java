public class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        int n=A.size();
        int[] leftLarger=new int[n];
        int[] rightLarger=new int[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        leftLarger[0]=0;
        for(int i=1;i<n;i++){
            while(stack.size()>0 && A.get(i)>=A.get(stack.peek())){
                stack.pop();
            }
            leftLarger[i]=stack.size()>0?stack.peek():0;
            stack.push(i);
        }
        stack=new Stack<>();
        stack.push(n-1);
        rightLarger[n-1]=0;
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && A.get(i)>=A.get(stack.peek())){
                stack.pop();
            }
            rightLarger[i]=stack.size()>0?stack.peek():0;
            stack.push(i);
        }
        long max=0;
        // System.out.println(Arrays.toString(leftLarger));
        // System.out.println(Arrays.toString(rightLarger));
        for(int i=0;i<n;i++){
	// max=Long.max(max,(long)leftLarger[i]*(long)rightLarger[i]);            
	   max=Long.max(max,1L*leftLarger[i]*rightLarger[i]);
        }
        return (int)(max%1000000007);
    }
}
