package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Arrays;
import java.util.stream.Stream;

import org.zeromq.ZMQ;

import edu.wpi.first.wpilibj.*;

public class Shooter extends Subsystem {
	
	private Thread t;
	private String name;
	
	private static double angle;
	private static double distance;
	
	//private ZMQ.Socket sub = null;
	
	private static NetworkTable table;
	
	private TalonSRX shoot1 = new TalonSRX(8);
	private TalonSRX shoot2 = new TalonSRX(9);
	
	private VictorSP agitateMotor = new VictorSP(10);

	
	private PWMSpeedController[] motors = {shoot1, shoot2};
	
	Stream<PWMSpeedController> motorStream  = Arrays.stream(motors);

	public Shooter() {
		super();
		
		table = NetworkTable.getTable("Vision");
		
		LiveWindow.addActuator("Shooter", "Motor 1", (TalonSRX) shoot1);
		LiveWindow.addActuator("Shooter", "Motor 2", (TalonSRX) shoot2);
	}
	
	@Override
	public void initDefaultCommand() {} 
	
	public void log() {
		SmartDashboard.putNumber("Speed 1:", shoot1.getSpeed());
		SmartDashboard.putNumber("Speed 2:", shoot2.getSpeed());
	}
	/*
	public void parseInput() {
		String input = sub.recvStr(0).trim();
    		String[] data = input.split(" ");
    			
    		String temp1 = data[1].trim().replaceAll("[^\\d|\\.|-]", "");
    		double a = Double.parseDouble(temp1);
    	
    		String temp2 = data[1].trim().replaceAll("[^\\d|\\.|-]", "");
    		double d = Double.parseDouble(temp2);
    		
    		setAngle(a);
    		setDistance(d);
	}
	
	public void startSub() {
		ZMQ.Context context = ZMQ.context(1);
		sub = context.socket(ZMQ.SUB);
		
		sub.connect("tcp://10.44.68.3:5801"); //placeholder value
		
		String filter = "valuesß";
		sub.subscribe(filter.getBytes());
		
		System.out.println("Starting " +  name );
		
	    if (t == null) {
	    		t = new Thread (name);
	    		t.start ();
	    }
	*/
	}
	
	public void setFly(double speed) {
		motorStream.forEach((PWMSpeedController m) -> m.set(speed));
	}
	
	public void setAgitate(double speed) {
		agitateMotor.set(speed);
	}
	
	public void stop() {
		setFly(0);
		setAgitate(0);
	}
	
	public static double getAngle() {
		return table.getNumber("angle", 50);
	}
	
	public static double getDistance(){
		return table.getNumber("distance", 50);
	}
}