package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class driverPartida {
    /**
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(nivell.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		
		
        String nombreClase = "Partida";
        System.out.println("Driver " + nombreClase + '.');
        
        partida par = new partida();
                System.out.println("Elija una opicion:");
                System.out.println("\t 1) Crear partida -> partida()");
                System.out.println("\t 2) Crear partida -> partida(nomNivell)");
                System.out.println("\t 3) Consultar idPartida -> int getIdPartida()");
                System.out.println("\t 4) Consultar nombreTirades -> int getNombreTirades()");
                System.out.println("\t 5) Consultar estaAcabada? -> boolean getEstaAcabada()");
                System.out.println("\t 6) Consultar estaGuanyada? -> boolean getEstaGuanyada()");
                System.out.println("\t 7) Consultar nivell -> nivell getNivell()");
                System.out.println("\t 8) Modificar/posar idPartida -> void setIdPartida(int idPartida)");
                System.out.println("\t 9) Modificar/posar NombreTirades -> void setNombreTirades(int nT)");
                System.out.println("\t 10) Modificar/posar estaAcabada [0, 1] -> void setEstaAcabada (boolean estaAcabada)");
                System.out.println("\t 11) Modificar/posar estaGuanyada [0, 1] -> void setEstaGuanyada (boolean estaGuanyada)");
                System.out.println("\t 12) Escriure partida");
                System.out.println("\t 0) Salir");
                
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            boolean out = false;
            while (!out) {


                String linia = buffer.readLine();
                String palabras[] = linia.split(" ");
                String opcio = palabras[0];
               try {
                    System.out.println("Opcio " + opcio + " seleccionada.");
                    switch (opcio) {
                        case "1":
                            par = new partida();
                            break;
                        case "2":
                    		session.beginTransaction();
                            par = new partida(palabras[1]);
                            session.save(par);
                            session.getTransaction().commit();
                            break;
                        case "3":
                            System.out.println(par.getIdPartida());
                            break;
                        case "4":
                            System.out.println(par.getNombreTirades());
                            break;
                        case "5":
                            System.out.println(par.getEstaAcabada());
                            break;
                        case "6":
                            System.out.println(par.getEstaGuanyada());
                            break;
                        case "7":
                            System.out.println(par.getNivell().getNom());
                            break;
                        case "8":
                            par.setIdPartida(Integer.parseInt(palabras[1]));
                            break;                            
                        case "9":
                            par.setNombreTirades(Integer.parseInt(palabras[1]));
                            break;
                        case "10":
                            boolean acabada = false;
                            int aux = Integer.parseInt(palabras[1]);
                            if (aux == 1) acabada = true;
                            par.setEstaAcabada(acabada);
                            break;
                        case "11":
                            boolean guanyada = false;
                            int aux2 = Integer.parseInt(palabras[1]);
                            if (aux2 == 1) guanyada = true;
                            par.setEstaGuanyada(guanyada);
                            break;
                        case "12":
                            System.out.println("idPartida: " + par.getIdPartida());
                            System.out.println("nombreTirades: " + par.getNombreTirades());
                            System.out.println("estaAcabada?: " + par.getEstaAcabada());
                            System.out.println("estaGuanyada?: " + par.getEstaGuanyada());
                            System.out.println("nomNivell: " + par.getNivell().getNom());
                            break;
                        case "0":
                            out = true;
                            break;
                        default:
                            System.out.println("La opcio no existeix");
                            break;
                    }
               }
               catch (Exception e) { 
                    System.out.println(e.getMessage());
                }

            }
            System.out.println("Fi del driver");
        }
        catch (Exception e) { 
            System.out.println(e.getMessage());
        }
    }    
}
