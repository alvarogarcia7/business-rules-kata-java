package com.example.kata.businessrules;

public class PaymentProcessor {

	public DuplicateSlip pay (final Book book) {
		final DuplicateSlipRule rule = new DuplicateSlipRule(book, new Payment());
		rule.apply();
		return rule.result();
	}

	public Slip pay (final PhysicalProduct physicalProduct) {
		final GenerateSlipRule rule = new GenerateSlipRule(physicalProduct, new Payment());
		rule.apply();
		return rule.result();
	}

	public Membership pay (final Membership membership) {
		new MembershipActivationRule(membership, new Payment()).apply();
		return membership;
	}
}
