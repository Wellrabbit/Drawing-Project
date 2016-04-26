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
	private JButton circleButton;
	//private ShapePanel shapePanel;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> PolygonList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;

	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		rectangleButton = new JButton("Press this for Rect");
		squareButton = new JButton("SQARE");
		triangleButton = new JButton("triangle");
		polygonButton = new JButton("Polygon");
		ellipseButton = new JButton("Ellipse");
		circleButton = new JButton("Circle");
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 0, SpringLayout.NORTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, circleButton, -6, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, ellipseButton, 0, SpringLayout.NORTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, ellipseButton, -6, SpringLayout.WEST, polygonButton);
		//shapePanel = new ShapePanel();
		
		
		
				
		triangleList = new ArrayList<Polygon>();
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		PolygonList = new ArrayList<Polygon>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		//this.add(shapePanel);
		this.add(rectangleButton);
		this.add(squareButton);
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(ellipseButton);
		this.add(circleButton);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 0,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, rectangleButton, -138,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, squareButton, 0,
				SpringLayout.NORTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, squareButton, 25,
				SpringLayout.EAST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, triangleButton, 6, SpringLayout.SOUTH, squareButton);
		baseLayout.putConstraint(SpringLayout.EAST, triangleButton, 0, SpringLayout.EAST, squareButton);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 6, SpringLayout.SOUTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, polygonButton, -53, SpringLayout.WEST, triangleButton);
	}

	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int) (Math.random() * getWidth());
				int yPosition = (int) (Math.random() * getHeight());
				int width = (int) (Math.random() * 100);
				int hieght = (int) (Math.random() * 100);

				rectangleList.add(new Rectangle(xPosition, yPosition, width,
						hieght));

				repaint();

			}
		});

		squareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int) (Math.random() * getWidth());
				int yPosition = (int) (Math.random() * getHeight());
				int width = (int) (Math.random() * 100);
				int hieght = width;

				squareList.add(new Rectangle(xPosition, yPosition, width,
						hieght));

				repaint();

			}
		});

		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				addTriangle();
				repaint();

			}
		});
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				addPolygon();
				repaint();

			}
		});
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				addEllipse();
				repaint();

			}
		});
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				addCircle();
				repaint();

			}
		});

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
	int width = (int)(Math.random() * 100);
	int height = width;
	
	Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
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
		
		for(Ellipse2D current : ellipseList)
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
		//do for all lists
	}
}
