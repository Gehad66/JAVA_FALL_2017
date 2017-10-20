
import org.junit.Assert;
import org.junit.Test;

public class LunchTest {
	
	
	@Test
	public void testType(){
		Lunch myLunch = new Lunch("Rice + Molkhia", 2);
		System.out.println(myLunch);
		Assert.assertTrue(
				myLunch instanceof Identifiable && 
				myLunch instanceof Expense && 
				myLunch instanceof Meal
				);
	}

	@Test
	public void testId(){
		Lunch myLunch = new Lunch("Rice + Molkhia", 2);
		System.out.println(myLunch);
		Assert.assertTrue(myLunch.getId() == 200002);
	}
	
	
	@Test
	public void testAmount(){
		Lunch myLunch = new Lunch("Rice + Molkhia", 2);
		System.out.println(myLunch);
		Assert.assertTrue(Math.round(myLunch.getAmount()) == 25);
	}
	

	@Test
	public void testDescription(){
		Lunch myLunch = new Lunch("Rice + Molkhia", 2);
		System.out.println(myLunch);
		Assert.assertTrue(myLunch.getDescription().equals("Rice + Molkhia"));
	}
	
}
