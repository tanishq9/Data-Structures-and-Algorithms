package IBit;

import java.util.Iterator;
import java.util.PriorityQueue;

public class pqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(0);
		pq.add(1);
		pq.add(-1);
		Iterator it = pq.iterator();
		
		System.out.println(pq.peek());
	}

}
