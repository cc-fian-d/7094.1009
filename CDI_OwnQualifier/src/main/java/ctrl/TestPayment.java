package ctrl;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

@RequestScoped
//@Dependent
@Test
public class TestPayment implements Payment {

	@Override
	public void checkAccount() {
		System.out.println("checkAccount at TestPayment");

	}
	
	public TestPayment() {
		System.out.println("Testpayment wird erzeugt");
	}

	@Override
	public void buy() {
		System.out.println("buy at TestPayment");
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
