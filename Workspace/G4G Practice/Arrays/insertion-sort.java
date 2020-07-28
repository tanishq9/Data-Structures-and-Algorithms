static void insert(int arr[],int len)
  {
        int n=arr.length;
        for(int i=1;i<n;i++){
            int itemToBeCorrectlyPlaced=arr[i];
            int indexToBePlaced=i;
            for(int j=i-1;j>=0;j--){
                // finding the correct spot
                if(itemToBeCorrectlyPlaced>arr[j]){
                    break;
                }
                // continue right till we find the correct spot
                arr[j+1]=arr[j];
                indexToBePlaced=j;
            }
            arr[indexToBePlaced]=itemToBeCorrectlyPlaced;
        }
  }