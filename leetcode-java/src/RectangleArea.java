package leetcode;

public class RectangleArea {
	class Point {
		public Point (int _x, int _y)
		{
			x = _x;
			y = _y;
		}
		int x;
		int y;
	}
	
	class Rectangle
	{
		Point p1;
		Point p2;
		
		public Rectangle(Point _p1, Point _p2)
		{
			p1 = _p1;
			p2 = _p2;
		}
		public boolean intersect(Rectangle other)
		{
			
			if (p1.y > other.p1.y && p1.y < other.p2.y)
			{
				
				return ( (p1.x > other.p1.x && p1.x < other.p2.x) ||
						 (p2.x > other.p1.x && p2.x < other.p2.x));
			}
			return false;
		}
		
		public Rectangle intersectRectangle(Rectangle other)
		{
			if (!this.intersect(other))
			{
				return new Rectangle(new Point(0,0), new Point(0,0));
			}
			Rectangle intersect;
			int x1 = Math.max(this.p1.x, other.p1.x);
			int x2 = Math.min(this.p2.x, other.p2.x);
			
			int y1 = Math.max(this.p1.y, other.p1.y);
			int y2 = Math.min(this.p2.y, other.p2.y);
			return new Rectangle(new Point(x1,y1), new Point(x2,y2));
			
		}
		
		public int area()
		{
			return (p2.x - p1.x)*(p2.y-p1.y);
		}
		
	}
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Rectangle r1 = new Rectangle(new Point(A,B), new Point(C,D));
        Rectangle r2 = new Rectangle(new Point(E,F), new Point(G,H));
        
        int area = 0;
        if (! r1.intersect(r2))
        {
        		area = r1.area() + r2.area(); 
        }
        else
        {
        		Rectangle other = r1.intersectRectangle(r2);
        		area = r1.area() + r2.area() - other.area(); 
        }
        
        return area;
        
    }
	public static void main(String[] args) {
		RectangleArea sol = new RectangleArea();
		int area = sol.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
		System.out.println("area=" + area);
	}

}
