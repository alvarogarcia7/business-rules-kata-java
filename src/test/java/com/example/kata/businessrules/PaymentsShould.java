package com.example.kata.businessrules;

import com.example.kata.businessrules.membership.Membership;
import com.example.kata.businessrules.payment.PaymentProcessor;
import com.example.kata.businessrules.rule.VoidRule;
import com.example.kata.businessrules.slip.Book;
import com.example.kata.businessrules.slip.DuplicateSlip;
import com.example.kata.businessrules.slip.PhysicalProduct;
import com.example.kata.businessrules.slip.Slip;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class PaymentsShould {

	PaymentProcessor paymentProcessor;

	@Before
	public void setUp () throws Exception {
		paymentProcessor = new PaymentProcessor();
	}

	@Test
	public void generateSlipOnPhysicalProduct(){
		PhysicalProduct physicalProduct = new PhysicalProduct();

		Slip slip = paymentProcessor.pay(physicalProduct);

		assertThat(slip, is(not(nullValue())));
	}

	@Test
	public void generateDuplicateSlipOnBook(){
		Book book = new Book();

		DuplicateSlip duplicateSlip = paymentProcessor.pay(book);

		assertThat(duplicateSlip, is(not(nullValue())));
	}

	@Test
	public void activateMembership(){
		Membership membership = new Membership();

		membership = paymentProcessor.pay(membership);

		assertThat(membership.isActive(), is(true));
	}

	@Test
	public void apply_any_void_rule () {
		final VoidRule voidRule = Mockito.mock(VoidRule.class);

		paymentProcessor.process(voidRule);

		Mockito.verify(voidRule).apply();
	}
}
