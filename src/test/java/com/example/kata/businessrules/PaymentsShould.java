package com.example.kata.businessrules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class PaymentsShould {

	Payment payment;

	@Before
	public void setUp () throws Exception {
		payment = new Payment();
	}

	@Test
	public void generateSlipOnPhysicalProduct(){

		Slip slip = payment.payPhysicalProduct();

		Assert.assertThat(slip, is(not(nullValue())));
	}

	@Test
	public void generateDuplicateSlipOnBook(){
		Book book = new Book();

		DuplicateSlip duplicateSlip = payment.pay(book);

		Assert.assertThat(duplicateSlip, is(not(nullValue())));
	}
}
