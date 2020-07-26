class Solution {
    
    Stack<Integer> stack=new Stack<>();
    int min=-1;
    
    public void push(int x) {
        if(stack.size()==0){
            stack.push(x);
            min=x;
        }else if(stack.size()>0 && x>=min){
            stack.push(x);
        }else if(stack.size()>0 && x<min){
            // push a value such that it will be less than old min
            // and we will be able to derive the old min from it
            stack.push(2*x-min); 
            // 2*x-min will always be less than x and thus we will know 
            // at this point while popping that if peek<min then we have to 
            // restore the earlier min; 2*newMin-oldMin = peek, => oldMin = 2*newMin-peek
            min=x;
        }
    }

    public void pop() {
        if(stack.size()==0){
            return;
        }
        int peek=stack.pop();
        if(min>peek){
            // restore the oldMin
            min=2*min-peek;
        }
    }

    public int top() {
        if(stack.size()==0){
            return -1;
        }
        int peek=stack.peek();
        if(min<=peek){
            // yehi sachi value hai
            return peek;
        }else{
            // min return karna hai kyuki peek pe jhooth rakha hai
            return min;
        }
    }

    public int getMin() {
        if(stack.size()==0){
            return -1;
        }
        return min;
    }
}
