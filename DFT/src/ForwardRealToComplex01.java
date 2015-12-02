public class ForwardRealToComplex01{

  public static void transform(
                              double[] data,
                              double[] realOut,
                              double[] imagOut,
                              double[] angleOut,
                              double[] magnitude,
                              int zero,
                              double lowF,
                              double highF){
    double pi = Math.PI;//for convenience
    int dataLen = data.length;
    double delF = (highF-lowF)/data.length;
    
  //Outer loop iterates on frequency
    // values.
    for(int i=0; i < dataLen;i++){
      double freq = lowF + i*delF;
      double real = 0.0;
      double imag = 0.0;
      double ang = 0.0;
      //Inner loop iterates on time-
      // series points.
      for(int j=0; j < dataLen; j++){
        real += data[j]*Math.cos(
                             2*pi*freq*(j-zero));
        imag += data[j]*Math.sin(
                             2*pi*freq*(j-zero));
      }//end inner loop
      
      realOut[i] = real/dataLen;
      imagOut[i] = imag/dataLen;
      magnitude[i] = (Math.sqrt(
                 real*real + imag*imag))/dataLen;

      //Calculate and return the phase
      // angle in degrees.
      if(imag == 0.0 && real == 0.0){ang = 0.0;}
      else{ang = Math.atan(imag/real)*180.0/pi;}

      if(real < 0.0 && imag == 0.0){ang = 180.0;}
      else if(real < 0.0 && imag == -0.0){
                                   ang = -180.0;}
      else if(real < 0.0 && imag > 0.0){
                                   ang += 180.0;}
      else if(real < 0.0 && imag < 0.0){
                                  ang += -180.0;}
      angleOut[i] = ang;
    }//end outer loop
  }//end transform method

}//end class ForwardRealToComplex01