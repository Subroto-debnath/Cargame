import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class carpanel extends JPanel implements KeyListener {
	JLabel maincar = new JLabel();
	JLabel car1 = new JLabel();
	JLabel car2 = new JLabel();
	JLabel car3 = new JLabel();
	JLabel score = new JLabel("Score:");
	JLabel bum = new JLabel();
	JLabel count = new JLabel();
	Timer tim = new Timer();
	Timer timm = new Timer();
	int i;
	int jjj = 0, jj = 450, j = 600;
	int kkk = 150, kk = 300;

	//Graphics gg;
	int x = 150, y = 520;
	int xx = 15, yy = 0;
	int xxx = 150, yyy = -450;
	int xxxx = 270, yyyy = -850;

	int p = 0, a = 12, b = 8, r = 270, s = 20, v = 330, u = 20;

	public carpanel(MAIN ob) {
		setBackground(Color.darkGray);
		add(bum);
		add(count);
		add(score);
		add(car1);
		add(maincar);
		add(car2);
		add(car3);

		count.setFont(new Font("Gill sans", Font.ITALIC, 20));
		score.setFont(new Font("Gill sans", Font.ITALIC, 20));
		bum.setFont(new Font("Gill sans", Font.ITALIC, 50));
		count.setForeground(Color.green);
		score.setForeground(Color.MAGENTA);
		bum.setForeground(Color.red);

		maincar.setIcon(new ImageIcon(carpanel.class.getResource("Main car.png")));

		car1.setIcon(new ImageIcon(carpanel.class.getResource("car1.png")));
		car2.setIcon(new ImageIcon(carpanel.class.getResource("car2.png")));
		car3.setIcon(new ImageIcon(carpanel.class.getResource("car3.png")));

		ob.addKeyListener(this);

		tim.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				yy += 1;
				yyy += 1;
				yyyy += 1;
				if (yy > 700)
					yy = -400;
				if (yyy > 700)
					yyy = -710;
				if (yyyy > 700)
					yyyy = -1020;
				p++;
				if (a > 3 || b > 1) {
					timm.scheduleAtFixedRate(new TimerTask() {

						public void run() {
							b--;
							a--;
							repaint();

						}
					}, 100, 1);
				}

				if ((y < (yy + 130) && y > (yy - 100))
						&& (x > 1 && x < 86)
						|| ((y < (yyy + 135) && y > (yyy - 100)) && (x > 79 && x < 222))
						|| ((y < (yyyy + 140) && y > (yyyy - 100)) && (x > 198 && x < 345))) {
					bum.setText("Boo..MM !!");
					r = 100;
					s = 160;
					v = 220;
					u = 160;
					count.setFont(new Font("Gill sans", Font.ITALIC, 40));
					score.setFont(new Font("Gill sans", Font.ITALIC, 40));

					tim.cancel();

					// tim.purge();
					return;

				}

				else

				{
					bum.setText("");
					count.setText(Integer.toString(p));
				}
				repaint();
			}

		}, 1000, b);

		tim.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				jjj += 1;
				kkk += 1;
				kk += 1;
				jj += 1;
				j += 1;

				repaint();

				if (jjj > 700)
					jjj = -100;
				if (jj > 700)
					jj = -100;
				if (kkk > 700)
					kkk = -200;
				if (kk > 700)
					kk = -100;
				if (j > 700)
					j = -100;

			}

		}, 1000, a);

	}

	protected void paintComponent(Graphics gg) {
		super.paintComponent(gg);

		maincar.setLocation(x, y);
		count.setLocation(v, u);
		score.setLocation(r, s);
		bum.setLocation(100, 300);
		car1.setLocation(xx, yy);
		car2.setLocation(xxx, yyy);
		car3.setLocation(xxxx, yyyy);

		gg.setColor(Color.white);

		gg.fillRect(120, jjj, 10, 100);
		gg.fillRect(240, jjj, 10, 100);
		gg.fillRect(120, kkk, 10, 100);
		gg.fillRect(240, kkk, 10, 100);
		gg.fillRect(120, kk, 10, 100);
		gg.fillRect(240, kk, 10, 100);
		gg.fillRect(120, jj, 10, 100);
		gg.fillRect(240, jj, 10, 100);
		gg.fillRect(120, j, 10, 100);
		gg.fillRect(240, j, 10, 100);

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			if (x < 1)
				x = x;
			else
				x = x - 8;

			repaint();

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (x > 320)
				x = 321;
			else
				x = x + 8;
			repaint();

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (y < 1)
				y = y;
			else
				y = y - 3;
			repaint();

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (y > 550)
				y = 551;
			else
				y = y + 3;
			repaint();

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
