package ctrl;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

//@Dependent
@RequestScoped
public class PayPal implements Payment {

	@Override
	public void checkAccount() {
		System.out.println("checkAccount at Paypal");

	}

	@Override
	public void buy() {
		System.out.println("buy at Paypal");

	}

	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
