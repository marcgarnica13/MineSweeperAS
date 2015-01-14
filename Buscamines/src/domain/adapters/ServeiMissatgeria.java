package domain.adapters;

import javax.swing.JOptionPane;

public class ServeiMissatgeria {
	
	public void enviarMissatge(String missatge, String email) {
        String clave = "jkzwjegqckskridp";
        System.out.println("marcgarnica13@gmail.com");
        System.out.println(email);
        Email e = new Email("fibuscaminas@gmail.com",clave, email, missatge);
        if (e.sendMail()) JOptionPane.showMessageDialog(null,"Email enviat correctament");
        else JOptionPane.showMessageDialog(null,"El email no se mandó correctamente");
    }

}
