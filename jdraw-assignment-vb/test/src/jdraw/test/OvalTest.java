package jdraw.test;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OvalTest extends AbstractFigureTest{

	
//  hier keine @Before, weil das KEINE Methode ist, 
//	die vor Beginn des Tests ausgeführt wird
//	Teil 2 vom FactoryPattern
	protected Figure createFigure(){
		return new jdraw.figures.Oval(0, 0, 20, 10);
	}

}
