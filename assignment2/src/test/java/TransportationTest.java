
import org.junit.Assert;
import org.junit.Test;

public class TransportationTest {
	
	
	@Test
	public void testType(){
		Transportation transportation = new Transportation("home to work", 40);
		System.out.println(transportation);
		Assert.assertTrue(
				transportation instanceof Identifiable && 
				transportation instanceof Expense && 
				transportation instanceof Transportation
				);
	}

	@Test
	public void testId(){
		Transportation transportation = new Transportation("home to work", 40);
		System.out.println(transportation);
		Assert.assertTrue(transportation.getId() == 200002);
	}
	
	
	@Test
	public void testAmount(){
		Transportation transportation = new Transportation("home to work", 40);
		System.out.println(transportation);
		Assert.assertTrue(Math.round(transportation.getAmount()) == 1708);
	}
	

	@Test
	public void testDescription(){
		Transportation transportation = new Transportation("home to work", 40);
		System.out.println(transportation);
		Assert.assertTrue(transportation.getDescription().equals("home to work"));
	}

	@Test
	public void testDistance(){
		Transportation transportation = new Transportation("home to work", 40);
		System.out.println(transportation);
		Assert.assertTrue(transportation.getDistance() == 40);
	}
	
}
