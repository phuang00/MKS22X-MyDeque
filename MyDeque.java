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
    if (size() == 0) return "{}";
    String ans = "{";
    for (int i = start;(start > end && i < data.length) || (start <= end && i <= end); i++){
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
    if (size() == data.length){
      resize();
    }
    if (size() != 0){
      if (end == data.length - 1){
        end = 0;
      }
      else{
        end++;
      }
    }
    data[end] = element;
    size++;
  }

  public E removeFirst(){
    if (size() == 0) throw new NoSuchElementException();
    E temp = data[start];
    if (size() != 1){
      if (start == data.length - 1){
        start = 0;
      }
      else{
        start++;
      }
    }
    size--;
    return temp;
  }

  public E removeLast(){
    if (size() == 0) throw new NoSuchElementException();
    E temp = data[end];
    if (size() != 1){
      if (end == 0){
        end = data.length - 1;
      }
      else{
        end--;
      }
    }
    size--;
    return temp;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

  public static void main(String[] args) {
    System.out.println();
    System.out.println();
    System.out.println();

    MyDeque<Integer> one = new MyDeque<Integer>();
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());

    System.out.println();

    System.out.println("Adding 1 - 20 using addFirst");
    for (int i = 0; i < 20; i++){
      one.addFirst(20 - i);
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());

    System.out.println();

    System.out.println("Adding 21 - 40 using addLast");
    for (int i = 0; i < 20; i++){
      one.addLast(21 + i);
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());

    System.out.println();

    System.out.println("Removing 1 - 40 using removeFirst");
    for (int i = 0; i < 40; i++){
      one.removeFirst();
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());

    System.out.println();

    System.out.println("Adding 21 - 40 using addLast");
    for (int i = 0; i < 20; i++){
      one.addLast(21 + i);
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());

    System.out.println();

    System.out.println("Removing 31 - 40 using removeLast");
    for (int i = 0; i < 10; i++){
      one.removeLast();
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());

    System.out.println();


    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    System.out.println("First: " + one.getFirst());
    System.out.println("start: " + one.start);
    System.out.println("Last: " + one.getLast());
    System.out.println("end: " + one.end);
  }
}
