public class CodeWarrior extends Adventurer{
  int caffeine, caffeineMax;
  String preferredLanguage,elimQuote;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public CodeWarrior(String name, int hp, String language, String elimQuote){
    super(name,hp);
    caffeineMax = 12;
    caffeine = caffeineMax/2;
    preferredLanguage = language;
    elimQuote = elimQuote;
  }

  public CodeWarrior(String name, int hp){
    this(name,hp,"c++", "The power of c++ compels you to leave the server of life.");
  }

  public CodeWarrior(String name){
    this(name,10 + (int) (Math.random() * 5));
  }

  public CodeWarrior(){
    this("Carmack");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "caffeine";
  }

  public int getSpecial(){
    return caffeine;
  }

  public void setSpecial(int n){
    caffeine = n;
  }

  public String getType(){
    return "CodeWarrior";
  }

  public int getSpecialMax(){
    return caffeineMax;
  }

  /*Deal 2-7 damage to opponent, restores 2 caffeine*/
  public String attack(Adventurer other){
int damage = (int) (((Math.random() * 6) + 2) * getAttackMultiplier());
    other.applyDamage(damage);
    other.killIfNecessary();
    restoreSpecial(2);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage. They then take a sip of their coffee.";
  }

  /*Deal 3-12 damage to opponent, only if caffeine is high enough.
  *Reduces caffeine by 8.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
int damage = (int) (((Math.random() * 6) + 2) * getAttackMultiplier());
      other.applyDamage(damage);
      other.killIfNecessary();
      return this + " used their "+preferredLanguage+
      " skills to hack the matrix. "+
      " This glitched out "+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough caffeine to use the ultimate code. Instead "+attack(other);
    }

  }
  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return "Gives a coffee to "+other+" and restores "
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }




    public String toString() {
      return "CodeWarrior " + super.toString();
    }

}
