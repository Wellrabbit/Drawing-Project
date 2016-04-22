package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.DrawingController;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private JButton rectangleButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		rectangleButton = new JButton("Press this");
		baseLayout = new SpringLayout();
		rectangleList = new ArrayList<Rectangle>();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rectangleButton);
	}

	private void setupLayout()
	{

	}

	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int) (Math.random() * getWidth());
				int yPosition = (int) (Math.random() * getHeight());
				int width = (int) (Math.random() * 100 );
				int hieght = (int) (Math.random() * 100);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, hieght));
				
				repaint();
				
			}
		});

	}

	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);

		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setStroke(new BasicStroke(2));
		mainGraphics.setColor(Color.CYAN);

		mainGraphics.drawRect(50, 70, 200, 20);
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics .fill(current);
			
	}
}
}
