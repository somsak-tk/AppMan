package com.test;

import java.util.List;

public class BingoGame {
	
	private static final int rows = 5;
	private static final int cols = 5;
	private Card[][] card = new Card[rows][cols];
	private List<Card> input;
	
	BingoGame()
	{
		try {
			initialize();
			showCard();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void initialize()
    {
        //removeAll();
		int count = 1;
        for ( int row = 0; row < rows; row++ ) {
        	for ( int col = 0; col < cols; col++ ) {
        		card[row][col] = new Card(count++);
        	}
        }
    }
	
	public void removeAll()
	{
		 for ( int row = 0; row < rows; row++ )
	        	for ( int col = 0; col < cols; col++ )
	        		card[row][col].setBingo(false);
	}
	
	public void showCard()
	{
		for ( int row = 0; row < rows; row++ )
		{
        	for ( int col = 0; col < cols; col++ )
        	{
        		System.out.print( card[row][col].getValue() +"|"+card[row][col].isBingo()+" ");
        	}
        	System.out.println("");
		}
		
	}
	
	public boolean check( int a, int b, int c, int d, int e )
	{
		int count = 0;
		boolean bingo1 = false, bingo2 = false, bingo3 = false, bingo4 = false, bingo5 = false;
		while ( count != input.size() )
		{
			int inp = input.get(count).getValue();
			if ( inp == a ) bingo1 = true;
				else if ( inp == b ) bingo2 = true;
					else if ( inp == c ) bingo3 = true;
						else if ( inp == d ) bingo4 = true;
							else if ( inp == e ) bingo5 = true;
			count++;
		}
		if ( bingo1 && bingo2 && bingo3 && bingo4 && bingo5 ) return true;
		else return false;
	}
	
	public boolean isBingo(List<Card> input)
	{
		this.input = input;
		for (int idx=0; idx < input.size(); idx++)
		{
			for (int i=0; i < rows; i++)
			{
				for (int j=0; j <= i; j++)
				{
					if ( check( card[0][j].getValue(), card[1][j].getValue(), card[2][j].getValue(), card[3][j].getValue(), card[4][j].getValue() ) ) { // Vertical
	                    return true;
	                }
	                else if ( check( card[i][0].getValue(), card[i][1].getValue(), card[i][2].getValue(), card[i][3].getValue(), card[i][4].getValue() ) ) { // Horizontal
	                    return true;
	                }
	                else if ( check( card[0][0].getValue(), card[1][1].getValue(), card[2][2].getValue(), card[3][3].getValue(), card[4][4].getValue() ) ) { // Left Diagonal
	                    return true;
	                }
	                else if( check( card[0][4].getValue(), card[1][3].getValue(), card[2][2].getValue(), card[3][1].getValue(), card[4][0].getValue() ) ) { // Right Diagonal
	                    return true;
	                }
	                else
	                    continue;
				}
			}
		}
		return false;
	}

}
