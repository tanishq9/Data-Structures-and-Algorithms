public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println(largest(arr,k));
 		}
	}
	public static int largest(int[] arr,int k){
	    HashMap<Integer,Integer> map = new HashMap<>();
	    int sum=0;
	    int maxLen=0;
	    for(int i=0;i<arr.length;i++){
	        sum+=arr[i];
	        if(sum==k){
	            maxLen=i+1;
	        }
	        if(!map.containsKey(sum)){
	            map.put(sum,i);
	        }
	        if(map.containsKey(sum-k)){
	            if(maxLen<i-map.get(sum-k)){
	                maxLen=i-map.get(sum-k);
	            }
	        }
	    }
	    return maxLen;
	}
}
