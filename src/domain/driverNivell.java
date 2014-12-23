package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class driverNivell {
	public static void main (String[] args) throws IOException {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(nivell.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		String nombreClase = "Nivell";
        System.out.println("Driver " + nombreClase + '.');
        
        nivell niv = new nivell();
                System.out.println("Eliga una opicion:");
                System.out.println("\t 1) Crear nivell -> nivell()");
                System.out.println("\t 2) Crear nivell -> nivell(String nom)");
                System.out.println("\t 3) Consultar al nom -> String getNom()");
                System.out.println("\t 4) Consultar nombre CasellesxFila -> int getNombreCasellesxFila()");
                System.out.println("\t 5) Consultar nombre CasellesxColumna -> int getNombreCasellesxColumna()");
                System.out.println("\t 6) Consultar nombre mines -> int getNombreMines()");
                System.out.println("\t 7) Modificar/posar nom -> void setNom(String nom)");
                System.out.println("\t 8) Modificar/posar nombre CasellesxFila -> void setNombreCasellesxFila(int nF)");
                System.out.println("\t 9) Modificar/posar nombre CasellesxColumna -> void setNombreCasellesxColumna(int nC)");
                System.out.println("\t 10) Modificar/posar nombre Mines -> void setNombreMines(int nombreMines)");
                System.out.println("\t 11) Escriure nivell");
                System.out.println("\t 0) Salir");
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false;
            while (!out) {

                
                String linia = buffer.readLine();
                String palabras[] = linia.split(" ");
                String opcio = palabras[0];
               try {
           		session.beginTransaction();

                    System.out.println("Opcio " + opcio + " seleccionada.");
                    switch (opcio) {
                        case "1":
                            niv = new nivell();
                            break;
                        case "2":

                            niv = new nivell(palabras[1]);

                            break;
                        case "3":
                            System.out.println(niv.getNom());
                            break;
                        case "4":
                            System.out.println(niv.getNombreCasellesxFila());
                            break;
                        case "5":
                            System.out.println(niv.getNombreCasellesxColumna());
                            break;
                        case "6":
                            System.out.println(niv.getNombreMines());
                            break;
                        case "7":
                            niv.setNom(palabras[1]);
                            break;
                        case "8":
                            niv.setNombreCasellesxFila(Integer.parseInt(palabras[1]));
                            break;
                        case "9":
                            niv.setNombreCasellesxColumna(Integer.parseInt(palabras[1]));
                            break;
                        case "10":
                            niv.setNombreMines(Integer.parseInt(palabras[1]));
                            break;
                        case "11":
                            System.out.println("Nom: " + niv.getNom());
                            System.out.println("CasellesxFila: " + niv.getNombreCasellesxFila());
                            System.out.println("CasellesxColumna: " + niv.getNombreCasellesxColumna());
                            System.out.println("NombreMines: " + niv.getNombreMines());
                            break;
                        case "0":
                            out = true;
                            break;
                        default:
                            System.out.println("La opcio no existeix");
                            break;
                    }
                    session.save(niv);
                    session.getTransaction().commit();
               }
               catch (Exception e) { 
                    System.out.println(e.getMessage());
                }               
            }
            System.out.println("Fi del Driver");
        }
        catch (Exception e) { 
            System.out.println(e.getMessage());
        }        
	}
}
