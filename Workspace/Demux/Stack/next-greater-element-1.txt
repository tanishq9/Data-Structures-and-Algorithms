class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums2.length==0){
            return new int[0];
        }
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        stack.push(nums2[nums2.length-1]);
        map.put(nums2[nums2.length-1],-1);
        for(int i=nums2.length-2;i>=0;i--){
            while(stack.size()>0 && stack.peek()<=nums2[i]){
               stack.pop(); 
            }
            if(stack.size()>0){
                map.put(nums2[i],stack.peek());
            }else{
                map.put(nums2[i],-1);
            }
            stack.push(nums2[i]);
        }
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}