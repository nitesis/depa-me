package patterns.clone.immutable;

import java.awt.Point;

public class ImmutableLine implements Cloneable {
	private final Point start, end;

	public ImmutableLine(Point start, Point end) {
		this.start = (Point)start.clone();
		this.end = (Point)end.clone();
	}

	
	
	public Point getStartPoint() {
		return (Point) start.clone();
	}

	public ImmutableLine setStartPoint(Point start) {
		return new ImmutableLine(start, end);
	}

	public Point getEndPoint() {
		return (Point) end.clone();
	}

	public ImmutableLine setEndPoint(Point end) {
		return new ImmutableLine(start, end);
	}

//	@Override
//	public ImmutableLine clone() {
//		try {
//			ImmutableLine p = (ImmutableLine) super.clone();
//			p.start = (Point)start.clone();
//			p.end = (Point)end.clone();
//			return p;
//		} catch (CloneNotSupportedException e) {
//			throw new InternalError();
//		}
//	}

	@Override
	public String toString() {
	   return String.format("Line[start=%s, end=%s]", start, end);
	}
}
