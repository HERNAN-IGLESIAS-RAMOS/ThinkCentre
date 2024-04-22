import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WallapopControl {

	WallapopView view;
	VisualizadorView v;

	public WallapopControl(WallapopView view,VisualizadorView v) {
		this.view = view;
		this.v=v;
		view.getBTCancelar().addActionListener(e -> borrado(view));
		view.getBTAñadir().addActionListener(e -> añadir());
		view.getBTBorrar().addActionListener(e -> borrar());
		view.getBt().addActionListener(e->j());//mostrar(view.getTable(),"C:\\Users\\higle\\OneDrive\\Escritorio\\herniglerams\\Wallapop\\src\\datos.txt"));
	}

	public static void borrado(WallapopView view) {
		view.getTFDesc().setText("");
		view.getTFProducto().setText("");
		view.getTFPrecio().setText("");
	}

	public void añadir() {
		if(view.getTFDesc().getText().isEmpty() || view.getTFProducto().getText().isEmpty() || view.getTFPrecio().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view, "No has indicado ningún producto, ni su precio, ni una descripción", "AVISO",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.addRow(new Object[] { view.getTFProducto().getText(), view.getTFPrecio().getText(),
				view.getTFDesc().getText() });
	}

	public void borrar() {
		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		int selectedRow = view.getTable().getSelectedRow();
	    if (selectedRow != -1) { 
	        model.removeRow(selectedRow);
	    }
	}
	
	public void j() {
		v.setVisible(true);
	}
	
	public void mostrar(JTable tabla, String nombreArchivo) {
		
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
	            // Escribir los encabezados de las columnas
	            for (int i = 0; i < view.getTable().getColumnCount(); i++) {
	                writer.write(view.getTable().getColumnName(i));
	                if (i < view.getTable().getColumnCount() - 1) {
	                    writer.write("\t");
	                }
	            }
	            writer.newLine();

	            // Escribir los datos de las filas
	            for (int i = 0; i < view.getTable().getRowCount(); i++) {
	                for (int j = 0; j < view.getTable().getColumnCount(); j++) {
	                    writer.write(String.valueOf(view.getTable().getValueAt(i, j)));
	                    if (j < view.getTable().getColumnCount() - 1) {
	                        writer.write("\t");
	                    }
	                }
	                writer.newLine();
	            }

	        } catch (IOException ex) {
	            System.err.println("Error al guardar los datos de la tabla en el archivo");
	            ex.printStackTrace();
	        }
	    }
	

}
