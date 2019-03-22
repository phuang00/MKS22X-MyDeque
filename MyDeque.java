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
    for (int i = start; i < data.length && (start > end || (start <= end && i <= end)); i++){
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
    // if the parameter element is null, throw NullPointerException
    if (size() == data.length){
      // if the array is at its capacity
      resize();
      // call resize
    }
    if (size() != 0){
      // if size is no equal to zero
      if (start == 0){
        // and if start is equal to zero
        start = data.length - 1;
        // start is set to the last index of the data array
      }
      else{
        start--;
        // else decrease start by one
      }
    }
    data[start] = element;
    // set the value at the new start to element
    size++;
    // increase size by one
  }

  private void resize(){
    E[] temp = (E[]) new Object[size() * 2 + 1];
    // new temp array is equal to the size times two plus one (in case size is 0)
    int idx = 0;
    // int idx is set to the current index of temp (starting at 0)
    for (int i = start; i < data.length && (start > end || (start <= end && i <= end)); i++){
      // for every index from start to either the end (inclusive and if end > start)
      // or the length of the data (exclusive)
      temp[idx] = data[i];
      // copy the values over to temp such that first element is at index 0
      idx++;
      // increase current index of temp by one
    }
    if (start > end){
      // if start is greater than end
      for (int i = 0; i <= end; i++){
        // for every index between 0 and end (inclusive)
        temp[idx] = data[i];
        // copy value over, starting from where it left off in the previous loop
        idx++;
        // increase current index of temp by one
      }
    }
    data = temp;
    // data is set to the temp array
    start = 0;
    // start is set to zero
    end = size() - 1;
    // end is set to the size minus one
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    // if the parameter element is null, throw NullPointerException
    if (size() == data.length){
      // if the array is full
      resize();
      // call resize
    }
    if (size() != 0){
      // if size is not zero
      if (end == data.length - 1){
        // and if end is the last index of data
        end = 0;
        // end is set to zero
      }
      else{
        end++;
        // else end is increased by one
      }
    }
    data[end] = element;
    // value of the next end index is set to element
    size++;
    // increase size by one
  }

  public E removeFirst(){
    if (size() == 0) throw new NoSuchElementException();
    // if the size is zero, throw NoSuchElementException
    E temp = data[start];
    // the temp value to be returned is the value at the old start index of data
    if (size() != 1){
      // if the size is not one
      if (start == data.length - 1){
        // and if start is the last index of the array
        start = 0;
        // start is set to zero
      }
      else{
        start++;
        // else start is increased by one
      }
    }
    size--;
    // size decreases by one
    return temp;
    // return value that is removed
  }

  public E removeLast(){
    if (size() == 0) throw new NoSuchElementException();
    // if size is equal to zero, throw NoSuchElementException
    E temp = data[end];
    // temp is set to value at old end index of data
    if (size() != 1){
      // if size is not one
      if (end == 0){
        // and if end is equal to zero
        end = data.length - 1;
        // end is set to the last index of data
      }
      else{
        end--;
        // else end decreases by one
      }
    }
    size--;
    // size is decreased by one
    return temp;
    // return the value at the old end index of data
  }

  public E getFirst(){
    if (size() == 0) throw new NoSuchElementException();
    // if the size is zero, throw NoSuchElementException
    return data[start];
    // else return the value at index start of data (the first value)
  }

  public E getLast(){
    if (size() == 0) throw new NoSuchElementException();
    // if the size is zero, throw NoSuchElementException
    return data[end];
    // else return the value at index end of data (the last value)
  }

  public static void main(String[] args) {
    System.out.println();
    System.out.println();
    System.out.println();

    MyDeque<Integer> one = new MyDeque<Integer>(0);
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    try{
      System.out.println("First: " + one.getFirst());
    }catch (NoSuchElementException e){
      System.out.println("Catched NoSuchElementException for getFirst");
    }
    try{
      System.out.println("Last: " + one.getLast());
    }catch (NoSuchElementException e){
      System.out.println("Catched NoSuchElementException for getLast");
    }

    System.out.println();

    System.out.println("Adding 1 - 20 using addFirst");
    for (int i = 0; i < 20; i++){
      one.addFirst(20 - i);
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    System.out.println("First: " + one.getFirst());
    System.out.println("Last: " + one.getLast());
    try{
      one.addFirst(null);
    }catch (NullPointerException e){
      System.out.println("Catched NullPointerException for addFirst");
    }

    System.out.println();

    System.out.println("Adding 21 - 40 using addLast");
    for (int i = 0; i < 20; i++){
      one.addLast(21 + i);
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    System.out.println("First: " + one.getFirst());
    System.out.println("Last: " + one.getLast());
    try{
      one.addLast(null);
    }catch (NullPointerException e){
      System.out.println("Catched NullPointerException for addLast");
    }

    System.out.println();

    System.out.println("Removing 1 - 40 using removeFirst");
    for (int i = 0; i < 40; i++){
      one.removeFirst();
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    try{
      one.removeFirst();
    }catch (NoSuchElementException e){
      System.out.println("Catched NoSuchElementException for removeFirst");
    }
    try{
      one.removeLast();
    }catch (NoSuchElementException e){
      System.out.println("Catched NoSuchElementException for removeLast");
    }

    System.out.println();

    System.out.println("Adding 21 - 40 using addLast");
    for (int i = 0; i < 20; i++){
      one.addLast(21 + i);
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    System.out.println("First: " + one.getFirst());
    System.out.println("Last: " + one.getLast());

    System.out.println();

    System.out.println("Removing 31 - 40 using removeLast");
    for (int i = 0; i < 10; i++){
      one.removeLast();
    }
    System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    System.out.println("First: " + one.getFirst());
    System.out.println("Last: " + one.getLast());

    System.out.println();


    /*System.out.println("data: " + one);
    System.out.println("size: " + one.size());
    System.out.println("First: " + one.getFirst());
    System.out.println("start: " + one.start);
    System.out.println("Last: " + one.getLast());
    System.out.println("end: " + one.end);*/
  }
}
