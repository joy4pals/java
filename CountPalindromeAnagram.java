/*
 * For each given word, the king needs to find out the
 * number of anagrams of the string which are palindromes.
 * As the number of anagrams can be large, the king needs
 * number of anagrams % (109+ 7).
 */
import java.util.Scanner;
import java.math.BigInteger;

public class CountPalindromeAnagram {

  String text;
  private static final int MODVAL = 1000000007;

  long fact(long n){
    long fact = 1;
    if (n < 2)
      return 1;
    for (int i=1;i<=n; i++)
      fact = (fact * i)%MODVAL;

    return fact;
  }

  void getAllPermutations(){
    int[] alpha = new int[26];
    for (int i=0; i<text.length(); i++)
      alpha[text.charAt(i)-'a']++;

    long perm = 1;
    long sum = 0;

    for (int i=0; i<alpha.length; i++)
      alpha [i] /= 2;

    for (int i: alpha){
      perm = (perm*fact(i))%MODVAL ;
      sum += i;
    }

    System.out.println(fact(sum) * BigInteger.valueOf(perm).
          modInverse(BigInteger.valueOf(MODVAL)).longValue() % MODVAL);
  }
  public static void main(String[] args){
    CountPalindromeAnagram pa = new CountPalindromeAnagram();
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    pa.text = input;
    pa.getAllPermutations();
  }
}
