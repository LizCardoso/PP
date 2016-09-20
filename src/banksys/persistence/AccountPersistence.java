package banksys.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import banksys.account.AbstractAccount;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;
import banksys.persistence.exception.AccountNotFoundException;

public class AccountPersistence implements IAccountRepository{

	ArrayList<AbstractAccount> repository = null;
	XStream persister;
	
	public AccountPersistence(){
		this.persister = new XStream();
		try{
			this.capture();
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Error: " + fnfe.getMessage());
		}
		
		if(this.repository == null){
			this.repository = new ArrayList<>();
			try {
				this.persist();
			} catch (FileNotFoundException fnfe) {
				System.out.println("Error: " + fnfe.getMessage());
			}
		}
	}
	
	@Override
	public void create(AbstractAccount account) throws AccountCreationException, FileNotFoundException {
		if (this.findAccount(account.getNumber()) == null) {
			this.repository.add(account);
			this.persist();
		} else {
			throw new AccountCreationException("OrdinaryAccount alredy exist!", account.getNumber());
		}
	}

	@Override
	public void delete(String number) throws AccountDeletionException, FileNotFoundException {
		AbstractAccount account = this.findAccount(number);
		if (account != null) {
			this.repository.remove(account);
			this.persist();
		} else {
			throw new AccountDeletionException("OrdinaryAccount doesn't exist!", number);
		}
	}

	@Override
	public AbstractAccount retrieve(String number) throws AccountNotFoundException {
		AbstractAccount account = findAccount(number);
		if (account != null) {
			return account;
		} else {
			throw new AccountNotFoundException("OrdinaryAccount not found!", number);
		}
	}

	@Override
	public AbstractAccount[] list() {
		AbstractAccount[] list = null;
		if (this.repository.size() > 0) {
			list = new AbstractAccount[this.repository.size()];
			for (int i = 0; i < this.repository.size(); i++) {
				list[i] = (AbstractAccount) this.repository.get(i);
			}
		}
		return list;
	}
	
	private AbstractAccount findAccount(String number) {
		if (this.repository.size() > 0) {
			for (int i = 0; i < this.repository.size(); i++) {
				AbstractAccount account = (AbstractAccount) this.repository.get(i);
				if (account.getNumber().equals(number)) {
					return account;
				}
			}
		}
		return null;
	}
	
	public void persist() throws FileNotFoundException{
		persister.toXML(repository, new FileOutputStream(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "repositoryFile.txt"));
	}
	
	@SuppressWarnings("unchecked")
	public void capture() throws FileNotFoundException{
		File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "repositoryFile.txt");
		if(file.length() != 0){
			this.repository = (ArrayList<AbstractAccount>)persister.fromXML(new FileInputStream(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "repositoryFile.txt"));
		}
	}

	@Override
	public int mumberOfAccounts() {
		return this.repository.size();
	}

}