package actions;

import org.usfirst.frc.team2472.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveAction implements Actionable{
	
	private long endTime;
	private final double lifetime;
	private double speed = 0.5;
	

	public DriveAction (double lifetime) {
		this.lifetime = lifetime;
	}
	
	public DriveAction(double lifetime, double speed) {
		this.lifetime = lifetime;
		this.speed = speed;
	}
	
	@Override
	public void startAction() {
		endTime = System.currentTimeMillis() + (long)(1000 * lifetime);		
	}
	
	@Override
	public void periodic() {
		Robot.frontLeft.set(ControlMode.PercentOutput, speed);
		Robot.backLeft.set(ControlMode.PercentOutput, speed);
		Robot.frontRight.set(ControlMode.PercentOutput, speed);
		Robot.backRight.set(ControlMode.PercentOutput, speed);
		System.out.println("peeriodic");
	}

	@Override
	public void endAction() {
		Robot.frontLeft.set(ControlMode.PercentOutput, 0.0);
		Robot.backLeft.set(ControlMode.PercentOutput, 0.0);
		Robot.frontRight.set(ControlMode.PercentOutput, 0.0);
		Robot.backRight.set(ControlMode.PercentOutput, 0.0);
		System.out.println("EndAction");
		
	}

	@Override
	public boolean isFinished() {
		if (System.currentTimeMillis() > endTime) {
			return true;
		} else {
			return false;
		}
	}

	

}
