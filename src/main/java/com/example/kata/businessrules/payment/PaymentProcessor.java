package com.example.kata.businessrules.payment;

import com.example.kata.businessrules.RuleProcessor;
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

	private final RuleProcessor ruleProcessor;

	public PaymentProcessor (final RuleProcessor ruleProcessor) {
		this.ruleProcessor = ruleProcessor;
	}


	public DuplicateSlip pay (final Book book) {
		return ruleProcessor.process(new DuplicateSlipRule(book, new Payment()));
	}

	public Slip pay (final PhysicalProduct physicalProduct) {
		return ruleProcessor.process(new GenerateSlipRule(physicalProduct, new Payment()));
	}

	public Membership pay (final Membership membership) {
		ruleProcessor.process(new MembershipActivationRule(membership, new Payment()));
		return membership;
	}

	public void process (final VoidRule voidRule) {
		ruleProcessor.process(voidRule);
	}

	public <T> T process (final ResultingRule<T> rule) {
		return ruleProcessor.process(rule);
	}
}
