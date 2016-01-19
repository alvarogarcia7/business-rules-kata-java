package com.example.kata.businessrules.payment;

import com.example.kata.businessrules.membership.Membership;
import com.example.kata.businessrules.rule.VoidRule;
import com.example.kata.businessrules.slip.Book;
import com.example.kata.businessrules.slip.DuplicateSlipRule;
import com.example.kata.businessrules.slip.GenerateSlipRule;
import com.example.kata.businessrules.membership.MembershipActivationRule;
import com.example.kata.businessrules.slip.DuplicateSlip;
import com.example.kata.businessrules.slip.PhysicalProduct;
import com.example.kata.businessrules.slip.Slip;

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
		process(new MembershipActivationRule(membership, new Payment()));
		return membership;
	}

	public void process (final VoidRule voidRule) {
		voidRule.apply();
	}
}
