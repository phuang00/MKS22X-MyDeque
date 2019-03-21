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
    for (int i = start; i <= end || i < data.length; i++){
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
    if (size() == data.length){
      resize();
    }
    if (size() != 0){
      if (start == 0){
        start = data.length - 1;
      }
      else{
        start--;
      }
    }
    data[start] = element;
    size++;
  }

  private void resize(){

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
    one.addFirst(5);
    one.addFirst(4);
    one.addFirst(3);
    one.addFirst(2);
    one.addFirst(1);
    one.addFirst(0);
    System.out.println(one);
  }
}
