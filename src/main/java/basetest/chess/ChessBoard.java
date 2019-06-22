package basetest.chess;

import java.util.List;

public class ChessBoard {
	private Box[][] boxes = new Box[8][8];
	private List<Piece> removedPieces;
	
	
	public boolean movePiece(int pieceColor, int sourceX, int sourceY, int destX, int destY) { return false; }
	
	public boolean checkforCheck() { return false; }
	
	public void removePiece(int sourceX, int sourceY) {}
}
