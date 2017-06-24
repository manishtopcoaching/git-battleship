/**
 * 
 */
package battleship;

import java.util.HashMap;  

/**
 * @author manish.gulati
 *
 */
public class BattleShipGame {


	
	public static void main(String[] args) 
	{
		// Declare local variables
		int i=0, j=0, value=0, ship1Value=0, ship2Value=0, width=0, height=0, widthship1=0, heightship1=0, yShip1PlayerA=0, xShip1PlayerA=0;
		int widthship2=0, heightship2=0, yShip1PlayerB=0, xShip1PlayerB=0, yShip2PlayerA=0, xShip2PlayerA=0, yShip2PlayerB=0, xShip2PlayerB=0; 
		HashMap <Integer, String> inputsMap;
		HashMap<String, Integer> mapShip1Player2, mapShip1Player1, mapShip2Player2, mapShip2Player1;
		String boundary, battleship1, battleship2, dimensionBattleship1, locationBattleship1PlayerA, locationBattleship1PlayerB;
		String dimensionBattleship2, locationBattleship2PlayerA, locationBattleship2PlayerB, position, inputPlayerA, inputPlayerB;
		String [] targetsPlayerA, targetsPlayerB;
		String typeBattleship, dimensionBattleship, locationBattleship;
		
		if (args.length == 0)
		{
			System.out.println("Please provide fileName");
			System.exit(1); 	
		}
		
		
		// Get Battleground, Battleships and Player moves from input file 
		BattleTools bt = new BattleTools ();
		inputsMap = bt.getGameInputsFromFile(args[0]);
		if (inputsMap.containsKey(bt.ERROR))
		{
			System.out.println(inputsMap.get(bt.ERROR));
			System.exit(1); 
		}

		// Setup Battleground dimensions
		BattleGround bg = new BattleGround(inputsMap.get(bt.BOUNDARY));
		
		// Create Battleship 1 in play-area A 
		typeBattleship = inputsMap.get(bt.BATTLESHIP_1_TYPE); 
		dimensionBattleship = inputsMap.get(bt.BATTLESHIP_1_DIMENSION);
		locationBattleship = inputsMap.get(bt.BATTLESHIP_1_LOCATION_PLAYAREA_1); 
		BattleShip bs1A = new BattleShip (typeBattleship, dimensionBattleship, 'A', locationBattleship);
		
		// Create Battleship 1 in play-area B
		locationBattleship = inputsMap.get(bt.BATTLESHIP_1_LOCATION_PLAYAREA_2); 
		BattleShip bs1B = new BattleShip (typeBattleship, dimensionBattleship, 'B', locationBattleship);
		
		// Create Battleship 2 in play-area A
		typeBattleship = inputsMap.get(bt.BATTLESHIP_2_TYPE); 
		dimensionBattleship = inputsMap.get(bt.BATTLESHIP_2_DIMENSION); 
		locationBattleship = inputsMap.get(bt.BATTLESHIP_2_LOCATION_PLAYAREA_1); 
		BattleShip bs2A = new BattleShip (typeBattleship, dimensionBattleship, 'A', locationBattleship);
		
		// Create Battleship 2 in play-area B
		locationBattleship = inputsMap.get(bt.BATTLESHIP_2_LOCATION_PLAYAREA_2); 
		BattleShip bs2B = new BattleShip (typeBattleship, dimensionBattleship, 'B', locationBattleship);
		
		// Set both battleships in both play-areas of the Battleground
		bg.setBattleships(bs1A, bs1B, bs2A, bs2B);
	
		// Set winning position for each player for both battleships 
		bg.markAllBattleshipPositions();
		
		// Feed Moves for player A
		bg.setMovesPlayerA(inputsMap.get(bt.BATTLESHIP_1_MOVES));
		
		// Feed Moves for player B	
		bg.setMovesPlayerB(inputsMap.get(bt.BATTLESHIP_2_MOVES));

		// Let the Game Begin!!!
		bg.start();
		
	}
	

}
