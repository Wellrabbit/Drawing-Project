package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.*;

import controller.DrawingController;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> RecatngleList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> CircleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> PolygonList;
	private JButton triangleButton;

	private DrawingController baseController;

	private SpringLayout baseLayout;

	public void DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		RecatngleList = new ArrayList<Rectangle>();
		baseLayout = new SpringLayout();
		ellipseList = new ArrayList<Ellipse2D>();
		triangleList = new ArrayList<Polygon>();
		triangleButton = new JButton("Traingle");
		PolygonList = new ArrayList<Polygon>();

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(triangleButton);
	}

	private void setupLayout()
	{

	}

	private void setupListeners()
	{
		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				addTriangle();
				repaint();
			}
		});
	}

	public void addRectangle()
	{
		int xPosition = (int) (Math.random() * getWidth());
		int yPosition = (int) (Math.random() * getHeight());
		int width = (int) (Math.random() * 100);
		int hieght = (int) (Math.random() * 100);

		RecatngleList.add(new Rectangle(xPosition, yPosition, width, hieght));

		repaint();
	}

	public void addSquare()
	{

	}

	public void addEllipse()
	{

	}

	public void addTriangle()
	{
		int[] xPoints = new int[3];
		xPoints[0] = (int) (Math.random() * 150);
		xPoints[2] = (int) (Math.random() * 250);
		xPoints[3] = (int) (Math.random() * 350);

		int[] yPoints = new int[3];
		yPoints[0] = (int) (Math.random() * 250);
		yPoints[2] = (int) (Math.random() * 450);
		yPoints[3] = (int) (Math.random() * 250);

		Polygon trianlge = new Polygon(xPoints, yPoints, 3);
		triangleList.add(trianlge);
	}
public void addPolygon()
{
	int numOfSides = (int)(Math.random()*9) + 3;
	int [] xPoints = new int [numOfSides];
	int [] yPoints = new int [numOfSides];
	
	for(int side = 0; side < numOfSides; side++)
	{
		xPoints[side] = (int)(Math.random() * 2000);
		yPoints[side] = (int)(Math.random() * 2000);
	}
	Polygon myPolygon = new Polygon(xPoints, yPoints, numOfSides);
	PolygonList.add(myPolygon);
}
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		for (Polygon currentPolygon : triangleList)
		{
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(
					(int) (Math.random() * 6) + 2));
			mainGraphics.draw(currentPolygon);
		}
		for (Polygon currentPolygon : PolygonList)
		{
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(
					(int) (Math.random() * 6) + 2));
			mainGraphics.draw(currentPolygon);
		}

	}
}
