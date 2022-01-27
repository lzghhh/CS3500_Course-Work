package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import java.util.ArrayList;

import java.util.Arrays;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

/**
 * This is the test class for the EuropeanSolitaire class.
 */

public class EuropeanSolitaireModelTest {
  EuropeanSolitaireModel model1;
  MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
  MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;
  MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;


  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelSmallerArm() {
    new EuropeanSolitaireModel(1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelEvenArm() {
    new EuropeanSolitaireModel(4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelNegativeArm() {
    new EuropeanSolitaireModel(-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterLeftUp() {
    new EuropeanSolitaireModel(3,0,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void tesEuropeanSolitaireModelInvalidCenterLeftDown() {
    new EuropeanSolitaireModel(3,6,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterRightUp() {
    new EuropeanSolitaireModel(3,0,6);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterFree() {
    new EuropeanSolitaireModel(-1,-2);
  }


  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidArm() {
    new EuropeanSolitaireModel(8);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterRightDown() {
    new EuropeanSolitaireModel(3,6,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterNegativeSingle() {
    new EuropeanSolitaireModel(3,-6,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterNegativeBoth() {
    new EuropeanSolitaireModel(3,-2,-1);
  }


  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterNegativeBothWithNegativeArm() {
    new EuropeanSolitaireModel(-2,-2,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEuropeanSolitaireModelInvalidCenterNegativeBothWithPositiveEvenArm() {
    new EuropeanSolitaireModel(4,-2,-1);
  }

  boolean layoutStringChecker(EuropeanSolitaireModel model,
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
  public void EuropeanSolitaireModellayoutCheckerSize3Center() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EuropeanSolitaireModelayoutCheckerSize3NoCenter() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(3,1,1);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,empty,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EuropeanSolitaireModelayoutCheckerSize3CenterFree() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5,5);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,empty,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EuropeanSolitaireModelayoutCheckerSize3CenterFalse() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
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
  public void EuropeanSolitaireModelayoutCheckerSize5Center() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,marble,marble,marble,
                                    marble,marble,marble,marble,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,marble,
                                    marble,marble,marble,marble,marble, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble,marble, marble,invalid)),
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
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,
                                    marble,marble,marble,marble,marble, marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,marble,
                                    marble,marble,marble,marble,marble, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,marble,marble,marble,
                                    marble,marble,marble,marble,invalid, invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,invalid,invalid,marble,marble,
                                    marble,marble,marble,invalid,invalid, invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void EuropeanSolitaireModelayoutCheckerSize5CenterFalse() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5);
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
  public void testmoveInvalidPosInRangeInvalidtoValid() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(0,0,0,2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoInvalidDis1() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(0,0,1,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoEmpty() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(0,2,0,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoMarble() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,1,3,3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeInvalidtoMarbleVertical() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,1,3,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoInvalid() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(0,3,0,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoInvalidVertical() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(4,1,6,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoMarble() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(0,3,0,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoMarbleVertical() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(0,3,2,3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoEmptyEmptybetweenTwo() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(3,5,3,3);
    model.move(3,6,3,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoEmptyEmptybetweenTwoVertical() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(3,5,3,3);
    model.move(1,4,3,4);
    model.move(0,4,2,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeMarbletoMarbleEmptybetweenTwoVertical() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(3,5,3,3);
    model.move(2,4,4,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosOutRangeFrom() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(-1,5,1,5);
  }


  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosOutRangeTo() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(3,1,3,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testmoveInvalidPosInRangeTwoPositionAway() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(3,0,3,3);
  }

  @Test
  public void testmoveVerticalDown() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,3,3,3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,empty,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveVerticalUp() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,empty,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveHorizontalRight() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,empty,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,empty,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveHorizontalLeft() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    model.move(3,4,3,2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,empty,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,marble,empty,empty,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveHorizontalLeft1() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
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
                            Arrays.asList(invalid,marble,marble,empty,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,marble,empty,marble,empty,empty)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,empty,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,marble,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void testmoveVerticalUp1() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
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
                            Arrays.asList(invalid,marble,marble,empty,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,marble,empty,marble,empty,empty)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble,marble,marble)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,marble,marble,empty,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(invalid,invalid,marble,empty,marble,invalid,invalid))
            ));
    assertTrue(layoutStringChecker(model,board));
  }

  @Test
  public void isGameOver() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    model.move(3,4,3,2);
    model.move(3,6,3,4);
    model.move(6,3,4,3);
    model.move(1,1,1,3);
    model.move(1,4,1,2);
    model.move(5,1,3,1);
    model.move(2,1,4,1);
    model.move(1,5,3,5);
    model.move(4,5,2,5);
    model.move(5,5,5,3);
    model.move(5,2,5,4);
    model.move(2,3,2,1);
    model.move(0,2,2,2);
    model.move(0,4,0,2);
    model.move(3,2,5,2);
    model.move(4,0,4,2);
    model.move(5,2,3,2);
    model.move(2,0,4,0);
    model.move(2,2,2,0);
    model.move(2,5,2,3);
    model.move(4,3,4,5);
    model.move(4,6,4,4);
    model.move(4,4,2,4);
    model.move(2,3,2,5);
    model.move(2,6,2,4);
    model.move(6,4,4,4);
    assertTrue(model.isGameOver());
  }

  @Test
  public void isGameOverFalse() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(1,3,3,3);
    model.move(4,3,2,3);
    model.move(3,1,3,3);
    model.move(3,4,3,2);
    model.move(3,6,3,4);
    model.move(6,3,4,3);
    model.move(1,1,1,3);
    model.move(1,4,1,2);
    model.move(5,1,3,1);
    model.move(2,1,4,1);
    model.move(1,5,3,5);
    model.move(4,5,2,5);
    model.move(5,5,5,3);
    model.move(5,2,5,4);
    model.move(2,3,2,1);
    model.move(0,2,2,2);
    model.move(0,4,0,2);
    model.move(3,2,5,2);
    model.move(4,0,4,2);
    model.move(5,2,3,2);
    assertFalse(model.isGameOver());
  }


  @Test
  public void getBoardSize3Nocenter() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    assertEquals(7, model.getBoardSize());
  }

  @Test
  public void getBoardSize5Nocenter() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5);
    assertEquals(13, model.getBoardSize());
  }

  @Test
  public void getBoardSize7Nocenter() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(7);
    assertEquals(19, model.getBoardSize());
  }

  @Test
  public void getBoardSize3center() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(3,3);
    assertEquals(7, model.getBoardSize());
  }

  @Test
  public void getBoardSize5center() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5, 6,7);
    assertEquals(13, model.getBoardSize());
  }

  @Test
  public void getSlotAtCenter() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    assertEquals(empty, model.getSlotAt(3,3));
  }

  @Test
  public void getSlotAtCenterSize5() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5);
    assertEquals(empty, model.getSlotAt(6,6));
  }

  @Test
  public void getSlotAtCenterSize5Nocenter() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5, 6,7);
    assertEquals(empty, model.getSlotAt(6,7));
  }

  @Test
  public void getSlotAtNormal() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    assertEquals(marble, model.getSlotAt(3,2));
  }

  @Test
  public void getSlotAtNormalSize5() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5);
    assertEquals(marble, model.getSlotAt(6,7));
  }

  @Test
  public void getSlotAtInvalid1() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    assertEquals(invalid, model.getSlotAt(0,1));
  }

  @Test
  public void getSlotAtInvalid2() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    assertEquals(invalid, model.getSlotAt(0,5));
  }

  @Test
  public void getSlotAtInvalid2Size5() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5);
    assertEquals(invalid, model.getSlotAt(0,3));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle1() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.getSlotAt(-1,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle2() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.getSlotAt(3,7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeBoth() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.getSlotAt(-3,-7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle1Size5() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.getSlotAt(-1,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeSingle2Size5() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.getSlotAt(3,15);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testgetSlotAtInvalidNegativeBothSize5() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel(5);
    model.getSlotAt(-3,-7);
  }

  @Test
  public void getScore() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    assertEquals(36,model.getScore());
  }

  @Test
  public void getScore5Move() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    model.move(3,1,3,3);
    model.move(1,2,3,2);
    model.move(3,3,3,1);
    model.move(2,0,2,2);
    model.move(4,0,2,0);
    assertEquals(31,model.getScore());
  }
}