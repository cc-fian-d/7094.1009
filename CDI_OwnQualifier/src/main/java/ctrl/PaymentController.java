package ctrl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("paymentController")
public class PaymentController {

	@Inject
	@Test
	private Payment payment;
	
	public void doCheckout() {
		payment.checkAccount();
		payment.buy();
		// logging
	}

}
