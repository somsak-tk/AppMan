package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallApp {
	
	public static void main(String[] args) {
	
		List<Card> input = new ArrayList<Card>();
		BingoGame bingo = new BingoGame();
		
		System.out.println("Example Input : 3, 4, 8, 13, 18, 19, 23 = ");
		System.out.print("input : "); // eg : 3, 4, 8, 13, 18, 19, 23 = (without bracket)

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(",");
		sc.useDelimiter("="); // Use '=' symbol to find answer
		
		while ( sc.hasNext() )
		{
			String line = sc.next();
			String[] inp = line.split(",");
			for ( int i=0; i < inp.length; i++)
			{
				input.add( new Card( Integer.valueOf(inp[i].trim()) ) );
			}
			System.out.println(" = "+bingo.isBingo(input));
			input.clear();
			System.out.println("input : ");
		}
		
	}

}
