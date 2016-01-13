package com.example.kata.businessrules;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class PaymentsShould {

	@Test
	public void generateSlipOnPhysicalProduct(){
		Payment payment = new Payment();

		Slip slip = payment.payPhysicalProduct();

		Assert.assertThat(slip, is(not(nullValue())));
	}

	@Test
	public void generateDuplicateSlipOnBook(){
		Payment payment = new Payment();

		DuplicateSlip duplicateSlip = payment.pay(book);

		Assert.assertThat(duplicateSlip, is(not(nullValue())));
	}
}
