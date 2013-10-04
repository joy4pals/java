public class Quicksort{
  int arr[];
  private void sort(int p, int r){
    if (p < r){
      int q = partition(p, r);
      sort (p, q-1);
      sort (q+1, r);
    }
    return;
  }
  private void swap(int x, int y){
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }
  private int partition(int p, int r){
    int i = p-1;
    int x = arr[r];
    for (int j=p; j<r; j++){
      if (arr[j] <= x){
        i++;
        swap(i, j);
      }
    }
    swap(i+1, r);
    return i+1;
  }
  private Integer ithOrderStatistic(int p, int r, int i){
    if (p == r)
      return arr[p];
    int q = partition(p, r);
    int k = q-p;
    System.out.println("p="+p+" r="+r+" q= "+q + " i="+i+"  k="+k);
    if (k == i)
      return arr[q];
    if (i<k)
      return ithOrderStatistic(p, q-1, i);
    else
      return ithOrderStatistic(q+1, r, i-k-1);
  }
  private void printArr(String msg){
    System.out.println(msg);
    for (int i: arr)
      System.out.print(i+"  ");
    System.out.println();
  }
  public static void main(String[] args){
    Quicksort qs = new Quicksort();
    qs.arr = new int[]{4,5,1,2,9,5,6,2,2};
    //qs.printArr("Before Sort: ");
    //qs.sort(0, qs.arr.length-1);
    //qs.printArr("After Sort: ");
    System.out.println(qs.ithOrderStatistic(0, qs.arr.length-1, 5));
  }
}
