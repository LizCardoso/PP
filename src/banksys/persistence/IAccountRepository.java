package banksys.persistence;

import java.io.FileNotFoundException;

import banksys.account.AbstractAccount;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;
import banksys.persistence.exception.AccountNotFoundException;

public interface IAccountRepository {

	public void create(AbstractAccount account) throws AccountCreationException, FileNotFoundException;

	public void delete(String number) throws AccountDeletionException, FileNotFoundException;

	public AbstractAccount retrieve(String number) throws AccountNotFoundException;

	public AbstractAccount[] list();

	public void persist() throws FileNotFoundException;
	
	public void capture() throws FileNotFoundException;
	
	public int mumberOfAccounts();
}
