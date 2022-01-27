public class ConnectN implements INConnect{
  private final Player[][] board;
  private final int width ;
  private final int height;
  private final int winGoal;
  private final int numPlayers;
  private Player nextPlayer;

  private ConnectN() {
    this.board = new Player[4][4];
    this.width = 4;
    this.height = 4;
    this.winGoal = 4;
    this.numPlayers = 2;
    this.nextPlayer = Player.O;
  }

  private ConnectN(int width, int height, int numPlayers, int winGoal) {
    if (width < 0 || height < 0 || numPlayers < 2 || winGoal < 3) {
      throw new IllegalArgumentException("Invalid arguments.");
    }
    this.board = new Player[width][height];
    this.width = width;
    this.height =height;
    this.winGoal = winGoal;
    this.numPlayers = numPlayers;
  }

  public ConnectN(int width, int height) {
    this(width, height, 2,4);
  }



  @Override
  public int getNumPlayers() {
    return this.numPlayers;
  }

  @Override
  public int getWinningGoal() {
    return this.winGoal;
  }

  Player [][] getBoard() {
    return this.board;
  }

  @Override
  public Player getPlayerAt(int row, int col) {
    if (row < 0 || col < 0 || row >=height || col >= width) {
      throw new IllegalArgumentException("Invalid argument.");
    }
    return this.board[row][col];
  }

  @Override
  public Player getWinner() {
    return null;
  }

  @Override
  public Player nextPlayer() {
    return this.nextPlayer;
  }

  public void movePlayer1(int col) {

  }

  public void movePlayer2(int col) {

  }

  @Override
  public void move(int col) {
    if (this.nextPlayer == Player.O) {
      this.nextPlayer = Player.X;
    } else {
      this.nextPlayer = Player.O;
    }
  }

  public static ConnectNBuilder builedr() {
    return new ConnectNBuilder();
  }

  public static class ConnectNBuilder {
    private int width;
    private int height;
    private int winGoal;
    private int numPlayers;

    private ConnectNBuilder() {
      this.width = 4;
      this.height = 4;
      this.winGoal = 3;
      this.numPlayers = 2;
    }

    public ConnectNBuilder setWidth(int width) {
      this.width = width;
      return this;
    }

    public ConnectNBuilder setHeight(int height) {
      this.height = height;
      return this;
    }

    public ConnectNBuilder setWinGoal(int winGoal) {
      this.winGoal = winGoal;
      return this;
    }

    public ConnectNBuilder setNumPlayers(int numPlayers) {
      this.numPlayers = numPlayers;
      return this;
    }

    public INConnect build() {
      return new ConnectN(this.width, this.height, this.numPlayers, this.winGoal);
    }


  }

}
