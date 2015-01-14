package domain.adapters;

import javax.swing.JOptionPane;

import domain.model.Email;

public class ServeiMissatgeria {
	
	public void enviarMissatge(String missatge) {
        String clave = "jkzwjegqckskridp"; 
        Email e = new Email("fibuscaminas@gmail.com",clave,"marcgarnica13@gmail.com", missatge);
        if (e.sendMail()) JOptionPane.showMessageDialog(null,"Email enviat correctament");
        else JOptionPane.showMessageDialog(null,"El email no se mandó correctamente");
    }

}
