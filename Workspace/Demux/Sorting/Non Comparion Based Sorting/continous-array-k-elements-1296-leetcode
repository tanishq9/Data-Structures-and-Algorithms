class Pair{
	int element,count;
	Pair(int ii,int ij){
		this.element=ii;
		this.count=ij;
	}
}

ArrayList<Pair> list = new ArrayList<>();

for(int i=0;i<arr.length;i++){
	if(list.size()>0 && arr[i]==list.get(i-1)){
		int prevCount =  list.get(i-1);
		list.add(new Pair(arr[i],prevCount+1));
	}else{
		list.add(new Pair(arr[i],1);	
	}
}

int countSize = list.size();
for(int i=0;i<countSize;i++){
	int el = countSize.get(i).element;
	int cn = countSize.get(i).count;
	if(cn==0) continue;
	if(i+k>countSize) return false;
	for(int j=i+1;j<i+k;j++){
		if(list.get(j).element!=el) return false;
		if(list.get(j).count>el) return false;
		list.get(j).count-=cn;
	}
	list.get(i).count-=cn;
}