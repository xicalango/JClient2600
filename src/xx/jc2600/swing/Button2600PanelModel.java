package xx.jc2600.swing;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import xx.jc2600.client.packet.ButtonType;

interface IButton2600PanelModel extends GUIMVC, KeyListener {
	
}

class Button2600PanelModel implements IButton2600PanelModel {

	private IButton2600PanelView view;
	private IButton2600PanelControl control;
	
	private Map<ButtonType, Boolean> pressedButtons = new HashMap<>();
	
	public Button2600PanelModel(IButton2600PanelControl control) {
		this.control = control;
		
		pressedButtons.put(ButtonType.BT_UP, false);
		pressedButtons.put(ButtonType.BT_DOWN, false);
		pressedButtons.put(ButtonType.BT_LEFT, false);
		pressedButtons.put(ButtonType.BT_RIGHT, false);
		pressedButtons.put(ButtonType.BT_BUTTON, false);
		
		view = new Button2600PanelView(this);
	}

	@Override
	public void setVisible(boolean visible) {
		view.setVisible(visible);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ButtonType bt = ButtonType.fromKeyEvent(e);
		
		if(bt == null) {
			return;
		}
		
		if(pressedButtons.get(bt) == false) { //change
			pressedButtons.put(bt, true);
			
			view.updatePressedButtons(pressedButtons);
			control.keyPressed(bt);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ButtonType bt = ButtonType.fromKeyEvent(e);
		
		if(bt == null) {
			return;
		}
		
		if(pressedButtons.get(bt) == true) { //change
			pressedButtons.put(bt, false);
			
			view.updatePressedButtons(pressedButtons);
			control.keyReleased(bt);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mount(Container container) {
		view.mount(container);
	}
	
}
