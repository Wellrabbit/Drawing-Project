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
	private static ArrayList<Rectangle> RecatngleList;
	private static ArrayList<Ellipse2D> ellipseList;
	private static ArrayList<Ellipse2D> CircleList;
	private static  ArrayList<Polygon> triangleList;
	private static ArrayList<Polygon> PolygonList;
	private static ArrayList<Rectangle> squareList;
	private ArrayList<Color> colorList;


	private DrawingController baseController;

	private SpringLayout baseLayout;
	public testPanel()
	{
		this.baseController = baseController;
		RecatngleList = new ArrayList<Rectangle>();
		setBaseLayout(new SpringLayout());
		ellipseList = new ArrayList<Ellipse2D>();
		triangleList = new ArrayList<Polygon>();
		CircleList = new ArrayList<Ellipse2D>();
		PolygonList = new ArrayList<Polygon>();
		squareList =new ArrayList<Rectangle>();
		colorList = new ArrayList<Color>();
		
		setupColor();
	
	}



private void setupColor()
{
	Color Orange = new Color(255, 55, 0);
	Color YellowOrange = new Color(255, 179, 0);
	Color Yellow = new Color(204, 255,0);
	Color Green = new Color(77,255,0);
	Color Pink = new Color(255,0,77);
	Color Peach = new Color(255,100,61);
	Color Almond = new Color(255,149,122);
	Color DGreen = new Color(0,255,51);
	Color FlPink = new Color(255,0,204);
	Color Sky = new Color(122,228,255);
	Color Blue = new Color(61,216,255);
	Color Seafoam = new Color(0,255,179);
	Color Violet = new Color(179,0,255);
	Color DBlue = new Color(55,0,255);
	Color DieBluRider = new Color(0,77,255);
	Color Turqious = new Color(0,204,255);
	
	colorList.add(Orange);
	colorList.add(YellowOrange);
	colorList.add(Yellow);
	colorList.add(Green);
	colorList.add(Pink);
	colorList.add(Peach);
	colorList.add(Almond);
	colorList.add(DGreen);
	colorList.add(FlPink);
	colorList.add(Sky);
	colorList.add(Blue);
	colorList.add(Seafoam);
	colorList.add(Violet);
	colorList.add(DBlue);
	colorList.add(DieBluRider);
	colorList.add(Turqious);
	
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
		int xPosition = (int) (Math.random() * getWidth());
		int yPosition = (int) (Math.random() * getHeight());
		int width = (int) (Math.random() * 100);
		int hieght = width;

	squareList.add(new Rectangle(xPosition, yPosition, width, hieght));

		repaint();
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
			//	int red = (int) (Math.random() * 256);
			//	int blue = (int) (Math.random() * 256);
			//	int green = (int) (Math.random() * 256);
			//	mainGraphics.setColor(new Color(red, green, blue));
				int	circleColor = (int) (Math.random() * colorList.size());
				mainGraphics.setColor((colorList.get(circleColor)));
				mainGraphics.setStroke(new BasicStroke((int) (Math.random() * 4)));
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
			int	circleColor = (int) (Math.random() * colorList.size());
				mainGraphics.setColor((colorList.get(circleColor)));
				mainGraphics.setStroke(new BasicStroke((int) (Math.random() * 4)));
				mainGraphics.draw(current);

			}
		}
		public void clear()
		{
			testPanel.RecatngleList.clear();
			testPanel.getSquareList().clear();
			testPanel.ellipseList.clear();
			testPanel.CircleList.clear();
			testPanel.triangleList.clear();
			testPanel.PolygonList.clear();
		}

		public static ArrayList<Rectangle> getRecatngleList()
		{
			return RecatngleList;
		}
		public static ArrayList<Ellipse2D> getEllipseList()
		{
			return ellipseList;
		}
		public static ArrayList<Ellipse2D> getCircleList()
		{
			return CircleList;
		}
		public static ArrayList<Polygon> getTriangleList()
		{
			return triangleList;
		}
		public static ArrayList<Polygon> getPolygonList()
		{
			return PolygonList;
		}
		public static ArrayList<Rectangle> getSquareList()
		{
			return squareList;
		}
		public ArrayList<Color> getColorList()
		{
			return colorList;
		}
		public DrawingController getBaseController()
		{
			return baseController;
		}
		public SpringLayout getBaseLayout()
		{
			return baseLayout;
		}
		public void setBaseLayout(SpringLayout baseLayout)
		{
			this.baseLayout = baseLayout;
		}
}

