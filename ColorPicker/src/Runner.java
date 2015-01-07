import javax.swing.JOptionPane;

public class Runner {
	public static void main(String[] args) {

		int pane = JOptionPane.showConfirmDialog(null, "Use custom voice?");
		System.out.println(pane);
		if (pane == 0) {
			ColorTeacher teacher = new ColorTeacher(
					JOptionPane.showInputDialog("Type the voice you want"));
			teacher.setUp();
		} else if (pane == 1) {
			ColorTeacher teacher = new ColorTeacher();
			teacher.setUp();
		} else if (pane == 2) {
			System.out.println("Exit");
			System.exit(0);
		}
	}
}
