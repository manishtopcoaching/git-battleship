/**
 * 
 */
package battleship;

/**
 * @author manish.gulati
 *
 */
public class BattleShip {
	private static int WEIGHT_OF_SHIP_TYPE_P = 1;
	private static int WEIGHT_OF_SHIP_TYPE_Q = 2;	
	private int width;
	private int length;
	private int type;
	private char playarea;
	private int xcoordinate;
	private int ycoordinate;
	
	public BattleShip(String t, String dimensionBattleship, char pa, String location)
	{
		width = Character.getNumericValue(dimensionBattleship.charAt(0));
		length = Character.getNumericValue(dimensionBattleship.charAt(1));
		type = (t.equals("P")) ? WEIGHT_OF_SHIP_TYPE_P : WEIGHT_OF_SHIP_TYPE_Q;
		playarea = pa;
		ycoordinate = (int)(location.charAt(0) - 'A') + 1;
		xcoordinate = Character.getNumericValue(location.charAt(1));		
	}
	
	public int getWidth() { return width; }
	public int getLength() { return length; }
	public int getType() { return type; }
	public int getPlayarea() { return playarea; }
	public int getxpos() { return xcoordinate; }
	public int getypos() { return ycoordinate; }
	
}
