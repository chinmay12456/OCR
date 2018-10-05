import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvSetImageROI;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;//read it
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class Crop{
	public static void main(String args[]) {
		try {
			
			System.loadLibrary( Core.NATIVE_LIBRARY_NAME );	
			
			 Mat source = Imgcodecs.imread("D:\\testfiles\\thumb.jpeg", 
			         Imgcodecs.CV_LOAD_IMAGE_COLOR);
			         
			         Mat destination = new Mat(source.rows()*2,source.cols()*2, source.type());
			         destination = source;
			         Imgproc.pyrUp(source, destination, new Size(source.cols()*2, source.rows()*2));
			         
			         //Creating the transformation matrix M
			         Mat rotationMatrix = Imgproc.getRotationMatrix2D(new Point(675, 310), 270, 0.44);

			         //Rotating the given image
			         Imgproc.warpAffine(source, destination, rotationMatrix, new Size(source.cols(), source.cols()));
			         
			         Imgcodecs.imwrite("D:\\testfiles\\thumb.jpeg", destination);
			         
			         Rect rectCrop = new Rect(0, 0, 840, 520);
			         Mat image_roi = new Mat(destination, rectCrop);
			         image_roi.copyTo(destination);
			         Imgcodecs.imwrite("D:\\testfiles\\thumb.jpeg",image_roi);


		
	      
    	    Mat src = Imgcodecs.imread("D:\\testfiles\\thumb.jpeg");
    	    Mat resizeimage = new Mat();
    	    Imgproc.resize(src, resizeimage, new Size(498, 313));
    	    Imgcodecs.imwrite("D:\\testfiles\\thumb.jpeg", resizeimage);
   
         
        IplImage orig = cvLoadImage("D:\\testfiles\\thumb.jpeg");
        // Creating rectangle by which bounds image will be cropped
        CvRect r = new CvRect(10,80,350,300);
        // After setting ROI (Region-Of-Interest) all processing will only be done on the ROI
        cvSetImageROI(orig, r);
        IplImage cropped = cvCreateImage(cvGetSize(orig), orig.depth(), orig.nChannels());
        // Copy original image (only ROI) to the cropped image
        cvCopy(orig, cropped);
        cvSaveImage("D:\\testfiles\\thumb.jpeg", cropped);
        
        
		}catch (Exception e) {
			 System.out.println("error: " + e.getMessage());
		 }
   
	    
	}
}
	
