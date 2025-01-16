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
    setHP(getHP() + 2);
    int damage = (int)((Math.random()*3) + 3);
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " hard punched "+ other + " and dealt "+ damage + // IMPORTANT THIS IS CYBORG CODE FIX LATER
    " points of damage. They then clank their gauntlets together.";
  }



  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int damage = 3 + (int) (2 * Math.random()) * getAttackMultiplier();
      other.applyDamage(damage);

      return this + " used their laser barrage dealing " + damage + " points of damage and singing their enemies"; //SAME FOR THIS

    }else{
      return "Not enough energy to use the ultimate code. Instead "+attack(other);
    }

  }
  public String getType(){
    return "TechPriest";
  }


  public String support(Adventurer other){
    setHP(getHP() + 2);
    other.setAttackTick(getAttackTick() + 1);
    return getName() + " says kill them for me "+other+" and buffs his attack substantially ";
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    setHP(getHP() + 2);
    setAttackTick(getAttackTick() + 1);
    return getName() +" says fine I'll do it myself and significantly boosts their own attack power.";
  }
}
