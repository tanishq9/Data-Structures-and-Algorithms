class GfG
     {
        static class Helper implements Comparable<Helper>{
            int data; // data value
            int arnum; // list index 
            int datanum; // array data index in list
            Helper(int idata,int iarnum,int idatanum){
                this.data=idata;
                this.arnum=iarnum;
                this.datanum=idatanum;
            }
            public int compareTo(Helper other){
                if(this.data<other.data){
                    return -1;
                }else if(this.data>other.data){
                    return 1;
                }else{
                    return 0;
                }
            }
        } 
        
        public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) {
            ArrayList<Integer> result = new ArrayList<>();
            PriorityQueue<Helper> pq = new PriorityQueue<>();
            for(int i=0;i<k;i++){
                pq.add(new Helper(arrays[i][0],i,0));
            }
            while(pq.size()>0){
                Helper peek = pq.peek();
                result.add(peek.data);
                pq.remove();
                peek.datanum++;
                if(peek.datanum<arrays[peek.arnum].length){
                    pq.add(new Helper(arrays[peek.arnum][peek.datanum],peek.arnum,peek.datanum));
                }
            }   
            return result;
        }
}
