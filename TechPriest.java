public class TechPriest extends Adventurer{
  int mana, manaMax;
  String elimQuote;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public TechPriest(String name, int hp, String elimQuote){
    super(name,hp);
    manaMax = 12;
    mana = manaMax/2;
    elimQuote = elimQuote;
  }

  public TechPriest(String name, int hp){
    this(name,hp,"By the power of the omnissiah");
  }

  public TechPriest(String name){
    this(name,8 + (int) (Math.random() * 5));
  }

  public TechPriest(){
    this("Ferrus Vivek");
  }

  public String getSpecialName(){
    return "mana";
  }

  public int getSpecial(){
    return mana;
  }

  public void setSpecial(int n){
    mana = n;
  }

  public int getSpecialMax(){
    return manaMax;
  }

public String attack(Adventurer other){
//set attack ticker to -1 and then reset attack ticker at the time
    other.setBleedCount(other.getBleedCount() + 1);
    other.setAttackTick(other.getAttackTick() - 1);
    //other.setAttackMultiplier();
    restoreSpecial(2);
return this + " hacks " + other.getName() + " and causes them to bleed, reducing their attack power and making them take persistant damage.";
  }



  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int sleepturns = (int) (Math.random() * 3) + 2;
      setSleepCount(sleepturns);

      return this + " delievered  a hack, putting " + other + " to sleep for " + sleepturns ; //SAME FOR THIS

    }else{
      return "Not enough mana to hack the opponent. Instead "+attack(other);
    }

  }
  public String getType(){
    return "TechPriest";
  }


  public String support(Adventurer other){
  int newHP = getHP() + (int) (Math.random() * 5) + 3;
    other.setHP(newHP);
    return this + " heals " + other + " to " + newHP + ".";
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
  int newHP = getHP() + (int) (Math.random() * 5) + 4;
    setHP(newHP);
    return this + "heals themselves to " + newHP;
  }
  public String toString() {
    return "TechPriest " + super.toString();
  }
}
