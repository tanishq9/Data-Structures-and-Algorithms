class NumArray {
    
    // every index in the segTree refers to a range
    // segment tree is exactly like a heap, we use array to store 
    // the values of different ranges in segTree array
    // each (s,e) range of the input array will correspond to an index in segTree array
    int[] segTree;
    int[] lazy;
    int n;
    
    void initialize(int[] nums){
        int height=getCeil(n);
        // refer g4g for proof/intuition about size of segment tree
        segTree=new int[(1<<(height+1))-1];
        lazy=new int[segTree.length];
        Arrays.fill(lazy,Integer.MIN_VALUE);
        buildTree(0,0,n-1,nums);
    }
    
    int getCeil(int len){
        int pow=0;
        while((1<<pow)<len){
            pow++;
        }
        return pow;
    }
    // root : starting index of the segment tree, chosen as 0
    // s : start index of nums array
    // e : end index of nums array
    void buildTree(int root,int s,int e,int[] nums){
        if(s>e){
            return;
        }
        // got leaf node
        if(s==e){
            segTree[root]=nums[s];
            return;
        }
        int mid=(s+e)/2;
        buildTree(2*root+1,s,mid,nums);
        buildTree(2*root+2,mid+1,e,nums);
        segTree[root]=Operation(segTree[2*root+1],segTree[2*root+2]);
    }
    
    // Methods to be implemented as part of solution
    public NumArray(int[] nums) {
        n=nums.length;
        initialize(nums);
    }
    
    public void update(int i, int val) {
        updateHelper(0,0,n-1,i,i,val);
    }
    
    // updating range in O(4*log(N)) using lazy propogation approach
    void updateHelper(int root,int s,int e,int qs,int qe,int val){
        // index to be updated is out of range
        if(s>e || s>qe || e<qs){
            return;
        }
        // update value at index, here update tells us to replace the value entirely
        // i.e we are not doing +=
        if(qs<=s && e<=qe){
            lazy[root]=val;
            handlePendingUpdates(root,s,e);
            return;
        }
        
        int mid=(s+e)/2;
        updateHelper(2*root+1,s,mid,qs,qe,val);
        updateHelper(2*root+2,mid+1,e,qs,qe,val);
        // update the whole segtree as well
        segTree[root]=Operation(segTree[2*root+1],segTree[2*root+2]);
    }
    
    
    public int sumRange(int i, int j) {
        return search(0,0,n-1,i,j);
    }
    
    int search(int root,int s,int e,int qs,int qe){
        handlePendingUpdates(root,s,e);
        // no overlap
        if(s>e || s>qe || qs>e){
            return Identity(); // identity of sum
        }
        // complete overlap
        if(qs<=s && e<=qe){
            // [qs,qe] = [3,6]
            // [s,e] = [4,5]
            return segTree[root];
        }
        int mid=(s+e)/2;
        int left=search(2*root+1,s,mid,qs,qe);
        int right=search(2*root+2,mid+1,e,qs,qe);
        return Operation(left,right);
    }
    
    // handling pending updates logic can be customized as per the question
    void handlePendingUpdates(int root,int s,int e){
        // Integer.MIN_VALUE, becoz update can be 0 as well
        if(lazy[root]!=Integer.MIN_VALUE){
            segTree[root]=(e-s+1)*lazy[root];
            if(s!=e){
                lazy[2*root+1]=lazy[root];
                lazy[2*root+2]=lazy[root];
            }
            lazy[root]=Integer.MIN_VALUE;    
        }
    }
    
    public int Identity(){
        return 0;
    }
    
    public int Operation(int a,int b){
        return a+b;
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */