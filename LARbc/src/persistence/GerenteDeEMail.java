package persistence;

import persistence.util.MailSender;
import beans.Demanda;

public class GerenteDeEMail {

	private static final String ADMIN_MAIL = "joaofso@gmail.com";
	private static final String SUBJECT = "Submiss�o de demanda de usu�rio";
	
	private MailSender mailSender;
	
	public GerenteDeEMail(){
		this.mailSender = new MailSender();
	}

	public void sendMail(String personWhoSubmittedDemand, String email,	String phone) {
		this.mailSender.sendMail(ADMIN_MAIL, SUBJECT, this.getMessage(personWhoSubmittedDemand, email, phone));
	}
	
	public void sendMail(Demanda demanda){
		this.mailSender.sendMail(ADMIN_MAIL, SUBJECT, 
				this.getMessage(demanda.getNomeCliente(), demanda.getEmailCliente(), demanda.getTelefone()));
	}
	
	private String getMessage(String personWhoSubmittedDemand, String email, String phone){
		String result = "O usu�rio " + personWhoSubmittedDemand + " (Contato: " + email + " - " + phone + ")" +
		"submeteu uma demanda a ser analisada pela aplica��o.";
		return result;
	}

}
