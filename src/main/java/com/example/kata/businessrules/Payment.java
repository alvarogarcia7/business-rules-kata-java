package com.example.kata.businessrules;

public class Payment {
	public Slip payPhysicalProduct () {
		return new Slip();
	}

	public DuplicateSlip pay (final Book book) {
		return new DuplicateSlip();
	}

	public Slip pay (final PhysicalProduct physicalProduct) {
		return payPhysicalProduct();
	}
}
