package xx.jc2600.gui;

import java.awt.Container;

import xx.jc2600.client.packet.ButtonType;
import xx.jc2600.controller.Controller2600;

interface IButton2600PanelControl extends GUIMVC {

	void keyPressed(ButtonType bt);

	void keyReleased(ButtonType bt);
	
}

public class Button2600Panel implements IButton2600PanelControl {

	private Button2600PanelModel model;
	private Controller2600 controller2600;
	
	public Button2600Panel(Controller2600 controller2600) {
		this.controller2600 = controller2600;
		model = new Button2600PanelModel(this);
	}

	@Override
	public void setVisible(boolean visible) {
		model.setVisible(visible);
	}

	@Override
	public void keyPressed(ButtonType bt) {
		controller2600.keyPress(bt);
	}

	@Override
	public void keyReleased(ButtonType bt) {
		controller2600.keyRelease(bt);
	}

	@Override
	public void mount(Container container) {
		model.mount(container);
	}
	
}
