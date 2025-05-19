
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(){
      player1 = new Player();
      player2 = new Player();
    }

    public void setFirstPlayer(){
        if (Math.random() > .5){
            currentPlayer = player1;
        } else{
            currentPlayer = player2;
        }
    }

    public void switchPlayer(){
      if(currentPlayer == player1){
          currentPlayer= player2;
        } else{
          currentPlayer = player1;
        }
  }

    public void play(){
      setFirstPlayer();

      while(Board.getPileSize() > 1){
        System.out.println("It is " + currentPlayer.getName() + "'s turn");
        System.out.println(Board.getPileSize());
        Board.takePieces();
        switchPlayer();

      }

      endGame();
      

    }
    
    public void endGame(){
      if(currentPlayer == player1){
        System.out.println(player2.getName() + " wins!");
        player2.updateScore(1);
      } else {
        System.out.println(player1.getName() + " wins!");
        player1.updateScore(1);
      }

      System.out.println(player1.getName() + "'s score is " + player1.getScore());
      System.out.println(player2.getName() + "'s score is " + player2.getScore());


      System.out.println("Do you want to play again?");
      Scanner sc = new Scanner(System.in);
      String answer = sc.nextLine();
      
      
      if (answer.equals ("yes")){
        Board.populate();
        play();
      }

    }

    
   

}