class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int max=0;
        int[] hArr = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                // cannot be taken as base since it is 0
                if(matrix[i][j]=='0'){
                    hArr[j]=0;                
                }else{
                    // can be taken as base since > 0
                    hArr[j]+=(matrix[i][j]-'0');                    
                }
            }
            max=Math.max(max,largestRectangleArea(hArr));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        int[] leftSmaller=new int[heights.length];
        int[] rightSmaller=new int[heights.length];
        // computing the just previous left smaller index for every element
        leftSmaller[0]=-1;
        stack.push(0);
        for(int i=1;i<heights.length;i++){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            leftSmaller[i]=stack.size()>0?stack.peek():-1;
            stack.push(i);
        }
        // computing the just next right smaller index for every element
        rightSmaller[heights.length-1]=heights.length;
        stack.clear();
        stack.push(heights.length-1);
        for(int i=heights.length-2;i>=0;i--){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            rightSmaller[i]=stack.size()>0?stack.peek():heights.length;
            stack.push(i);
        }
        // find maximum area
        int max=0;
        for(int i=0;i<heights.length;i++){
            int area = (rightSmaller[i]-1-(leftSmaller[i]+1)+1)*heights[i];
            max=Math.max(max,area);
        }
        return max;
    }
}