package com.example.kata.businessrules;

public class PaymentProcessor {

	public DuplicateSlip pay (final Book book) {
		return new DuplicateSlip();
	}

	public Slip pay (final PhysicalProduct physicalProduct) {
		return new Slip();
	}

	public Membership pay (final Membership membership) {
		membership.activate();
		return membership;
	}
}
