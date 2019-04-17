package Print;

public class Generic<P extends Comparable<P>>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr= {1,5,2,3,9,4};
		display(arr);
		if(isLarger(4,3)>0) {
			System.out.println(3);
		}else {
			System.out.println(4);		
		}
	}	
	public static<T> void display(T[] arr) {
		for(T i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static<P> int isLarger(P i,P j) {
		return ((Comparable<P>) i).compareTo(j);
	}

}
