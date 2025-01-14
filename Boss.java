public class Boss extends Adventurer{
  int caffeine, caffeineMax;
  String preferredLanguage;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Boss(String name, int hp, String language){
    super(name,hp);
    caffeineMax = 12;
    caffeine = caffeineMax/2;
    preferredLanguage = language;
  }

  public Boss(String name, int hp){
    this(name,hp,"c++");
  }

  public Boss(String name){
    this(name,24);
  }

  public Boss(){
    this("Carmack");
  }

}