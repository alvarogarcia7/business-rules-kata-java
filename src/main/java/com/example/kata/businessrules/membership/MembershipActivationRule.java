package com.example.kata.businessrules.membership;

import com.example.kata.businessrules.payment.Payment;
import com.example.kata.businessrules.rule.VoidRule;

public class MembershipActivationRule implements VoidRule {
	private final Membership membership;
	private final Payment payment;

	public MembershipActivationRule (final Membership membership, final Payment payment) {
		this.membership = membership;
		this.payment = payment;
	}

	@Override
	public void apply () {
		membership.activate();
	}
}
