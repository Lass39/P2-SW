package P2;

import java.util.Date;

//@author 
//Giovanni Fernandes CB1640488

public class order {

	private int ordNo, customerId, salesmanId;
	private Date ordDate;
	private float purchAmt;
	
	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
	
	public Date getOrdDate() {
		return ordDate;
	}
	
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	
	public float getPurchAmt() {
		return purchAmt;
	}
	
	public void setPurchAmt(float purchAmt) {
		this.purchAmt = purchAmt;
	}
}
