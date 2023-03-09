public class NBody{
    static String starfield="starfield.jpg";   

    public static void main(String []args){
           double T=Double.parseDouble(args[0]);
           double dt=Double.parseDouble(args[1]);
           double time=0;
           String filename=args[2];
           double radius=readRadius(filename);
           Body[] bodys=readBodies(filename);
           StdDraw.enableDoubleBuffering();
           while(time<T){
              double[]xForces=new double[bodys.length];
              double[]yForces=new double[bodys.length];
              for(int i=0;i<bodys.length;i++){
                  xForces[i]=bodys[i].calcNetForceExertedByX(bodys);
                  yForces[i]=bodys[i].calcNetForceExertedByY(bodys);    
              }   
              for(int i=0;i<bodys.length;i++){
                  bodys[i].update(dt,xForces[i],yForces[i]);
              }
              DrawBackground(radius);
              StdDraw.picture(0,0,starfield);
              Body.draw(bodys,radius);
              StdDraw.show();
              StdDraw.pause(10);
              time=time+dt;
           }
       StdOut.printf("%d\n",bodys.length);
       StdOut.printf("%.2e\n",radius);
       for(int i=0;i<bodys.length;i++){
       
         System.out.println(bodys[i].xxPos+"  "+bodys[i].yyPos+"  "+bodys[i].xxVel+"   "+bodys[i].yyVel+"    "+bodys[i].mass+"   "+bodys[i].imgFileName+"   ");

       }
       double[]xForce=new double[bodys.length];
       double[]yForce=new double[bodys.length];
       for(int i=0;i<bodys.length;i++){
              System.out.println(bodys[i].calcNetForceExertedByX(bodys));
              System.out.println(bodys[i].calcNetForceExertedByY(bodys));      
       }
       
    }
    /* this method is used for reading radius from planets.txt,what's more
     this method also invokes "in" method to read information word by word.
     */
     public static double readRadius(String filename){
            In in =new In(filename);
            in.readInt();
            double radius=in.readDouble();
            return radius;
     } /* this method is used for reading bodies' information from planets.txt,what' more
     this method invokes "in" method and constructor method .Last but not least ,this method will
     return array that consist of bodies object. 
     */
    
     public static Body[] readBodies(String filename){
            In re =new In(filename);
            re.readInt();
            re.readString();
            Body earth=new Body(re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readString());
            Body mars=new Body(re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readString());
            Body mercury=new Body(re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readString());
            Body sun=new Body(re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readString());
            Body venus=new Body(re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readDouble(),re.readString());
            Body[]bodys={earth,mars,mercury,sun,venus};
            return bodys;
     }
     public static void  DrawBackground(double radius){
         StdDraw.enableDoubleBuffering();
         
         StdDraw.setScale(-radius,radius);
         StdDraw.clear();
         StdDraw.picture(0,0,starfield);
         StdDraw.show();
     }
}