import static java.lang.Math.*;
//making a point class
class Point {
  
  //constructor for Point class

  public Point(float coo1,float coo2){
  //using constructor initializing the coordinate value for two values of coordinate x and y to define a point
    x_coordinate_value=coo1;
    y_coordinate_value=coo2;
  }
  
  //two private feild in a class for x and y value of a coordinate point
  private float x_coordinate_value;
  private float y_coordinate_value;
  
  //display function return the value of coordinate in string
  public String display() {
    return  x_coordinate_value+" , " + y_coordinate_value ;
  }
  public float get_x_coordinate(){
    return x_coordinate_value ;
  }
  
  public float get_y_coordinate(){
    return y_coordinate_value ;
  }
}
// extending the point class to define a line
class Line extends Point {
    
    private float x_coordinate_value;
    private float y_coordinate_value;
    
    double length;
   
    public Line(float coo1,float coo2 , float coo3 , float coo4){
        super(coo1,coo2);    
        x_coordinate_value=coo3;
        y_coordinate_value=coo4;
    }
    
    public String display() {
        return  super.display()+ " and  "+ x_coordinate_value+ " , " +y_coordinate_value ;
        }
   
      public double calc_length(){
          float x2=super.get_x_coordinate();
          float y2=super.get_y_coordinate();
          float xx=x_coordinate_value-x2;
          float yy=y_coordinate_value-y2;
          double ini= pow(xx,2)+ pow(yy,2);
          double length_f= sqrt(ini);
          this.length=length_f;
          return this.length;
        }
     }

class Triangle extends Line{
  private double len1,len2,len3;
 
  
  public Triangle(float x1,float y1,float x2,float y2,float x3,float y3){
    super(x1,y1,x2,y2);
    len1=super.calc_length();
    Line second=new Line(x2,y2,x3,y3);
    Line third=new Line(x1,y1,x3,y3);
    len2=second.calc_length();
    len3=third.calc_length();
  }
  public double calc_area(){
    double s=(len1+len2+len3)/2;
    double calc=s*(s-len1)*(s-len2)*(s-len3);
    double area=sqrt(calc);
    return area;
  }
}

class inheritance {
  public static void main(String[] args) {

    Point a_point=new Point(5,4);
    Line a_line = new Line(1,1,2,2);
    Triangle a_triangle=new Triangle(0, 0, 0, 1, 1, 0);
    System.out.println(a_point.display());
    System.out.println(a_line.display());
    System.out.println(a_line.calc_length());
    System.out.println(a_triangle.calc_area());
  }
}