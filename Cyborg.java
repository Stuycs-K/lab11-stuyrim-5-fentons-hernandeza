public class Cyborg extends Adventurer{
  int charge, maxCharge;
  String elimQuote;
    /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Cyborg(String name, int hp, String elimQuote){
    super(name,hp);
    maxCharge = 8;
    charge = maxCharge/2;
    elimQuote = elimQuote;
  }

  public Cyborg(String name, int hp){
    this(name,hp,"Error: Opponent no longer exists. Your data has been deleted");
  }

  public Cyborg(String name){
    this(name,8 + (int) (Math.random() * 5));
  }

  public Cyborg(){
    this("Victor Stone");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "charge";
  }

  public int getSpecial(){
    return charge;
  }

  public void setSpecial(int n){
    charge = n;
  }

  public int getSpecialMax(){
    return maxCharge;
  }

  public String attack(Adventurer other){
    setHP(getHP() + 2);
    int damage = (int)((Math.random()*3) + 3);
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " hard punched "+ other + " and dealt "+ damage +
    " points of damage. They then clank their gauntlets together.";
  }



  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int damage = 3 + (int) (2 * Math.random()) * getAttackMultiplier();
      other.applyDamage(damage);

      return this + " used their laser barrage dealing " + damage + " points of damage and singing their enemies";

    }else{
      return "Not enough energy to use the ultimate code. Instead "+attack(other);
    }

  }


  /*Restores 5 special to other*/
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
