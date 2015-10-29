package view;


import java.awt.EventQueue;
import javax.swing.JPanel;

public class FormsView extends Template {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormsView frame = new FormsView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FormsView() {
		super();
	}

}
