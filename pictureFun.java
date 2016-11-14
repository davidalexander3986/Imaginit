/*
 * Author: David Alexander
 * This program uses the class Picture to perform various modifications on a 
 * JPEG image, such as color scales and image mirroring.
 */
import java.awt.*;
import java.util.*;
import imaginitClasses.*;

import imaginitClasses.Picture;
import imaginitClasses.Pixel;
public class pictureFun extends Picture{

pictureFun(String path){
  super(path);
}

public void clearRed(){
  Pixel[] pix = this.getPixels();
  Pixel pi = null;

  for(int i = 0; i < pix.length; i++){
    pi = pix[i];
    pi.setRed(0);
  }

  this.show();

}
public void clearBlue(){
  Pixel[] pixArr = this.getPixels();
  Pixel pix = null;

    for( int i = 0; i < pixArr.length; i++){
      pix = pixArr[i];
      pix.setBlue(0);
    }
    this.show();
  }

  public void clearGreen(){
    Pixel[] pixArr = this.getPixels();
    Pixel pi = null;

    for(int i = 0; i < pixArr.length;i++){
      pi = pixArr[i];
      pi.setGreen(0);
    }
    this.show();
  }

  public void flipVert(){
    Pixel temp = new Pixel(new Picture(1,1),1,1);
    Pixel sPix = null;
    Pixel tPix = null;

    for(int y = 0; y < this.getHeight()/2;y++)
    {
      for(int x = 0; x < this.getWidth();x++)
      {
        sPix = this.getPixel(x,y);
        tPix = this.getPixel(x,this.getHeight()-y);
        temp.setColor(tPix.getColor());
        tPix.setColor(sPix.getColor());
        sPix.setColor(temp.getColor());
      }
    }
    this.show();
  }

  public void keepBlue(){
    Pixel[] pixArr = this.getPixels();
    Pixel pi = null;

    for(int i = 0; i < pixArr.length; i++){
      pi = pixArr[i];
      pi.setGreen(0);
      pi.setRed(0);
    }
   
  }

  public void keepGreen(){
    Pixel[] pixArr = this.getPixels();
    Pixel pi = null;

    for(int i = 0; i < pixArr.length;i++){
      pi = pixArr[i];
      pi.setRed(0);
      pi.setBlue(0);
    }
    
  }

  public void keepRed(){
    Pixel[] pixArr = this.getPixels();
    Pixel pi = null;
    for(int i = 0; i < pixArr.length;i++){
      pi = pixArr[i];
      pi.setBlue(0);
      pi.setGreen(0);
    }
   
  }

  public void maxBlue(){
    Pixel[] pixArr = this.getPixels();
    Pixel pi = null;
    for(int i = 0; i < pixArr.length; i++){
      pi = pixArr[i];
      pi.setBlue(255);
    }
    this.show();
  }
  public void mirrorVert(){
    int w = this.getWidth();
    int h = this.getHeight();
    Pixel p = null;
    Pixel pt = null;
    for(int y = 0; y < h;y++){
      for(int x = 0; x < w; x++){
        p = this.getPixel(x,y);
        pt = this.getPixel(w-1-x,y);
        pt.setColor(p.getColor());
      }
    }
    
  }

  public void mirrorHoriz(){
    int w = this.getWidth();
    int h = this.getHeight();
    Pixel p = null;
    Pixel pt = null;

    for(int y = 0; y < h; y++)
      for(int x = 0; x < w; x++){
        p = this.getPixel(x,y);
        pt = this.getPixel(x, h-1-y);
        pt.setColor(p.getColor());
      }
    
  }
public static void main(String[] args) {
  pictureFun source = new pictureFun("C:/Users/Dave/Pictures" +
 "/Coyote300/IMG_0259.jpg");
 source.show();
 source.flipVert();
 source.show();


}

}
