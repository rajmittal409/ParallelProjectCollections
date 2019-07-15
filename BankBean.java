package beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class BankBean { 	//Bean class where all information of an account holder is stored in an object
	private String name;
	private String mobile;
	private long balance;
	private String password;
	private String tran;
	private long accNo;

	// Setters And Getters of all private Variables
	public String getName() {
		return name;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTransaction(String tran) {
		this.tran = tran;

	}

	public String getMobile() {
		return mobile;
	}

	public long getAccNo() {
		return accNo;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long bal) {
		this.balance = bal;
	}

	public boolean getPassword(String password) {
		if (this.password.equals(password))
			return true;
		else
			return false;

	}

	public String getPassword1() {
		return password;

	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTran() {
		return tran;
	}

	public void setTran(String tran) {
		this.tran = tran;
	}

	public String getPassword() {
		return password;
	}

	

	public void setPassword(String password) {
		this.password = password;
	}

	//Constructor receiving all infos and assinging them to private variables 
	public BankBean(String name, long accNo, String mobile, String password, long bal, String tan) throws SQLException {

		this.name = name;

		this.mobile = mobile;
		this.password = password;
		balance = bal;
		tran = tan;
		this.accNo = accNo;

	}

	
	@Override
	public String toString() {
		return "CreateAccount [ name=" + name + ", mobile=" + mobile + ", balance=" + balance + ", password=" + password
				+ ", tran=" + tran + "]";
	}

}