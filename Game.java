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
    drawBackground();
    try{
    TextBox(3, 4, 2, 5, "AAADGAAAAAAAaHUIA");
    }catch(Exception e){
      System.out.print(e);
    }
    //run();
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
       else if (y == 0 || y == height - 1 || y == 4 || y == 25) {
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
        Text.go(startRow, 34);
        System.out.print(party.get(0));
      }
      if (party.size() == 2){
        Text.go(startRow, 2); // need textbox working for this
        System.out.print(party.get(0));
        Text.go(startRow, 41);
        System.out.print(party.get(1));
      }
      if (party.size() == 3){
        Text.go(startRow, 2);
        System.out.print(party.get(0));
        Text.go(startRow, 27);
        System.out.print(party.get(1));
        Text.go(startRow, 55);
        System.out.print(party.get(2));
      }
      if (party.size() == 4){
        Text.go(startRow, 2);
        System.out.print(party.get(0));
        Text.go(startRow, 21);
        System.out.print(party.get(1));
        Text.go(startRow, 41);
        System.out.print(party.get(2));
        Text.go(startRow, 61);
        System.out.print(party.get(3));
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
      enemies.add(new Boss("The Lich King", 20 + (int)(Math.random() * 9)));
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

    //Main loop
    /*
    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*
        }
        else if((input.equals("special") || input.equals("sp"))){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        //}
        
        
        //else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices 	 here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;  //go(32,81);

        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen();

    }//end of main game loop


    //After quit reset things:
    quit();
 */
  }
}
