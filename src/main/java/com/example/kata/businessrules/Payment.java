package com.example.kata.businessrules;

public class Payment {

	public DuplicateSlip pay (final Book book) {
		return new DuplicateSlip();
	}

	public Slip pay (final PhysicalProduct physicalProduct) {
		return new Slip();
	}
}
