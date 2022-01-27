package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class is used to represent the string image of this game.
 */

public class MarbleSolitaireTextView extends AbstractMarbleSolitaireView {

  /**
   * This Constructor is used to generate a string image from the
   * received MarbleSolitaireModelState.
   * @param state A string image of a MarbleSolitaireModelState.
   */

  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable appendable) {
    super(state, appendable);
  }

  public MarbleSolitaireTextView(MarbleSolitaireModelState state) {
    super(state);
  }

}
