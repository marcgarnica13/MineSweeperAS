package gui;

/**
 * @author Marc Garnica
 * 
 */
public class MainProject {

  /**
   * @param args
   */
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JugarPartidaCtrl ctrl = new JugarPartidaCtrl();
        ctrl.init();
      }
    });
  }
}
