/*
 * Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given numbers are {54, 546, 548, 60}, 
 * the arrangement 6054854654 gives the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 
 * 998764543431 gives the largest value.
 */
import java.util.Arrays;
import java.util.Comparator;

class ArrangeToBeLargest {
  public static void main(String[] args){
    Integer[] arr = {1, 34, 3, 98, 9, 76, 45, 4};
    for (Integer i: arr)
      System.out.print(i+"  ");
    Arrays.sort(arr, new Comparator<Integer>(){
      @Override
      public int compare(Integer x, Integer y){
        String xs = Integer.toString(x);
        String ys = Integer.toString(y);
        String xy = xs+ys;
        String yx = ys+xs;
        return 0 - xy.compareTo(yx);
      }
    });
      System.out.println();
    for (Integer i: arr)
      System.out.print(i+"  ");
  }
}
