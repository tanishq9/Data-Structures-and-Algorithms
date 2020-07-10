import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.*;

class TestClass {

    // every index in the segTree refers to a range
    // segment tree is exactly like a heap, we use array to store 
    // the values of different ranges in segTree array
    // each (s,e) range of the input array will correspond to an index in segTree array
    static int[] segTree;
    static long[] lazy;
    static int n;
    
    static void initialize(int[] nums){
        int height=getCeil(n);
        // refer g4g for proof/intuition about size of segment tree
        segTree=new int[(1<<(height+1))-1];
        lazy=new long[segTree.length];
        buildTree(0,0,n-1,nums);
    }
    
    static int getCeil(int len){
        int pow=0;
        while((1<<pow)<len){
            pow++;
        }
        return pow;
    }
    // root : starting index of the segment tree, chosen as 0
    // s : start index of nums array
    // e : end index of nums array
    static void buildTree(int root,int s,int e,int[] nums){
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
    
    public static void update(int qs,int qe, int val) {
        updateHelper(0,0,n-1,qs,qe,val);
    }
    
    // updating range in O(4*log(N)) using lazy propogation approach
    static void updateHelper(int root,int s,int e,int qs,int qe,int val){
        // resolve pending updates       
        handlePendingUpdates(root,s,e);
        // index to be updated is out of range
        if(s>e || s>qe || e<qs){
            return;
        }

        if(qs<=s && e<=qe){
            // update lazy propagation value for root
            // remember that root stores min of range
            lazy[root]+=val;
            // resolve pending updates
            handlePendingUpdates(root,s,e);
            return;
        }
        
        int mid=(s+e)/2;
        updateHelper(2*root+1,s,mid,qs,qe,val);
        updateHelper(2*root+2,mid+1,e,qs,qe,val);
        // update the whole segtree as well
        segTree[root]=Operation(segTree[2*root+1],segTree[2*root+2]);
    }
    
    
    public static int minRange(int i, int j) {
        return minRangeHelper(0,0,n-1,i,j);
    }
    
    static int minRangeHelper(int root,int s,int e,int qs,int qe){
        // resolve pending updates
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
        int left=minRangeHelper(2*root+1,s,mid,qs,qe);
        int right=minRangeHelper(2*root+2,mid+1,e,qs,qe);
        return Operation(left,right);
    }
    
    // handling pending updates logic can be customized as per the question
    static void handlePendingUpdates(int root,int s,int e){
        if(lazy[root]!=0){
            segTree[root]+=lazy[root];
            if(s!=e){
                lazy[2*root+1]+=lazy[root];
                lazy[2*root+2]+=lazy[root];
            }
            lazy[root]=0;
        }
    }
    
    public static int Identity(){
        return Integer.MAX_VALUE;
    }
    
    public static int Operation(int a,int b){
        return Math.min(a,b);
    }

    public static void main(String args[] ) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] l1=br.readLine().trim().split("\\s+");
        int len=Integer.parseInt(l1[0]);
        int nq=Integer.parseInt(l1[1]);
        int[] nums=new int[len];
        l1=br.readLine().trim().split("\\s+");
        for(int i=0;i<len;i++){
            nums[i]=Integer.parseInt(l1[i]);
        }
        // init the global variables
        n=nums.length;
        initialize(nums);
        while(nq-->0){
            l1=br.readLine().trim().split("\\s+");
            char cc=l1[0].charAt(0);
            int qs=Integer.parseInt(l1[1]);
            int qe=Integer.parseInt(l1[2]);
            if(cc=='q'){
                System.out.println(minRange(qs-1,qe-1));
            }else{
                int val=Integer.parseInt(l1[3]);
                update(qs-1,qe-1,val);
            }
            // System.out.println(Arrays.toString(segTree));
            // System.out.println(Arrays.toString(lazy));
            // System.out.println();
        }

    }
}
