public class TechPriest extends Adventurer{
  int caffeine, caffeineMax;
  String preferredLanguage;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public TechPriest(String name, int hp, String language){
    super(name,hp);
    caffeineMax = 12;
    caffeine = caffeineMax/2;
    preferredLanguage = language;
  }

  public TechPriest(String name, int hp){
    this(name,hp,"c++");
  }

  public TechPriest(String name){
    this(name,24);
  }

  public TechPriest(){
    this("Carmack");
  }

}