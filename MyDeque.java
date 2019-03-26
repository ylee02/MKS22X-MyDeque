import java.util.NoSuchElementException;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = 0;
    size = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 0;
    size = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String toReturn = "{";
        if(size != 0){
        if(start <= end){
          for(int i = start; i<= end; i++){
            if (data[i] != null) {
              if(i != end){
                toReturn+= data[i] + " ";
              }
              else toReturn += data[i];
            }
          }
        }
        else{
          for(int i = start; i < data.length; i++){
            if (data[i] != null) {
              toReturn+= data[i] + " ";
            }
          }
          for(int i = 0; i <= end; i++){
            if (data[i] != null) {
              if(i != end && data[i] != null){
                toReturn+= data[i] + " ";
              }
              else toReturn += data[i];
            }
          }
        }
      }
      toReturn+="}";
      return toReturn;
    }

  private void resize() {
    @SuppressWarnings("unchecked")
    E[] temp = (E[])new Object[data.length * 2];
    for (int i = 0; i < size; i++) {
      if (start + i >= size) {
        temp[i] = data[i + start - data.length];
      }else {
        temp[i] = data[i + start];
      }
    }
    start = 0;
    end = size - 1;
    data = temp;
  }
  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if ((end != 0 || size > 0) && (start == end || start - 1 == end || (start == 0 && end == data.length -1))) {
      resize();
    }
    if (data[start] != null) {
      if (start == 0) {
        start = data.length - 1;
      } else {
        start--;
      }
    }
    size++;
    data[start] = element;
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if ((end != 0 || size > 0) && (start == end || start == end + 1 || (start == 0 && end == data.length -1))) {
      resize();
    }
    if (data[end] != null) {
      if (end == data.length - 1) {
        end = 0;
      } else {
        end++;
      }
    }
    size++;
    data[end] = element;
  }
  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E temp = data[start];
    if (data[start] != null) {
      data[start] = null;
      size--;
      if (start == data.length - 1) {
        start = 0;
      } else {
        start++;
      }
    }
    return temp;

  }
  public E removeLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E temp = data[end];
    if (data[end] != null) {
      data[end] = null;
      size--;
      if (end == 0) {
        end = data.length - 1;
      } else {
        end--;
      }
    }
    return temp;
  }
  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }
}
