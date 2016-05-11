package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import controller.DrawingController;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private JButton rectangleButton;
	private JButton squareButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton ellipseButton;
	private JButton clearButton;
	private JButton circleButton;
	private testPanel shapePanel;
	private GraphPanel graphPanel;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> PolygonList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	public int circleCount;
	

	public int squareCount;
	public int ellipseCount;
	public int rectCount;

	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		rectangleButton = new JButton("Press this for Rect");
		squareButton = new JButton("SQARE");
		triangleButton = new JButton("triangle");
		polygonButton = new JButton("Polygon");
		ellipseButton = new JButton("Ellipse");
		circleButton = new JButton("Circle");
		clearButton = new JButton("Clear Screen");
		baseLayout = new SpringLayout();

		shapePanel = new testPanel();

		graphPanel = new GraphPanel(this);

		shapePanel.setBackground(Color.WHITE);

		graphPanel.setBackground(Color.BLACK);

		triangleList = new ArrayList<Polygon>();
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		PolygonList = new ArrayList<Polygon>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
		
		this.circleCount = 0;
		this.squareCount = 0;
		this.ellipseCount = 0;
		this.rectCount = 0;
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);

		this.add(shapePanel);
		this.add(graphPanel);

		this.add(rectangleButton);
		this.add(squareButton);
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(ellipseButton);
		this.add(circleButton);
		this.add(clearButton);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, squareButton, -47,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 29,
				SpringLayout.SOUTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, 0,
				SpringLayout.EAST, circleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, squareButton, 0,
				SpringLayout.NORTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, ellipseButton, 333,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 6,
				SpringLayout.EAST, polygonButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, triangleButton, -6,
				SpringLayout.NORTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 6,
				SpringLayout.SOUTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 6,
				SpringLayout.SOUTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 10,
				SpringLayout.WEST, ellipseButton);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 0,
				SpringLayout.NORTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 6,
				SpringLayout.EAST, ellipseButton);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 10,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -55,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 6,
				SpringLayout.EAST, shapePanel);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 6,
				SpringLayout.EAST, shapePanel);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -6,
				SpringLayout.WEST, graphPanel);
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 0,
				SpringLayout.NORTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -16,
				SpringLayout.NORTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 705,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -47,
				SpringLayout.EAST, this);

	}

	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				// int xPosition = (int) (Math.random() * getWidth());
				// int yPosition = (int) (Math.random() * getHeight());
				// int width = (int) (Math.random() * 100);
				// int hieght = (int) (Math.random() * 100);
				//
				// rectangleList.add(new Rectangle(xPosition, yPosition, width,
				// hieght));
				shapePanel.addRectangle();
				rectCount ++;
				repaint();

			}
		});

		squareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				// int xPosition = (int) (Math.random() * getWidth());
				// int yPosition = (int) (Math.random() * getHeight());
				// int width = (int) (Math.random() * 100);
				// int hieght = width;
				//
				// squareList.add(new Rectangle(xPosition, yPosition, width,
				// hieght));
				shapePanel.addSquare();
				squareCount++;
				repaint();

			}
		});
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
				repaint();
			}
		});

		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();

			}
		});
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();

			}
		});
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				ellipseCount++;
				repaint();

			}
		});
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				circleCount++;
				repaint();

			}
		});

	}

	public void addEllipse()
	{
		int xPosition = (int) (Math.random() * getWidth());
		int yPosition = (int) (Math.random() * getHeight());
		int width = (int) (Math.random() * 50);
		int height = (int) (Math.random() * 100);

		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition,
				width, height);
		ellipseList.add(currentEllipse);
	}

	public void addCircle()
	{
		int xPosition = (int) (Math.random() * getWidth());
		int yPosition = (int) (Math.random() * getHeight());
		int width = (int) (Math.random() * 100);
		int height = width;

		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition,
				width, height);
		circleList.add(currentEllipse);
	}

	public void addPolygon()
	{
		int numOfSides = (int) (Math.random() * 3) + 3;
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
		xPoints[2] = (int) (Math.random() * getWidth());
		xPoints[3] = (int) (Math.random() * getWidth());

		int[] yPoints = new int[3];
		yPoints[0] = (int) (Math.random() * getHeight());
		yPoints[2] = (int) (Math.random() * getHeight());
		yPoints[3] = (int) (Math.random() * getHeight());

		Polygon trianlge = new Polygon(xPoints, yPoints, 3);
		triangleList.add(trianlge);
	}

	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);

		Graphics2D mainGraphics = (Graphics2D) currentGraphics;

		for (Rectangle current : rectangleList)
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

		for (Ellipse2D current : ellipseList)
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
		PolygonList.clear();
		// do for all lists
	}

public int getCircleCount()
{
	return circleCount;
}

public void setCircleCount(int circleCount)
{
	this.circleCount = circleCount;
}

public int getSquareCount()
{
	return squareCount;
}

public void setSquareCount(int squareCount)
{
	this.squareCount = squareCount;
}

public int getEllipseCount()
{
	return ellipseCount;
}

public void setEllipseCount(int ellipseCount)
{
	this.ellipseCount = ellipseCount;
}

public int getRectCount()
{
	return rectCount;
}

public void setRectCount(int rectCount)
{
	this.rectCount = rectCount;
}
}
