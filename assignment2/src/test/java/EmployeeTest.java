
import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testType(){
		Employee emp = new Employee("Mokhtar Ahmed");
		System.out.println(emp);
		Assert.assertTrue(emp instanceof Identifiable);
	}
	
	@Test
	public void testName(){
		Employee emp = new Employee("Mokhtar Ahmed");
		System.out.println(emp);
		Assert.assertTrue(emp.getName().equals("Mokhtar Ahmed"));
	}
	
	@Test
	public void testId(){
		Employee emp = new Employee("Mokhtar Ahmed");
		System.out.println(emp);
		Assert.assertTrue(emp.getId() == 100003);
	}
	
	
}
