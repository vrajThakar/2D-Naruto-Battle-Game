package com.vraj.narutogame.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


//Display class for the JFrame and Canvas
public class Display {

	private static JFrame frame; 
	private Canvas canvas;

	private String title;
	private int width, height;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();

	}

	//Creates the GUI
	private void createDisplay() {

		frame = new JFrame(title);
		frame.setSize(width, height);

		//makes sure the program closes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public static JFrame getFrame() {
		return frame;
	}


}