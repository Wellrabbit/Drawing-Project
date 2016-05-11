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
import view.DrawingPanel;

public class GraphPanel extends JPanel
{
private ArrayList<Rectangle> getRect;
private ArrayList<Color> colorList;
private ArrayList<Integer> valueForGraph;
private int listSize;

private DrawingController baseController;
private DrawingPanel basePanel;
public GraphPanel(DrawingPanel basePanel)
{
	this.baseController = baseController;
	this.basePanel = basePanel;
	colorList = new ArrayList<Color>();
	getRect = new ArrayList<Rectangle>();
	valueForGraph = new ArrayList<Integer>();
	setupColor();
	setupList();
}
private void setupList()
{
	this.valueForGraph.add(basePanel.circleCount);
	this.valueForGraph.add(basePanel.ellipseCount);
	this.valueForGraph.add(basePanel.rectCount);
	this.valueForGraph.add(basePanel.squareCount);
}
private void updateList()
{
	this.valueForGraph.set(0, basePanel.circleCount);
	this.valueForGraph.set(1, basePanel.ellipseCount);
	this.valueForGraph.set(2, basePanel.rectCount);
	this.valueForGraph.set(3, basePanel.squareCount);
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
	
		updateList();
		int windowHeight = this.getHeight();
		int windowWidth = this.getWidth();
		int xPos = 0;
		int height = (int) (windowHeight/4);
		int yPos = (int) (index * height);
		int width = (int) valueForGraph.get(index);
		
		int	circleColor = (int) (Math.random() * colorList.size());
		mainGraphics.setColor((colorList.get(circleColor)));

		
		mainGraphics.fill(new Rectangle(xPos,yPos,width,height));
	}
	
}



}
