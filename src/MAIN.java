import java.awt.Color;
import javax.swing.JFrame;

public class MAIN extends JFrame {
	private static final long serialVersionUID = 1L;

	MAIN() {
		setSize(400, 700);
        setTitle("2D Car Game");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		carpanel cp = new carpanel(this);
		this.add(cp);
		setVisible(true);

	}

	public static void main(String[] args) {
		new MAIN();

	}

}
