/* Linked list Node
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class GfG
{
    Node deleteAllOccurances(Node head, int x)
    {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node temp = dummy;
        while(temp.next!=null){
            if(temp.next.data==x){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return dummy.next;
    }
}
