import java.util.*;
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
    E[] temp = (E[]) new Object[size() * 2 + 1];
    System.out.println("temp: " + Arrays.toString(temp));
    int idx = 0;
    for (int i = start; i <= end || i < data.length; i++){
      temp[idx] = data[i];
      idx++;
    }
    if (start > end){
      for (int i = 0; i <= end; i++){
        temp[idx] = data[i];
        idx++;
      }
    }
    data = temp;
    start = 0;
    end = size() - 1;
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
    MyDeque<Integer> one = new MyDeque<Integer>();
    for (int i = 0; i < 50; i++){
      one.addFirst(50 - i);
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    System.out.println("First: " + one.getFirst());
    System.out.println("Last: " + one.getLast());
  }
}
