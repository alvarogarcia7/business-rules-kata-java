package com.example.kata.businessrules.rule;

import com.example.kata.businessrules.Book;
import com.example.kata.businessrules.DuplicateSlip;
import com.example.kata.businessrules.Payment;

public class DuplicateSlipRule implements Rule{
	private final Book book;
	private final Payment payment;

	private DuplicateSlip result;

	public DuplicateSlipRule (final Book book, final Payment payment) {
		this.book = book;
		this.payment = payment;
	}

	@Override
	public void apply () {
		result = new DuplicateSlip();
	}

	public DuplicateSlip result () {
		return result;
	}
}
