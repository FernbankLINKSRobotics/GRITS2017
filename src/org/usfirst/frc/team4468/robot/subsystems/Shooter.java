package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.*;

public class Shooter extends Subsystem {
	
	private static NetworkTable table;

	public CANTalon shoot1 = new CANTalon(10);
	public CANTalon shoot2 = new CANTalon(11);
	
	public VictorSP agitateMotor = new VictorSP(9);
	
	public Shooter() {
		super();
		
		table = NetworkTable.getTable("Vision");

		LiveWindow.addActuator("Shooter", "Motors", (CANTalon) shoot1);
		LiveWindow.addActuator("Agitator", "Motor",  (VictorSP) agitateMotor);
		
		shoot1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shoot1.changeControlMode(CANTalon.TalonControlMode.Speed);
		
		shoot2.changeControlMode(CANTalon.TalonControlMode.Follower);
		shoot2.set(shoot1.getDeviceID());
	}
	
	@Override
	public void initDefaultCommand() {} 
	
	public void log() {
		SmartDashboard.putNumber("Speeds :", shoot1.getSpeed());
		SmartDashboard.putNumber("Rates :" , shoot1.getEncVelocity());
		SmartDashboard.putNumber("Motor: " , agitateMotor.getSpeed());
	}

	public void setFly(double speed) {
		shoot1.set(speed);
	}

	public void setAgitate(double speed) {
		agitateMotor.set(speed);
	}
	
	public void stop() {
		//setFly(0);
		setAgitate(0);
	}
	
	public static double getAngle() {
		return table.getNumber("angle", 50);
	}
	
	public static double getDistance(){
		return table.getNumber("distance", 50);
	}
}