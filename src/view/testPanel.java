package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.DrawingController;

public class testPanel extends JPanel
{
	private ArrayList<Rectangle> RecatngleList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> CircleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> PolygonList;
	private ArrayList<Rectangle> squareList;


	private DrawingController baseController;

	private SpringLayout baseLayout;
	public testPanel()
	{
		this.baseController = baseController;
		RecatngleList = new ArrayList<Rectangle>();
		baseLayout = new SpringLayout();
		ellipseList = new ArrayList<Ellipse2D>();
		triangleList = new ArrayList<Polygon>();
		CircleList = new ArrayList<Ellipse2D>();
		PolygonList = new ArrayList<Polygon>();
		squareList =new ArrayList<Rectangle>();

	
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
		int xPosition = (int)(Math.random() * getWidth());
		int yPosition = (int)(Math.random() * getHeight());
		int width = (int)(Math.random() * 50);
		int height = (int)(Math.random()* 100);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
		ellipseList.add(currentEllipse);
	}
	public void addCircle()
	{
		int xPosition = (int)(Math.random() * getWidth());
		int yPosition = (int)(Math.random() * getHeight());
		int width = (int)(Math.random() * 500);
		int height = width;
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
		CircleList.add(currentEllipse);
	}
		public void addPolygon()
		{
			int numOfSides = (int) (Math.random() * 2) + 3;
			int[] xPoints = new int[numOfSides];
			int[] yPoints = new int[numOfSides];

			for (int side = 0; side < numOfSides; side++)
			{
				xPoints[side] = (int) (Math.random() * getWidth());
				yPoints[side] = (int) (Math.random() * getHeight());
			}
			Polygon myPolygon = new Polygon(xPoints, yPoints, numOfSides);
			PolygonList.add(myPolygon);
		}

		public void addTriangle()
		{
			int[] xPoints = new int[3];
			xPoints[0] = (int) (Math.random() * getWidth());
			xPoints[1] = (int) (Math.random() * getWidth());
			xPoints[2] = (int) (Math.random() * getWidth());

			int[] yPoints = new int[3];
			yPoints[0] = (int) (Math.random() * getHeight());
			yPoints[1] = (int) (Math.random() * getHeight());
			yPoints[2] = (int) (Math.random() * getHeight());

			Polygon trianlge = new Polygon(xPoints, yPoints, 3);
			triangleList.add(trianlge);
		}

		@Override
		protected void paintComponent(Graphics currentGraphics)
		{
			super.paintComponent(currentGraphics);

			Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		

			for (Rectangle current : RecatngleList)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				mainGraphics.setColor(new Color(red, green, blue));
				mainGraphics.setStroke(new BasicStroke((int) (Math.random() * 6)));
				mainGraphics.draw(current);

			}

			for (Rectangle current : squareList)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				mainGraphics.setColor(new Color(red, green, blue));
				mainGraphics.setStroke(new BasicStroke((int) (Math.random() * 6)));
				mainGraphics.draw(current);

			}
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
			
			for(Ellipse2D current : ellipseList)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				mainGraphics.setColor(new Color(red, green, blue));
				mainGraphics.setStroke(new BasicStroke((int) (Math.random() * 6)));
				mainGraphics.draw(current);
			}
			for (Ellipse2D current : CircleList)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				mainGraphics.setColor(new Color(red, green, blue));
				mainGraphics.setStroke(new BasicStroke((int) (Math.random() * 6)));
				mainGraphics.draw(current);

			}
		}
		public void clear()
		{
			this.RecatngleList.clear();
			this.squareList.clear();
			this.ellipseList.clear();
			this.CircleList.clear();
			this.triangleList.clear();
			this.PolygonList.clear();
		}
	}

