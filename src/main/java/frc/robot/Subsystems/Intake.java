package frc.robot.Subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.*;


public class Intake extends SubsystemBase{

    public SparkMax intakeMotorL;
    public SparkMax intakeMotorR;

    public Intake(){
        // Initialize crap
        intakeMotorL = new SparkMax(IntakeConstants.LeftID, MotorType.kBrushless);
        intakeMotorR = new SparkMax(IntakeConstants.RightID, MotorType.kBrushless);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Motor Left Speed", intakeMotorL.get());
        SmartDashboard.putNumber("Intake Motor Right Speed", intakeMotorR.get());
    }

    public Command IntakeSpin(double speed){
        // Spin motors with the speed of the input
        return run(() -> {
            intakeMotorL.set(speed);
            intakeMotorR.set(speed);
        });
    }

    public Command IntakeReverse(double speed){
        // Spin motors in reverse with the speed of the input
        return run(() -> {
            intakeMotorL.set(-speed);
            intakeMotorR.set(-speed);
        });
    }

    public Command IntakeStop(){
        //Stop the motor
        return run(() -> {
            intakeMotorL.stopMotor();
            intakeMotorR.stopMotor();
        });
    }

    public Command IntakeSpinL(double speed){
        return run(() -> intakeMotorL.set(speed));
    }

    public Command IntakeSpinR(double speed){
        return run(() -> intakeMotorR.set(speed));
    }
}