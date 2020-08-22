/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                if(i1.start==i2.start){
                    return i1.end-i2.end;
                }   
                return i1.start-i2.start;
            }
        });
        Stack<Interval> stack=new Stack<>();
        stack.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval current=intervals.get(i);
            Interval top=stack.peek();
            if(top.end>=current.start){
                // update current top interval 
                newInterval=new Interval(top.start,Math.max(top.end,current.end));
                stack.pop();
                stack.push(newInterval);
            }else{
                // add new interval
                stack.push(current);
            }
        }
        ArrayList<Interval> result=new ArrayList<>();
        while(stack.size()>0){
            result.add(0,stack.pop());
        }
        return result;
    }
}
