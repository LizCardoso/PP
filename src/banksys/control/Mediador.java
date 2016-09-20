package banksys.control;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.account.TaxAccount;
import banksys.control.exception.BankTransactionException;

public class Mediador {
	
	BankController bankControl;
	AccountController accountControl;
	
	public Mediador(BankController bankController, AccountController accountController){
		this.bankControl = bankController;
		this.accountControl = accountController;
	}

	public void createAccount(int type, String number){
		AbstractAccount account;
		switch(type){
		case 1:
			account = new OrdinaryAccount(number);
			try {
				bankControl.addAccount(account);
				JOptionPane.showMessageDialog(null, "Account created sucessfuly");
			} catch (FileNotFoundException | BankTransactionException e) {
				JOptionPane.showMessageDialog(null, "Error at Account Creation");
			}
		break;
		case 2:
			account = new SavingsAccount(number);
			try {
				bankControl.addAccount(account);
				JOptionPane.showMessageDialog(null, "Account created sucessfuly");
			} catch (FileNotFoundException | BankTransactionException e) {
				JOptionPane.showMessageDialog(null, "Error at Account Creation");
			}
		break;
		case 3:
			account = new SpecialAccount(number);
			try {
				bankControl.addAccount(account);
				JOptionPane.showMessageDialog(null, "Account created sucessfuly");
			} catch (FileNotFoundException | BankTransactionException e1) {
				JOptionPane.showMessageDialog(null, "Error at Account Creation");
			}
			
		break;
		case 4:
			account = new TaxAccount(number);
			try {
				bankControl.addAccount(account);
				JOptionPane.showMessageDialog(null, "Account created sucessfuly");
			} catch (FileNotFoundException | BankTransactionException e) {
				JOptionPane.showMessageDialog(null, "Error at Account Creation");
			}
		break;
		}
	}
	
	public void deleteAccount(String number){
		try {
			bankControl.removeAccount(number);
			JOptionPane.showMessageDialog(null, "Account deleted sucessfuly");
		} catch (FileNotFoundException | BankTransactionException e) {
			JOptionPane.showMessageDialog(null, "Error at Account Deletion");
		}
	}
	public void doCredit(String account, Double value) {
		try {
			accountControl.doCredit(account,value);
			JOptionPane.showMessageDialog(null, "DEPOSIT\nAccount: " + account + "\nValue: " + value + "\nOperation was Sucessfull!");
		} catch (BankTransactionException bte) {
			JOptionPane.showMessageDialog(null, bte.getMessage());
		}
	}
	
	public void doDebit(String account, Double value){
		try {
			accountControl.doDebit(account, value);
			JOptionPane.showMessageDialog(null, "DEBIT\nAccount: " + account + "\nValue: " + value + "\nOperation was Sucessfull!");
		} catch (BankTransactionException bte) {
			JOptionPane.showMessageDialog(null, bte.getMessage());
		}
	}
	
	public void doTransfer(String accountReceiver, String accountSender, Double value){
		try {
			accountControl.doTransfer(accountSender, accountReceiver, value);
			JOptionPane.showMessageDialog(null, "TRANSFER\nSender's Account : " + accountSender + "\nReceivar's Account" + accountReceiver + "\nValue: " + value + "\nOperation was Sucessfull!");
		} catch (BankTransactionException bte) {
			JOptionPane.showMessageDialog(null, bte.getMessage());
		}
	}
	
	public void doIterest(String account){
		try {
			accountControl.doEarnInterest(account);
			JOptionPane.showMessageDialog(null, "Operation was Sucessfull!");
		} catch (BankTransactionException bte) {
			JOptionPane.showMessageDialog(null, bte.getMessage());
		}
	}
	
	public void doEarnBonus (String account){
		try {
			accountControl.doEarnBonus(account);
			JOptionPane.showMessageDialog(null, "Operation was Sucessfull!");
		} catch (BankTransactionException bte) {
			JOptionPane.showMessageDialog(null, bte.getMessage());
		}
	}
	
	public void showBalance(String account){
		try {
			JOptionPane.showMessageDialog(null, "Balance \nAccount: " + account + "\nAmount: " + accountControl.getBalance(account));
		} catch (BankTransactionException bte) {
			JOptionPane.showMessageDialog(null, bte.getMessage());
		}
	}
}
