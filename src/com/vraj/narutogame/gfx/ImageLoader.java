package com.vraj.narutogame.gfx;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageLoader {

	//loads images from folder
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {

			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	//Method that horizontally flips a buffered image
	public static BufferedImage flip(BufferedImage image) {

		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}


}