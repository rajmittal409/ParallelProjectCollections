package service;

import java.sql.SQLException;

import beans.BankBean;

//interface where all methods for validation and exception handling is declared
public interface BankService1 {

	long getBalance(long accNo) throws ClassNotFoundException, SQLException;

	String getTransaction(long accNo) throws ClassNotFoundException, SQLException;

	void setBalance(long accNo, long bal, String st) throws ClassNotFoundException, SQLException;

	boolean checkAccNo(long acc) throws ClassNotFoundException, SQLException;

	boolean checkPass(String st, long accNo) throws ClassNotFoundException, SQLException;

	boolean checkName(String name);

	boolean checkM(String mob);

	boolean checkP(String password);

	String addAccount(String name, String mobile, String password,int i) throws SQLException, ClassNotFoundException;

	BankBean getInfo(long accNo);

}
