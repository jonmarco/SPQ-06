package es.deusto.client.GUI;


import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.deusto.server.dto.CancionDTO;

public class PnlCanciones extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cancion="";
	public ArrayList<CancionDTO> listacancion = new ArrayList<CancionDTO>();
	private DefaultTableModel modelo;
	private JTable tablacanciones;

	
	public ArrayList<CancionDTO> getListacancion() {
		return listacancion;
	}


	public void setListacancion(ArrayList<CancionDTO> listacancion) {
		this.listacancion = listacancion;
	}


	// array doble de canciones que debe recibir del server
	private String[] columnas={"Id", "Nombre","Precio"};
	private Object[] data={"","",""};
    
	    	    
	/**
	 * Create the panel.
	 */
	public PnlCanciones(PnlReproduccion repro) {

		try
        {
            setLayout(null);
             
            modelo = new DefaultTableModel(columnas,0);
            
  
            System.out.println("error");
            System.out.println(listacancion.size());
            // se la pasamos de pnlVisualizar
           
            tablacanciones= new JTable(modelo);
            
            tablacanciones.setPreferredScrollableViewportSize(new Dimension(700,70));
            
            tablacanciones.addMouseListener(new MouseAdapter() 
            {
           
            @Override
            public void mouseClicked(MouseEvent e) 
            {
               int fila = tablacanciones.rowAtPoint(e.getPoint());
               int columna = tablacanciones.columnAtPoint(e.getPoint());
               if ((fila > -1) && (columna > -1))
               {
            	   cancion = (String) tablacanciones.getValueAt(fila, columna);
            	   System.out.println(cancion);
            	   
            	   
               }
                 
            }
            });
            
            JScrollPane scrollpane = new JScrollPane(tablacanciones);
            scrollpane.setBounds(0, 0, 768, 200);
            //scrollpane.setBounds(0, 0, _x, _y);
            this.add(scrollpane);
            
            
            
        }catch(Exception e)
        {
         e.printStackTrace();
         System.out.println("errores");
        }
		
	}
	
	
	public void cargarListaCanciones(ArrayList<CancionDTO> _cancion)
	{
		listacancion=_cancion;
		
		for(int i=0; i<listacancion.size(); i++)
		{
			System.out.println("pnlcanciones" + listacancion.get(i).getNombre());
		}
		
		// actualizamos la JTable
		
		 for(int i=0; i < listacancion.size(); i++)
         {
         	int idcancion = listacancion.get(i).getId_cancion();
         	String nombre = listacancion.get(i).getNombre();
         	Double precio= listacancion.get(i).getPrecio();
         	
         	data[0]=idcancion;
         	data[1]=nombre;
         	data[2]=precio;
         	System.out.println(idcancion);
         	System.out.println(nombre);
         	System.out.println(precio);
         	
         	System.out.println(data[0]);
         	System.out.println(data[1]);
         	System.out.println(data[2]);
         	
         	modelo.addRow(data);
         	
         }
		
		 
	
	}

}
