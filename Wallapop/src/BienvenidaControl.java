
public class BienvenidaControl {

	public Bienvenida view;
	public WallapopView wv;

	public BienvenidaControl(Bienvenida view, WallapopView wv) {
		this.view = view;
		this.wv = wv;
		view.getBTAcceder().addActionListener(e -> mostrarSig());
		view.getBTAcceder().addActionListener(q -> noMostrar());

	}

	public void mostrarSig() {
		wv.setVisible(true);
	}

	public void noMostrar() {
		view.setVisible(false);
	}
}
