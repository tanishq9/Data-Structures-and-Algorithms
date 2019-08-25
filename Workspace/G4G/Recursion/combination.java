/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static ArrayList<ArrayList<Integer>> result = null;
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int n = sc.nextInt();
		    HashSet<Integer> hs = new HashSet<>();
		    for(int i=0;i<n;i++){
		        hs.add(sc.nextInt());
		    }
		    int[] arr = new int[hs.size()];
            int idx=0;
            for(int i:hs){
                arr[idx]=i;
                idx++;
            }
		    Arrays.sort(arr);
    		int sum = sc.nextInt();
            result = new ArrayList<ArrayList<Integer>>();
    		ArrayList<Integer> list = new ArrayList<>();
    		subsets(arr, sum, 0, list);
		    ArrayList<Integer> recent = new ArrayList<>();
		    if(result.size()==0){
		        System.out.println("Empty");
		        t--;
		        continue;
		    }
		    StringBuffer sb = new StringBuffer();
    		for(ArrayList<Integer> l:result){
    		    if(!recent.equals(l)){
                    //System.out.print("(");
                    sb.append("(");
                    for(int i=0;i<l.size();i++){
                        if(i==l.size()-1){
                            //System.out.print(l.get(i));
                            sb.append(l.get(i));
                        }else{
                            //System.out.print(l.get(i)+" ");
                            sb.append(l.get(i)+" ");
                        }
                    }    
        		    //System.out.print(")");
        		    sb.append(")");
                }
                recent=l;
    		}
    		//sb.append("\n");
    		//System.out.println();
    		System.out.println(sb.toString());
    	    t--;
		}
	}

	private static void subsets(int[] arr, int sum, int li, ArrayList<Integer> list) {
		if (sum == 0) {
			result.add((ArrayList<Integer>) list.clone());
			return;
		}
		for (int i = li; i < arr.length; i++) {
			if ((sum - arr[i]) >= 0) {
				list.add(arr[i]);
				subsets(arr, sum - arr[i], i, list);
				list.remove(list.size() - 1);
			}
		}
	}

}
