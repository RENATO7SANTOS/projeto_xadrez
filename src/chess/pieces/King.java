package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King( Board board, Color color ){
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove( Position position ){
        ChessPiece piece = ( ChessPiece ) getBoard().piece( position );
        return piece == null ||  piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[ getBoard().getRows()][ getBoard().getColumns() ];

        Position position = new Position(0, 0);

        //above 
        position.setValue( position.getRow() -1, position.getColumn() );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        //below
        position.setValue( position.getRow() +1, position.getColumn() );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        //left
        position.setValue( position.getRow(), position.getColumn() -1 );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        //rigth
        position.setValue( position.getRow(), position.getColumn() + 1 );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        //up left
        position.setValue( position.getRow() -1 , position.getColumn() - 1 );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        //down left
        position.setValue( position.getRow() +1 , position.getColumn() - 1 );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        //up rigth 
        position.setValue( position.getRow() - 1 , position.getColumn() + 1 );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        //down right
        position.setValue( position.getRow() +1 , position.getColumn() + 1 );
        if ( getBoard().positionExists( position ) && canMove( position ) ){
            matriz[ position.getRow() ][ position.getColumn() ] = true;
        }

        return matriz;    
    }


    
}
