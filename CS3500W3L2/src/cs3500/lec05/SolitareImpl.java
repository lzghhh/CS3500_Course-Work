package cs3500.lec05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SolitareImpl implements ISolitare {
  private final ICard[][] board;
  private final List<ICard> deck;

  public SolitareImpl() {
    this(getRandomDeck());
  }

  public SolitareImpl(List<ICard> deck) {
    Objects.requireNonNull(deck);

    for (ICard card : deck) {
      Objects.requireNonNull(card);
    }

    this.board = new ICard[7][12];

    this.deck = new ArrayList<>();
    for (ICard card : deck) {
      this.deck.add(card);
    }

  }

  protected static List<ICard> getRandomDeck() {
    List<ICard> deck = new ArrayList<ICard>();
    return deck;
  }

  @Override
  public void move(int row, int col) {
  }

  @Override
  public String toString() {
    for (ICard card : this.deck) {
      System.out.println(card.getSuite() + "" + card.getValue());
    }
    return "";
  }
}

