/*
 * For each given word, can you help the king in figuring 
 * out if any anagram of it can be a palindrome or not?.
 */
import java.util.Scanner;

public class PalindromeAnagram {

  String text;
  
  void getAllPermutations(){
    int[] alpha = new int[26];
    for (int i=0; i<text.length(); i++)
      alpha[text.charAt(i)-'a']++;
    
    int countOdds = 0;
    for (int i: alpha){
      if ((i & 1) == 1)
        countOdds++;
      if (countOdds == 2)
        break;
    }
    if (countOdds < 2)
      System.out.println("YES");
    else 
      System.out.println("NO");
  }
  public static void main(String[] args){
    PalindromeAnagram pa = new PalindromeAnagram();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter something");
    String input = scanner.next();
    pa.text = input;
    pa.getAllPermutations();
  }
}
