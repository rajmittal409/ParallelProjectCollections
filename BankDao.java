package daomap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import beans.BankBean;

//Class where all methods of interafce BankDao1 are overrided 
public class BankDao implements BankDao1 {
	HashMap hm = new HashMap();		//Hashmap which is storing all account holders information
	BankBean bb1;					//object of Bankbean class

	@Override	// getting Balance of account holder by reference to their accno
	public long getBalance(long accNo) { 
		if (hm.containsKey(accNo)) {
			bb1 = (BankBean) hm.get(accNo);
			return bb1.getBalance();
		} else
			return 9999;
	}

	@Override	// getting Transaction of account holder by reference to their accno
	public String getTransaction(long accNo) {	
		if (hm.containsKey(accNo)) {
			bb1 = (BankBean) hm.get(accNo);
			return bb1.getTran();
		} else
			return " ";
	}

	@Override	// getting Balance of account holder by reference to their accno	
	public void setBalance(long accNo, long bal, String st) throws ClassNotFoundException, SQLException {
		if (hm.containsKey(accNo)) {
			bb1 = (BankBean) hm.get(accNo);
			bb1.setBalance(bal);
			String str = bb1.getTran() + st;
			bb1.setTran(str);

		}
	}

	@Override	// Checking if an Account is already present by using Mobile number	
	public boolean checkMobile(String mob) throws ClassNotFoundException, SQLException {
		if (hm.containsKey(mob + 10000))
			return false;
		else
			return true;

	}

	@Override	// Checking if a password of account holder is correct by reference to their password and accno	
	public boolean checkPassword(String str, long accNo) throws ClassNotFoundException, SQLException {
		if (hm.containsKey(accNo)) {
			bb1 = (BankBean) hm.get(accNo);
			if (str.equals(bb1.getPassword())) {
				return true;
			}
			return false;
		} else
			return false;

	}

	@Override	// Checking if an Account number is present by using accNo	
	public boolean checkAccNo(long accNo) throws ClassNotFoundException, SQLException {
		if (hm.containsKey(accNo))
			return true;
		else
			return false;

	}

	@Override	// Setting up of data in HashMap object by using BankBean class Object
	public void setData(BankBean bb) throws ClassNotFoundException, SQLException {
		hm.put(bb.getAccNo(), bb);

	}
	
	@Override	// Getting information of account holder using accNo
	public BankBean getInfo(long accNo) {
		// TODO Auto-generated method stub
		BankBean b=(BankBean)hm.get(accNo);
		return b;
	}

}
