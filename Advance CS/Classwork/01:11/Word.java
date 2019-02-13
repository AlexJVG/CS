public class Word{
  private int vowels;
  private int letters;
  private String word;

  public Word(String word){
    this.word = word;
    for(String each : word.split("")){
      if(each.equals("a")||each.equals("e")||each.equals("i")||each.equals("o")||each.equals("u")){
        vowels++;
      }
      letters++;
    }
  }

  public int getVowel(){
    return vowels;
  }

  public int getLetter(){
    return letters;
  }

  public String toString(){
    return word;
  }
}