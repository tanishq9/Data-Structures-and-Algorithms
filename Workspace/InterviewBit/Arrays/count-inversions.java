public class Solution {
    int count;
    public int countInversions(int[] A) {
        count=0;
        sort(A,0,A.length-1);
        return count;
    }
    void sort(int[] A,int s,int e){
        if(s>=e){
            return;
        }
        int mid=(s+e)/2;
        sort(A,s,mid);
        sort(A,mid+1,e);
        merge(A,s,mid,e);
    }
    void merge(int[] A,int s,int mid,int e){
        int i=s,j=mid+1,k=0;
        int[] temp=new int[e-s+1];
        while(i<=mid && j<=e){
            if(A[i]>A[j]){
                temp[k++]=A[j++];
                count+=(mid-i+1);
            }else{
                temp[k++]=A[i++];
            }
        }
        while(i<=mid){
            temp[k++]=A[i++];            
        }
        while(j<=e){
            temp[k++]=A[j++];            
        }
        for(i=s;i<=e;i++){
            A[i]=temp[i-s];
        }
    }
}
