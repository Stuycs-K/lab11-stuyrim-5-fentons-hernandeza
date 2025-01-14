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

  /*Deal 2-7 damage to opponent, restores 2 caffeine*/
  public String attack(Adventurer other){
    int damage = (int)((Math.random()*6)+2);
    other.applyDamage(damage);
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
      int damage = (int)((Math.random()*5+Math.random()*5)+3) * getAttackMultiplier();
      other.applyDamage(damage);
      return this + " used their "+elimQuote+
      " skills to hack the matrix. "+
      " This glitched out "+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough caffeine to use the ultimate code. Instead "+attack(other);
    }

  }
  /*Restores 5 special to other*/
  public String support(Adventurer other){
    setAttackTick(getAttackTick() + 1);
    return "Kill them for me "+other+" and buffs his attack substantially ";
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }







}
