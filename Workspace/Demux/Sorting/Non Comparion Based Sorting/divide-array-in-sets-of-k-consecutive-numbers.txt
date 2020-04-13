class Solution {
     class Pair{
        int element,count;
        Pair(int ii,int ij){
            this.element=ii;
            this.count=ij;
        }
    }

    public boolean isPossibleDivide(int[] arr, int k) {
        
    Arrays.sort(arr);
      
    ArrayList<Pair> list = new ArrayList<>();

    for(int i=0;i<arr.length;i++){
        
        if(list.size()>0 && arr[i]==list.get(list.size()-1).element){ 
            list.get(list.size()-1).count++;
        }else{
            list.add(new Pair(arr[i],1));	
        }
    }

    int countSize = list.size();
    for(int i=0;i<countSize;i++){
        int el = list.get(i).element;
        int cn = list.get(i).count;
        if(cn==0) continue;
        if(i+k>countSize) return false;
        for(int j=i+1;j<i+k;j++){
            // check if consequetive
            if(list.get(j).element!=el+j-i) return false;
            // check if there are sufficient numbers in the array
            if(list.get(j).count<cn) return false;
            list.get(j).count-=cn;
        }
        list.get(i).count-=cn; 
    }
    return true;
  }
}