public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        int[] arr1=new int[n];
	        int[] arr2=new int[n];
	        for(int i=0;i<n;i++){
	            arr1[i]=sc.nextInt()*-1;
	        }
	        for(int i=0;i<n;i++){
	            arr2[i]=arr1[i]+sc.nextInt();
	        }
	        // now find largest 0 sum subarray
	        HashMap<Integer,Integer> map=new HashMap<>();
	        map.put(0,-1);
	        int rsum=0,max=0;
	        for(int i=0;i<arr2.length;i++){
	            rsum+=arr2[i];
	            if(map.containsKey(rsum)){
	                max=Math.max(max,i-map.get(rsum));
	            }
	            map.putIfAbsent(rsum,i);
	        }
	        System.out.println(max);
	    }
	 }