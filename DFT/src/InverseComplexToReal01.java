public class InverseComplexToReal01{

  public static void inverseTransform(
                               double[] realIn,
                               double[] imagIn,
                               double[] realOut){

    int dataLen = realIn.length;
    double delT = 1.0/realIn.length;
    double startTime = 0.0;
    //Outer loop interates on time domain
    // values.
    for(int i=0; i < dataLen;i++){
      double time = startTime + i*delT;
      double real = 0;
      //Inner loop iterates on frequency
      // domain values.
      for(int j=0; j < dataLen; j++){
        real += realIn[j]*
                      Math.cos(2*Math.PI*time*j)
             + imagIn[j]*
                      Math.sin(2*Math.PI*time*j);
      }//end inner loop
      realOut[i] = real;
    }//end outer loop
  }//end inverseTransform

}//end class InverseComplexToReal01