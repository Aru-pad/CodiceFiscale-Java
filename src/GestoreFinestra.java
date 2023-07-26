import java.awt.event.*;

class GestoreFinestra implements WindowListener
{
  public void windowIconified(WindowEvent e) 
  {
	  System.out.println("Programma inconizzato.");
  }
  public void windowDeiconified(WindowEvent e) 
  {
	  System.out.println("Programma deinconizzato.");
  }
  public void windowActivated(WindowEvent e) 
  {
	  System.out.println("Programma attivato.");
  }
  public void windowDeactivated(WindowEvent e) 
  {
	  System.out.println("Programma deattivato.");
  }
  public void windowOpened(WindowEvent e)
  {
    System.out.println("Programma avviato.");
  }
  public void windowClosed(WindowEvent e) 
  {
	  System.out.println("Programma chiuso.");
  }
  public void windowClosing(WindowEvent e)
  {
    System.out.println("Programma terminato.");
    System.exit(0);
  }
}
