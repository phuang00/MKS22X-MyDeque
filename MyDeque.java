import java.util.*;
@SuppressWarnings("unchecked")

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    data = (E[])new Object[10];
    // initialize data array with default capacity of 10
  }

  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    // initialize data array with a capacity of initialCapacity
  }

  public int size(){
    return size;
    // return the size
  }

  public String toString(){
    if (size() == 0) return "{}";
    // if the size is zero, return empty brackets
    String ans = "{";
    // start the ans String with open brackets
    for (int i = start;(start > end && i < data.length) || (start <= end && i <= end); i++){
      // for every index from start to either the end (inclusive and if end > start)
      // or the length of the data (exclusive)
      ans += data[i];
      // add the value at the index to ans
      if (i != end) ans += " ";
      // if the index is not end, add a space after the value
      else ans += "}";
      // else add closing brackets
    }
    if (start > end){
      // if start is greater than end
      for (int i = 0; i <= end; i++){
        // for every index between 0 and end (inclusive)
        ans += data[i];
        // add the value at the index to ans
        if (i != end) ans += " ";
        // if index is not end, add a space after the value
        else ans += "}";
        // else add closing brackets
      }
    }
    return ans;
    // return String ans
  }

  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
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
    if (element == null) throw new NullPointerException();
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
    if (size() == 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if (size() == 0) throw new NoSuchElementException();
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
