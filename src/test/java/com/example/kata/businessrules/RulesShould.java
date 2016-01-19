package com.example.kata.businessrules;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RulesShould {

	@Test
	public void activate_a_membership () {
		Membership membership = new Membership();
		MembershipActivationRule rule = new MembershipActivationRule(membership, new Payment());
		
		rule.apply();

		assertThat(membership.isActive(), is(true));
	}
}
