	private static int waterTrapped(int[] arr){
	    int[] lmax = new int[arr.length];
	    int[] rmax = new int[arr.length];
	    lmax[0]=arr[0];
	    for(int i=1;i<lmax.length;i++){
	        lmax[i]=Math.max(lmax[i-1],arr[i]);
	    }
	    rmax[rmax.length-1]=arr[arr.length-1];
	    for(int i=rmax.length-2;i>=0;i--){
	        rmax[i]=Math.max(rmax[i+1],arr[i]);
	    }
	    int units=0;
	    for(int i=0;i<arr.length;i++){
	        units+=Math.min(lmax[i],rmax[i])-arr[i];
	    }
	    return units;
	}
