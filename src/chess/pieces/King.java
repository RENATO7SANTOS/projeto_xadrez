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

        Position maPosition = new Position(0, 0);

        //above 
        maPosition.setValues( position.getRow() +1, position.getColumn() );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        //below
        maPosition.setValues( position.getRow() -1, position.getColumn() );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        //left
        maPosition.setValues( position.getRow(), position.getColumn() -1 );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        //rigth
        maPosition.setValues( position.getRow(), position.getColumn() + 1 );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        //up left
        maPosition.setValues( position.getRow() +1 , position.getColumn() - 1 );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        //down left
        maPosition.setValues( position.getRow() -1 , position.getColumn() - 1 );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        //up rigth 
        maPosition.setValues( position.getRow() +1 , position.getColumn() + 1 );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        //down right
        maPosition.setValues( position.getRow() -1 , position.getColumn() + 1 );
        if ( getBoard().positionExists( maPosition ) && canMove( maPosition ) ){
            matriz[ maPosition.getRow() ][ maPosition.getColumn() ] = true;
        }

        return matriz;    
    }


    
}
