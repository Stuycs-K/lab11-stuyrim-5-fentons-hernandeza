import java.util.Random;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP,attackTicker, bleedCount,sleepCount;
  private double attackMultiplier;
  private boolean dead;

  //Abstract methods are meant to be implemented in child classes.
  /*
  all adventurers must have a custom special
  consumable resource (mana/rage/money/witts etc)
  */

  //give it a short name (fewer than 13 characters)
  public abstract String getSpecialName();
  //accessor methods
  public abstract int getSpecial();
  public abstract int getSpecialMax();
  public abstract void setSpecial(int n);
  public abstract String getType();

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()
  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
    return n;
  }

  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(Adventurer other);

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public abstract String support(Adventurer other);

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);

  /*
  standard methods
  */

  public void applyDamage(int amount){
    if (this.HP - amount < 0){
      this.HP = 0;
    }
    else{
    this.HP -= amount;
    }
  }

  public boolean isDead(){
    return dead;
  }
  //You did it wrong if this happens.
  public Adventurer(){
    this("Lester-the-noArg-constructor-string");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
    this.attackTicker = 0;
    this.attackMultiplier = (1 + (1 / 2) * getAttackTick());
    this.dead = false;
  }

  //toString method
  public String toString(){
    return (this.getName());
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getAttackTick() {
  return attackTicker;
  }

  public double getAttackMultiplier() {
  return attackMultiplier;
  }


  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }
  public void setmaxHP(int newMax){
    maxHP = newMax;
  }

public boolean dead() {
  return dead;
}


  public int getBleedCount() {
  return bleedCount;
  }

public int getSleepCount() {
return sleepCount;
}

  //Set Methods

  public static String triggerBleed(Adventurer other) {
  other.applyDamage(other.getBleedCount());
  return other + " takes " + other.getBleedCount() + " points of persistant bleed damage.";
  }

 public void setBleedCount(int newBleedCount) {
  this.bleedCount = newBleedCount;
  }

  public void setHP(int health){
    this.HP = health;
  }

  public void setAttackTick(int newAttackTicker) {
    this.attackTicker = newAttackTicker;
    this.attackMultiplier = 1 + (.5 * getAttackTick());
  }

public void setSleepCount(int newSleepCount) {
this.sleepCount = newSleepCount;
}

  public void setName(String s){
    this.name = s;
  }

  public void setDeathStatus(boolean a) {
    this.dead = a;
  }

  public void killIfNecessary() {
    if (getHP() == 0) {
      setDeathStatus(true);
    }
  }
}
