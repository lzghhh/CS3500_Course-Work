import cs3500.tictactoe.controller.PlayerImpl;
import cs3500.tictactoe.controller.PlayerType;
import cs3500.tictactoe.controller.TTTController;
import cs3500.tictactoe.controller.TicTacToeController;
import cs3500.tictactoe.model.Piece;
import cs3500.tictactoe.model.TTTModelImpl;
import cs3500.tictactoe.model.TicTacToeModel;
import cs3500.tictactoe.my_strategies.BlockWin;
import cs3500.tictactoe.my_strategies.CompositeStrategy;
import cs3500.tictactoe.my_strategies.PlayACorner;
import cs3500.tictactoe.my_strategies.PlayFirstEmptySpot;
import cs3500.tictactoe.my_strategies.PlayHuman;
import cs3500.tictactoe.my_strategies.TryToWin;

/**
 * Created by vidojemihajlovikj on 10/29/21.
 */
public class Main {
  public static void main(String [] args){
    TicTacToeModel model = new TTTModelImpl.Builder().setHeight(3).setWidth(3).setGoal(3).build();
    TicTacToeController controler = new TTTController(model, System.out);
    controler.addPlayer(new PlayerImpl(Piece.X, new PlayHuman() ));
    controler.addPlayer(new PlayerImpl(Piece.O, new CompositeStrategy( new TryToWin(), new CompositeStrategy(new BlockWin(),
                                                new CompositeStrategy( new PlayACorner(), new PlayFirstEmptySpot())))));
    controler.play();
  }
}
