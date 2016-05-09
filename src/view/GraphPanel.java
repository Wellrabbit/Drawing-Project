package view;

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import view.testPanel;

import controller.DrawingController;

public class GraphPanel extends JPanel
{
private ArrayList<Rectangle> getRect;
private ArrayList<Color> colorList;
private ArrayList<Integer> valueForGraph;
private int listSize;

private DrawingController baseController;

public GraphPanel()
{
	this.baseController = baseController;
	colorList = new ArrayList<Color>();
	getRect = new ArrayList<Rectangle>();
valueForGraph = new ArrayList<Integer>();
listSize = testPanel.getCircleList().size();
setupList();
	setupColor();
}
private void setupList()
{
	valueForGraph.add(testPanel.getCircleList().size());
	valueForGraph.add(listSize);
	valueForGraph.add(testPanel.getSquareList().size());
	valueForGraph.add(testPanel.getTriangleList().size());
	valueForGraph.add(testPanel.getEllipseList().size());
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

protected void paintComponent(Graphics currentGraphics)
{
	super.paintComponent(currentGraphics);
	Graphics2D mainGraphics = (Graphics2D) currentGraphics;

	for(int index = 0; index < valueForGraph.size(); index++)
	{
	
		
		int windowHeight = this.getHeight();
		int windowWidth = this.getWidth();
		int xPos = 0;
		int height = (int) (windowHeight/valueForGraph.size());
		int yPos = (int) (index * height);
		int width = (int) valueForGraph.get(index);
		
		int	circleColor = (int) (Math.random() * colorList.size());
		mainGraphics.setColor((colorList.get(circleColor)));

		
		mainGraphics.fill(new Rectangle(xPos,yPos,width,height));
	}
	
}



}
