public static Node construcTree(int arr[], int n)
    {
        HashMap<Integer,Node> map = new HashMap<>();
        for(int i=0;i<n;i++){
            Node newNode = new Node(i);
            map.put(i,newNode);
        }
        Node root = null;
        for(int i=0;i<n;i++){
            Node parent = map.get(arr[i]);
            Node child = map.get(i);
            if(arr[i]==-1){
                root = child;
                continue;
            }else if(parent.left==null){
                parent.left = child;
            }else if(parent.right==null){
                parent.right = child;                
            }
        }
        //System.out.println(root.data);
        return root;
    }
