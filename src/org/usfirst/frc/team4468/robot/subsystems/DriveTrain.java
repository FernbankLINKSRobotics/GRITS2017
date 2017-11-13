package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4468.robot.commands.Drive.JoystickDrive;

import com.kauailabs.navx.frc.AHRS;

public class DriveTrain extends Subsystem {
  
  public AHRS gyro = new AHRS(SerialPort.Port.kUSB1);
  
  private VictorSP leftTop  = new VictorSP(0);
  private VictorSP leftMid  = new VictorSP(1);
  private VictorSP leftBot  = new VictorSP(2);
  private VictorSP rightTop = new VictorSP(3);
  private VictorSP rightMid = new VictorSP(4);
  private VictorSP rightBot = new VictorSP(5);
    
  public Encoder rightEncoder = new Encoder(0, 1, true,   Encoder.EncodingType.k4X);
  public Encoder leftEncoder  = new Encoder(2, 3, false,  Encoder.EncodingType.k4X);

  private PWMSpeedController[] leftMotors  = {leftTop,  leftMid,  leftBot};
  private PWMSpeedController[] rightMotors = {rightTop, rightMid, rightBot};
  
  public final double multL = 0.6;
  public final double multR = 0.5;
  
  public double distanceTraveled;
  public double angleTravled;
  
  public DriveTrain() {
    super();
    
    LiveWindow.addActuator("Drive Train", "Front_Left Motor"  , (VictorSP) leftTop );
    LiveWindow.addActuator("Drive Train", "Middle_Left Motor" , (VictorSP) leftMid );
    LiveWindow.addActuator("Drive Train", "Bottom_Left Motor" , (VictorSP) leftBot );
    LiveWindow.addActuator("Drive Train", "Front_Right Motor" , (VictorSP) rightTop);
    LiveWindow.addActuator("Drive Train", "Middle_Right Motor", (VictorSP) rightMid);
    LiveWindow.addActuator("Drive Train", "Bottom_Right Motor", (VictorSP) rightBot);
    LiveWindow.addSensor("Drive Train", "Left Encoder" , leftEncoder );
    LiveWindow.addSensor("Drive Train", "Right Encoder", rightEncoder);
    LiveWindow.addSensor("Drive Train", "Gyro", gyro);
    
    
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new JoystickDrive());
  }
  
  public void drive(double left, double right) {
    double r = 0;
    double l = 0;
    
    // Normalize Speed
    if((right * 1.2) > 1) {
      r = 1;
      l = (left / (right * 1.2));
    } else {
      r = right * 1.2;
      l = left;
    }
    
    for(PWMSpeedController lMotor : leftMotors) {
      lMotor.set(l);
    }
    for(PWMSpeedController rMotor : rightMotors) {
      rMotor.set(-r);
    }
  }
  
  public void stop() {
    for(PWMSpeedController l : leftMotors) {
      l.stopMotor();
    }
    for(PWMSpeedController r : rightMotors) {
      r.stopMotor();
    }
  }

  public double getHeading() {
    return gyro.getAngle();
  }
  
  public double getDistance() {
    return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
  }
  
  public void reset() {
    gyro.reset();
    leftEncoder.reset();
    rightEncoder.reset();
  }
  
  public void encoderReset() {
    leftEncoder.reset();
    rightEncoder.reset();
  }
  
  public void gyroReset() {
    gyro.reset();
  }
  
  public void log() {
    SmartDashboard.putNumber("Left Distance",  leftEncoder .getDistance());
    SmartDashboard.putNumber("Right Distance", rightEncoder.getDistance());
    SmartDashboard.putNumber("Gyro",           gyro        .getAngle());
    SmartDashboard.putNumber("Left Speed",     leftEncoder .getRate());
    SmartDashboard.putNumber("Right Speed",    rightEncoder.getRate());
  }
}
