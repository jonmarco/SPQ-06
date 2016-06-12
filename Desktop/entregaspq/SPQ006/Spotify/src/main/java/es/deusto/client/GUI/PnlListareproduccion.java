package es.deusto.client.GUI;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

public class PnlListareproduccion extends JPanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablereproducciones;
	private String nombrecancion="";
	// array doble de reproducciones que debe recibir del servidor
	private String[] columnas={"Nombre","Duracion","Author","Fecha Reproducción",};
	private Object[][] datos={{"1973","1:02","ACDC","12/02/1995"},{"BackInBlack","James","2:02","14/02/1996"},
			{"Beautiful","James","2:02","14/02/1996"},{"BonfireHeart","James","2:02","14/02/1996"},
			{"GoodbyeMyLover","James","2:02","14/02/1996"},{"HighwayToHell","James","2:02","14/02/1996"},
			{"Locked","James","2:02","14/02/1996"},{"TheLazySong","James","2:02","14/02/1996"}};
	/**
	 * Create the panel.
	 */
	public PnlListareproduccion(final PnlScroll repro) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		
		
		tablereproducciones = new JTable(datos, columnas);
        
        tablereproducciones.setPreferredScrollableViewportSize(new Dimension(500,70));
        
        tablereproducciones.addMouseListener(new MouseAdapter()
        {
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
