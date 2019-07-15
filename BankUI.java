package ui;

import java.sql.SQLException;
import java.util.Scanner;

import beans.BankBean;
import service.BankService;
import service.BankService1;

//This creates a user interface for user so that the user can connect with database
public class BankUI {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in); // Scanner Object for Taking Input from User
		BankService1 bs = new BankService();
		int i = 1001;
		while (true) {
			System.out.println("****************************************************************");

			System.out.println("                         Pay Wallet");
			System.out.println("****************************************************************");
			System.out.println();

			System.out.println(
					" 1. Create Account \n 2. Show Balance \n 3. Deposit \n 4. Withdraw \n 5. Fund Transfer \n 6. Print Transaction \n 7. Print Info \n 8. Exit \n \n*************************************************************** \n");
			System.out.print("    Enter Your Choice : ");

			int key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.print("    Enter your name : ");
				String name = sc.next();
				name += sc.nextLine();
				while (!bs.checkName(name)) {

					System.out.print("    Enter your name : ");
					name = sc.next();
					name += sc.nextLine();
				}

				System.out.print("    Enter your mobile number : ");
				String mob = sc.next();
				while (!bs.checkM(mob)) {
					System.out.print("    Enter your mobile number : ");
					mob = sc.next();
				}

				System.out.print("    Enter a password :");
				String password = sc.next();
				while (!bs.checkP(password)) {
					System.out.print("    Enter a password :");
					password = sc.next();
				}

				String st = bs.addAccount(name, mob, password, i);
				i++;
				System.out.print("    " + st);

				break;
			case 2:
				System.out.print("    Enter Your Account number : ");
				long accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bs.checkPass(pass, accNo)) {
						long bal = bs.getBalance(accNo);
						System.out.print("    Your account balance is : Rs." + bal + "\n");
					}
				}

				break;
			case 3:
				System.out.print("    Enter Your Account number : ");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bs.checkPass(pass, accNo)) {

						System.out.print("    Enter the amount to be deposited : Rs.");
						long bal1 = sc.nextInt();
						long bal = bs.getBalance(accNo) + bal1;

						bs.setBalance(accNo, bal, "\n    TransID : " + i + "       Amount credited  Rs." + bal1);
						i++;
						System.out.print("    Amount You deposited is Rs." + bal1 + "\n");
						System.out.print("    Total balance is Rs." + bs.getBalance(accNo) + "\n");

					}
				}
				break;
			case 4:
				System.out.print("    Enter Your Account number : ");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bs.checkPass(pass, accNo)) {

						System.out.print("    Enter the amount to be withdrawn : Rs.");
						long bal1 = sc.nextInt();
						long bal = bs.getBalance(accNo) - bal1;
						bs.setBalance(accNo, bal, "\n    TransID : " + i + "       Amount debited    Rs." + bal1);
						System.out.print("    Amount You withdraw is Rs." + bal1 + "\n");
						System.out.print("    Total balance is Rs." + bs.getBalance(accNo) + "\n");
						i++;
					}
				}
				break;
			case 5:
				System.out.print("    Enter Your Account number : ");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bs.checkPass(pass, accNo)) {
						System.out.print("    Enter Account number where you want to transer fund : ");
						long accNo1 = sc.nextLong();
						if (bs.checkAccNo(accNo1)) {
							long bal = bs.getBalance(accNo);
							long bal1 = bs.getBalance(accNo1);

							System.out.print("    Enter the amount to be transferred : Rs.");
							long bal2 = sc.nextInt();
							bs.setBalance(accNo, bal - bal2, "\n    TransID : " + i + "       Amount debited    Rs."
									+ bal2 + "  to Account Number " + accNo1);
							bs.setBalance(accNo1, bal1 + bal2, "\n    TransID : " + i + "        Amount credited  Rs."
									+ bal2 + "  from Account Number " + accNo);
							System.out.print("    Amount You transferred is Rs." + bal2 + "\n");
							System.out.println("    Total balance is Rs." + bs.getBalance(accNo) + "\n");
							i++;
						}
					}
				}
				break;
			case 6:
				System.out.print("    Enter Your Account number : ");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bs.checkPass(pass, accNo)) {
						System.out.print("\n \n**********************Mini Statment***************************\n");
						String strn = bs.getTransaction(accNo);
						System.out.print("    " + strn + "\n");
						System.out.print("    Total balance is Rs." + bs.getBalance(accNo) + "\n");

					}
				}
				break;
			case 7:
				System.out.print("    Enter Your Account number : ");
				accNo = sc.nextLong();
				if (bs.checkAccNo(accNo)) {
					System.out.print("    Enter your Password : ");
					String pass = sc.next();
					if (bs.checkPass(pass, accNo)) {
						BankBean b = bs.getInfo(accNo);
						System.out
								.println("\n \n************Account Information*********** \n*    Account Holder Name : "
										+ b.getName() + "           *\n*    Account Number      : " + b.getAccNo()
										+ "    *\n*    Mobile Number       : " + b.getMobile()
										+ "    *\n*    Account Balance     : Rs." + b.getBalance() + "       *");
						System.out.println("****************************************** \n \n");
					}
				}
				break;
			case 8:
				System.exit(0);
			default:
				System.out.println("    Enter proper choice : ");
				break;

			}

		}
	}
}
