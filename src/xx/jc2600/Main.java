package xx.jc2600;

import xx.jc2600.controller.Controller2600;
import xx.jc2600.controller.DefaultController2600;
import xx.jc2600.swing.MainFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Controller2600 controller2600 = new DefaultController2600();
		//controller2600.startApplication("192.168.34.222", 2600);

		MainFrame mf = new MainFrame(controller2600);
		
		mf.setVisible(true);
		
		

		
		
	}

}
