package xx.jc2600.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar2600 extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	private JMenu mainMenu;
	private MainGUIContoller guiContoller;

	private JMenuItem connectMenuItem;

	private JMenuItem disconnectMenuItem;
	
	public MenuBar2600(MainGUIContoller guiContoller) {
		
		this.guiContoller = guiContoller;
		
		setup();
		
	}
	
	public void setConnectionStatus(boolean connected) {
		if(connected) {
			connectMenuItem.setVisible(false);
			disconnectMenuItem.setVisible(true);
		} else {
			connectMenuItem.setVisible(true);
			disconnectMenuItem.setVisible(false);
		}
	}

	private void setup() {
		
		mainMenu = new JMenu("Client2600");
		
		connectMenuItem = new JMenuItem("Connect...");
		connectMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean conn = guiContoller.establishNewConnection();
				setConnectionStatus(conn);
			}
		});
		
		disconnectMenuItem = new JMenuItem("Disconnect");
		disconnectMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guiContoller.disconnect();
				setConnectionStatus(false);
			}
		});
		disconnectMenuItem.setVisible(false);

		JMenuItem quitMenuItem = new JMenuItem("Quit");
		quitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guiContoller.quitApplication();
			}
		});

		mainMenu.add(connectMenuItem);
		mainMenu.add(disconnectMenuItem);
		mainMenu.add(quitMenuItem);
		
		add(mainMenu);
		
	}



}
