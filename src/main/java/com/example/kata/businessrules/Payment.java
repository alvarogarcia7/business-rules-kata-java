package com.example.kata.businessrules;

public class Payment {
	public Slip payPhysicalProduct () {
		return new Slip();
	}

	public DuplicateSlip pay (final Book book) {
		return null;
	}
}
