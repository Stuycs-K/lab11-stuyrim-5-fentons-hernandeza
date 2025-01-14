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
    int damage = (int)((Math.random()*5) + 2);
    other.applyDamage(damage);
    killIfNecessary();
    restoreSpecial(2);
    return this + " fired a laser beam at "+ other + " and dealt "+ damage +
    " points of damage. They then let out a horrifying grin.";
  }



  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int damage = 3 + (int) (2 * Math.random()) * getAttackMultiplier();
      other.applyDamage(damage);
      killIfNecessary();
      return this + " used their laser barrage dealing " + damage + " points of damage and singeing their enemies";

    }else{
      return "Not enough energy to use the ultimate code. Instead "+attack(other);
    }

  }
  public String toString() {
    return "TechnoLich " + super.toString();
  }

  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return getName() + " says kill them for me "+other+" and buffs his attack substantially ";

  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){

    return getName() +" says fine I'll do it myself and significantly boosts their own attack power.";
  }

  public String toString() {
    return "TechnoLich " + super.toString();
  }




}
