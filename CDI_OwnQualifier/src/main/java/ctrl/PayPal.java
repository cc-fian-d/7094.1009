package ctrl;

import javax.enterprise.context.Dependent;

@Dependent
public class PayPal implements Payment {

	@Override
	public void checkAccount() {
		System.out.println("checkAccount at Paypal");

	}

	@Override
	public void buy() {
		System.out.println("buy at Paypal");

	}

}
