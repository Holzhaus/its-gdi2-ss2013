import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 * @author Jan Holthuis
 * Datum: 08.06.2013
 *
 */
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Aktivitaetenliste extends JFrame {
	private JTextField textfield = new JTextField(10);
	private JButton btn_copy = new JButton("Kopiere");
	private JButton btn_remove = new JButton("Lösche");
	private JTextArea textarea = new JTextArea();

	class CopyL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textarea.setText(Aktivitaetenliste.copy(textfield.getText(),textarea.getText()));
		}
	}

	class RemoveL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textarea.setText(Aktivitaetenliste.remove(textfield.getText(),textarea.getText()));
		}
	}

	public static void main(String[] args) {
		new Aktivitaetenliste();
	}
	public static String copy(String copystring, String liststring) {
		if (!copystring.trim().isEmpty()) {
			if(liststring.trim().isEmpty()) {
				return copystring.trim();
			}
			return liststring.trim()+"\n"+copystring.trim();
		}
		return liststring;
	}
	public static String remove(String copystring, String liststring) {
		String lines[] = liststring.split("\\r?\\n");
		String text = "";
		for (int i = 0; i < lines.length; i++) {
			if (!lines[i].trim().equals(copystring.trim())
					&& !lines[i].trim().isEmpty()) {
				text += lines[i].trim() + "\n";
			}
		}
		return text;
	}
	public Aktivitaetenliste() {
		this.setTitle("Begrüßungsfenster");

		this.btn_copy.addActionListener(new CopyL());
		this.btn_remove.addActionListener(new RemoveL());
		this.textarea.setRows(20);
		this.textarea.setEditable(false);

		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(textfield);
		panel.add(btn_copy);
		panel.add(btn_remove);
		cp.add(panel);
		cp.add(textarea);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

}
