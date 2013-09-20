class CircularBuffer<T>{
  private T[] list;
  public static final int MAX_CAP = 21;
  private int capacity;
  private int head = -1;
  private int tail = -1;
  private int data_count = 0;

  public CircularBuffer() throws IllegalArgumentException{
    this(MAX_CAP);
  }
  public CircularBuffer(int cap) throws IllegalArgumentException{
    if (cap > MAX_CAP)
      throw new IllegalArgumentException("Capacity: " +cap +" is greater than MAX value: "+
          +MAX_CAP);
    this.capacity = cap;
    list = (T []) new Object[capacity];
  }

  public void push(T element){
    tail = (tail+1) % capacity;
    list[tail] = element;
    if (data_count < capacity)
      data_count++;
  }

  public T pop(){
    if (data_count > 0){
      head = (head+1) % capacity;
      data_count--;

      return list[head];
    }
    return null;
  }

  public int size(){
    return data_count;
  }

  public boolean isEmpty(){
    return data_count == 0;
  }

}
public class MyCircularBuffer{

  public static void main (String[] args){
    MyCircularBuffer b = new MyCircularBuffer();

    CircularBuffer<Integer> buf = new CircularBuffer<Integer>(5);
    //pop an empty buffer
    System.out.println(buf.pop());
    //lets feed some data
    buf.push(3);
    System.out.println(buf.pop());
    System.out.println(buf.isEmpty());


    buf.push(3);
    buf.push(4);
    buf.push(5);
    buf.push(6);
    buf.push(7);
    //the next input should overwrite the first insert: 3. Therefore the first element
    //popped should be 9 and not 3
    buf.push(9);

    System.out.println(buf.pop());
    System.out.println(buf.pop());
    System.out.println(buf.pop());
    System.out.println(buf.pop());
    System.out.println(buf.pop());
    System.out.println(buf.pop());
  }
}

