package org.usfirst.frc.team4468.robot.commands.Shooter;

//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4468.robot.Robot;

public class Shoot extends Command {
  /*
  static double aD = 1.2; //in C, will change later
  static double angle = Math.toRadians(61); //Can Change
  static double m = .0706;
  static double g = 9.8;
  static double distanceX = 5;
  */
  
  public Shoot () {
    requires(Robot.shoot);
    
    //Robot.shoot.shoot1.setPIDSourceType(PIDSourceType.kRate);
    //Robot.shoot.shoot1.setPID(1, 0, 0);
  }
   /*
  public static double RotationalVelocity() {
    return (FinalVelocity()*.1519)/.0347; //in RPS
  }
  
  public static double FinalVelocity() {
    return Math.sqrt(Math.pow(YVelocity(), 2)+Math.pow(XVelocity(), 2));
  }
  
  public static double YVelocity() {
    double k = Math.sin(angle)*.0777*aD*.5*.0309;
    double correctV=0;
    int z=0;
    double[] storeArray = new double[180];
    double[] distanceArray = new double[180];
    for (double i=3; i<21; i=i+.1) {
      storeArray[z] = (float) i;
      z=z+1;
    }
    for (int o=0; o<180; o++) {
      double tMax = ((storeArray[o])/g);
      double dMax = ((Math.sqrt(m*(k*tMax*(2*storeArray[o]-g*tMax)+m))-m)/k);
      double dTraveledA = (-k/(2*m));
      double dTraveledC = (g*Math.pow(calcTime(storeArray[o]), 2));
      double dTraveledDown = (1-Math.sqrt(1-4*dTraveledA*dTraveledC))/(2*dTraveledA);
      //on the way down (Math.sqrt(m)*Math.sqrt((g*k*Math.pow(tMax, 2)+m))-m)/k;, but they equal the same at tMax
      distanceArray[o]= Math.abs(dMax - dTraveledDown);
      //uncomment below line if you wanna see the patterns
      //System.out.println("Distance: " + distanceArray[o] + " Velocity: " + storeArray[o] + " Time: " + calcTime(storeArray[o]));
    }
    double min = 100;
    for (int h=1; h<distanceArray.length;h++) {
      if (distanceArray[h]<min) {
        min = distanceArray[h];
        correctV = storeArray[h];
      }
    }
    return correctV;
  }
  
  public static double XVelocity() {
    double k = Math.cos(angle)*.0777*aD*.5*.0309;
    return (distanceX*(distanceX*k+2*m))/(2*m*calcTime(YVelocity()));
  }
  
  public static double calcTime(double storeArray) {
    //using max distance - 2.05 (which we know) = 0.5(Final velocity)t to solve for t
    double k = Math.sin(angle)*.0777*aD*.5*.0309;
    double comp1 = (((10000*Math.pow(k, 2)*Math.pow(storeArray, 2))/Math.pow(g, 2)));
    double comp2 = ((1/g)*400*k);
    double comp3 = ((-1640*k*Math.sqrt((m*(g*m+k*Math.pow(storeArray, 2)))/g))/m);
    double comp4 = (-600*Math.sqrt((m*(g*m+k*Math.pow(storeArray, 2)))/g));
    double comp5 = (((400*k*Math.pow(storeArray, 2))/g)+((1681*Math.pow(k, 2))/m)+(1230*k)+(600*m));
    return ((storeArray/g)+((1/(200*k))*(((-100*k*storeArray)/g)+Math.sqrt(comp1+comp2*(comp3+comp4+comp5)))));
  }
  */
  
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.shoot.setAgitate(0.7);
    Robot.shoot.setFly(-0.88);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !(Robot.oi.left.getRawButton(4));
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.shoot.stop();
  }
}
