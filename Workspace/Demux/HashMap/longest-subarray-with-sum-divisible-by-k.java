public static void main (String[] args)
	 {
	  Scanner sc=new Scanner(System.in);
	  int tc=sc.nextInt();
	  while(tc-->0){
	      int n=sc.nextInt();
	      int k=sc.nextInt();
	      int[] arr=new int[n];
	      for(int i=0;i<n;i++){
	          arr[i]=sc.nextInt();
	      }
	      longest(arr,k);
	  }
	 }
	 
	 
	 static void longest(int[] arr,int k){
	     HashMap<Integer,Integer> map=new HashMap<>();
	     int rsum=0,max=0;
	     map.put(0,-1);
	     // running sum and first occurrance
	     for(int i=0;i<arr.length;i++){
	         rsum=(rsum%k+(arr[i]%k+k)%k)%k;
	         int rem=(rsum%k+k)%k;
	         if(map.containsKey(rsum)){
	            max=Math.max(max,i-map.get(rsum));
	         }
	         map.putIfAbsent(rsum,i);
	     }
	     System.out.println(max);
	 }