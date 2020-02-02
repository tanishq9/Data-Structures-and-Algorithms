{
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
	
public class ReorderList
{
    Node head;  // head of lisl
  
    /* Linked list Node*/
   
                    
    /* Utility functions */
 
    /* Inserts a new Node at front of the list. */
     public void addToTheLast(Node node) {
  if (head == null) {
   head = node;
  } else {
   Node temp = head;
   while (temp.next != null)
    temp = temp.next;
   temp.next = node;
  }
 }
  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			ReorderList llist = new ReorderList();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
         }
          //int k=sc.nextInt();
         
        llist.head = new gfg().reorderlist(llist.head);
        //llist.printList();
		//llist.head = llist.reverse(llist.head);
		llist.printList();
		
        t--;
    }
}
}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* Following is the Linked list node structure */
/*class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}*/
	
class gfg
{

    Node getMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    int sizeList(Node head){
        int count = 1;
        while(head.next!=null){
            head = head.next;
            count++;
        }
        return count;
    }

    Node rdrLeft = null;

    Node reorderlist(Node head)
    {
        Node mid = getMid(head);
        int size = sizeList(head);
        rdrLeft = head;
        reorder(head,0,size);
        mid.next = null;
        return head;
    }
    
    void reorder(Node node,int floor,int size){
        if(node==null){
            return;
        }
        reorder(node.next,floor+1,size);
        if(floor>size/2){
            Node temp = rdrLeft.next;
			rdrLeft.next = node;
			node.next = temp;
			rdrLeft = temp;
        }
    }
}

