package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import java.util.ArrayList;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

/**
 * This class is to test all methods in the EnglishSolitaireModel.
 */

public class EnglishSolitaireModelTest {
  EnglishSolitaireModel model1;
  MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
  MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;
  MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;


  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelSmallerArm() {
    new EnglishSolitaireModel(1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelEvenArm() {
    new EnglishSolitaireModel(4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelNegativeArm() {
    new EnglishSolitaireModel(-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidCenterLeftUp() {
    new EnglishSolitaireModel(3,0,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidCenterLeftDown() {
    new EnglishSolitaireModel(3,5,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidCenterRightUp() {
    new EnglishSolitaireModel(3,5,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidCenterFree() {
    new EnglishSolitaireModel(-1,-2);
  }


  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidArm() {
    new EnglishSolitaireModel(8);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidCenterRightDown() {
    new EnglishSolitaireModel(3,6,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidCenterNegativeSingle() {
    new EnglishSolitaireModel(3,-6,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEnglishSolitaireModelInvalidCenterNegativeBoth() {
    new EnglishSolitaireModel(3,-2,-1);
  }

  boolean layoutStringChecker(EnglishSolitaireModel model,
                              ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board) {
    boolean result = true;
    for (int i = 0; i < model.getBoardSize(); i++) {
      for (int k = 0; k < model.getBoardSize(); k++) {
        result = result && (model.getSlotAt(i,k) == board.get(i).get(k));
      }
    }
    return result;
  }

  @Test
  public void EnglishSolitaireModelayoutCheckerSize3Center() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EnglishSolitaireModelayoutCheckerSize3NoCenter() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(3,2,2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,empty,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EnglishSolitaireModelayoutCheckerSize3CenterFree() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(2,2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,empty,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EnglishSolitaireModelayoutCheckerSize3CenterFalse() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertFalse(layoutStringChecker(model, board));
  }

  @Test
  public void EnglishSolitaireModelayoutCheckerSize5Center() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,empty,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EnglishSolitaireModelayoutCheckerSize5CenterFalse() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,empty,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,invalid,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble, marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,empty,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,invalid,invalid,invalid,marble,marble,marble,
                                    marble,marble,invalid,invalid, invalid,invalid))
            ));
    assertFalse(layoutStringChecker(model, board));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoInvalid() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(0,0,0,2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoInvalidDis1() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(0,0,1,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoEmpty() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(0,2,0,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoMarble() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,1,3,3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoMarbleVertical() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,1,3,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoInvalid() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(0,3,0,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoInvalidVertical() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(4,1,6,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoMarble() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(0,3,0,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoMarbleVertical() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(0,3,2,3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoEmptyEmptybetweenTwo() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(3,5,3,3);
    model.move(3,6,3,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoEmptyEmptybetweenTwoVertical() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(3,5,3,3);
    model.move(1,4,3,4);
    model.move(0,4,2,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoMarbleEmptybetweenTwoVertical() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(3,5,3,3);
    model.move(2,4,4,4);
  }

  @Test
  public void testmoveVerticalDown() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,3,3,3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveVerticalUp() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveHorizontalRight() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,empty,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveHorizontalLeft() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    model.move(3,4,3,2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,marble,empty,empty,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveHorizontalLeft1() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    model.move(3,4,3,2);
    model.move(3,6,3,4);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,marble,empty,marble,empty,empty)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveVerticalUp1() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    model.move(3,4,3,2);
    model.move(3,6,3,4);
    model.move(6,3,4,3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,marble,empty,marble,empty,empty)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void isGameOver() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    model.move(3,4,3,2);
    model.move(3,6,3,4);
    model.move(6,3,4,3);
    assertTrue(model.isGameOver());
  }

  @Test
  public void getBoardSize3Nocenter() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    assertEquals(7, model.getBoardSize());
  }

  @Test
  public void getBoardSize5Nocenter() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    assertEquals(13, model.getBoardSize());
  }

  @Test
  public void getBoardSize7Nocenter() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(7);
    assertEquals(19, model.getBoardSize());
  }

  @Test
  public void getBoardSize3center() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(3,3);
    assertEquals(7, model.getBoardSize());
  }

  @Test
  public void getBoardSize5center() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5, 6,7);
    assertEquals(13, model.getBoardSize());
  }

  @Test
  public void getSlotAtCenter() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    assertEquals(empty, model.getSlotAt(3,3));
  }

  @Test
  public void getSlotAtCenterSize5() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    assertEquals(empty, model.getSlotAt(6,6));
  }

  @Test
  public void getSlotAtCenterSize5Nocenter() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5, 6,7);
    assertEquals(empty, model.getSlotAt(6,7));
  }

  @Test
  public void getSlotAtNormal() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    assertEquals(marble, model.getSlotAt(3,2));
  }

  @Test
  public void getSlotAtNormalSize5() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    assertEquals(marble, model.getSlotAt(6,7));
  }

  @Test
  public void getSlotAtInvalid1() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    assertEquals(invalid, model.getSlotAt(0,1));
  }

  @Test
  public void getSlotAtInvalid2() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    assertEquals(invalid, model.getSlotAt(0,5));
  }

  @Test
  public void getSlotAtInvalid2Size5() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    assertEquals(invalid, model.getSlotAt(0,3));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle1() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.getSlotAt(-1,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle2() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.getSlotAt(3,7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeBoth() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.getSlotAt(-3,-7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle1Size5() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.getSlotAt(-1,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle2Size5() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.getSlotAt(3,15);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeBothSize5() {
    EnglishSolitaireModel model = new EnglishSolitaireModel(5);
    model.getSlotAt(-3,-7);
  }

  @Test
  public void getScore() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    assertEquals(32,model.getScore());
  }

  @Test
  public void getScore5Move() {
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    model.move(3,1,3,3);
    model.move(1,2,3,2);
    model.move(3,3,3,1);
    model.move(2,0,2,2);
    model.move(4,0,2,0);
    assertEquals(27,model.getScore());
  }
}