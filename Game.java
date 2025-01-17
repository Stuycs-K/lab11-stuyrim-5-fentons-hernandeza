import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;
  private static final String[] fantasyNames = {
    "Eldrin",
    "Thalia",
    "Brom",
    "Lyra",
    "Dorian",
    "Kaelin",
    "Roderick",
    "Seraphina",
    "Gromm",
    "Elowen",
    "Talon",
    "Vespera",
    "Finnian",
    "Zara",
    "Korrin",
    "Mira",
    "Jareth",
    "Selene",
    "Thorne",
    "Cassandra"
};


  public static void main(String[] args) {
    run();
  }

 public static void colorRGB(int r, int g, int b) {
      System.out.print("\u001b[38;2;"+r+";"+g+";"+b+"m");
    }
  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
      int height = 30;
      int length = 80;
      for (int y = 0; y < height; y++) {
      for (int x = 0; x < length; x++) {
    //if (x == 1 || y == 1 || y == height - 1 || x == length - 1) {
       if (x == 0 || x == length - 1) {
         System.out.print("┃");
       }
       else if (y == 0 || y == height - 1 || y == 4 || y == 25 || y == 21) {
        System.out.print("━");
       }
        else {
        System.out.print(" ");
        }

       if (x == length - 1) {
       System.out.println();
       }
    //   }


      // if (x == length - 1) {
       //System.out.println();
       //}
      }
    }
    Text.go(5,0);
    System.out.print("┣");
    Text.go(5,80);
    System.out.print("┫");
    Text.go(22,0);
    System.out.print("┣");
    Text.go(22,80);
    System.out.print("┫");
    Text.go(26,0);
    System.out.print("┣");
    Text.go(26,80);
    System.out.print("┫");
    Text.go(0,0);
    System.out.print("┏");
    Text.go(30,0);
    System.out.print("┗");
    Text.go(0,80);
    System.out.print("┓");
    Text.go(30,80);
    System.out.print("┛");
  }

public static boolean startsWithIgnoreCase(String mainString,String stringToCompareTo) {
 return mainString.toLowerCase().startsWith(stringToCompareTo.toLowerCase());
}
  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner oresetf the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
 public static void TextBox(int row, int col, int width, int height, String text){
  TextBox(row, col, width, height, text, 1);
 }

 public static void TextBox(int row, int col, int width, int height, String text, int currentHeight){
    Text.go(row, col);
    if (currentHeight > height){
      throw new StringIndexOutOfBoundsException("String too long to fit in textbox");
    }
    if (text.length() > width){
      System.out.print(text.substring(0, width));
      TextBox(row + 1, col, width, height, text.substring(width), 2);
    }
    else{
      System.out.print(text);
    }
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.

    public static Adventurer createRandomAdventurer(){
      int rand = (int)(Math.random() * 3);
      int rand2 = (int)(Math.random() * 20);
      if (rand == 0)
        return new Cyborg(fantasyNames[rand2], (8 + (int)(Math.random()*5)));
      else if (rand == 1)
        return new TechPriest(fantasyNames[rand2], (8 + (int)(Math.random()*5)));
      else
        return new CodeWarrior(fantasyNames[rand2], (8 + (int)(Math.random()*5)));
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      if (party.size() == 1){
        TextBox(startRow, 38, 38, 1, party.get(0).getName());
        if (party.get(0).isDead()){
          TextBox(startRow + 1, 38, 38, 1, "DEAD");
        }
        else{
          TextBox(startRow+1, 38, 38, 1, party.get(0).getHP() + "/" + party.get(0).getmaxHP());
          TextBox(startRow+2, 39, 38, 1, party.get(0).getSpecial() + "/" + party.get(0).getSpecialMax());
        }
      }
      if (party.size() == 2){
        int k = 0;
        for (int i = 2; i < 50; i += 39){
          TextBox(startRow, i, 38, 1, party.get(k).getName());
          TextBox(startRow+1, i, 38, 1, party.get(k).getHP() + "/" + party.get(k).getmaxHP());
          TextBox(startRow+2, i, 38, 1, party.get(k).getSpecial() + "/" + party.get(k).getSpecialMax());
          k++;
        }
      }
      if (party.size() == 3){
        TextBox(startRow, 2, 38, 1, party.get(0).getName());
        TextBox(startRow+1, 2, 38, 1, party.get(0).getHP() + "/" + party.get(0).getmaxHP());
        TextBox(startRow+2, 2, 38, 1, party.get(0).getSpecial() + "/" + party.get(0).getSpecialMax());

        TextBox(startRow, 27, 38, 1, party.get(1).getName());
        TextBox(startRow+1, 27, 38, 1, party.get(1).getHP() + "/" + party.get(1).getmaxHP());
        TextBox(startRow+2, 27, 38, 1, party.get(1).getSpecial() + "/" + party.get(1).getSpecialMax());

        TextBox(startRow, 55, 38, 1, party.get(2).getName());
        TextBox(startRow+1, 55, 38, 1, party.get(2).getHP() + "/" + party.get(2).getmaxHP());
        TextBox(startRow+2, 55, 38, 1, party.get(2).getSpecial() + "/" + party.get(2).getSpecialMax());
      }
      if (party.size() == 4){
        int k = 0;
        for (int i = 2; i < 40; i += 19){
          TextBox(startRow, i, 38, 1, party.get(k).getName());
          TextBox(startRow+1, i, 38, 1, party.get(k).getHP() + "/" + party.get(k).getmaxHP());
          TextBox(startRow+2, i, 38, 1, party.get(k).getSpecial() + "/" + party.get(k).getSpecialMax());
          k++;
        }
        TextBox(startRow, 41, 38, 1, party.get(2).getName());
        TextBox(startRow+1, 41, 38, 1, party.get(2).getHP() + "/" + party.get(2).getmaxHP());
        TextBox(startRow+2, 41, 38, 1, party.get(2).getSpecial() + "/" + party.get(2).getSpecialMax());

        TextBox(startRow, 61, 38, 1, party.get(3).getName());
        TextBox(startRow+1, 61, 38, 1, party.get(3).getHP() + "/" + party.get(3).getmaxHP());
        TextBox(startRow+2, 61, 38, 1, party.get(3).getSpecial() + "/" + party.get(3).getSpecialMax());
      }
    }


  //Use this to create a colorized number string based on the % compared to the max value.

  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    if (hp / maxHP < .25){
      output = Text.colorize(output, Text.RED);
    }
    else if (hp / maxHP < .75){
      output = Text.colorize(output, Text.YELLOW);
    }
    else {
      output = Text.colorize(output, Text.WHITE);
    }
    return output;
  }




  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> enemies, ArrayList<Adventurer> party){
    colorRGB(135,206,235);
    drawBackground();

    //draw enemy party
    colorRGB(135,206,235);
    if (enemies.size() == 2){
      Text.go(0, 40);
      System.out.print("┯");
      for (int i = 2; i < 5; i++){
        Text.go(i, 40);
        System.out.print("│");
      }
      Text.go(5, 40);
      System.out.print("┷");
    }
    if (enemies.size() == 3){
      for (int x = 26; x < 80; x += 28){
        Text.go(0, x);
        System.out.print("┯");
        for (int i = 2; i < 5; i++){
          Text.go(i, x);
          System.out.print("│");
        }
        Text.go(5, x);
        System.out.print("┷");
      }
    }
    //draw player party
    if (party.size() == 2){
      Text.go(26, 40);
      System.out.print("┯");
      for (int i = 1; i < 4; i++){
        Text.go(26 + i, 40);
        System.out.print("│");
      }
      Text.go(30, 40);
      System.out.print("┷");
    }
    if (party.size() == 3){
      for (int x = 26; x < 80; x += 28){
        Text.go(26, x);
        System.out.print("┯");
        for (int i = 1; i < 4; i++){
          Text.go(26 + i, x);
          System.out.print("│");
        }
        Text.go(30, x);
        System.out.print("┷");
      }
    }
    if (party.size() == 4){
      for (int x = 20; x < 80; x += 20){
        Text.go(26, x);
        System.out.print("┯");
        for (int i = 1; i < 4; i++){
          Text.go(26 + i, x);
          System.out.print("│");
        }
        Text.go(30, x);
        System.out.print("┷");
      }
    }
    Text.reset();
    drawParty(enemies, 2);
    drawParty(party, 27);

    Text.go(30,0);
    System.out.println();
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }
  public static int grabNumber(String input) {
    int[] allTheoreticalNumbersPreviouslyDiscoveredOrNot = {0,1,2,3};
    for (int i = 0; i < input.length(); i++) {
     for (int z = 0; z < allTheoreticalNumbersPreviouslyDiscoveredOrNot.length; z++) {
  try{
     if (allTheoreticalNumbersPreviouslyDiscoveredOrNot[z] == Integer.parseInt(input.substring(i, i + 1))) {
       return allTheoreticalNumbersPreviouslyDiscoveredOrNot[z];
     }
   }
   catch (NumberFormatException e) {

   }
     }
    }
    return -100000;
   }
  public static void run(){
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    int rand = (int) (Math.random() * 3);
    if (rand == 0){
      enemies.add(new Boss());
    }
    else if (rand == 1){
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
    }
    else{
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    int rand3 = (int) Math.random() * 3;
    if (rand == 0){
      party.add(createRandomAdventurer());
    }
    if (rand == 1){
      party.add(createRandomAdventurer());
      party.add(createRandomAdventurer());
    }
    party.add(createRandomAdventurer());
    party.add(createRandomAdventurer());
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    Cyborg defaultCyborgForComparision =  new Cyborg();
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(enemies, party);//initial state.
    Text.showCursor();
    //Text.go(10,1);
    //display this prompt at the start of the game.

    while(! (startsWithIgnoreCase(input, "q") || startsWithIgnoreCase(input, "quit"))){
      //Read user input

      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){
        String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
        TextBox(23, 2, 78, 2, preprompt);
        TextBox(24, 2, 78, 2, "Input: ");

        input = userInput(in);
        //Process user input for the last Adventurer:
        if(startsWithIgnoreCase(input, "attack") || startsWithIgnoreCase(input, "a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          party.get(whichPlayer).attack(enemies.get(grabNumber(input)));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(startsWithIgnoreCase(input, "special") || startsWithIgnoreCase(input, "sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          party.get(whichPlayer).specialAttack(enemies.get(grabNumber(input)));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(startsWithIgnoreCase(input, "support") || startsWithIgnoreCase(input, "su")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          party.get(whichPlayer).support(enemies.get(grabNumber(input)));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        //drawScreen(enemies, party);
        whichPlayer++;


        if(!(whichPlayer < party.size())){
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "Press enter to see monster's turn";
          partyTurn = false;
          whichOpponent = 0;
          drawScreen(enemies, party);
          TextBox(23, 2, 78, 2, prompt);
          input = userInput(in);
        }
        //done with one party member
      }else{
        //not the party turn!

        int randNumber = (int) Math.random() * 3;
        if(randNumber == 0){
          enemies.get(whichOpponent).attack(party.get((int) Math.random() * party.size()));
        }
        else if(randNumber == 1){
          enemies.get(whichOpponent).specialAttack(party.get((int) Math.random() * party.size()));
        }
        else{
          enemies.get(whichOpponent).support(party.get((int) Math.random() * party.size()));
        }


        //Decide where to draw the following prompt:
        if (whichOpponent != 0){
          String prompt = "Press enter to see next turn";
          TextBox(23, 2, 78, 2, prompt);
          input = userInput(in);
        }
        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;  //go(32,81);

        turn++;
        partyTurn=true;
      }

      //display the updated screen after input has been processed.
      //drawScreen(enemies, party);
      drawScreen(enemies, party);

    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
