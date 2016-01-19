package com.example.kata.businessrules;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class RulesShould {

	@Test
	public void activate_a_membership () {
		Membership membership = new Membership();
		MembershipActivationRule rule = new MembershipActivationRule(membership, new Payment());

		rule.apply();

		assertThat(membership.isActive(), is(true));
	}

	@Test
	public void generate_duplicate_slip(){
		Book book = new Book();
		DuplicateSlipRule rule = new DuplicateSlipRule(book, new Payment());

		rule.apply();

		assertThat(rule.result(), is(not(nullValue())));
	}
}
