import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JList;

public class VisualizadorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JList lista;
	public JButton BTAtras;

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
					VisualizadorView frame = new VisualizadorView();
					WallapopView w = new WallapopView();
					VisualizadorControl f = new VisualizadorControl(frame,w);
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
	public VisualizadorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 BTAtras = new JButton("Atrás");
		BTAtras.setBounds(221, 266, 89, 23);
		contentPane.add(BTAtras);
		
		 lista = new JList();
		 JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setBounds(29, 11, 497, 213);
		contentPane.add(scrollPane);
	}

	public JList getLista() {
		return lista;
	}

	public void setLista(JList lista) {
		this.lista = lista;
	}

	public JButton getBTAtras() {
		return BTAtras;
	}

	public void setBTAtras(JButton bTAtras) {
		BTAtras = bTAtras;
	}
	
	
}
