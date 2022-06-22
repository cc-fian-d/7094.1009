package ctrl;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

@Dependent
@Test
public class TestPayment implements Payment {

	@Override
	public void checkAccount() {
		System.out.println("checkAccount at TestPayment");

	}

	@Override
	public void buy() {
		System.out.println("buy at TestPayment");

	}

}
