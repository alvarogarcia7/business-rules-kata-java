package com.example.kata.businessrules;

import javafx.beans.binding.Bindings;
import org.junit.Assert;
import org.junit.Test;

public class PaymentsShould {

	@Test
	generateSlipOnPhysicalProduct(){
		Payment payment = new Payment();
		Slip slip = payment.payPhysicalProduct();
		Assert.assertThat(slip, Bindings.isNotNull());
	}
}
