import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class WindowAbout {

	protected Shell aboutWindow;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WindowAbout window = new WindowAbout();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		aboutWindow.open();
		aboutWindow.layout();
		while (!aboutWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		aboutWindow = new Shell();
		aboutWindow.setSize(218, 151);
		aboutWindow.setText("About");
		
		Label lbl_createdBy = new Label(aboutWindow, SWT.NONE);
		lbl_createdBy.setBounds(30, 21, 149, 15);
		lbl_createdBy.setText("Created by: Curtis Haynes");
		
		Label lbl_Version = new Label(aboutWindow, SWT.NONE);
		lbl_Version.setBounds(30, 56, 88, 15);
		lbl_Version.setText("Version: 2.3");

	}

}
