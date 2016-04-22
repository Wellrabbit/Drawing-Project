package view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.DrawingController;

public class ShapePanel extends JPanel
{
private ArrayList<Rectangle> RecatngleList;
private ArrayList<Ellipse2D> ellipseList;
private ArrayList<Ellipse2D> CircleList;
private ArrayList<Polygon> PolygonList;



	
	
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
		 
		 public void addRectangle()
		 {
			 
		 }
		 public void addSquare()
		 {
			 
		 }
		 public void addEllipse()
		 {
			 
		 }
		 
		 @Override
		 protected void paintComponent(Graphics currentGraphics)
		 {
			 super.paintComponent(currentGraphics);
			 
		 }
}
