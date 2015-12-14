package jdraw.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;


public abstract class AbstractFigureTest {
	
	protected Figure f;
	protected int cnt;
	
//	abstract, damit die Unterklassen das sehen können
	protected abstract Figure createFigure();
	
	@Before
//	Teil 1 vom FactoryPattern
	public void setUp() {
		f = createFigure();
		cnt = 0;
	}
	
	@Test
	public void testNotification1() {
		FigureListener l = new TestListener();
		f.addFigureListener(l);
		int c = cnt;
		f.move(1, 1);
		assertTrue("figureChanged must be called on a registered listener", cnt == c+1);
		f.removeFigureListener(l);
		f.move(2,2);
		assertTrue("figureChanged must not be called on disconnected listener",   cnt == c+1);
	}

	@Test
	public void testNotification2() {
		f.addFigureListener(new TestListener());
		int c = cnt;
		f.move(0, 0);
		assertTrue("Listener was called even if state does not change", cnt == c);
	}

	@Test
	final public void testMultiListeners() {
		f.addFigureListener(new TestListener());
		f.addFigureListener(new TestListener());
		int c = cnt;
		f.move(3, 3);
		assertTrue("multiple listeners are not supported", cnt == c+2);
	}

	@Test
	final public void testRemoveListener(){
		f.addFigureListener(new TestListener());
		f.addFigureListener(new RemoveListener(f));
		f.addFigureListener(new TestListener());
		f.move(4,4);
	}

	class TestListener implements FigureListener {
		public void figureChanged(FigureEvent e){
			assertTrue(e.getSource() == f);
			cnt++;
		}
	}

	class RemoveListener implements FigureListener {
		Figure f;
		RemoveListener(Figure f){this.f = f;}
		public void figureChanged(FigureEvent e){
			f.removeFigureListener(this);
		}
	}

}
