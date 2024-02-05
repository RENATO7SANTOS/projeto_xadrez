package chess;

import boardgame.Board;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;
    
    public ChessMatch(){
        board = new Board( 8, 8 );
        initialSetup();
    }

    public ChessPiece[][] getPieces() { 
        ChessPiece[][] matriz = new ChessPiece[ board.getRows() ][ board.getColumns() ];
        for ( int i = 0; i < board.getRows(); i++ ) {
            for ( int j = 0; j < board.getColumns(); j++ ) {
                matriz[ i ][ j ] = (ChessPiece) board.piece( i, j );
            }
        } 
        return matriz;
    }

    private void placeNewPiece( char column, int row, ChessPiece piece ){
        board.placePiece( piece, new ChessPosition( column, row ).toPositon() );
    }

    private void initialSetup() {
        placeNewPiece( 'b', 4, new Rook( board, Color.WHITE ) );
    }
    
}
