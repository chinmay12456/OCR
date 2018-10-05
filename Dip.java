import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;



import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class Dip {
 BufferedImage image;
 int wid;
 int hght;
 static int width;
 static int height;
 static double alpha=1;
 static double beta=50;
 
 public Dip() {
	 try {
	 File input = new File("D:\\testfiles\\thumb.jpeg");
	 image = ImageIO.read(input);
	 wid = image.getWidth();
	 hght = image.getHeight();
	 for(int i=0; i<hght; i++){
	
	 for(int j=0; j<wid; j++){
	 Color c = new Color(image.getRGB(j, i));
	 int red = (int)(c.getRed() * 0.299);
	 int green = (int)(c.getGreen() * 0.587);
	 int blue = (int)(c.getBlue() *0.114);
	 Color newColor = new Color(red+green+blue,
	 red+green+blue,red+green+blue);
	 image.setRGB(j,i,newColor.getRGB());
	 }
	 }
	 File ouptut = new File("D:\\testfiles\\thumb.jpeg");
	 ImageIO.write(image, "jpeg", ouptut);
	 } catch (Exception e) {}
	 }

	
 public static void main( String[] args )
 {
	 Dip obj=new Dip();
  	 
 
/* 
 try{
 
 System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
  
 Mat source = Imgcodecs.imread("D:\\testfiles\\thumb1.jpeg",
 Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
 Mat destination = new
 Mat(source.rows(),source.cols(),source.type());
 Imgproc.equalizeHist(source, destination);
 Imgcodecs.imwrite("D:\\testfiles\\thumb2.jpeg", destination);
 


 Mat source1 = Imgcodecs.imread("D:\\testfiles\\pan.jpg",
		 Imgcodecs.CV_LOAD_IMAGE_COLOR);
 Mat destination1 = new Mat(source1.rows(),source1.cols(),source1.type());
 source1.convertTo(destination1, -1, alpha, beta);
 Imgcodecs.imwrite("D:\\testfiles\\pan.jpg", destination1);
 
 
 Mat source2 = Imgcodecs.imread("D:\\testfiles\\pan.jpg",Imgcodecs.CV_LOAD_IMAGE_COLOR);
 Mat destination2 = new Mat(source2.rows(),source2.cols(),source2.type());
 Imgproc.GaussianBlur(source2,destination2,new Size(0,0),10);
 Core.addWeighted(source2, 1.5, destination2, -0.5, 0, destination2);
 Imgcodecs.imwrite("D:\\testfiles\\pan.jpg", destination2);
 
 }catch (Exception e) {
 System.out.println("error: " + e.getMessage());
 }
*/
 
 System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
 String file="D:\\testfiles\\thumb.jpeg";
 Mat src=Imgcodecs.imread(file);
 Mat dst = new Mat();
 Imgproc.threshold(src, dst, 90, 255,Imgproc.THRESH_BINARY_INV);
 Imgcodecs.imwrite("D:\\testfiles\\thumb.jpeg",dst);
 System.out.println("image processed");
 
 
 }
}
 
 

