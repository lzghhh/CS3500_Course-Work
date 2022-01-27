package cs3500.lec05;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String [] args) {
    List<ICard> myDeck = new ArrayList<>();
    myDeck.add(new Card(Value.ACE, Suite.DIAMOND));
    myDeck.add(new Card(Value.QUEEN, Suite.CLUB));
    ISolitare model = new SolitareImpl(myDeck);

    myDeck.clear();
    System.out.println(model.toString());
  }
}
