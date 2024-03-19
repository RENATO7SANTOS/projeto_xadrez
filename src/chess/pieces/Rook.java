package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook( Board board, Color color ) {
        super( board, color );
    }
    
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
       
        boolean[][] matriz = new boolean[ getBoard().getRows()][ getBoard().getColumns() ];
        Position matPosition = new Position(0, 0);


        //bottom
        matPosition.setValues( position.getRow() - 1, position.getColumn() );
        while ( ( validatePosition( matPosition ) ) ) {
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            matPosition.setRow( matPosition.getRow() - 1 );
        }

        if ( getBoard().positionExists( matPosition )  && isThereOpponentPiece( matPosition ) ){
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
        }

        //above
        matPosition.setValues( position.getRow() +1, position.getColumn() );
        while ( validatePosition( matPosition ) ) {
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            matPosition.setRow( matPosition.getRow() +1 );
        }
        
        if ( getBoard().positionExists( matPosition )  && isThereOpponentPiece( matPosition ) ){
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
        }

        //right
        matPosition.setValues( position.getRow(),  position.getColumn() +1 );
        while ( validatePosition( matPosition ) ) {
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            matPosition.setColumn( matPosition.getColumn() + 1 );
        }

        if ( getBoard().positionExists( matPosition )  && isThereOpponentPiece( matPosition ) ){
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
        }

        //left
        matPosition.setValues(position.getRow(), position.getColumn() -1 );
        while ( ( validatePosition( matPosition ) ) ) {
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            matPosition.setColumn( matPosition.getColumn() -1 );
        }

        if ( getBoard().positionExists( matPosition )  && isThereOpponentPiece( matPosition ) ){
            matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
        }





        return matriz;
        
    }

    private boolean validatePosition( Position position ){
        return getBoard().positionExists( position ) && !getBoard().thereIsAPiece( position );
    }

}
