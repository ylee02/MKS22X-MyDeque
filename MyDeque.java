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
    return data.length;
  }
  public String toString(){ }

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
    if ((end != 0 || size > 0) && (start == end || start - 1 == end || (start == 0 && end = data.length -1)) {
      resize();
    }
    if (data[start] != null) {
      if (start == 0) {
        start = data.length - 1;
      } else {
        start--;
      }
    }
    size++
    data[start] = element;
  }

  public void addLast(E element){
    if ((end != 0 || size > 0) && (start == end || start == end + 1 || (start == 0 && end = data.length -1)) {
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
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
