package mars.rover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest public class RoverApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("testing........");
	}

	@Test
	public void roverMainTest(){
		int maxX=5;int maxY=5;  /*initializing the max grid coordinates that , grid can move*/

		Rover roverOne = new Rover(1,2,"N"); /*initializing the rover position*/
		roverOne.setMaxX(maxX);
		roverOne.setMaxY(maxY);
		roverOne.setInstructions("LMLMLMLMM"); /* give movement instructions for rover*/
		roverOne.moveRover();
		System.out.println(roverOne.toString());

		System.out.println("\n");

		Rover roverTwo = new Rover(3,3,"E");
		roverTwo.setMaxX(maxX);
		roverTwo.setMaxY(maxY);
		roverTwo.setInstructions("MMRMMRMRRM");
		roverTwo.moveRover();
		System.out.println(roverTwo.toString());
	}

	@Test
	public void moveRoverTest(){   /* test method for moveByOneGridDistance method*/
		Rover r = new Rover(1,2,"N");
		r.moveByOneGridDistance("N");
		System.out.println(r.toString());
	}

	@Test
	public void moveRoverDirToRightTest(){   /* test method for changeRoverDirectionToRight method*/
		Rover r = new Rover(1,2,"N");
		r.changeRoverDirectionToRight("N");
		System.out.println(r.toString());
	}

	@Test
	public void moveRoverDirToLeftTest(){   /* test method for changeRoverDirectionToLeft method*/
		Rover r = new Rover(1,2,"N");
		r.changeRoverDirectionToLeft("N");
		System.out.println(r.toString());
	}

}
