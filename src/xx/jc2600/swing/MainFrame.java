package xx.jc2600.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ConnectException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import xx.jc2600.client.Client2600Exception;
import xx.jc2600.controller.Controller2600;

public class MainFrame extends JFrame implements MainGUIContoller {


	private static final long serialVersionUID = 1L;

	private Button2600Panel panel;
	private Controller2600 controller2600;
	
	public MainFrame(Controller2600 controller2600) {
		super("Client 2600");
		this.controller2600 = controller2600;
		
		panel = new Button2600Panel(controller2600);
		panel.mount(this);
		panel.setVisible(false);
		
		setJMenuBar(new MenuBar2600(this));
		
		pack();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disconnect();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void setVisible(boolean arg0) {
		super.setVisible(arg0);
	}

	@Override
	public void quitApplication() {
		disconnect();
		setVisible(false);
		dispose();
	}

	@Override
	public boolean establishNewConnection() {
		
		String result = JOptionPane.showInputDialog(this, "Please input a connection string", "localhost:2600");
		
		if(result != null) {
			disconnect();
			
			try {
				controller2600.connect(result);
				
				panel.setVisible(true);
				pack();
				return true;
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this, "Malformed connection string: " + result);
				return false;
			} catch (Client2600Exception e) {
				try {
					throw e.getCause();
				} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(this, "Connection failed...");
					return false;
				} catch(Throwable e1) {
					throw new Client2600Exception(e1);
				}
			}
		} else {
			return false;
		}
		
	}

	@Override
	public void disconnect() {
		if(controller2600.isConnected()) {
			controller2600.disconnect();
			panel.setVisible(false);
			pack();
		}
	}
	
	
}
