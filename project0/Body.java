import java.lang.*;
import java.util.*;
public class Body{
         double xxPos;
         double yyPos;
         double xxVel;
         double yyVel;
         double mass;
         String imgFileName;
         static final double G=6.67E-11;
     public static void main(String [] args){
           Scanner sc=new Scanner(System.in);
           Body b1=new Body(0,0,0,0,3,"haha");
           Body b2=new Body(3,4,0,0,4,"baba");

           double a=calcDistance(b1,b2);
           System.out.println(a);
           double f=calcForceExertedBy(b1,b2);
           System.out.println(f);
     }
     /*
           this method is used for initing Object "Body",which includes position
        (xxPos,yyPos),velocity(xxVel,yyVel),mass and filename
     */
     public Body(double xP,double yP,double xV,double yV,double m,String img){
          this.xxPos=xP;
          this.yyPos=yP;
          this.xxVel=xV;
          this.yyVel=yV;
          this.mass=m;
          this.imgFileName=img;
     }
      /*   this method is used for copying same information to other Object
      "Body"
       */  
     public Body(Body b){
           this.xxPos=b.xxPos;
           this.yyPos=b.yyPos;
           this.xxVel=b.xxVel;
           this.yyVel=b.yyVel;
           this.mass=b.mass;
           this.imgFileName=b.imgFileName;
     }
      /*
         this method is used for caculating the distance between b1 and b2
     */
     public static double calcDistance(Body b1,Body b2){
        double r2;
        double r;
        r2=(b1.xxPos-b2.xxPos)*(b1.xxPos-b2.xxPos)+(b1.yyPos-b2.yyPos)*
           (b1.yyPos-b2.yyPos);
        return r=Math.sqrt(r2);
     }
     /*
         this method is used for caculating the gravitation between b1 and b2.
      what's more,this method also includes other method called calcDistance
         these methods only include magnitude,not including direction.
     */
     public static double calcForceExertedBy(Body b1,Body b2){
        double F;
        double r=calcDistance(b1,b2);
        return F=(G*b1.mass*b2.mass)/(r*r);
     }
     public  static double calcForceExertedByX(Body b1,Body b2){
        double Fx;
        Fx=calcForceExertedBy(b1,b2)*Math.abs(b1.xxPos-b2.xxPos)/calcDistance(b1,b2);
        return Fx;
     }
     public static double calcForceExertedByY(Body b1,Body b2){
        double Fy;
        Fy=calcForceExertedBy(b1,b2)*Math.abs(b1.yyPos-b2.yyPos)/calcDistance(b1,b2);
        return Fy;
     }
     /*
         these methods are used for caculating the gravitation in series of
      Object.
         To achieve the goal, we have to think about Force-Direction to systhsis
      the force in the same staight line
     */
     public  double calcNetForceExertedByX(Body[] allBodys){
           double Fx=0;        
           for(int i=0;i<allBodys.length;i++){
               double Fi;
               if(allBodys[i]==this){
                  continue;
               }
               Fi=calcForceExertedByX(allBodys[i],this);
               if(this.xxPos>allBodys[i].xxPos){
                  Fi=-Fi;
               }  
               Fx=Fx+Fi;       
           }
           return Fx;
     }
     public  double calcNetForceExertedByY(Body[] allBodys){
            double Fy=0;
            for(int i=0;i<allBodys.length;i++){
               double Fi;
               if(allBodys[i]==this){
                  continue;
               }
               Fi=calcForceExertedByY(allBodys[i],this);
               if(this.yyPos>allBodys[i].yyPos){
                  Fi=-Fi;
               }
               Fy=Fy+Fi;
            }
            return Fy;
     }
     /*
        this method is used for synthesising Fx and Fy.
     */
     public static double Synthesisofforce(double Fx,double Fy){
            double F;
            return F=Math.sqrt((Fx*Fx)+(Fy*Fy));
     }
     /*
        this method is used for updating object's velocity,position.
      what's more ,we can't use calcForceExertedByX()to determine "update"
      which don't have direction
     */
     public void update(double t,double Fx,double Fy){
            double ax;
            double ay;
            ax=Fx/this.mass;
            ay=Fy/this.mass;
            this.xxVel=this.xxVel+ax*t;
            this.yyVel=this.yyVel+ay*t;
            this.xxPos=this.xxVel*t-(1/2)*ax*t*t;
            this.yyPos=this.yyVel*t-(1/2)*ay*t*t;
     }
     public static void draw(Body[] bodies,double radius){
            StdDraw.enableDoubleBuffering();
            
            StdDraw.setScale(-radius,radius);

            for(int i=0;i<bodies.length;i++){
               StdDraw.picture(bodies[i].xxPos,bodies[i].yyPos,bodies[i].imgFileName);
            }
            
            StdDraw.show();
     }
}













