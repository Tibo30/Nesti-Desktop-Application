package view;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ScrollPane extends JScrollPane{
	
	
	public ScrollPane(int x, int y, int L, int l) {
	
		this.setBounds(x, y, L, l);		
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	}
	
	

}
