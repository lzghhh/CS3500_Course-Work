package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import java.util.ArrayList;

import java.util.Arrays;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

/**
 * This is the test class for the TriangleSolitaire class.
 */

public class TriangleSolitaireModelTest {
  MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
  MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;
  MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;

  @Test (expected = IllegalArgumentException.class)
  public void testTriangleSolitaireModelNegativeArm() {
    new TriangleSolitaireModel(-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTriangleSolitaireModelInvalidCenterRightUp() {
    new TriangleSolitaireModel(3,0,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTriangleSolitaireModelInvalidCenterFree() {
    new TriangleSolitaireModel(-1,-2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTriangleSolitaireModelInvalidCenterRightDown() {
    new TriangleSolitaireModel(6,4,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTriangleSolitaireModelInvalidCenterNegativeSingle() {
    new TriangleSolitaireModel(6,-6,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTriangleSolitaireModelInvalidCenterNegativeBoth() {
    new TriangleSolitaireModel(6,-2,-1);
  }

  boolean layoutStringChecker(TriangleSolitaireModel model,
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
  public void TriangleSolitaireModellayoutCheckerSizeDefault() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void TriangleSolitaireModellayoutCheckerSize3() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(3);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void TriangleSolitaireModellayoutCheckerSiz3CenterChanged() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(1,0);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,marble,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }


  @Test
  public void TriangleSolitaireModellayoutCheckerSize3CenterChanged() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(3, 1,0);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }


  @Test
  public void getBoardSize5Nocenter() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    assertEquals(5, model.getBoardSize());
  }

  @Test
  public void getBoardSizeCenter() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(6,1,1);
    assertEquals(6, model.getBoardSize());
  }

  @Test
  public void getBoardSizeCenterTwo() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(1,1);
    assertEquals(5, model.getBoardSize());
  }

  @Test
  public void getBoardSizeCenterOne() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(3);
    assertEquals(3, model.getBoardSize());
  }

  @Test
  public void getSlotAtCenter() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    assertEquals(empty, model.getSlotAt(0,0));
  }

  @Test
  public void getSlotAtMarble() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    assertEquals(marble, model.getSlotAt(1,1));
  }

  @Test
  public void getSlotAtInvalid() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    assertEquals(invalid, model.getSlotAt(0,1));
  }

  @Test
  public void getSlotAtCenterSize5() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(6);
    assertEquals(empty, model.getSlotAt(0,0));
  }

  @Test (expected = IllegalArgumentException.class)
  public void getSlotAtOutRange() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    assertEquals(marble, model.getSlotAt(-1,0));
  }

  @Test (expected = IllegalArgumentException.class)
  public void getSlotAtOutRange1() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    assertEquals(marble, model.getSlotAt(0,7));
  }

  @Test
  public void testGetScore() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    assertEquals(14,model.getScore());
  }

  @Test
  public void testGetScoreSize() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(7);
    assertEquals(27,model.getScore());
  }

  @Test
  public void testGetScoreCenter() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(7,1,1);
    assertEquals(27,model.getScore());
  }

  @Test
  public void testisGameOver() {
    TriangleSolitaireModel board1 = new TriangleSolitaireModel(6,0,0);
    board1.move(2,0,0,0);
    board1.move(2,2,2,0);
    board1.move(0,0,2,2);
    board1.move(3,0,1,0);
    board1.move(3,3,1,1);
    board1.move(3,1,3,3);
    board1.move(4,4,2,2);
    board1.move(2,2,0,0);
    board1.move(0,0,2,0);
    board1.move(4,2,4,4);
    board1.move(4,0,4,2);
    board1.move(5,5,3,3);
    board1.move(5,3,3,1);
    board1.move(2,0,4,2);
    board1.move(5,2,3,2);
    board1.move(3,3,3,1);
    board1.move(5,0,5,2);
    assertTrue(board1.isGameOver());
  }


  @Test
  public void testisGameOverFail() {
    TriangleSolitaireModel board1 = new TriangleSolitaireModel(6,0,0);
    board1.move(2,0,0,0);
    board1.move(2,2,2,0);
    board1.move(0,0,2,2);
    board1.move(3,0,1,0);
    board1.move(3,3,1,1);
    board1.move(3,1,3,3);
    board1.move(4,4,2,2);
    board1.move(2,2,0,0);
    board1.move(0,0,2,0);
    assertFalse(board1.isGameOver());
  }

  @Test
  public void testisGameOverFail1() {
    TriangleSolitaireModel board1 = new TriangleSolitaireModel(6,0,0);
    assertFalse(board1.isGameOver());
  }

  @Test
  public void testValidMoveHorizonMarbletoEmptyRight() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,2);
    model.move(2,0,2,2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,empty,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void testValidMoveVerticalMarbletoEmptyUp() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,2);
    model.move(4,2,2,2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,empty,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,empty,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void testValidMoveHorizonMarbletoEmptyLeft() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(3,0);
    model.move(3,2,3,0);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,empty,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void testValidMoveVerticalMarbletoEmptyDown() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,0);
    model.move(0,0,2,0);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,marble,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void testValidMoveDiagonalMarbletoEmptyRightDown() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,2);
    model.move(0,0,2,2);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(empty,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test
  public void testValidMoveDiagonalMarbletoEmptyLeftUp() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    model.move(2,2,0,0);
    ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> board =
            new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(Arrays.asList(
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,invalid,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,empty,invalid,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,empty,invalid,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,invalid)),
                    new ArrayList<MarbleSolitaireModelState.SlotState>(
                            Arrays.asList(marble,marble,marble,marble,marble))));
    assertTrue(layoutStringChecker(model, board));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalMarbletoEmptyTwoPosAway() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    model.move(3, 3, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove1PosHorizon() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,1);
    model.move(2, 0, 2, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove1PosVertical() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,1);
    model.move(3, 1, 2, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove1PosDiagonal() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,1);
    model.move(1, 0, 2, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalMarbletoEmptyRightUp() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,2);
    model.move(4, 0, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalMarbletoEmptyLeftDown() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(4,0);
    model.move(2, 2, 4, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveHorizonMarbletoInvalid() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(0,0);
    model.move(1,0, 1, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalMarbletoEmptyEmptyInBetween() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(3);
    model.move(2,0,0,0);
    model.move(0,0, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalMarbletoMarbleEmptyInBetween() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(3,2,1);
    model.move(2,0,2,2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalInvalidtoEmpty() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,2);
    model.move(0, 4, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalInvalidtoMarble() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    model.move(0, 4, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveVerticalInvalidtoEmpty() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,2);
    model.move(0, 2, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveVerticalInvalidtoMarble() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    model.move(0, 2, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveHorizonInvalidtoMarble() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    model.move(1, 2, 1, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveHorizonInvalidtoEmpty() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(1,0);
    model.move(1, 2, 1, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveHorizonInvalidOutofRangeTo() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(1,0);
    model.move(1, 2, -1, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveHorizonInvalidOutofRangeFrom() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(1,0);
    model.move(-1, 2, -1, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveHorizonEmptytoMarble() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,0);
    model.move(2, 0, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveHorizonEmptytoInvalid() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,1);
    model.move(2, 1, 2, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveVerticalEmptytoMarble() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,0);
    model.move(2, 0, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveVerticalEmptytoInvalid() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(2,2);
    model.move(2, 2, 0, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonalEmptytoMarble() {
    TriangleSolitaireModel model = new TriangleSolitaireModel(0,0);
    model.move(0, 0, 2, 2);
  }




}
