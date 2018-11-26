package actions;

import org.usfirst.frc.team2472.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Forward extends Action{
private double speed = 0.5;

	

	/**sets time*/

	public Forward(double time) {

		System.out.println("Forward construtor");

		timeout = time;



	}

	/**sets time and speed (in that order)*/

	public Forward(double time, double speeed) {



		timeout = time;



		speed = speeed;



	}



	public void startAction() {

		

		super.startAction();
		System.out.println("StartAction");



	}



	public void periodic() {

		

		Robot.frontLeft.set(ControlMode.PercentOutput, 0.2);
		Robot.backLeft.set(ControlMode.PercentOutput, 0.2);
		Robot.frontRight.set(ControlMode.PercentOutput, 0.2);
		Robot.backRight.set(ControlMode.PercentOutput, 0.2);
		System.out.println("peeriodic");

		 

		}

	



	public void endAction() {


		System.out.println("end action");
		Robot.frontLeft.set(ControlMode.PercentOutput, 0.0);
		Robot.backLeft.set(ControlMode.PercentOutput, 0.0);
		Robot.frontRight.set(ControlMode.PercentOutput, 0.0);
		Robot.backRight.set(ControlMode.PercentOutput, 0.0);

	}

	
/*
	public boolean isFinished(){

		

		if(isTimedOut()){

			

			endAction();

			

			return true;

			

		}

		

		else{

		

			return false;

			

		}

		

	}
	*/

}
