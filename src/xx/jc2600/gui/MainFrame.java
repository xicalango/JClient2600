package xx.jc2600.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import xx.jc2600.controller.Controller2600;

public class MainFrame extends JFrame implements WindowListener {


	private static final long serialVersionUID = 1L;

	private Button2600Panel panel;
	private Controller2600 controller2600;
	
	public MainFrame(Controller2600 controller2600) {
		this.controller2600 = controller2600;
		
		panel = new Button2600Panel(controller2600);
		panel.mount(this);
		
		pack();
		
		addWindowListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void setVisible(boolean arg0) {
		super.setVisible(arg0);
		
		panel.setVisible(arg0);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		controller2600.quitApplication();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
