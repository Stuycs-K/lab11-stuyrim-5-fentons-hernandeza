public class Cyborg extends Adventurer{
  int caffeine, caffeineMax;
  String preferredLanguage;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Cyborg(String name, int hp, String language){
    super(name,hp);
    caffeineMax = 12;
    caffeine = caffeineMax/2;
    preferredLanguage = language;
  }

  public Cyborg(String name, int hp){
    this(name,hp,"c++");
  }

  public Cyborg(String name){
    this(name,24);
  }

  public Cyborg(){
    this("Carmack");
  }

}