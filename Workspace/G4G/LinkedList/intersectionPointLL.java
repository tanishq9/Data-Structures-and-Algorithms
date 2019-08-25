class GFG
{
	int intersectPoint(Node headA, Node headB)
	{
        Node tempA = headA;
        Node tempB = headB;
        int countA=0,countB=0;
        while(tempA!=null){
            countA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            countB++;
            tempB=tempB.next;
        }
        int diff=countB-countA;
        if(diff>0){
            while(diff!=0){
                headB=headB.next;
                diff--;
            }
            while(headB!=headA){
                headB=headB.next;
                headA=headA.next;
            }
        }else{
            while(diff!=0){
                headA=headA.next;
                diff++;
            }
            while(headB!=headA){
                headB=headB.next;
                headA=headA.next;
            }
        }
        return headA.data;
	}
}
