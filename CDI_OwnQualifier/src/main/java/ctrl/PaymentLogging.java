package ctrl;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

@ApplicationScoped
@Named
public class PaymentLogging {

	private static final Logger LOG = Logger.getLogger("Payment Logging");

	public void observPayment(@Observes Payment payment) {
		System.out.println("LOGGING " + payment.getClass().getSimpleName());
		//LOG.info(payment.getClass().getSimpleName());
	}
	
}
