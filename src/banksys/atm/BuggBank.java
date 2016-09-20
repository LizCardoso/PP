package banksys.atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import banksys.control.AccountController;
import banksys.control.BankController;
import banksys.control.Mediador;
import banksys.persistence.AccountPersistence;

public class BuggBank {

	//Atributos utilizados na reception
	JFrame reception;
	
	//atributos de usuario
	JFrame menuUser;
	JLabel title;
	JLabel titleClient;
	JLabel titleAdm;
	JButton adm;
	JButton client;
	
	JFrame menuAdmin;
	
	// atributos utilizados para o cliente
	JFrame menuClient;
	JButton doCredit;
	JButton doDebit;
	JButton showBalance;
	JButton doTransfer;
	JButton earnBonus;
	JButton earnIterest;
	
	//Atributos utilizados no menu doCredit
	JFrame menuDoCredit;
	JButton btnCredit;
	JLabel lblAccount;
	JLabel lblValue;
	JTextField textAccount;
	JTextField textValue;
	JLabel lblCredit;
	
	//Atributos utilizados no menu CreateAccount
	JFrame menuCreateAccount;
	JLabel lblCreateAcc;
	JLabel lblAccNumb; //Tambem utilizado no DeleteAccount
	JTextField textAccNumb; //Tambem utilizado no DeleteAccount
	JButton btnCreate;
	JRadioButton rdbtnOrdinaryAccount;
	JRadioButton rdbtnSavingsAccount;
	JRadioButton rdbtnSpecialAccount;
	JRadioButton rdbtnTaxAccount;
	
	//Atributos utilizados no menu DeleteAccount
	JFrame menuDeleteAccount;
	JLabel lblDeleteAcc;
	JButton btnDelete;
	
	
	
	JLabel lblreception;
	JLabel lblBackground;
	
	//atributos de bonus
	JButton btnBonus;
	JFrame menuBonus; 
	
	//atributos do balance
	JFrame menuBalance;
	JButton btnBalance ;
	

	private JFrame menuDoDebit;
	private JButton btnDebit;
	JLabel lblDebit;

	private JFrame menuDoIterest;

	private JButton btnIterest;

	private JFrame menuDoTransfer;

	private JLabel lblAccountSender;

	private JTextField textAccountSender;

	private JTextField textAccountReceiver;

	private JLabel lblAccountReceiver;

	private JLabel lblTransfer;
	
	BankController bank = new BankController(new AccountPersistence());
	AccountController accountControl = new AccountController(bank.getRepository());
	Mediador mediador = new Mediador(bank, accountControl);

	private JButton btnTransfer;

	private JButton btnUndo;
	
		
	public static void main(String[] args) throws InterruptedException {
		BuggBank graphics = new BuggBank();
		graphics.reception();
		graphics.menuUser();
	}
	
	private void reception() throws InterruptedException{
		reception = new JFrame("BUGGBANK");
		reception.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reception.setBounds(100, 100, 600, 600);
		reception.setLocationRelativeTo(null);
		reception.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		reception.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblreception = new JLabel("");
		lblreception.setIcon(new ImageIcon(getClass().getResource("/banksys/images/Fundo_BuggBank.jpg")));
		lblreception.setBounds(0, 0, 584, 561);
		contentPane.add(lblreception);
		
		reception.setVisible(true);
		Thread.sleep(3000);
		reception.dispose();
	}
	
	private void menuUser(){
		menuUser = new JFrame("BUGGBANK");
		menuUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuUser.setBounds(100, 100, 600, 600);
		menuUser.setLocationRelativeTo(null);
		menuUser.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuUser.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		adm = new JButton("");
		adm.setIcon(new ImageIcon(getClass().getResource("/banksys/images/adm.png")));
		adm.setBounds(56, 205, 204, 204);
		contentPane.add(adm);
		adm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuUser.dispose();
				menuAdmin();
			}
		});
		
		client = new JButton("");
		client.setIcon(new ImageIcon(getClass().getResource("/banksys/images/Clients.png")));
		client.setBounds(322, 205, 204, 204);
		contentPane.add(client);
		client.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuUser.dispose();
				menuClient();
			}
		});
		
		titleAdm = new JLabel("Administrator");
		titleAdm.setHorizontalAlignment(SwingConstants.CENTER);
		titleAdm.setFont(new Font("Vani", Font.PLAIN, 30));
		titleAdm.setBounds(56, 420, 204, 48);
		contentPane.add(titleAdm);
		
		titleClient = new JLabel("Client");
		titleClient.setHorizontalAlignment(SwingConstants.CENTER);
		titleClient.setFont(new Font("Vani", Font.PLAIN, 30));
		titleClient.setBounds(322, 417, 204, 51);
		contentPane.add(titleClient);
		
		title = new JLabel("Choose a User:");
		title.setFont(new Font("Vani", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(56, 44, 470, 79);
		contentPane.add(title);
		
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuUser.setVisible(true);
	}
	
	private void menuClient(){
		menuClient = new JFrame("BUGGBANK");
		menuClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuClient.setBounds(100, 100, 600, 600);
		menuClient.setLocationRelativeTo(null);
		menuClient.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuClient.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClient.dispose();
				menuUser();
			}
		});
		
		doCredit = new JButton("");
		doCredit.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconCredit.png")));
		doCredit.setBounds(79, 121, 202, 81);
		contentPane.add(doCredit);
		doCredit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClient.dispose();
				menuDoCredit();
			}
		});
		
		doDebit = new JButton("");
		doDebit.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconDebit.png")));
		doDebit.setBounds(327, 121, 202, 81);
		contentPane.add(doDebit);
		doDebit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClient.dispose();
				menuDoDebit();
			}
		});
		
		showBalance = new JButton("");
		showBalance.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconShowBalance.png")));
		showBalance.setBounds(327, 228, 202, 81);
		contentPane.add(showBalance);
		showBalance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClient.dispose();
				menuBalance();
				
			}
		});
		
		doTransfer = new JButton("");
		doTransfer.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconTranf.png")));
		doTransfer.setBounds(79, 228, 202, 81);
		contentPane.add(doTransfer);
		doTransfer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClient.dispose();
				menuDoTransfer();
			}
		});
		
		earnBonus = new JButton("");
		earnBonus.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconEarnBonus.png")));
		earnBonus.setBounds(79, 341, 202, 81);
		contentPane.add(earnBonus);
		earnBonus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClient.dispose();
				menuEarnBonus();
				
			}
		});
		
		earnIterest = new JButton("");
		earnIterest.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconEarnIterest.png")));
		earnIterest.setBounds(327, 341, 202, 81);
		contentPane.add(earnIterest);
		earnIterest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuClient.dispose();
				menuDoIterest();
			}
		});
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuClient.setVisible(true);
	}
	
	private void menuAdmin(){
		menuAdmin = new JFrame("BUGGBANK");
		menuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuAdmin.setBounds(100, 100, 600, 600);
		menuAdmin.setLocationRelativeTo(null);
		menuAdmin.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuAdmin.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuAdmin.dispose();
				menuUser();
			}
		});
		
		JButton deleteAccButton = new JButton("");
		deleteAccButton.setIcon(new ImageIcon(getClass().getResource("/banksys/images/Deleteaccount.png")));
		deleteAccButton.setBackground(SystemColor.menu);
		deleteAccButton.setBounds(321, 217, 253, 101);
		contentPane.add(deleteAccButton);
		deleteAccButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuAdmin.dispose();
				menuDeleteAccount();	
			}	
		});
		
		JButton createAccButton = new JButton("");
		createAccButton.setBackground(SystemColor.menu);
		createAccButton.setIcon(new ImageIcon(getClass().getResource("/banksys/images/Createaccount.png")));
		createAccButton.setBounds(10, 217, 253, 101);
		contentPane.add(createAccButton);
		createAccButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuAdmin.dispose();
				menuCreateAccount();	
			}	
		});
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuAdmin.setVisible(true);
	}
	
	private void menuCreateAccount(){
		menuCreateAccount = new JFrame("BUGGBANK");
		menuCreateAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuCreateAccount.setBounds(100, 100, 600, 600);
		menuCreateAccount.setLocationRelativeTo(null);
		menuCreateAccount.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuCreateAccount.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuCreateAccount.dispose();
				menuAdmin();
			}
		});
		
		rdbtnOrdinaryAccount = new JRadioButton("Ordinary Account");
		rdbtnOrdinaryAccount.setBounds(165, 106, 109, 23);
		contentPane.add(rdbtnOrdinaryAccount);
		
		rdbtnSavingsAccount = new JRadioButton("Savings Account");
		rdbtnSavingsAccount.setBounds(165, 148, 109, 23);
		contentPane.add(rdbtnSavingsAccount);
		
		rdbtnSpecialAccount = new JRadioButton("Special Account");
		rdbtnSpecialAccount.setBounds(381, 106, 109, 23);
		contentPane.add(rdbtnSpecialAccount);
		
		rdbtnTaxAccount = new JRadioButton("Tax Account");
		rdbtnTaxAccount.setBounds(381, 148, 109, 23);
		contentPane.add(rdbtnTaxAccount);
		
		lblCreateAcc = new JLabel("Create New Account");
		lblCreateAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAcc.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblCreateAcc.setBounds(168, 47, 276, 66);
		contentPane.add(lblCreateAcc);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnOrdinaryAccount);
		group.add(rdbtnSavingsAccount);
		group.add(rdbtnSpecialAccount);
		group.add(rdbtnTaxAccount);
		
		textAccNumb = new JTextField();
		textAccNumb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAccNumb.setBounds(296, 222, 194, 57);
		contentPane.add(textAccNumb);
		textAccNumb.setColumns(10);
		
		lblAccNumb = new JLabel("Account Number:");
		lblAccNumb.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccNumb.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccNumb.setBounds(50, 220, 224, 57);
		contentPane.add(lblAccNumb);
		
		btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon(getClass().getResource("/banksys/images/CreateConf.png")));
		btnCreate.setBounds(168, 290, 241, 92);
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnOrdinaryAccount.isSelected()){
					mediador.createAccount(1, textAccNumb.getText());
				}else if(rdbtnSavingsAccount.isSelected()){
					mediador.createAccount(2, textAccNumb.getText());
				}else if(rdbtnSpecialAccount.isSelected()){
					mediador.createAccount(3, textAccNumb.getText());
				}else if (rdbtnTaxAccount.isSelected()){
					mediador.createAccount(4, textAccNumb.getText());
				}else{
					JOptionPane.showMessageDialog(null, "NO ACCOUNT TYPE IS SELECTED");
				}
			}
			
		});

		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuCreateAccount.setVisible(true);
	}
	
	private void menuDeleteAccount(){
		menuDeleteAccount = new JFrame("BUGGBANK");
		menuDeleteAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuDeleteAccount.setBounds(100, 100, 600, 600);
		menuDeleteAccount.setLocationRelativeTo(null);
		menuDeleteAccount.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuDeleteAccount.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuDeleteAccount.dispose();
				menuAdmin();
			}
		});
		
		lblDeleteAcc = new JLabel("Delete Account");
		lblDeleteAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteAcc.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblDeleteAcc.setBounds(168, 47, 276, 66);
		contentPane.add(lblDeleteAcc);
		
		textAccNumb = new JTextField();
		textAccNumb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAccNumb.setBounds(296, 222, 194, 57);
		contentPane.add(textAccNumb);
		textAccNumb.setColumns(10);
		
		lblAccNumb = new JLabel("Account Number:");
		lblAccNumb.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccNumb.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccNumb.setBounds(50, 220, 224, 57);
		contentPane.add(lblAccNumb);
		
		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(getClass().getResource("/banksys/images/DeleteConf.png")));
		btnDelete.setBounds(168, 290, 247, 92);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.deleteAccount(textAccNumb.getText());
			}
			
		});

		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuDeleteAccount.setVisible(true);
	}
	
	private void menuDoDebit(){
		menuDoDebit = new JFrame("BUGGBANK");
		menuDoDebit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuDoDebit.setBounds(100, 100, 600, 600);
		menuDoDebit.setLocationRelativeTo(null);
		menuDoDebit.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuDoDebit.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuDoDebit.dispose();
				menuClient();
			}
		});
		
		textAccount = new JTextField();
		textAccount.setBounds(274, 148, 172, 57);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		
		lblAccount = new JLabel("Account :");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccount.setBounds(63, 148, 172, 57);
		contentPane.add(lblAccount);
		
		textValue = new JTextField();
		textValue.setBounds(274, 253, 172, 57);
		contentPane.add(textValue);
		textValue.setColumns(10);
		
		lblValue = new JLabel("Value :");
		lblValue.setForeground(new Color(0, 0, 0));
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblValue.setBounds(63, 253, 172, 57);
		contentPane.add(lblValue);
		
		btnDebit = new JButton("");
		btnDebit.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconDebitValue.png")));
		btnDebit.setBounds(186, 355, 215, 102);
		contentPane.add(btnDebit);
		btnDebit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String account = textAccount.getText();
				Double value = Double.valueOf(textValue.getText());
				mediador.doDebit(account, value);
			}
		});
		
		lblDebit = new JLabel("DEBIT");
		lblDebit.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblDebit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDebit.setBounds(186, 47, 215, 57);
		contentPane.add(lblDebit);

		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuDoDebit.setVisible(true);
	}
	
	private void menuDoCredit(){
		menuDoCredit = new JFrame("BUGGBANK");
		menuDoCredit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuDoCredit.setBounds(100, 100, 600, 600);
		menuDoCredit.setLocationRelativeTo(null);
		menuDoCredit.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuDoCredit.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuDoCredit.dispose();
				menuClient();
			}
		});
		
		textAccount = new JTextField();
		textAccount.setBounds(274, 148, 172, 57);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		
		lblAccount = new JLabel("Account :");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccount.setBounds(63, 148, 172, 57);
		contentPane.add(lblAccount);
		
		textValue = new JTextField();
		textValue.setBounds(274, 253, 172, 57);
		contentPane.add(textValue);
		textValue.setColumns(10);
		
		lblValue = new JLabel("Value :");
		lblValue.setForeground(new Color(0, 0, 0));
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblValue.setBounds(63, 253, 172, 57);
		contentPane.add(lblValue);
		
		btnCredit = new JButton("");
		btnCredit.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconCreditValue.png")));
		btnCredit.setBounds(186, 355, 215, 102);
		contentPane.add(btnCredit);
		btnCredit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String account = textAccount.getText();
				Double value = Double.valueOf(textValue.getText());
				mediador.doCredit(account, value);
			}
		});

		lblCredit = new JLabel("DEPOSIT");
		lblCredit.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredit.setBounds(186, 47, 215, 57);
		contentPane.add(lblCredit);

		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuDoCredit.setVisible(true);		
	}
	
	private void menuDoTransfer(){
		menuDoTransfer = new JFrame("BUGGBANK");
		menuDoTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuDoTransfer.setBounds(100, 100, 600, 600);
		menuDoTransfer.setLocationRelativeTo(null);
		menuDoTransfer.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuDoTransfer.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuDoTransfer.dispose();
				menuClient();
			}
		});
		
		textAccountSender = new JTextField();
		textAccountSender.setBounds(274, 120, 172, 57);
		contentPane.add(textAccountSender);
		textAccountSender.setColumns(10);
		
		lblAccountSender = new JLabel("Sender's Account :");
		lblAccountSender.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountSender.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccountSender.setBounds(40, 120, 230, 57);
		contentPane.add(lblAccountSender);
		
		textAccountReceiver = new JTextField();
		textAccountReceiver.setBounds(274, 200, 172, 57);
		contentPane.add(textAccountReceiver);
		textAccountReceiver.setColumns(10);
		
		lblAccountReceiver = new JLabel("Receiver's Account :");
		lblAccountReceiver.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountReceiver.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccountReceiver.setBounds(40, 200, 230, 57);
		contentPane.add(lblAccountReceiver);
		
		textValue = new JTextField();
		textValue.setBounds(274, 280, 172, 57);
		contentPane.add(textValue);
		textValue.setColumns(10);
		
		lblValue = new JLabel("Value :");
		lblValue.setForeground(new Color(0, 0, 0));
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblValue.setBounds(40, 280, 172, 57);
		contentPane.add(lblValue);
		
		btnTransfer = new JButton("");
		btnTransfer.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconTransferValue.png")));
		btnTransfer.setBounds(186, 355, 215, 102);
		contentPane.add(btnTransfer);
		btnTransfer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String accountReceiver = textAccountReceiver.getText();
				String accountSender = textAccountSender.getText();
				Double value = Double.valueOf(textValue.getText());
				mediador.doTransfer(accountReceiver, accountSender, value);
			}
		});
		
		lblTransfer = new JLabel("TRANSFER");
		lblTransfer.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setBounds(186, 47, 215, 57);
		contentPane.add(lblTransfer);

		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuDoTransfer.setVisible(true);				
	}
	
	private void menuDoIterest(){
		menuDoIterest = new JFrame("BUGGBANK");
		menuDoIterest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuDoIterest.setBounds(100, 100, 600, 600);
		menuDoIterest.setLocationRelativeTo(null);
		menuDoIterest.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuDoIterest.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuDoIterest.dispose();
				menuClient();
			}
		});
		
		textAccount = new JTextField();
		textAccount.setBounds(274, 253, 172, 57);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		
		lblAccount = new JLabel("Account :");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccount.setBounds(63, 253, 172, 57);
		contentPane.add(lblAccount);
		
		btnIterest = new JButton("");
		btnIterest.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconIterest_.png")));
		btnIterest.setBounds(186, 355, 215, 102);
		contentPane.add(btnIterest);
		btnIterest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String account = textAccount.getText();
				mediador.doIterest(account);
			}
		});

		lblCredit = new JLabel("ITEREST");
		lblCredit.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredit.setBounds(186, 47, 215, 57);
		contentPane.add(lblCredit);

		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuDoIterest.setVisible(true);		
	}
	
	private void menuEarnBonus(){
		menuBonus = new JFrame("BUGGBANK");
		menuBonus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBonus.setBounds(100, 100, 600, 600);
		menuBonus.setLocationRelativeTo(null);
		menuBonus.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuBonus.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBonus.dispose();
				menuClient();
			}
		});
		
		textAccount = new JTextField();
		textAccount.setBounds(274, 253, 172, 57);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		
		lblAccount = new JLabel("Account :");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccount.setBounds(63, 253, 172, 57);
		contentPane.add(lblAccount);
		
		btnBonus = new JButton("");
		btnBonus.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconBonus_.png")));
		btnBonus.setBounds(186, 355, 215, 102);
		contentPane.add(btnBonus);
		
		btnBonus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String account = textAccount.getText();
				mediador.doEarnBonus(account);
				
			}
		});

		lblCredit = new JLabel("BONUS");
		lblCredit.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredit.setBounds(186, 47, 215, 57);
		contentPane.add(lblCredit);

		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuBonus.setVisible(true);		
	}
	
	private void menuBalance(){
		menuBalance = new JFrame("BUGGBANK");
		menuBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBalance.setBounds(100, 100, 600, 600);
		menuBalance.setLocationRelativeTo(null);
		menuBalance.setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuBalance.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUndo = new JButton("");
		btnUndo.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconUndo.png")));
		btnUndo.setContentAreaFilled(false);
		btnUndo.setFocusable(false);
		btnUndo.setBorderPainted(false);
		btnUndo.setBounds(10, 11, 70, 70);
		contentPane.add(btnUndo);
		btnUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBalance.dispose();
				menuClient();
			}
		});
		
		textAccount = new JTextField();
		textAccount.setBounds(274, 253, 172, 57);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		
		lblAccount = new JLabel("Account :");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
		lblAccount.setBounds(63, 253, 172, 57);
		contentPane.add(lblAccount);
		
		btnBalance = new JButton("");
		btnBalance.setIcon(new ImageIcon(getClass().getResource("/banksys/images/iconbalance_.png")));
		btnBalance.setBounds(186, 355, 215, 102);
		contentPane.add(btnBalance);

		btnBalance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String account = textAccount.getText();
				mediador.showBalance(account);
				
			}
		});
		
		lblCredit = new JLabel("BALANCE");
		lblCredit.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredit.setBounds(186, 47, 215, 57);
		contentPane.add(lblCredit);

		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/banksys/images/fundoOpaco.jpg")));
		lblBackground.setBounds(0, 0, 584, 561);
		contentPane.add(lblBackground);
		
		menuBalance.setVisible(true);		
	}
}