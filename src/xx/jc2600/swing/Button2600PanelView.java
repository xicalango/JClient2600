package xx.jc2600.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import xx.jc2600.client.packet.ButtonType;

interface IButton2600PanelView extends GUIMVC {

	public void updatePressedButtons(Map<ButtonType, Boolean> pressedButtons);
}

class Button2600PanelView extends JPanel implements IButton2600PanelView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel upLabel;
	private JLabel downLabel;
	private JLabel leftLabel;
	private JLabel rightLabel;
	private JLabel buttonLabel;
	
	private IButton2600PanelModel model;
	
	public Button2600PanelView(IButton2600PanelModel model) {
		
		this.model = model;
		
		setLayout(new GridLayout(5,1));
		
		upLabel = createLabel("Up");
		downLabel = createLabel("Down");
		leftLabel = createLabel("Left");
		rightLabel = createLabel("Right");
		buttonLabel = createLabel("Button");
		
		addKeyListener(model);
	}

	private JLabel createLabel(String name) {
		JLabel newLabel = new JLabel(name);
		newLabel.setBackground(Color.GRAY);
		add(newLabel);
		return newLabel;
	}

	@Override
	public void mount(Container container) {
		container.add(this);
	}

	@Override
	public void updatePressedButtons(Map<ButtonType, Boolean> pressedButtons) {
		
		for( Map.Entry<ButtonType, Boolean> states : pressedButtons.entrySet() ) {
			
			JLabel label = getLabelForButton(states.getKey());
			
			if(states.getValue()) {
				label.setForeground(Color.GREEN);
			} else {
				label.setForeground(Color.BLACK);
			}
			
		}
		
	}

	private JLabel getLabelForButton(ButtonType button) {
		
		switch (button) {
		case BT_UP:
			return upLabel;
			
		case BT_DOWN:
			return downLabel;
			
		case BT_LEFT:
			return leftLabel;
			
		case BT_RIGHT:
			return rightLabel;

		case BT_BUTTON:
			return buttonLabel;

		default:
			return null;
		}
		
	}
	
	@Override
	public void setVisible(boolean arg0) {
		super.setVisible(arg0);
		
		if(arg0) {
			requestFocus();
		}
	}

	
}
