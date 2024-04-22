import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton BTAcceder;

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
					Bienvenida frame = new Bienvenida();
					WallapopView wv = new WallapopView();
					VisualizadorView d = new VisualizadorView();
					WallapopControl s = new WallapopControl(wv,d);
					BienvenidaControl control = new BienvenidaControl(frame, wv);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("BIENVENIDA A LA APP DE WALLAPOP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel.setBounds(10, 11, 601, 94);
		contentPane.add(lblNewLabel);

		BTAcceder = new JButton("----->");
		BTAcceder.setBounds(502, 114, 89, 23);
		contentPane.add(BTAcceder);
	}

	public JButton getBTAcceder() {
		return BTAcceder;
	}

	public void setBTAcceder(JButton bTAcceder) {
		BTAcceder = bTAcceder;
	}

}
