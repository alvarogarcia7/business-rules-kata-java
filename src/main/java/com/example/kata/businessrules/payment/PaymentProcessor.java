package com.example.kata.businessrules.payment;

import com.example.kata.businessrules.membership.Membership;
import com.example.kata.businessrules.membership.MembershipActivationRule;
import com.example.kata.businessrules.rule.ResultingRule;
import com.example.kata.businessrules.rule.VoidRule;
import com.example.kata.businessrules.slip.Book;
import com.example.kata.businessrules.slip.DuplicateSlip;
import com.example.kata.businessrules.slip.DuplicateSlipRule;
import com.example.kata.businessrules.slip.GenerateSlipRule;
import com.example.kata.businessrules.slip.PhysicalProduct;
import com.example.kata.businessrules.slip.Slip;

public class PaymentProcessor {

	public DuplicateSlip pay (final Book book) {
		return process(new DuplicateSlipRule(book, new Payment()));
	}

	public Slip pay (final PhysicalProduct physicalProduct) {
		return process(new GenerateSlipRule(physicalProduct, new Payment()));
	}

	public Membership pay (final Membership membership) {
		process(new MembershipActivationRule(membership, new Payment()));
		return membership;
	}

	public void process (final VoidRule voidRule) {
		voidRule.apply();
	}

	public <T> T process (final ResultingRule<T> rule) {
		rule.apply();
		return rule.result();
	}
}
