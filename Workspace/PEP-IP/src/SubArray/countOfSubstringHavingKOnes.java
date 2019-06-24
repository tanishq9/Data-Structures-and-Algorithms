package SubArray;

import java.util.HashMap;

public class countOfSubstringHavingKOnes {
	 static int countOfSubstringWithKOnes(String s, int K) 
     { 
 	 	int[] arr=new int[s.length()];
 	 	int index=0;
 	 	for(char cc:s.toCharArray()){
 	 	    if(cc=='0'){
 	 	        arr[index++]=0;
 	 	    }else{
 	 	        arr[index++]=1;
 	 	    }
 	 	}
 	 	HashMap<Integer,Integer> map=new HashMap<>();
 	 	// Find count of 0 sum sub arrays now
 	 	int rsum=0;
 	 	int count=0;
 	 	int target=K;
 	 	map.put(0,1); // rsum and frequency 
 	 	for(int i=0;i<arr.length;i++){
 	 	    rsum+=arr[i];
 	 	    if(map.containsKey(rsum-target)){
 	 	        count+=map.get(rsum-target);
 	 	    }
 	 	    map.put(rsum,map.getOrDefault(rsum,0)+1);
 	 	}
 	 	return count;
     } 
}
