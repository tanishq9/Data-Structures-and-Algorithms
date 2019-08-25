
/*You are required to complete below class */
class LRUCache {
    class Node {
		Node front;
		Node back;
		int key;
		int val;

		Node(Node ifront, Node iback, int ikey, int ival) {
			this.front = ifront;
			this.back = iback;
			this.key = ikey;
			this.val = ival;
		}
	}

	HashMap<Integer, Node> map = new HashMap<>();

	Node head;
	Node tail;
	int size;
	int limit;

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       	// Initialize the head and tail nodes
		this.head = new Node(this.tail, null, -1, -1);
		this.tail = new Node(null, this.head, -1, -1);
		this.head.front = this.tail; // Imp. because it'll reinitialize front of head which was earlier set to null
		this.size = 0;
		this.limit = N; // Maximum cache size
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
        int key=x;
       	if (map.containsKey(key)) {
			// Bring updated Node to the front as it the most recently used
			Node toBeUpdated = map.get(key);
			// Change the ordering of previous front and back of node to be updated
			Node frontOfTBU = toBeUpdated.front;
			Node backOfTBU = toBeUpdated.back;
			backOfTBU.front = frontOfTBU;
			frontOfTBU.back = backOfTBU;
			// Now move the node to the front
			Node earlierMRU = this.head.front;
			this.head.front = toBeUpdated;
			earlierMRU.back = toBeUpdated;
			toBeUpdated.front = earlierMRU;
			toBeUpdated.back = this.head;
			return map.get(key).val;
		} else {
			// Item not present
			return -1;
		}
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
       //Your code here
        int key = x;
	    int value = y;
		// Add/Update
		if (map.containsKey(key)) {
			// Bring updated Node to the front as it the most recently used
			Node toBeUpdated = map.get(key);
			// Change the ordering of previous front and back of node to be updated
			Node frontOfTBU = toBeUpdated.front;
			Node backOfTBU = toBeUpdated.back;
			backOfTBU.front = frontOfTBU;
			frontOfTBU.back = backOfTBU;
			// Now move the node to the front
			Node earlierMRU = this.head.front;
			this.head.front = toBeUpdated;
			earlierMRU.back = toBeUpdated;
			toBeUpdated.front = earlierMRU;
			toBeUpdated.back = this.head;
			// Update the value of new Node
			toBeUpdated.val = value;
		} else {
			// Form a new Node
			Node newNode = new Node(null, null, key, value);
			// Add at the beginning , since it the least recently used
			Node earlierRU = this.head.front;
			this.head.front = newNode;
			newNode.front = earlierRU;
			newNode.back = this.head;
			earlierRU.back = newNode;
			this.size++;
			// Check for elimination
			if (this.size > this.limit) {
				// Eliminate the least recently used
				Node lru = this.tail.back;
				Node lru2nd = lru.back;
				lru2nd.front = this.tail;
				this.tail.back = lru2nd;
				this.size--;// Due to elimination
				map.remove(lru.key); // Remove from the map
			}
			map.put(key, newNode); // Add to Map
		}
    }
}
