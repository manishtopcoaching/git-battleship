package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class BattleTools 
{	
	public final int ERROR = 10;
	public final int BOUNDARY = 11;
	public final int BATTLESHIP_1_TYPE = 12;
	public final int BATTLESHIP_1_DIMENSION = 13;
	public final int BATTLESHIP_1_LOCATION_PLAYAREA_1 = 14;
	public final int BATTLESHIP_1_LOCATION_PLAYAREA_2 = 15;
	public final int BATTLESHIP_2_TYPE = 16;
	public final int BATTLESHIP_2_DIMENSION = 17;
	public final int BATTLESHIP_2_LOCATION_PLAYAREA_1 = 18;
	public final int BATTLESHIP_2_LOCATION_PLAYAREA_2 = 19;
	public final int BATTLESHIP_1_MOVES = 20;
	public final int BATTLESHIP_2_MOVES = 21;
	HashMap <Integer,String> hmap;

	public HashMap <Integer,String> getGameInputsFromFile(String fileName)
	{
		HashMap <Integer, String> hmap = new HashMap <Integer, String> ();
		if (fileName == null || fileName.length() == 0)
		{
			hmap.put(this.ERROR,  "Please provide input file name!");
		}

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) 
		{
			// Boundary would be first line in the input file <width><height>: 5E	
			String boundary = br.readLine();
			if (boundary == null || boundary.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide boundary of the battleship <width><height>");
				return hmap;					
			}
			boundary = boundary.trim();

			if (!Character.isDigit(boundary.charAt(0)))
			{
				hmap.put(this.ERROR,  "Please provide width of boundary as integer");
				return hmap;	
			}
			
			// Height of boundary should be an alphabet
			if (!Character.isUpperCase(boundary.charAt(1)))
			{
				hmap.put(this.ERROR,  "Please provide height of boundary as an Uppercase Letter");
				return hmap;	
			}
            hmap.put(BOUNDARY, boundary);
			
			// Type of Battleship 1
			String battleship_1_type = br.readLine();
			if (battleship_1_type == null || battleship_1_type.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide type of battleship 1 as either P or Q");
				return hmap;					
			}
			battleship_1_type = battleship_1_type.trim();
			if ( !(battleship_1_type.charAt(0) == 'p' || battleship_1_type.charAt(0) == 'q' 
					|| battleship_1_type.charAt(0) == 'P' || battleship_1_type.charAt(0) == 'Q'))
			{
				hmap.put(this.ERROR,  "Please provide type of battleship 1 as either P or Q");
				return hmap;	
			}
			hmap.put(BATTLESHIP_1_TYPE, battleship_1_type);

			// Dimension of Battleship 1
			String dimension_1 = br.readLine();			
			if (dimension_1 == null || dimension_1.length() < 2)
			{
				hmap.put(ERROR, "Please provide dimension of the battleship1 as <width><heigh>");
				return hmap;
			}
			dimension_1 = dimension_1.trim();
			if (!Character.isDigit(dimension_1.charAt(0)) || !Character.isDigit(dimension_1.charAt(1)))
			{
				hmap.put(ERROR, "Please provide dimension of the battleship1 as <length as int><height as int> , e.g.: 32");
				return hmap;				
			}
			hmap.put(BATTLESHIP_1_DIMENSION, dimension_1);
			
			// Location of Battleship 1 for Playarea 1
			String locBattleship1Playarea1 = br.readLine();
			if (locBattleship1Playarea1 == null || locBattleship1Playarea1.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide location of the battleship 1 in playarea 1 as <x-coordinate><y-coordinate> as E5");
				return hmap;					
			}
			locBattleship1Playarea1 = locBattleship1Playarea1.trim();
			// x-coordinate 
			if (!Character.isUpperCase(locBattleship1Playarea1.charAt(0)))
			{
				hmap.put(this.ERROR,  "Please provide x-coordinate of location of battleship 1 in playarea 1 as uppercase lettre E");
				return hmap;	
			}
			
			// y-coordinate
			if (!Character.isDigit(locBattleship1Playarea1.charAt(1)))
			{
				hmap.put(this.ERROR,  "Please provide y-coordinate of location of battleship 1 in playarea as digit 5");
				return hmap;	
			}
            hmap.put(BATTLESHIP_1_LOCATION_PLAYAREA_1, locBattleship1Playarea1);
			
			// Location of Battleship 1 for Playarea 2
			String locBattleship1Playarea2 = br.readLine();
			if (locBattleship1Playarea2 == null || locBattleship1Playarea2.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide location of the battleship 1 in playarea 2 as <x-coordinate><y-coordinate> as E5");
				return hmap;					
			}
			locBattleship1Playarea2 = locBattleship1Playarea2.trim();
			// x-coordinate 
			if (!Character.isUpperCase(locBattleship1Playarea2.charAt(0)))
			{
				hmap.put(this.ERROR,  "Please provide x-coordinate of location of battleship 1 in playarea 2 as uppercase lettre E");
				return hmap;	
			}
			
			// y-coordinate
			if (!Character.isDigit(locBattleship1Playarea2.charAt(1)))
			{
				hmap.put(this.ERROR,  "Please provide y-coordinate of location of battleship 2 in playarea as digit 5");
				return hmap;	
			}
            hmap.put(BATTLESHIP_1_LOCATION_PLAYAREA_2, locBattleship1Playarea2);

            // Get Type of Battleship2
			String battleship_2_type = br.readLine();
			if (battleship_2_type == null || battleship_2_type.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide type of battleship 2 as either P or Q");
				return hmap;					
			}
			battleship_2_type = battleship_2_type.trim();
			if ( !(battleship_2_type.charAt(0) == 'p' || battleship_2_type.charAt(0) == 'q' 
					|| battleship_2_type.charAt(0) == 'P' || battleship_2_type.charAt(0) == 'Q'))
			{
				hmap.put(this.ERROR,  "Please provide type of battleship 2 as either P or Q");
				return hmap;	
			}
			hmap.put(BATTLESHIP_2_TYPE, battleship_1_type);

			// Dimension of Battleship 2
			String dimension_2 = br.readLine();			
			if (dimension_2 == null || dimension_2.length() < 2)
			{
				hmap.put(ERROR, "Please provide dimension of the battleship2 as <width><heigh>");
				return hmap;
			}
			dimension_2 = dimension_2.trim();
			if (!Character.isDigit(dimension_2.charAt(0)) || !Character.isDigit(dimension_2.charAt(1)))
			{
				hmap.put(ERROR, "Please provide dimension of the battleship1 as <length as int><height as int> , e.g.: 32");
				return hmap;				
			}
			hmap.put(BATTLESHIP_2_DIMENSION, dimension_2);
			
			// Location of Battleship 2 for Playarea 1
			String locBattleship2Playarea1 = br.readLine();
			if (locBattleship2Playarea1 == null || locBattleship2Playarea1.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide location of the battleship 2 in playarea 1 as <x-coordinate><y-coordinate> as E5");
				return hmap;					
			}
			locBattleship2Playarea1 = locBattleship2Playarea1.trim();
			// x-coordinate 
			if (!Character.isUpperCase(locBattleship2Playarea1.charAt(0)))
			{
				hmap.put(this.ERROR,  "Please provide x-coordinate of location of battleship 2 in playarea 1 as uppercase lettre E");
				return hmap;	
			}
			
			// y-coordinate
			if (!Character.isDigit(locBattleship2Playarea1.charAt(1)))
			{
				hmap.put(this.ERROR,  "Please provide y-coordinate of location of battleship 2 in playarea as digit 5");
				return hmap;	
			}
            hmap.put(BATTLESHIP_2_LOCATION_PLAYAREA_1, locBattleship2Playarea1);
			
			// Location of Battleship 2 for Playarea 2
			String locBattleship2Playarea2 = br.readLine();
			if (locBattleship2Playarea2 == null || locBattleship2Playarea2.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide location of the battleship 2 in playarea 2 as <x-coordinate><y-coordinate> as E5");
				return hmap;					
			}
			locBattleship2Playarea2 = locBattleship2Playarea2.trim();
			// x-coordinate 
			if (!Character.isUpperCase(locBattleship2Playarea2.charAt(0)))
			{
				hmap.put(this.ERROR,  "Please provide x-coordinate of location of battleship 2 in playarea 2 as uppercase lettre E");
				return hmap;	
			}
			
			// y-coordinate
			if (!Character.isDigit(locBattleship2Playarea2.charAt(1)))
			{
				hmap.put(this.ERROR,  "Please provide y-coordinate of location of battleship 2 in playarea 2 as digit 5");
				return hmap;	
			}
            hmap.put(BATTLESHIP_2_LOCATION_PLAYAREA_2, locBattleship2Playarea2);
            
            // Moves for Player 1
            String movesPlayer1 = br.readLine();
			if (movesPlayer1 == null || movesPlayer1.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide moves for Player1");
				return hmap;					
			}
            hmap.put(BATTLESHIP_1_MOVES, movesPlayer1);
			
            // Moves for Player 2
            String movesPlayer2 = br.readLine();
			if (movesPlayer2 == null || movesPlayer2.length() == 0)
			{
				hmap.put(this.ERROR,  "Please provide moves for Player2");
				return hmap;					
			}
            hmap.put(BATTLESHIP_2_MOVES, movesPlayer2);

            
		} 
		catch (IOException e) 
		{
			hmap.put(this.ERROR, e.getMessage());
			return hmap;					
		}

		return hmap;
	}
}
