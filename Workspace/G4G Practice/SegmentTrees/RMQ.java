 static int[] st;
    static int[] oba;
    
    public static int[] constructST(int arr[], int n)
    {
        oba = arr;
        // Find height of tree
        int h = getCeil(n);
        // Determine size of st array
        st = new int[(1<<(h+1))-1];
        buildTree(0,0,oba.length-1);
        return st;
    }
    
    public static int getCeil(int n){
        int log = 0;
        while((1<<log)<n){
            log++;
        }
        return log;
    }
    
    public static void buildTree(int si,int ss,int se){
        if(ss==se){
            st[si]=oba[ss];
            return;
        }
        int mid = (ss+se)/2;
        buildTree(2*si+1,ss,mid);
        buildTree(2*si+2,mid+1,se);
        st[si] = Math.min(st[2*si+1],st[2*si+2]);
    } 
    
    
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r)
    {
        return RMQ(0,0,oba.length-1,l,r); // si,ss,se,qs,qe
    }
    private static int RMQ(int si,int ss,int se,int qs,int qe){
        if(se<qs || ss>qe){
            return Integer.MAX_VALUE;
        }
        else if(ss>=qs && qe>=se){
            return st[si];
        }
        else{
            int mid=(ss+se)/2;
            int lc=RMQ(2*si+1,ss,mid,qs,qe);
            int rc=RMQ(2*si+2,mid+1,se,qs,qe);
            return Math.min(lc,rc);
        }
    }
    
