
import org.junit.Assert;
import org.junit.Test;

public class BreakfastTest {
	
	
	@Test
	public void testType(){
		Breakfast myBreakfast = new Breakfast("Fool + fries", 1);
		System.out.println(myBreakfast);
		Assert.assertTrue(
				myBreakfast instanceof Identifiable && 
				myBreakfast instanceof Expense && 
				myBreakfast instanceof Meal
				);
		
	}

	@Test
	public void testId(){
		Breakfast myBreakfast = new Breakfast("Fool + fries", 1);
		System.out.println(myBreakfast);
		Assert.assertTrue(myBreakfast.getId() == 200002);
	}
	
	
	@Test
	public void testAmount(){
		Breakfast myBreakfast = new Breakfast("Fool + fries", 1);
		System.out.println(myBreakfast);
		Assert.assertTrue(Math.round(myBreakfast.getAmount()) == 13);
	}
	

	@Test
	public void testDescription(){
		Breakfast myBreakfast = new Breakfast("Fool + fries", 1);
		System.out.println(myBreakfast);
		Assert.assertTrue(myBreakfast.getDescription().equals("Fool + fries"));
	}
	
}
