package service;

import java.sql.SQLException;

import beans.BankBean;

// This is a user-defined Exception class
class MyException extends Exception {
	String s1;

	MyException(String s) {
		s1 = s;

	}

	public String toString() {
		return (s1);
	}

}
//[0-9A-Za-z]{6,}
//(0-9)*(A-Z)*(a-z)*[0-9A-Za-z]{6,}
// Class for validating the data entered by Account holder and an intermediate between UI and Dao Class
public class BankService implements BankService1 {
	daomap.BankDao1 bd = new daomap.BankDao();

	public boolean checkName(String name)
	{
		String regex = "^[A-Z][a-z]*( [A-Z][a-z]*)*";
		try {
		if(name.matches(regex)) 
		return true;
		else 
			throw new MyException("     Invalid Name");}
		catch (MyException E) {
			System.out.println(E);
			return false;}
	}
	 //Validating Name of new account Holder
	public boolean checkName2(String name) {
		int n = name.length();
		char[] ch = name.toCharArray();
		for (int i = 0; i < n; i++) {
			try {
				if (ch[i] > 64 && ch[i] < 122 && ch[0]>64 && ch[0]<90) {
					continue;
				} else {
					throw new MyException("     Invalid Name");
				}
			} catch (MyException E) {
				System.out.println(E);
				return false;
			}

		}
		return true;

	}

	@Override 	//Getting Balance of an Account holder from class dao and forwarding it to UI
	public long getBalance(long accNo) throws ClassNotFoundException, SQLException {
		long bal = bd.getBalance(accNo);
		return bal;

	}

	@Override	//Getting transaction of a Account holder from class dao and forwarding it to UI
	public String getTransaction(long accNo) throws ClassNotFoundException, SQLException {
		String str = bd.getTransaction(accNo);
		return str;

	}

	@Override	//updating Balance of an account holder 
	public void setBalance(long accNo, long bal, String st) throws ClassNotFoundException, SQLException {

		
		bd.setBalance(accNo, bal, st);

	}
@Override	// Adding all information of an account holder to an object of BankBean class and sending it ton dao class
	public String addAccount(String name, String mobile,  String password,int i)
			throws SQLException, ClassNotFoundException {
		long accNo = Long.parseLong(mobile) - 10000;
		if (bd.checkMobile(mobile)) {
			BankBean bb = new BankBean(name, accNo, mobile, password, 1000, "    Account Created Successfully \n    TransID : "+i+"       Amount Deposited Rs.1000");
			bd.setData(bb);
			return "Account Created Successfully \n    Your Account number is \"" + accNo +"\"\n";
		} else
			return "Account already created ";
	}

	@Override	// Checking Correct account number by referring to database
	public boolean checkAccNo(long acc) throws ClassNotFoundException, SQLException {
		try {
			if (bd.checkAccNo(acc)) {

				return true;
			}

			else
				throw new MyException("    Wrong Account Number");
		} catch (MyException E) {
			System.out.println(E);
		}
		return false;
	}

	@Override	// Checking Correct password by referring to database
	public boolean checkPass(String st, long accNo) throws ClassNotFoundException, SQLException {
		try {
			if (bd.checkPassword(st, accNo)) {

				return true;
			} else
				throw new MyException("    Wrong Password");
		} catch (MyException E) {
			System.out.println(E);
		}
		return false;
	}

	@Override	//Validating Mobile of new account Holder
	public boolean checkM(String mob) {
		// TODO Auto-generated method stub
	
		int n = mob.length();
		char []ch=mob.toCharArray();
		
		try {
			if (n == 10 ) {
				for(int i=0;i<n;i++) {
					if(ch[i]>47 && ch[i]<58) {
						continue;
					}
					else
						throw new MyException("    Invalid Number \n    Enter 10 digits");
											
				}
				return true;
				
			} else {
				throw new MyException("    Invalid Number \n    Enter 10 digits");
			}
		} catch (MyException E) {
			System.out.println(E);
			return false;
		}

	}

	@Override	//Validating password of new account Holder
	public boolean checkP(String password) {
		// TODO Auto-generated method stub
	
		try {
			if (password.length() >= 6) {
				return true;
			} else {
				throw new MyException("    Invalid Password \n    Enter more than six characters");
			}
		} catch (MyException E) {
			System.out.println(E);
			return false;
		}

	}
@Override	//passing info of account holder from dao class to User interface to display
	public BankBean getInfo(long accNo) {
		// TODO Auto-generated method stub
		BankBean b=bd.getInfo(accNo);
		return b;
	}
}
