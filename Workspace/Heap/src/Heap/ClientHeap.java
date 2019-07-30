package Heap;

public class ClientHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap=new Heap();
		heap.add(10);
		heap.add(30);
		heap.add(20);
		heap.add(40);
		heap.display();
		System.out.println(heap.get());
		heap.remove();
		heap.display();
		System.out.println(heap.get());
	}

}
