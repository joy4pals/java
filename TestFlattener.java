import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Flattener<T>{
  Iterator<List<T>> it;
  int idx = 0;
  List<T> list = null;

  Flattener(List<List<T>> vv){
    it = vv.iterator();
  }
  boolean hasNext(){
    if (it.hasNext())
      return true;
    if (list != null && idx < list.size())
      return true;
    return false;
  }
  T next(){
    if (list == null && it.hasNext()){
      list = it.next();
      idx = 0;
    }
    T ret = list.get(idx++);
    if (idx == list.size())
      list = null;
    return ret;
  }
}

public class TestFlattener{
  private <T> List<T> asList(T ...items){
    List<T> list = new ArrayList<T>();
    for (T item: items){
      list.add(item);
    }
    return list;
  }
  private <T> void printListOfLists(List<List<T>> outerList){
    System.out.print("[  ");
    for (List<T> innerList: outerList){
      for (T item: innerList)
        System.out.print(item+ " ");
    }
    System.out.println("] ");
  }
  public static void main(String[] args){
    TestFlattener test = new TestFlattener();
    List<List<Integer>> list =
      test.asList(
           test.asList(3, 4, 5),
           test.asList(1),
           test.asList(112, 23, 12, 45, 67)
        );
   //test.printListOfLists(list);


   Flattener<Integer> flattener = new Flattener<Integer>(list);
   while (flattener.hasNext()){
    System.out.print(flattener.next()+ "  ");
   }
  }
}
