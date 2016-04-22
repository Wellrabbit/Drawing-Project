package view;

import javax.swing.JFrame;

import controller.DrawingController;



public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private ShapePanel basePanel;
	private DrawingPanel otherPanel;

	public DrawingFrame(DrawingController baseController)
	{
		this.baseController = baseController;
		basePanel = new ShapePanel();
		otherPanel = new DrawingPanel(baseController);
		setFrame();
	}

	private void setFrame()
	{
		this.setContentPane(otherPanel);
		this.setTitle("More Practice Yay");
		this.setResizable(false);
		this.setSize(1000,1000);
		this.setVisible(true);
	}
}
