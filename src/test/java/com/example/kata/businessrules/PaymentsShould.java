package com.example.kata.businessrules;

import org.junit.Before;
import org.junit.Test;

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
}
