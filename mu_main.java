package com.ocr.com;
import java.io.PrintWriter;
public class my_main {
public static void main(String[] args) {
 String input_file="D:\\testfiles\\thumb.jpeg";
 String output_file="D:\\testfiles\\thumbone";
 String tesseract_install_path="D:\\Tesseract-OCR\\tesseract";
 String[] command =
    {
        "cmd",
    };
    Process p;
 try {
 p = Runtime.getRuntime().exec(command);
        //new Thread(null).start();
        new Thread().start();
        PrintWriter stdin = new PrintWriter(p.getOutputStream());
        stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
        stdin.close();
        p.waitFor();
        System.out.println();
        
        System.out.println(Read.read_file(output_file+".txt"));
    } catch (Exception e) {
 e.printStackTrace();
    }
  }
}