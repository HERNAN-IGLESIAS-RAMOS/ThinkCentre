import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class VisualizadorControl {

	public VisualizadorView v;
	public WallapopView wv;
	
	public VisualizadorControl(VisualizadorView v, WallapopView wv) {
		this.v=v;
		this.wv=wv;
		v.getBTAtras().addActionListener(e -> guardarTablaEnArchivo(wv.getTable(), "C:\\Users\\higle\\OneDrive\\Escritorio\\herniglerams\\Wallapop\\src\\datos.txt"));
		
	}
	
	public static void guardarTablaEnArchivo(JTable jTable, String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            // Escribir los encabezados de las columnas
            for (int i = 0; i < jTable.getColumnCount(); i++) {
                writer.write(jTable.getColumnName(i));
                if (i < jTable.getColumnCount() - 1) {
                    writer.write("\t");
                }
            }
            writer.newLine();

            // Escribir los datos de las filas
            for (int i = 0; i < jTable.getRowCount(); i++) {
                for (int j = 0; j < jTable.getColumnCount(); j++) {
                    writer.write(String.valueOf(jTable.getValueAt(i, j)));
                    if (j < jTable.getColumnCount() - 1) {
                        writer.write("\t");
                    }
                }
                writer.newLine();
            }

            System.out.println("Datos de la tabla guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos de la tabla en el archivo");
            e.printStackTrace();
        }
    }

	
	
}
