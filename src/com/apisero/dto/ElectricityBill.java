package com.apisero.dto;

public class ElectricityBill {

	private String consumerNumber;
	private String consumerName;
	private String consumerAddress;
	private int unitsConsumed;
	private double billAmount;
	public String getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getConsumerAddress() {
		return consumerAddress;
	}
	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}
	public int getUnitsConsumed() {
		return unitsConsumed;
	}
	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public ElectricityBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElectricityBill(String consumerNumber, String consumerName, String consumerAddress, int unitsConsumed,
			double billAmount) {
		super();
		this.consumerNumber = consumerNumber;
		this.consumerName = consumerName;
		this.consumerAddress = consumerAddress;
		this.unitsConsumed = unitsConsumed;
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "\nElectricityBill [consumerNumber=" + consumerNumber + ", consumerName=" + consumerName
				+ ", consumerAddress=" + consumerAddress + ", unitsConsumed=" + unitsConsumed + ", billAmount="
				+ billAmount + "]";
	}
	
	public void calculateBillAmount(ElectricityBill obj) {
		double amount=0;
		 int units=obj.getUnitsConsumed();
		 if (units <= 100) {
	            amount=0;
	        }
	        else if (units <= 300) {
	            amount=(100*0)+((units - 100)* 1.5);
	        }
	        else if (units <= 600) {
	            amount= (100 * 0)
	                + (200 * 1.5)
	                + (units - 300)
	                      * 3.5;
	        }
	        else if (units <= 1000) {
	            amount= (100 * 0)
	                + (200 * 1.5)
	                +(300 * 3.5)
	                + (units - 600)
	                      * 5.5;
	        }
	        else if (units > 1000) {
	            amount= (100 * 0)
	                + (200 * 1.5)
	                + (300 * 3.5)
	                + (units - 600)
	                      * 5.5;
	        }
		 
		 obj.setBillAmount(amount);
	}
	
}
