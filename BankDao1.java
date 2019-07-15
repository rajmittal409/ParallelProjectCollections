package daomap;

import java.sql.SQLException;

import beans.BankBean;

public interface BankDao1 {  //interface where all methods for accessing database is declared
	
	long getBalance(long accNo) throws ClassNotFoundException, SQLException;

	void setBalance(long accNo, long bal, String st) throws ClassNotFoundException, SQLException;

	boolean checkMobile(String mob) throws ClassNotFoundException, SQLException;


	boolean checkAccNo(long accNo) throws ClassNotFoundException, SQLException;

	void setData(BankBean bb) throws ClassNotFoundException, SQLException;

	String getTransaction(long accNo);

	boolean checkPassword(String str, long accNo) throws ClassNotFoundException, SQLException;

	BankBean getInfo(long accNo);

	}
