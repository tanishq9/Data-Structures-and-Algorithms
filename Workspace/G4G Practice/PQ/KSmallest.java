class GFG {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.println(kthsmallest(arr,k));
		}
	}
	
	public static int kthsmallest(int[] arr,int k){
	    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	    for(int i=0;i<k && i<arr.length;i++){
	        pq.add(arr[i]);
	    }
	    for(int i=k;i<arr.length;i++){
	        if(arr[i]<pq.peek()){
	            pq.remove();
	            pq.add(arr[i]);
	        }
	    }
	    return pq.peek();
	} 
}
