@SuppressWarnings("unchecked")

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    data = (E[])new Object[10];
  }

  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
  }

  public int size(){
    return size;
  }

  public String toString(){
    if (start == end) return "{}";
    String ans = "{";
    for (int i = start; i <= end || i < size; i++){
      ans += data[i];
      if (i != end) ans += " ";
      else ans += "}";
    }
    if (start > end){
      for (int i = 0; i <= end; i++){
        ans += data[i];
        if (i != end) ans += " ";
        else ans += "}";
      }
    }
    return ans;
  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(){
    return data[0];
  }

  public E removeLast(){
    return data[0];
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

  public static void main(String[] args) {
    MyDeque<Integer> one = new MyDeque<Integer>(100);
    System.out.println(one);
  }
}
