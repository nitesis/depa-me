
/* File Dsp043.java
Copyright 2006, R.G.Baldwin
Revised 01/05/06

The purpose of this program is to demonstrate that the
imaginary part of the Fourier transform of a symmetrical
time series is all zeros if the origin is properly located.

Illustrates forward and inverse Fourier transforms on a 
symmetrical time series using DFT algorithms.

Passes resulting real and complex parts to inverse Fourier
transform program to reconstruct the original time series.

Run with Graph03. Enter the following to run the program:
java Graph03 Dsp043

Exection of this program requires access to the following
class files:
Dsp043.class
ForwardRealToComplex01.class
Graph01.class
GraphIntfc01.class
GUI$MyCanvas.class
GUI.class
InverseComplexToReal01.class

Tested using J2SE 5.0 under WinXP.
**********************************************************/
import java.util.*;

class Dsp043 implements GraphIntfc01{
  final double pi = Math.PI;

  int len = 300;

  double[] timeDataIn = new double[len];
  double[] realSpect = new double[len];
  double[] imagSpect = new double[len];
  double[] angle = new double[len];//unused
  double[] magnitude = new double[len];
  double[] timeDataOut = new double[len];
  int zero = 0;

  public Dsp043(){//constructor

    //Create raw waveform consisting of mirror image
    // sinusoidal segments with a sample having a value
    // of 0 in the center.
    //Set shift to a nonzero value to cause the imaginary
    // part of the transform to be non zero.
    for(int x = 0;x < len/4;x++){
      timeDataIn[len/2 + x + 1] = 
                        80.0 * Math.sin(2*pi*(x)*1.0/20.0);
      timeDataIn[len/2 - x - 1] = 
                                 timeDataIn[len/2 + x + 1];
    }//end for loop

    //Compute DFT of the time data and save it in
    // the output arrays.
    ForwardRealToComplex01.transform(timeDataIn,
                                     realSpect,
                                     imagSpect,
                                     angle,
                                     magnitude,
                                     zero,
                                     0.0,
                                     1.0);

    //Compute inverse DFT of the spectal data and
    // save output time data in output array
    InverseComplexToReal01.inverseTransform(realSpect,
                                            imagSpect,
                                            timeDataOut);
  }//end constructor
  //-----------------------------------------------------//
  
  //The following six methods are required by the interface
  // named GraphIntfc01.
  public int getNmbr(){
    //Return number of curves to plot.  Must not exceed 5.
    return 5;
  }//end getNmbr
  //-----------------------------------------------------//
  public double f1(double x){
    int index = (int)Math.round(x);
    if(index < 0 || index > timeDataIn.length-1){
      return 0;
    }else{
      return timeDataIn[index];
    }//end else
  }//end function
  //-----------------------------------------------------//
  public double f2(double x){
    int index = (int)Math.round(x);
    if(index < 0 || index > realSpect.length-1){
      return 0;
    }else{
      //scale for convenient viewing
      return 5*realSpect[index];
    }//end else
  }//end function
  //-----------------------------------------------------//
  public double f3(double x){
    int index = (int)Math.round(x);
    if(index < 0 || index > imagSpect.length-1){
      return 0;
    }else{
      //scale for convenient viewing
      return 5*imagSpect[index];
    }//end else
  }//end function
  //-----------------------------------------------------//
  public double f4(double x){
    int index = (int)Math.round(x);
    if(index < 0 || index > magnitude.length-1){
      return 0;
    }else{
      //scale for convenient viewing
      return 5*magnitude[index];
    }//end else
  }//end function
  //-----------------------------------------------------//
  public double f5(double x){
    int index = (int)Math.round(x);
    if(index < 0 ||
                   index > timeDataOut.length-1){
      return 0;
    }else{
      return timeDataOut[index];
    }//end else
  }//end function

}//end sample class Dsp043
