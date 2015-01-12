package domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
