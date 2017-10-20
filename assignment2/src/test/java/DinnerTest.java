
import org.junit.Assert;
import org.junit.Test;

public class DinnerTest {
	
	
	@Test
	public void testType(){
		Dinner myDinner = new Dinner("cheese + yogurt", 3);
		System.out.println(myDinner);
		Assert.assertTrue(
				myDinner instanceof Identifiable && 
				myDinner instanceof Expense && 
				myDinner instanceof Meal
				);
	}

	@Test
	public void testId(){
		Dinner myDinner = new Dinner("cheese + yogurt", 3);
		System.out.println(myDinner);
		Assert.assertTrue(myDinner.getId() == 200002);
	}
	
	
	@Test
	public void testAmount(){
		Dinner myDinner = new Dinner("cheese + yogurt", 3);
		System.out.println(myDinner);
		Assert.assertTrue(Math.round(myDinner.getAmount()) == 106);
	}
	

	@Test
	public void testDescription(){
		Dinner myDinner = new Dinner("cheese + yogurt", 3);
		System.out.println(myDinner);
		Assert.assertTrue(myDinner.getDescription().equals("cheese + yogurt"));
	}
	
}
