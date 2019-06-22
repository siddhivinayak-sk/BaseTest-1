package basetest.chess;

import java.util.List;
import java.util.Map;

public class ChessGame {
	private ChessBoard board;
	private Player player1;
	private Player player2;
	private Map<Player, List<int[][]>> moveHistory;
	private Map<Player, String> selectedPieceColor;
	
	public void selectPieceType(Player p) {}
	
	public void startTheGame() {}
	
	public Player announceWinner() { return null; }
}
