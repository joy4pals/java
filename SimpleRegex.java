/*
 *A very simple regex class written in java. This recognized some of the basic regex symbols
 *such as *, ^,$,. and characters.
 *For a given regex and a string if there is  a match it prints the true or false otherwise.
 *I shall try to improve it to return the index to the start of teh match
 */
class RegexSearch{

  private boolean search(String regex, String text){
    //System.out.println(text);
    if (regex.charAt(0)=='^')
      return matcher(regex.substring(1), text);
    do{
      if (matcher(regex, text))
        return true;
      text = text.substring(1);
    }while (text.length() >0 );
    return false;
  }
  private boolean matcher(String regex, String text){
    if (regex.length() == 0)
      return true;
    if (regex.length()>1 && regex.charAt(1) == '*')
      return matchStar(regex.charAt(0), regex.substring(2), text);
    if (regex.charAt(0) == '$' && regex.length()==1)
      return text.length() == 0;
    if (text.length()>0 && (text.charAt(0) == regex.charAt(0) || regex.charAt(0) == '.'))
      return matcher(regex.substring(1), text.substring(1));
    return false;
  }
  private boolean matchStar(char ch, String regex, String text){
    do{
      if (matcher(regex, text))
        return true;
    }while (text.length()>0 &&  (text.charAt(0) == regex.charAt(0) || regex.charAt(0) == '.'));
  return false;
  }
  public static void main(String[] args){
    RegexSearch rs = new RegexSearch();
    System.out.println( rs.search("^ab*", "abcdef") );
    System.out.println( rs.search("ab*", "gdjkaabcdef") );
    System.out.println( rs.search("ab.de", "gdjkaabcdef") );
    System.out.println( rs.search("def$", "gdjkaabcdef") );
  }
}
