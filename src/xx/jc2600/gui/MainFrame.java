package xx.jc2600.gui;

import javax.swing.JFrame;

import xx.jc2600.controller.Controller2600;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = 1L;

	private Button2600Panel panel;
	
	public MainFrame(Controller2600 controller2600) {
		
		panel = new Button2600Panel(controller2600);
		panel.mount(this);
		
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void setVisible(boolean arg0) {
		super.setVisible(arg0);
		
		panel.setVisible(arg0);
	}
	
	
}
