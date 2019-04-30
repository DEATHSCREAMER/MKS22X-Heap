public class MyHeap{
  public static void pushDown(int[]data,int size,int index){
    int node = index+1;
    if (node*2 <= size){
      if (node*2+1 <= size){
        if (data[index] < data[node*2] || data[index] < data[node*2-1]){
          if (data[node*2] > data[node*2-1]){
            swap(data,index,node*2);
            //pushDown(data,size,index);
            pushDown(data,size,node*2);
          }
          else{
            swap(data,index,node*2-1);
            //pushDown(data,size,index);
            pushDown(data,size,node*2-1);
          }
        }
      }
      else if (data[index] < data[node*2-1]){
        swap(data,index,node*2-1);
        pushDown(data,size,node*2-1);
      }
    }
  }
  private static void swap(int[] data,int first, int second){
    int temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }

  public static void pushUp(int[]data,int index){
    int node = index+1;
    if (node != 1 && data[index] > data[node/2-1]){
      swap(data,index,node/2-1);
      pushUp(data,node/2-1);
    }
  }

  public static void heapify(int[] data){
    for (int i = 0 ; i < data.length ; i++){
      pushUp(data,i);
    }
  }

  public static void heapsort(int[] data){
    heapify(data);
    for (int size = data.length ; size > 0 ; size--){
      swap(data,0,size-1);
      pushDown(data,size-1,0);
      //System.out.println(size + "\n" +driver.ary(data));
    }
  }

}
