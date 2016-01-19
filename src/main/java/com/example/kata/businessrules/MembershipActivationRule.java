package com.example.kata.businessrules;

public class MembershipActivationRule {
	private final Membership membership;
	private final Payment payment;

	public MembershipActivationRule (final Membership membership, final Payment payment) {
		this.membership = membership;
		this.payment = payment;
	}

	public void apply () {
		membership.activate();
	}
}
