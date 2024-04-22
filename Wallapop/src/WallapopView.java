import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WallapopView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFProducto;
	private JTextField TFPrecio;
	private JTextField TFDesc;
	private JButton BTAñadir, BTCancelar;
	protected static JTable table;
	private JButton BTBorrar;
	private JButton bt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new AcrylLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WallapopView frame = new WallapopView();

					frame.setVisible(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WallapopView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setBounds(0, 11, 72, 14);
		contentPane.add(lblNewLabel);

		TFProducto = new JTextField();
		TFProducto.setBounds(69, 8, 355, 20);
		contentPane.add(TFProducto);
		TFProducto.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(0, 47, 56, 14);
		contentPane.add(lblNewLabel_1);

		TFPrecio = new JTextField();
		TFPrecio.setBounds(69, 44, 86, 20);
		contentPane.add(TFPrecio);
		TFPrecio.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descripción");
		lblNewLabel_2.setBounds(0, 84, 72, 14);
		contentPane.add(lblNewLabel_2);

		TFDesc = new JTextField();
		TFDesc.setBounds(69, 81, 355, 33);
		contentPane.add(TFDesc);
		TFDesc.setColumns(10);

		BTAñadir = new JButton("Añadir");
		BTAñadir.setBounds(10, 145, 89, 23);
		contentPane.add(BTAñadir);

		BTCancelar = new JButton("Cancelar");
		BTCancelar.setBounds(335, 145, 89, 23);
		contentPane.add(BTCancelar);

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 179, 414, 94);
		contentPane.add(scrollPane);

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Producto", "Precio", "Descripción" }));

		BTBorrar = new JButton("Borrar");
		BTBorrar.setBounds(160, 145, 89, 23);
		contentPane.add(BTBorrar);
		
		bt = new JButton("");
		bt.setBounds(245, 39, 27, 23);
		contentPane.add(bt);

	}

	public JButton getBTAñadir() {
		return BTAñadir;
	}

	public void setBTAñadir(JButton bTAñadir) {
		BTAñadir = bTAñadir;
	}

	public JButton getBTCancelar() {
		return BTCancelar;
	}

	public void setBTCancelar(JButton bTCancelar) {
		BTCancelar = bTCancelar;
	}

	public JTextField getTFProducto() {
		return TFProducto;
	}

	public void setTFProducto(JTextField tFProducto) {
		TFProducto = tFProducto;
	}

	public JTextField getTFPrecio() {
		return TFPrecio;
	}

	public void setTFPrecio(JTextField tFPrecio) {
		TFPrecio = tFPrecio;
	}

	public JTextField getTFDesc() {
		return TFDesc;
	}

	public void setTFDesc(JTextField tFDesc) {
		TFDesc = tFDesc;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {

		this.table = table;

	}

	public JButton getBTBorrar() {
		return BTBorrar;
	}

	public void setBTBorrar(JButton bTBorrar) {
		BTBorrar = bTBorrar;
	}

	public JButton getBt() {
		return bt;
	}

	public void setBt(JButton bt) {
		this.bt = bt;
	}
	
	

}
