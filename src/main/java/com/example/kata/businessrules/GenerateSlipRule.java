package com.example.kata.businessrules;

public class GenerateSlipRule implements Rule {
	private final PhysicalProduct physicalProduct;
	private final Payment payment;
	private Slip result;

	public GenerateSlipRule (final PhysicalProduct physicalProduct, final Payment payment) {
		this.physicalProduct = physicalProduct;
		this.payment = payment;
	}

	@Override
	public void apply () {
		result = new Slip();
	}

	public Slip result () {
		return result;
	}
}
