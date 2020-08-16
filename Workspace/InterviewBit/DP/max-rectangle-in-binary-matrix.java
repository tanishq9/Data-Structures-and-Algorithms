public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int max=0;
        int[] arr=new int[A.get(0).size()];
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                // update height array
                if(A.get(i).get(j)==1){
                    arr[j]+=1;
                }else{
                    arr[j]=0;
                }
            }
            max=Math.max(max,getArea(arr));
        }
        return max;
    }
    
    public int getArea(int[] arr){
        int n=arr.length;
        int[] nsel=new int[n];
        int[] nser=new int[n];
        Stack<Integer> stack=new Stack<>();
        nsel[0]=-1;
        stack.push(0);
        for(int i=1;i<n;i++){
            while(stack.size()>0 && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            nsel[i]=stack.size()>0?stack.peek():-1;
            stack.push(i);
        }
        stack=new Stack<>();
        nser[n-1]=n;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            nser[i]=stack.size()>0?stack.peek():n;
            stack.push(i);
        }
        // System.out.println(Arrays.toString(nsel));
        // System.out.println(Arrays.toString(nser));
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]*(nser[i]-nsel[i]-1));
        }
        return max;
    }
    
}
