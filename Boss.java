public class Boss extends Adventurer{
//have to code the rest of this
  int necropoints, maxNecromagic;
  String elimQuote;


 public Boss(String name, int hp, String elimQuote){
    super(name,hp);
    maxNecromagic = 8;
    necropoints = maxNecromagic/2;
    elimQuote = elimQuote;
  }

  public Boss(String name, int hp){
    this(name,hp,"I am a god to you pathetic mortals");
  }

  public Boss(String name){
    this(name,20 + (int) (Math.random() * 9));
  }

  public Boss(){
    this("Vecna");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "necropoints";
  }

  public int getSpecial(){
    return necropoints;
  }

  public void setSpecial(int n){
    necropoints = n;
  }

  public int getSpecialMax(){
    return maxNecromagic;
  }

  public String attack(Adventurer other){
    int damage = ((int)((Math.random()*5) + 2)) * getAttackMultiplier();
    other.applyDamage(damage);
    killIfNecessary();
    restoreSpecial(2);
    return this + " fired a laser beam at "+ other + " and dealt "+ damage +
    " points of damage. They then let out a horrifying grin.";
  }



  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      other.applyDamage(8);
      killIfNecessary();
      return this + " used their laser barrage dealing " + damage + " points of damage and singeing their enemies";

    }else{
      return "Not enough energy to use the ultimate code. Instead "+attack(other);
    }

  }

  public String support(Adventurer other){
    other.setSleepCount((int) (Math.random() * 4));
    return getName() + " puts " + other.getName() + " to sleep.";

  }
  /*Restores 6 special and 1 hp to self.*/
  public String getType(){
    return "Boss";
  }
  public String support(){
    setSleepCount(0);
    setAttackTick(0);
    return getName() +" has restored himself by the grace of his own power.";
  }

  public String toString() {
    return "TechnoLich " + super.toString();
  }




}
