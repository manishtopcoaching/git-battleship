/**
 * 
 */
package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @author manish.gulati
 *
 */
public class BattleGround {
	
	/**
	 * @param args
	 */
	
	public final String positions[][] = {{"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9"}, 
									{"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9"},
									{"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"},
									{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"},
									{"E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9"},
									{"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9"},
									{"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9"},
									{"H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9"},
									{"I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9"},
									{"J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9"},
									{"K1", "K2", "K3", "K4", "K5", "K6", "K7", "K8", "K9"},
									{"L1", "L2", "L3", "L4", "L5", "L6", "L7", "L8", "L9"},
									{"M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9"},
									{"N1", "N2", "N3", "N4", "N5", "N6", "N7", "N8", "N9"},
									{"O1", "O2", "O3", "O4", "O5", "O6", "O7", "O8", "O9"},
									{"P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9"},
									{"Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9"},
									{"R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9"},
									{"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9"},
									{"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9"},
									{"U1", "U2", "U3", "U4", "U5", "U6", "U7", "U8", "U9"},
									{"V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9"},
									{"W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9"},
									{"X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9"},
									{"Y1", "Y2", "Y3", "Y4", "Y5", "Y6", "Y7", "Y8", "Y9"},
									{"Z1", "Z2", "Z3", "Z4", "Z5", "Z6", "Z7", "Z8", "Z9"}
									};

	private int width;
	private int length; 
	private BattleShip battleship1A;
	private BattleShip battleship1B;
	private BattleShip battleship2A;
	private BattleShip battleship2B;
	private HashMap <String, Integer> battleship1PositionPlayareaB ;
	private HashMap <String, Integer> battleship2PositionPlayareaB ;
	private HashMap <String, Integer> battleship1PositionPlayareaA ;
	private HashMap <String, Integer> battleship2PositionPlayareaA ;
	private String movesPlayerA;
	private String movesPlayerB;
	
	public BattleGround(String boundary)
	{
		width = Character.getNumericValue(boundary.charAt(0));
		length = (int) (boundary.charAt(1) - 'A') + 1; 		
	}
	
	public int getBattleGroundWidth() { return width; }
	public int getBattleGroundLength() { return length; }
	
	private void markBattleshipPosition(HashMap<String, Integer> mapship, int ycoordinate, int xcoordinate, int width, int height, int shipvalue)
	{
		// Find winning positions for player A for ship 1 which shall be all coordinates occupied by ship 1 in player B battle area.   
		String position; 	
		for (int i=0; i < width; i++)
		{
			for (int j=0; j < height; j++)
			{
				position = positions[j+ycoordinate-1][i+xcoordinate-1];
				mapship.put(position, shipvalue);				
			}
		}		
	}
	
	
	public void setBattleships(BattleShip bs1A, BattleShip bs1B, BattleShip bs2A, BattleShip bs2B)
	{
		battleship1A = bs1A;
		battleship1B = bs1B;
		battleship2A = bs2A;
		battleship2B = bs2B;		
	}
	
	public void markAllBattleshipPositions()
	{
		// Find winning positions for player A for ship 1 which shall be all coordinates occupied by ship 1 in player B battle area.   
		battleship1PositionPlayareaB = new HashMap<String, Integer>();
		markBattleshipPosition(battleship1PositionPlayareaB, battleship1B.getypos(), battleship1B.getxpos(), battleship1B.getWidth(), battleship1B.getLength(), battleship1B.getType());

		// Find winning positions for player B for ship 1 which shall be all coordinates occupied by ship 1 in player A battle area.   
		battleship1PositionPlayareaA = new HashMap<String, Integer>();
		markBattleshipPosition(battleship1PositionPlayareaA, battleship1A.getypos(), battleship1A.getxpos(), battleship1A.getWidth(), battleship1A.getLength(), battleship1A.getType());

		// Find winning positions for player A for ship 2 which shall be all coordinates occupied by ship 2 in player B battle area.   
		battleship2PositionPlayareaB = new HashMap<String, Integer>();
		markBattleshipPosition(battleship2PositionPlayareaB, battleship2B.getypos(), battleship2B.getxpos(), battleship2B.getWidth(), battleship2B.getLength(), battleship2B.getType());

		// Find winning positions for player B for ship 2 which shall be all coordinates occupied by ship 2 in player A battle area.   
		battleship2PositionPlayareaA = new HashMap<String, Integer>();
		markBattleshipPosition(battleship2PositionPlayareaA, battleship2A.getypos(), battleship2A.getxpos(), battleship2A.getWidth(), battleship2A.getLength(), battleship2A.getType());		
	}

	public void setMovesPlayerA(String moves)
	{
		movesPlayerA = moves;
	}
	
	public void setMovesPlayerB(String moves)
	{
		movesPlayerB = moves;
	}

	public void start()
	{
		// Let the Game Begin!!!
		String [] targetsPlayerA = movesPlayerA.split(" ");
		String [] targetsPlayerB = movesPlayerB.split(" ");
		int i=0, j=0, value;
		boolean hitPlayerA = false, hitPlayerB = false, skipPlayerATurn = false, skipPlayerBTurn = false;
		
		while (i < targetsPlayerA.length || j < targetsPlayerB.length)
		{
			hitPlayerA = false;
			hitPlayerB = false;
			if (skipPlayerATurn == false)
			{
			  if (i < targetsPlayerA.length)
			  {
				if (battleship1PositionPlayareaB.containsKey(targetsPlayerA[i]))
				{
					System.out.println("Player-1 fires a missile with target " + targetsPlayerA[i] + " which hit Ship 1 in battlearea 2");
					value = battleship1PositionPlayareaB.get(targetsPlayerA[i]);
					value--;
					if (value == 0)
					{
						battleship1PositionPlayareaB.remove(targetsPlayerA[i]);
					}
					else
					{
						battleship1PositionPlayareaB.put(targetsPlayerA[i], value);
					}
					hitPlayerA = true;
				}
				else if (battleship2PositionPlayareaB.containsKey(targetsPlayerA[i])) 
				{
					System.out.println("Player-1 fires a missile with target " + targetsPlayerA[i] + " which hit Ship 2 in battlearea 2");
					value = battleship2PositionPlayareaB.get(targetsPlayerA[i]);
					value--;
					if (value == 0)
					{
						battleship2PositionPlayareaB.remove(targetsPlayerA[i]);
					}
					else
					{
						battleship2PositionPlayareaB.put(targetsPlayerA[i], value);
					}
					hitPlayerA = true;
				}
				else 
				{
					System.out.println("Player-1 fires a missile with target " + targetsPlayerA[i] + " which missed");									
				}
				i++;
			  }
			  else
			  {
				System.out.println("Player 1 has no more missiles left");
		  	  }

			  // Check if Battleship1 in Playarea2 is destroyed
			  boolean player12 = true;
			  if (battleship1PositionPlayareaB.size() != 0)
			  {
				  player12 = false;
			  }

  			  // Check if Battleship2 in Playarea2 is destroyed		
			  boolean player22 = true;
			  if (battleship2PositionPlayareaB.size() != 0)
			  {
				  player22 = false;
			  }
			  			  
			  if (player12 == true && player22 == true)
			  {
				System.out.println("Player 1 wins because it destroyed both Battleships 1 & 2 in Playarea 2");
				System.exit(0);
			  }

			  if (hitPlayerA == true)
			  {
				skipPlayerBTurn = true;
			  }
			}
			else
			{
			  skipPlayerATurn = false;
			}
			
			if (skipPlayerBTurn == false)
			{
			  // Fire Player 2 Missile in Player 1 battle area
			  if (j < targetsPlayerB.length)
			  {
				if (battleship1PositionPlayareaA.containsKey(targetsPlayerB[j]))
				{
					System.out.println("Player-2 fires a missile with target " + targetsPlayerB[j] + " which hit Ship 1 in battlearea 1");
					value = battleship1PositionPlayareaA.get(targetsPlayerB[j]);
					value--;
					if (value == 0)
					{
						battleship1PositionPlayareaA.remove(targetsPlayerB[j]);
					}
					else 
					{
						battleship1PositionPlayareaA.put(targetsPlayerB[j], value);
					}
					hitPlayerB = true;
				}
				else if (battleship2PositionPlayareaA.containsKey(targetsPlayerB[j])) 
				{
					System.out.println("Player-2 fires a missile with target " + targetsPlayerB[j] + " which hit Ship 2 in battlearea 1");
					value = battleship2PositionPlayareaA.get(targetsPlayerB[j]);
					value--;
					if (value == 0)
					{
						battleship2PositionPlayareaA.remove(targetsPlayerB[j]);
					}
					else 
					{
						battleship2PositionPlayareaA.put(targetsPlayerB[j], value);
					}
					hitPlayerB = true;
				}
				else 
				{
					System.out.println("Player-2 fires a missile with target " + targetsPlayerB[j] + " which missed");									
				}
				
			  	j++;
			  }
			  else
			  {
				  System.out.println("Player 2 has no more missiles left");
			  }

			  // Check if battleship 1 in play area 1 is destroyed
			  boolean player11 = true;
			  if (battleship1PositionPlayareaA.size() != 0)
			  {
				  player11 = false;
			  }
			
			  // Check if battleship 2 in play area 1 is destroyed	
			  boolean player21 = true;
			  if (battleship2PositionPlayareaA.size() != 0)
			  {
				  player21 = false;
			  }

			  if (player11 == true && player21 == true)
			  {
			    System.out.println("Player 2 wins because it destroyed both Battleship 1 & 2 in Playarea 1");
			    System.exit(0);
			  }
			  
              if (hitPlayerB == true)
              {
            	  skipPlayerATurn = true;
              }
			}
			else
			{
				skipPlayerBTurn = false;
			}
		}		
	}
	
}
