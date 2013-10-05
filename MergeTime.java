/*
 * Suppose there are some time intervals given. If there is an intersection, then merge them
 * otherwise leave them as they are.
 */
import java.util.Arrays;

class Interval implements Comparable<Interval>{
  Integer t1, t2;
  public int compareTo(Interval interval){
    return this.t1.compareTo(interval.t1);
  }
  public Interval(Integer t1, Integer t2){
    this.t1 = t1;
    this.t2 = t2;
  }
}

class StackException extends Exception{
  StackException(){
    super();
  }
  StackException(String msg){
    super(msg);
  }
}

class Stack {

  Interval[] intervals;
  int current = -1;

  Stack(int size){
    if (size > 0)
      intervals = new Interval[size];
    else
      throw new IllegalArgumentException("Negative value given for size");
  }
  void push(Interval interval) throws StackException{
    if (current+1 < intervals.length){
      current++;
      intervals[current] = interval;
    } else
        throw new StackException("Stack Overflow");
  }
  Interval pop()throws StackException{
    Interval ret = null;
    if (current > -1){
      ret = intervals[current];
      current --;
      return ret;
    } else
        throw new StackException("Stack Underflow");
  }
  boolean isEmpty(){
    return current == -1;
  }
}

public class MergeTime{

  private void print(Interval[] intervals, String msg){
    System.out.print(msg+"\n{");
    for (int i=0; i<intervals.length; i++) {
      System.out.print("{"+intervals[i].t1+", "+intervals[i].t2+"}, ");
    }
    System.out.println("}");
  }
  private void mergeTime(int[][] intervalArr) throws StackException{
    int length  = intervalArr.length;
    Interval[] intervals = new Interval[length];
    for (int i=0; i<length; i++){
      intervals[i] = new Interval(intervalArr[i][0], intervalArr[i][1]);
    }
    print(intervals, "Before Sorting: ");
    Arrays.sort(intervals);
    print(intervals, "After sorting: ");

    Stack stack = new Stack(length);
    stack.push(intervals[0]);
    
    System.out.println("Merged times: ");
    
    for (int i=1; i<length; i++) {
      Interval interval = null;
        interval = stack.pop();
        if (interval.t2 >= intervals[i].t1){
          int t2 = (intervals[i].t2 > interval.t2) ? intervals[i].t2 : interval.t2;
          stack.push(new Interval(interval.t1, t2));
        } else {
          System.out.print("{"+interval.t1+", "+interval.t2+"}\n");
          stack.push(intervals[i]);
        }
    }
    while (!stack.isEmpty()){
      Interval interval = stack.pop();
      System.out.print("{"+interval.t1+", "+interval.t2+"}\n");
    }
  }
  public static void main(String[] args) throws StackException{
    MergeTime mt = new MergeTime();
    int[][] intervals = { {6,8}, {1,9}, {2,4}, {4,7} };
    mt.mergeTime(intervals);
    System.out.println();
    int [][]intervals2 = { {6,8},{1,3},{2,4},{4,7} };
    mt.mergeTime(intervals2);
    System.out.println();
    int[][] intervals3 = { {1,3},{7,9},{4,6},{10,13} };
    mt.mergeTime(intervals3);
  }
}
