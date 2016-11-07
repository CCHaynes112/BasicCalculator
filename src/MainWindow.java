import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.browser.Browser;
import swing2swt.layout.BoxLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class MainWindow {

	protected Shell shlCalculatron;
	private Text calc_result;
	private Button btn_2;
	private Button btn_equal;
	private Button btn_C;
	private Button btn_4;
	private Button btn_3;
	private Button btn_divide;
	private Button btn_5;
	private Button btn_multi;
	private Button btn_7;
	private Button btn_8;
	private Button btn_sub;
	private Button btn_add;
	private Button btn_6;
	private Button btn_9;
	private Button btn_pi;
	private Button btn_deci;
	private Button btn_back;
	private Button btn_neg;
	
	private double num1, num2, total, answer;
	private String enterNum = "", sNum1 = "", sNum2 = "", sTotal = "", operation = "", sAnswer = "";

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
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
		shlCalculatron.open();
		shlCalculatron.layout();
		while (!shlCalculatron.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	protected void createContents() {
		shlCalculatron = new Shell();
		shlCalculatron.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		shlCalculatron.setMinimumSize(new Point(370, 422));
		shlCalculatron.setSize(370, 422);
		shlCalculatron.setText("Calculatron");
		shlCalculatron.setLayout(null);
		
		
		calc_result = new Text(shlCalculatron, SWT.BORDER | SWT.RIGHT);
		calc_result.setEditable(false);
		calc_result.setFont(SWTResourceManager.getFont("Segoe UI", 33, SWT.BOLD));
		calc_result.setBounds(10, 10, 334, 74);
		calc_result.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		
		Button btn_0 = new Button(shlCalculatron, SWT.NONE);
		btn_0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "0";
				calc_result.append("0");
			}
		});
		btn_0.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_0.setBounds(20, 90, 58, 59);
		btn_0.setText("0");
		
		Button btn_1 = new Button(shlCalculatron, SWT.NONE);
		btn_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "1";
				calc_result.append("1");
			}
		});
		btn_1.setText("1");
		btn_1.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_1.setBounds(84, 90, 58, 59);
		
		btn_2 = new Button(shlCalculatron, SWT.NONE);
		btn_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "2";
				calc_result.append("2");
			}
		});
		btn_2.setText("2");
		btn_2.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_2.setBounds(148, 90, 58, 59);
		
		btn_equal = new Button(shlCalculatron, SWT.NONE);
		btn_equal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try 
				{
					sNum2 = calc_result.getText();
					num1 = Double.valueOf(sNum1);
					num2 = Double.valueOf(sNum2);
					
					if(operation == "+")
					{
						answer = num1 + num2;
						sAnswer = String.valueOf(answer);
						calc_result.setText(sAnswer);
					}
					
					else if(operation == "-")
					{
						answer = num1 - num2;
						sAnswer = String.valueOf(answer);
						calc_result.setText(sAnswer);
					}
					
					else if(operation == "*")
					{
						answer = num1 * num2;
						sAnswer = String.valueOf(answer);
						calc_result.setText(sAnswer);
					}
					
					else if(operation == "/")
					{
						answer = num1 / num2;
						sAnswer = String.valueOf(answer);
						calc_result.setText(sAnswer);
					}
				}
				
				catch(java.lang.NumberFormatException e1)
				{
					System.out.println("Too many decimals");
				}
				
			}
		});
		btn_equal.setText("=");
		btn_equal.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_equal.setBounds(212, 90, 58, 59);
		
		btn_C = new Button(shlCalculatron, SWT.NONE);
		btn_C.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				num1 = 0;
				num2 = 0;
				total = 0;
				answer = 0;
				enterNum = "";
				sNum1 = "";
				sNum2 = "";
				sTotal = "";
				operation = "";
				sAnswer = "";
				calc_result.setText("");
			}
		});
		btn_C.setText("C");
		btn_C.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_C.setBounds(276, 90, 58, 59);
		
		btn_4 = new Button(shlCalculatron, SWT.NONE);
		btn_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "4";
				calc_result.append("4");
			}
		});
		btn_4.setText("4");
		btn_4.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_4.setBounds(84, 155, 58, 59);
		
		btn_3 = new Button(shlCalculatron, SWT.NONE);
		btn_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "3";
				calc_result.append("3");
			}
		});
		btn_3.setText("3");
		btn_3.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_3.setBounds(20, 155, 58, 59);
		
		btn_divide = new Button(shlCalculatron, SWT.NONE);
		btn_divide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sNum1 = calc_result.getText();
				calc_result.setText("");
				operation = "/";
			}
		});
		btn_divide.setText("/");
		btn_divide.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_divide.setBounds(212, 155, 58, 59);
		
		btn_5 = new Button(shlCalculatron, SWT.NONE);
		btn_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "5";
				calc_result.append("5");
			}
		});
		btn_5.setText("5");
		btn_5.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_5.setBounds(148, 155, 58, 59);
		
		btn_multi = new Button(shlCalculatron, SWT.NONE);
		btn_multi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sNum1 = calc_result.getText();
				calc_result.setText("");
				operation = "*";
			}
		});
		btn_multi.setText("X");
		btn_multi.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_multi.setBounds(276, 155, 58, 59);
		
		btn_7 = new Button(shlCalculatron, SWT.NONE);
		btn_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "7";
				calc_result.append("7");
			}
		});
		btn_7.setText("7");
		btn_7.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_7.setBounds(84, 220, 58, 59);
		
		btn_8 = new Button(shlCalculatron, SWT.NONE);
		btn_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "8";
				calc_result.append("8");
			}
		});
		btn_8.setText("8");
		btn_8.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_8.setBounds(148, 220, 58, 59);
		
		btn_sub = new Button(shlCalculatron, SWT.NONE);
		btn_sub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sNum1 = calc_result.getText();
				calc_result.setText("");
				operation = "-";
			}
		});
		btn_sub.setText("-");
		btn_sub.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_sub.setBounds(212, 220, 58, 59);
		
		btn_add = new Button(shlCalculatron, SWT.NONE);
		btn_add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				sNum1 = calc_result.getText();
				calc_result.setText("");
				operation = "+";
			}
		});
		btn_add.setText("+");
		btn_add.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_add.setBounds(276, 220, 58, 59);
		
		btn_6 = new Button(shlCalculatron, SWT.NONE);
		btn_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "6";
				calc_result.append("6");
			}
		});
		btn_6.setText("6");
		btn_6.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_6.setBounds(20, 220, 58, 59);
		
		btn_9 = new Button(shlCalculatron, SWT.NONE);
		btn_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "9";
				calc_result.append("9");
			}
		});
		btn_9.setText("9");
		btn_9.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_9.setBounds(20, 285, 58, 59);
		
		btn_pi = new Button(shlCalculatron, SWT.NONE);
		btn_pi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + "3.14159";
				calc_result.append("3.14159");
			}
		});
		btn_pi.setText("pi");
		btn_pi.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_pi.setBounds(84, 285, 58, 59);
		
		btn_deci = new Button(shlCalculatron, SWT.NONE);
		btn_deci.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enterNum = enterNum + ".";
				calc_result.append(".");
			}
		});
		btn_deci.setText(".");
		btn_deci.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_deci.setBounds(148, 285, 58, 59);
		
		btn_back = new Button(shlCalculatron, SWT.NONE);
		btn_back.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				calc_result.setText(calc_result.getText().substring(0, calc_result.getText().length() - 1));
			}
		});
		btn_back.setText("del");
		btn_back.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_back.setBounds(212, 285, 58, 59);
		
		btn_neg = new Button(shlCalculatron, SWT.NONE);
		btn_neg.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					char c = calc_result.getText().charAt(0);
					if(c == '-')
					{
						calc_result.setText(calc_result.getText().substring(1, calc_result.getText().length()));
					}
					
					else
					{
						calc_result.setText("-" + calc_result.getText());
					}	
				}
				catch(java.lang.StringIndexOutOfBoundsException e2)
				{
					System.out.println("No number to set negative.");
				}
			}
		});
		btn_neg.setText("(-)");
		btn_neg.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btn_neg.setBounds(276, 285, 58, 59);
		
		Menu menu = new Menu(shlCalculatron, SWT.BAR);
		shlCalculatron.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("File");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		mntmNewItem.setText("Exit");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_2 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_2);
		
		MenuItem mntmAbout = new MenuItem(menu_2, SWT.NONE);
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WindowAbout about = new WindowAbout();
				about.open();
			}
		});
		mntmAbout.setText("About");
	}
}
