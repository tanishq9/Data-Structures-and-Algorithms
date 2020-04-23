https://leetcode.com/problems/maximum-frequency-stack/

class FreqStack {

    // maintain a reverse frequency map and a frequency map
    // reverse freq. map -> (freq. : stack of numbers)
    // freq. map -> (element : freq.)
    // push and pop both work in O(logn) since in this I am using TreeMap
    // it can be optimized by using a makeFreq variable as in the editorial solution
    
    Map<Integer,Integer> freqMap;
    TreeMap<Integer,Stack<Integer>> revFreqMap;

    public FreqStack() {
        freqMap=new HashMap<>();
        revFreqMap=new TreeMap<>();
    }
    
    public void push(int x) {
        // update the frequency map
        int f = freqMap.getOrDefault(x,0)+1;
        freqMap.put(x,f);
        // update the reverse frequency map
        if(!revFreqMap.containsKey(f)){
            revFreqMap.put(f,new Stack<>());
        }
        revFreqMap.get(f).push(x);
    }
    
    public int pop() {
        // pop from reverse frequency map's stack
        // last key in reverse frequency will be the max freq 
        System.out.println(revFreqMap.lastKey());
        int x=revFreqMap.get(revFreqMap.lastKey()).pop();
        if(revFreqMap.get(revFreqMap.lastKey()).size()==0){
            revFreqMap.pollLastEntry();
        }
        freqMap.put(x,freqMap.get(x)-1);
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */