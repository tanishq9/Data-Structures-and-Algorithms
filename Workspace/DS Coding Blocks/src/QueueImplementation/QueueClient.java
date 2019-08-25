package QueueImplementation;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue queue=new Queue(5);
		for(int i=1;i<=5;i++) {
			queue.enqueue(i*10);
			queue.display();
		}
		queue.dequeue();
		queue.display();
	}

}
