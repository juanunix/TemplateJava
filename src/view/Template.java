package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Template extends JFrame {

	private static final long serialVersionUID = 1L;
	private Integer x, y;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Template frame = new Template();
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
	public Template() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
		ImageIcon imageBackground = new ImageIcon(Template.class.getResource("/recursos/imagen2.jpg"));
		Icon iconBackground = new ImageIcon(
					imageBackground.getImage().getScaledInstance(
						lblBackground.getWidth(),
						lblBackground.getHeight(),
						Image.SCALE_DEFAULT));
		
		lblBackground.setIcon(iconBackground);

		JLabel lblClose = new JLabel("");
		lblClose.setIcon(new ImageIcon(Template.class.getResource("/recursos/cancel-circle.png")));
		lblClose.setBounds(this.getWidth() - 34, 0, 32, 33);

		JLabel lblTool = new JLabel("");
		lblTool.setOpaque(true);
		lblTool.setBackground(new Color(255, 255, 255, 70));
		lblTool.setBounds(0, 0, this.getWidth(), 33);

		JLabel lblMin = new JLabel("");
		lblMin.setIcon(new ImageIcon(Template.class.getResource("/recursos/circle-down.png")));
		lblMin.setBounds(this.getWidth() - 68, 0, 32, 33);

		contentPane.add(lblMin);
		contentPane.add(lblClose);
		contentPane.add(lblTool);
		contentPane.add(lblBackground);

		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		lblTool.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point point = MouseInfo.getPointerInfo().getLocation();
				setLocation(point.x - x, point.y - y);
			}
		});
		lblTool.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}
		});

	}
}
