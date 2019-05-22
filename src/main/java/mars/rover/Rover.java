package mars.rover;

/**
 * Created by Shameera on May, 2019
 */
public class Rover {

	private int x;
	private int y;
	private String direction;
	private String instructions;

	private int maxX;
	private int maxY;

	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void moveForwardToXDir() {   /* rover move along to forward in x direction*/
		this.x = this.x+1;
	}

	public void moveForwardToYDir() {   /* rover move along to forward in y direction*/
		this.y = this.y + 1;
	}

	public void moveBackwardToXDir() {    /* rover move along to backward in x direction*/
		this.x= this.x - 1;
	}

	public void moveBackwardToYDir() {  /* rover move along to backward in y direction*/
		this.y = this.y - 1;
	}

	public int getX() {

		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public void moveRover() {  /*move rover according to the instructions given*/
		for(int i = 0;i<instructions.length();i++){  /* loop . one single instruction a time*/
			switch (String.valueOf(instructions.charAt(i))) {
			case Constants.LEFT:
				//System.out.println("Turning Left");
				changeRoverDirectionToLeft(getDirection());
				break;
			case Constants.RIGHT:
				//System.out.println("Turning Right");
				changeRoverDirectionToRight(getDirection());
				break;
			case Constants.MOVE:
				//System.out.println("Move");
				moveByOneGridDistance(getDirection());
				break;
			default:
				System.out.println("Illegal command");
			}
		}
	}

	void changeRoverDirectionToLeft(String currentDirection){  /*execute when turning left*/
		switch (currentDirection){
		case Constants.NORTH:
			setDirection(Constants.WEST);
			break;
		case Constants.EAST:
			setDirection(Constants.NORTH);
			break;
		case Constants.SOUTH:
			setDirection(Constants.EAST);
			break;
		case Constants.WEST:
			setDirection(Constants.SOUTH);
			break;
		}
	}

	void changeRoverDirectionToRight(String currentDirection){ /* execute when turning right*/
		switch (currentDirection){
		case Constants.NORTH:
			setDirection(Constants.EAST);
			break;
		case Constants.EAST:
			setDirection(Constants.SOUTH);
			break;
		case Constants.SOUTH:
			setDirection(Constants.WEST);
			break;
		case Constants.WEST:
			setDirection(Constants.NORTH);
			break;
		}
	}

	void moveByOneGridDistance(String currentDirection){  /*rover movement*/
		switch (currentDirection){
		case Constants.NORTH:
			if(this.y != this.maxY){  /*rover can't move more that max grid coordinates given initially*/
				moveForwardToYDir();
			}else{
				System.out.println("Rover reached maximum y coordinate");
			}
			break;
		case Constants.EAST:
			if(this.x != this.maxX){
				moveForwardToXDir();
			}else{
				System.out.println("Rover reached maximum x coordinate");
			}
			break;
		case Constants.SOUTH:
			if(this.y != 0){
				moveBackwardToYDir();
			}else{
				System.out.println("Rover reached lowest y coordinate");
			}
			break;
		case Constants.WEST:
			if(this.x != 0){
				moveBackwardToXDir();
			}else{
				System.out.println("Rover reached lowest x coordinate");
			}
			break;
		}
	}

	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.direction;
	}
}
