package banksys.control;

import java.io.FileNotFoundException;
import java.io.IOException;

import banksys.account.AbstractAccount;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;
import banksys.control.exception.BankTransactionException;
import banksys.control.exception.IncompatibleAccountException;
import banksys.operationslog.OperationsLog;
import banksys.persistence.IAccountRepository;
import banksys.persistence.exception.AccountNotFoundException;

public class AccountController{
	
	IAccountRepository repository;
	AbstractAccount account;
	public OperationsLog log = new OperationsLog();
	
	public AccountController(IAccountRepository repository) {
		this.repository = repository;
	}

	public AbstractAccount associateAccount(String number) throws BankTransactionException{
		try {
			return this.repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		
	}
	
	public void doCredit(String number, double amount) throws BankTransactionException {
		
		account = associateAccount(number);	
			
		try {
			account.credit(amount);
			repository.persist();
		} catch (NegativeAmountException | FileNotFoundException nae) {
			throw new BankTransactionException(nae);
		}
		
		try {
			log.userOperationCredDeb("Credit", number, amount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doDebit(String number, double amount) throws BankTransactionException {
		
		account = associateAccount(number);	
		
		try {
			account.debit(amount);
			repository.persist();
		} catch (NegativeAmountException | InsufficientFundsException | IOException e) {
			throw new BankTransactionException(e);
		}
		
		try {
			log.userOperationCredDeb("Debit", number, amount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double getBalance(String number) throws BankTransactionException {
		
		account = associateAccount(number);	
		return account.getBalance();
		
	}

	public void doTransfer(String fromNumber, String toNumber, double amount) throws BankTransactionException {
		AbstractAccount fromAccount;
		fromAccount = associateAccount(fromNumber);	

		AbstractAccount toAccount;
			toAccount = associateAccount(toNumber);	;

		try {
			fromAccount.debit(amount);
			toAccount.credit(amount);
			repository.persist();
		} catch (InsufficientFundsException | NegativeAmountException | IOException e) {
			throw new BankTransactionException(e);
		}
		
		try {
			log.userOperationTransf(fromNumber, toNumber, amount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doEarnInterest(String number) throws BankTransactionException, IncompatibleAccountException {
		
		account = associateAccount(number);	
		
		if (account instanceof SavingsAccount) {
			((SavingsAccount) account).earnInterest();
			try {
				repository.persist();
			} catch (FileNotFoundException e) {
				throw new BankTransactionException(e);
			}
		} else {
			throw new IncompatibleAccountException(number);
		}
		
		try {
			log.userOperationEarn("Earn Interest", number);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doEarnBonus(String number) throws BankTransactionException, IncompatibleAccountException {
		
		account = associateAccount(number);	

		if (account instanceof SpecialAccount) {
			((SpecialAccount) account).earnBonus();
			try {
				repository.persist();
			} catch (FileNotFoundException e) {
				throw new BankTransactionException(e);
			}
		} else {
			throw new IncompatibleAccountException(number);
		}
		
		try {
			log.userOperationEarn("Earn Bonus", number);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
