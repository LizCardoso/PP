package banksys.operationslog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

public class OperationsLog {
	
	BufferedWriter bw = null;
	FileWriter arq;
	File log;
	String writable;
	String line = System.getProperty("line.separator");
	GregorianCalendar dh = new GregorianCalendar();
	
	public OperationsLog(){
		log = new File("log.txt");
		if(!log.exists()){
			try{
				log.createNewFile();
			}catch(IOException ex){
			    ex.printStackTrace();		
			}	
		}
		
	}
	
	public void writer(String operation) throws IOException{
		try{
			arq= new FileWriter(log, true);
		}catch(IOException ex){
		    ex.printStackTrace();			
		}
		
		try{
		bw = new BufferedWriter(arq);	
		bw.write(operation);
		bw.newLine();
		bw.flush();
		}catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
		bw.close();
		arq.close();
        }
	}
	
	public void adminOperation(String operation, String account) throws IOException{
		writable = "--------------------------------------------"+line
				+ "Operation: "+operation+line
				+ "Account: "+account+line
				+dh.getTime()+line
				+ "--------------------------------------------"+line;
		writer(writable);
	}
	
	public void userOperationCredDeb(String operation, String account, double amount) throws IOException{
		writable = "--------------------------------------------"+line
				+ "Operation: "+operation+line
				+ "Account: "+account+line
				+ "Amount: "+amount+line
				+dh.getTime()+line
				+ "--------------------------------------------"+line;
		writer(writable);
	}
	
	public void userOperationTransf(String fromAccount, String toAccount, double amount) throws IOException{
		writable = "--------------------------------------------"+line
				+ "Operation: Transference"+line
				+ "Origin Account: "+fromAccount+line
				+ "Destiny Account: "+toAccount+line
				+ "Amount: "+amount+line
				+dh.getTime()+line
				+ "--------------------------------------------"+line;
		writer(writable);
	}	
	public void userOperationEarn(String operation, String account) throws IOException{
		writable = "--------------------------------------------"+line
				+ "Operation: "+operation+line
				+ "Account: "+account+line
				+dh.getTime()+line
				+ "--------------------------------------------"+line;
		writer(writable);
	}
}

