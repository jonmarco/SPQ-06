package es.deusto.client.GUI;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

/**
 * This class makes the PnlListaReproduccion panel
 * @author: David Baz
 * @version: 22/05
 */

public class PnlListareproduccion extends JPanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablereproducciones;
	private String nombrecancion="";
	/**
 * Double array which receives a songs from the server
 */
	private String[] columnas={"Nombre","Duracion","Author","Fecha Reproducci�n",};
	private Object[][] datos={{"Demons","1:02","James","12/02/1995"},{"TipToe","James","2:02","14/02/1996"}};
	/**
	 * Create the panel.
	 */
	public PnlListareproduccion(final PnlScroll repro) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		
		
		tablereproducciones = new JTable(datos, columnas);
        
        tablereproducciones.setPreferredScrollableViewportSize(new Dimension(500,70));
        
        tablereproducciones.addMouseListener(new MouseAdapter()
        {
			
			/**
 * This method is for the event of the mouse
 * @param: receives the mouse event e like parameter
 */
        @Override
        public void mouseClicked(MouseEvent e) 
        {
           int fila = tablereproducciones.rowAtPoint(e.getPoint());
           int columna = tablereproducciones.columnAtPoint(e.getPoint());
           if ((fila > -1) && (columna > -1))
           {
        	   nombrecancion = (String) tablereproducciones.getValueAt(fila,columna);
        	   repro.getLbl_nombrecancion().setText(nombrecancion);
               System.out.println(nombrecancion);
        	   
           }
                    
        }
        });
        
        setLayout(null);
        
        JScrollPane scrollpane = new JScrollPane(tablereproducciones);
        scrollpane.setBounds(2, 2, 760, 200);
        
        this.add(scrollpane);
		
	}
	
	
		
	

	

}
