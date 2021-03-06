package domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * La annotacio Joined el que fa es construir la taula UsuariRegistrat amb tota la informacio
 * i les taules Jugador i Administrador afegeix l'identificador del UsuariRegistrat del que 
 * hereda i la informacio adicional.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class UsuariRegistrat {
	@Basic
	private String nom;
	@Basic
	private String cognom;
	@Id
	private String username;
	@Basic
	private String pwd;
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
