https://leetcode.com/problems/lru-cache

class LRUCache {
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int ikey,int ivalue,Node iprev,Node inext){
            this.key=ikey;
            this.value=ivalue;
            this.prev=iprev;
            this.next=inext;
        }
    }
    
    // Use map to store Key and node's address in the DLL
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    int size;
    
    public LRUCache(int capacity) {
        this.head=null;
        this.tail=null;
        this.size=0;
        this.capacity=capacity;
        this.map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            // get the node from the map
            Node toBeUpdated=map.get(key);
            // update the positon of this node in the DLL
            if(toBeUpdated==this.head){
                // no update in position if the node is already at the head
            }else if(toBeUpdated==this.tail){
                // update position if node is at the tail(least recently used)
                // changes its prev's next to null
                // and make it the new head (most recently used)
                Node prevNode=toBeUpdated.prev;
                prevNode.next=null;
                // assign the new tail
                this.tail=prevNode;
                
                // update the head
                this.head.prev=toBeUpdated;
                toBeUpdated.next=this.head;
                toBeUpdated.prev=null;
                // assign the new head 
                this.head=toBeUpdated;
            }else{
                // more generic if the node to be updated is in the middle
                Node prevNode=toBeUpdated.prev;
                Node nextNode=toBeUpdated.next;
                prevNode.next=nextNode;
                nextNode.prev=prevNode;
                
                this.head.prev=toBeUpdated;
                toBeUpdated.next=this.head;
                toBeUpdated.prev=null;
                // assign the new head
                this.head=toBeUpdated;
            }                        
            return this.head.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){            
            // get the node from the map and update it
            Node toBeUpdated=map.get(key);
            // update the value of this existing node
            toBeUpdated.value=value;
            
            // now update the positon of this node in the DLL
            if(toBeUpdated==this.head){
                // no update in position if the node is already at the head
            }else if(toBeUpdated==this.tail){
                // update position if node is at the tail(least recently used)
                // changes its prev's next to null
                // and make it the new head (most recently used)
                Node prevNode=toBeUpdated.prev;
                prevNode.next=null;
                
                // assign the new tail
                this.tail=prevNode;
                
                // update the head
                this.head.prev=toBeUpdated;
                toBeUpdated.next=this.head;
                toBeUpdated.prev=null;
                // assign the new head 
                this.head=toBeUpdated;
            }else{
                // more generic if the node to be updated is in the middle
                Node prevNode=toBeUpdated.prev;
                Node nextNode=toBeUpdated.next;
                prevNode.next=nextNode;
                nextNode.prev=prevNode;
                
                this.head.prev=toBeUpdated;
                toBeUpdated.next=this.head;
                toBeUpdated.prev=null;
                // assign the new head
                this.head=toBeUpdated;
            }      
        }else{            
            // make a new node
            Node newNode=new Node(key,value,null,null);
            // update the map
            map.put(key,newNode);
            // if the DLL is empty then assign the new node as the new head
            if(this.head==null){
                this.head=newNode;
                this.tail=newNode;
                this.size++;
                return;
            }
            // if more nodes can be added then add else delete LRU node
            
            // update the head
            newNode.next=this.head;
            this.head.prev=newNode;

            // assign the new head
            this.head=newNode;

            // update the size
            this.size++;
            
            if(this.size>capacity){
                // remove lru node i.e tail node
                // since size>capacity, unlink the tail node 
                Node tailPrev=this.tail.prev;    
                tailPrev.next=null;
                // remove this tail key from map
                map.remove(this.tail.key);
                
                this.tail.prev=null;
                this.tail=tailPrev;
                // update the size 
                this.size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */