package banksys.control;

import java.io.FileNotFoundException;
import java.io.IOException;

import banksys.account.AbstractAccount;
import banksys.control.exception.BankTransactionException;
import banksys.operationslog.OperationsLog;
import banksys.persistence.IAccountRepository;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;

public class BankController {

	protected IAccountRepository repository;
	public OperationsLog log = new OperationsLog();
	
	public BankController(IAccountRepository repository) {
		this.repository = repository;
	}

	public void addAccount(AbstractAccount account) throws BankTransactionException, FileNotFoundException {
		try {
			this.repository.create(account);
		} catch (AccountCreationException ace) {
			throw new BankTransactionException(ace);
		}
		
		try {
			log.adminOperation("Account Adition", account.getNumber());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeAccount(String number) throws BankTransactionException, FileNotFoundException {
		try {
			this.repository.delete(number);
		} catch (AccountDeletionException ade) {
			throw new BankTransactionException(ade);
		}
		
		try {
			log.adminOperation("Account Removal", number);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IAccountRepository getRepository() {
		return repository;
	}
	
}
