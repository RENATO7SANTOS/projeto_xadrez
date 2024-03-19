package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
    
    private ChessMatch chessMatch;

    public Pawn( Board board, Color color, ChessMatch chessMatch ){
        super( board, color );
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
       
        boolean[][] matriz   = new boolean[ getBoard().getRows()][ getBoard().getColumns() ];
        Position    matPosition = new Position( 0, 0 );

        if ( getColor() == Color.WHITE ){
            //White pieces
            //up one house
            matPosition.setValues( position.getRow() +1, position.getColumn() );
            if ( validatePosition( matPosition ) ){
                matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }

            //up two houses 
            matPosition.setValues( position.getRow() +2, position.getColumn() );
            if ( validatePosition( matPosition ) ){
                matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }

            //up left
            matPosition.setValues( position.getRow() +1 , position.getColumn() -1 );
            if  ( validatePosition( matPosition ) ) {
                matriz[  matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }

            //up right
            matPosition.setValues( position.getRow() +1 , position.getColumn() +1 );
            if ( validatePosition( matPosition ) ){
                matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }
        }
        else{
            //Black pieces
            //up one house
            matPosition.setValues( position.getRow() -1, position.getColumn() );
            if ( validatePosition( matPosition ) ){
                matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }

            //up two houses
            matPosition.setValues( position.getRow() -2, position.getColumn() );
            if ( validatePosition( matPosition ) ){
                matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }

            //up left
            matPosition.setValues( position.getRow() -1 , position.getColumn() -1 );
            if  ( validatePosition( matPosition ) ) {
                matriz[  matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }

            //up right
            matPosition.setValues( position.getRow() -1 , position.getColumn() +1 );
            if ( validatePosition( matPosition ) ){
                matriz[ matPosition.getRow() ][ matPosition.getColumn() ] = true;
            }
        }
    
        return matriz;    
    }

    private boolean validatePosition( Position position ){
        return getBoard().positionExists( position ) && !getBoard().thereIsAPiece( position );
    }
}
