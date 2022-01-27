package cs3500.marblesolitaire.controller;

/**
 * This is the controller of this whole Solitaire game. It plays the role as connecting the
 * information between the model and the view class. It allows the user to input command to play
 * the game.
 */
public interface MarbleSolitaireController {
  void playGame() throws IllegalStateException;
}
