package frc.robot.Subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Intake extends SubsystemBase{

    public SparkMax intakeMotorL;
    public SparkMax intakeMotorR;

    public Intake(){
        // Initialize the motors
        // Use the variables in Constants.java for the motor ID and kBrushless for the type
    }

    @Override
    public void periodic() {

    }

    public Command IntakeSpin(double speed){
        // Spin motors with the speed of the input
        return null;
    }

    public Command IntakeReverse(double speed){
        // Spin motors in reverse with the speed of the input
        return null;
    }

    public Command IntakeStop(){
        //Stop the motor by setting speed to 0
        return null;
    }
    
}