/*
 *The findPalindrome gives you the longest palindrome in a given string.
 */
class LongestPalindromeSubstring {
  void findPalindrome(String str){
     String largestPalindrome="";
     for (int i=0; i<str.length(); i++){
       for (int j=i; j<i+2; j++){
         String tmp="";
         if (j<str.length())
            tmp = eval(str, i, j);
         if (tmp.length() > largestPalindrome.length())
           largestPalindrome = tmp;
       }
     }
     System.out.println(largestPalindrome);
  }
  String eval(String str, int start, int end){

    while (start > -1 && end < str.length()){
      if (str.charAt(start) == str.charAt(end)){
          start--; 
          end++;
      } else 
          break; 
    }
    return str.substring(start+1, end);
  }
  public static void main(String[] args){
    new LongestPalindromeSubstring().findPalindrome("Animallootsfoliateddetailofstoollamina is the palindromemordnilap!!");
  }
}
