package view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.DrawingController;

public class ShapePanel extends JPanel
{



	
	
		 private DrawingController baseController;

		 private SpringLayout baseLayout;
		 public void DrawingPanel(DrawingController baseController)
		 {
			 this.baseController = baseController;
			
			 baseLayout = new SpringLayout();
			
			 
			 setupPanel();
			 setupLayout();
			 setupListeners();
		 }
		 private void setupPanel()
		 {
			 this.setLayout(baseLayout);
		 }
		private void setupLayout()
		{
			
		}
		 
		 private void setupListeners()
		 {
			 
		 }
}
