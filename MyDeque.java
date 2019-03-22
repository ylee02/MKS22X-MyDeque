public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = 0;
    size = 10;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 0;
    size = initialCapacity;
  }
  public int size(){
    return data.length;
  }
  public String toString(){ }

  private void resize() {
    int[] temp = new int[size * 2];
    for (int i = 0; i < size; i++) {
      if (start + i >= size) {
        temp[i] = data[i + start - data.length];
      }else {
        temp[i] = data[i + start];
      }
    }
    data = temp;
  }
  public void addFirst(E element){
    if (end != 0 && start == end) {
      resize();
    }
  }
  public void addLast(E element){
  }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
