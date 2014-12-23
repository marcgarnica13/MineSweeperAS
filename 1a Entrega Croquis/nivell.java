package practicaAS;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author Pepe
*/

@Entity
@Table (name = "NIVELL")
public class nivell {
   @Id
   private String nom;
   
   @Basic
   private int nombreCasellesxFila;
   
   @Basic
   private int nombreCasellesxColumna;
   
   @Basic
   private int nombreMines;

   /**
    * Creadora per defecte
    */
   public nivell() {
       nom = null;
       nombreCasellesxFila = 0;
       nombreCasellesxColumna = 0;
       nombreMines = 0;
   }
   
   /**
    * Creadora a partir del nom
    * @param nom 
    */
   public nivell (String nom) {
       this.nom = nom;
       nombreCasellesxFila = 0;
       nombreCasellesxColumna = 0;
       nombreMines = 0;
   }
   
   /**
    * Consultora Nom
    * @return nom
    */
   public String getNom() {
       return nom;
   }

   /**
    * Consultora NombreCasellesxFila
    * @return nombreCasellesxFila
    */
   public int getNombreCasellesxFila() {
       return nombreCasellesxFila;
   }
   
   /**
    * Consultora NombreCasellesxColumna
    * @return nombreCasellesxColumna
    */
   public int getNombreCasellesxColumna() {
       return nombreCasellesxColumna;
   }
   
   /**
    * Consultora NombreMines
    * @return nombreMines
    */
   public int getNombreMines() {
       return nombreMines;
   }
   
   /**
    * Set nom
    * @param nom 
    */
   public void setNom(String nom) {
       this.nom = nom;
   }
   
   /**
    * Set nombreCasellesxFila
    * @param nombreCasellesxFila 
    */
   public void setNombreCasellesxFila(int nombreCasellesxFila) {
       this.nombreCasellesxFila = nombreCasellesxFila;
   }
   
   /**
    * Set nombreCasellesxColumna
    * @param nombreCasellesxColumna 
    */
   public void setNombreCasellesxColumna(int nombreCasellesxColumna) {
       this.nombreCasellesxColumna = nombreCasellesxColumna;
   }
   
   /**
    * Set nombreMines
    * @param nombreMines 
    */
   public void setNombreMines(int nombreMines) {
       this.nombreMines = nombreMines;
   }
}