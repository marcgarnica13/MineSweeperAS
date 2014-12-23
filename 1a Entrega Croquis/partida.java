package practicaAS;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "PARTIDA")
public class partida {
    @Id
    private int idPartida;
    
    @Basic
    private int nombreTirades;
    
    @Basic
    private boolean estaAcabada;
    
    @Basic
    private boolean estaGuanyada;
    
    //@OneToOne
    //private jugador jugadorPartidaActual;
    
    //@OneToOne
    //private jugador jugadorPartidaJugada;
    
    @ManyToOne(targetEntity=nivell.class)
    private nivell niv;
    
    //@OneToMany(targetEntity=casella.class)
    //private casella[][] taulell;
    
    /**
     * Creadora per defecte
     */
    public partida () {
        idPartida = -1;
        niv = null;
        nombreTirades = 0;
        estaAcabada = false;
        estaGuanyada = false;        
    }
    
    /**
     * Creadora a partir del nomNivell
     * @param nomNivell 
     */
    public partida(String nomNivell) {
        idPartida = -1;
        niv = new nivell(nomNivell);
        nombreTirades = 0;
        estaAcabada = false;
        estaGuanyada = false;
    }
        
    /**
     * Consultora IdPartida
     * @return idPartida
     */
    public int getIdPartida() {
        return idPartida;
    }
        
    /**
     * Consultora NombreTirades
     * @return nombreTirades
     */
    public int getNombreTirades() {
        return nombreTirades;
    }
        
    /**
     * Consultora EstaAcabada
     * @return estaAcabada
     */
    public boolean getEstaAcabada() {
        return estaAcabada;
    }
        
    /**
     * Consultora EstaGuanyada
     * @return estaGuanyada
     */
    public boolean getEstaGuanyada() {
        return estaGuanyada;
    }    
    
    /**
     * Consultora nivell
     * @return niv
     */
    public nivell getNivell() {
        return niv;
    }
    
    /**
     * Set IdPartida
     * @param idPartida 
     */
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }
    
    /**
     * Set NombreTirades
     * @param nombreTirades 
     */
    public void setNombreTirades(int nombreTirades) {
        this.nombreTirades = nombreTirades;
    }
    
    /**
     * Set EstaAcabada
     * @param estaAcabada 
     */
    public void setEstaAcabada(boolean estaAcabada) {
        this.estaAcabada = estaAcabada;
    }
    
    /**
     * Set EstaGuanyada
     * @param estaGuanyada 
     */
    public void setEstaGuanyada(boolean estaGuanyada) {
        this.estaGuanyada = estaGuanyada;
    }
}
