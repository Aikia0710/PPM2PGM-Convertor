import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
/**
 * The class is used to convert a colourful PPM picture into a PGM grey
 * picture. It contains five field variables are width and height of the 
 * ppm picture, the maximum shade pixel, type of the file and a three-dimensional 
 * pixels array in which the third dimension is used to represent colour. 
 * 
 * @version 2018-11-07
 * @author zibo Wang
 *
 */
public class PPMImage {

	private int width;
	private int height;
	private int maxshade;
	private String typeOfFile;
	private short[][][]pixels;

	public PPMImage (String filename) {
		//open a PGM file in text editor, the order of the recording data 
		//is in file type, width and height, and the maxshade, so using the scanner
		//method to read data must follow in the same way
		try {
			Scanner s = new Scanner (new File(filename));
			typeOfFile = s.next();
			width = s.nextInt();
			height = s.nextInt();
			maxshade = s.nextInt();
			pixels = new short [height][width][3]; // red, green and blue
			for (int i = 0; i<height; i++) {
				for (int j = 0; j<width; j++) {
					for (int k = 0; k<3; k++) {
						pixels[i][j][k] = s.nextShort();
					}
				}
			}
			s.close();
			}
			catch (IOException e) {
				System.out.println("File not found.");
				typeOfFile = "P3";
				width = 0;
				height = 0;
				maxshade = 0;
				pixels = new short[height][width][3];
			}	
		}
	/**
	 * Getter for width
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Setter for width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * Getter for height
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Setter for height
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * Getter for the maximum shade
	 * @return the maximum value of shade
	 */
	public int getMaxshade() {
		return maxshade;
	}
	/**
	 * Setter for the maximum value of shade
	 * @param maxshade
	 */
	public void setMaxshade(int maxshade) {
		this.maxshade = maxshade;
	}
	/**
	 * Getter for the type of file
	 * @return the type of file
	 */
	public String getTypeOfFile() {
		return typeOfFile;
	}
	/**
	 * Setter for the type of file
	 * @param typeOfFile
	 */
	public void setTypeOfFile(String typeOfFile) {
		this.typeOfFile = typeOfFile;
	}
	/**
	 * Getter for the pixels
	 * @return the picels
	 */
	public short[][][] getPixels() {
		return pixels;
	}
	/**
	 * Setter for the pixels
	 * @param pixels
	 */
	public void setPixels(short[][][] pixels) {
		this.pixels = pixels;
	}
	/**
	 * Calculate the average of RGB values for the grey value of the new PGM picture. 
	 * @param filename is name of the new picture.
	 * @return a two-dimensional pixels array.
	 */
	public short[][] makeGrey(String filename){
		short[][] p = new short[height][width];
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			//We turn it to grey so the type of new file is P2.
			out.write("P2\n");
			out.write(getWidth() + "\n" + getHeight() + "\n");
			
			int total = 0;
			double average;
			short maxshade = 0;
			for (int i = 0;i < getHeight();i++){
				for (int j = 0;j < getWidth();j++){
					total= 0;
					for (int k = 0;k<3;k++){
						total = total + getPixels()[i][j][k]; 
					}
					average = Math.round(total/3.0);
					p[i][j] = (short)average;
					if (p[i][j] >= maxshade) {
						//find the maximum shade of each pixel
						maxshade = p[i][j];
					}
					
				}
			}
			out.write(maxshade + "\n");
			byte counter = 0;
			for(int i = 0;i < getHeight();i++) {
				for(int j = 0; j < getWidth();j++) {
					out.write(p[i][j] + " ");
					counter++;
					if (counter == 20) {
						out.write("\n");
						counter = 0;
					}
				}
			}
			out.close();
		}
		catch (IOException e) {
			System.out.println("File not found");
		}
		return p;
		}
	public static void main(String[] args) {
		PPMImage cs = new PPMImage("PPMtest5.ppm" );
		cs.makeGrey("PPMtest5-expected.pgm");
		for (int i = 0; i < cs.makeGrey("PPMtest5.pgm").length;i++) {
			System.out.println(Arrays.toString(cs.makeGrey("PPMtest5.pgm")[i]));
		}
	}
}
