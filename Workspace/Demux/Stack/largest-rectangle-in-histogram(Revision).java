class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        int n=heights.length;
        // this will contain the index of the leftmost next smallest element
        int[] left=new int[n];
        left[0]=-1;
        // this will contain the index of the rightmost next smallest element
        int[] right=new int[n];
        right[n-1]=n;
        // fill the left array now
        stack.push(0);
        for(int i=1;i<n;i++){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i]=stack.size()>0?stack.peek():-1;
            stack.push(i);
        }
        stack=new Stack<>();
        // fill the right array now
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i]=stack.size()>0?stack.peek():n;
            stack.push(i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,heights[i]*(right[i]-left[i]-1));
        }
        return max;
    }
}