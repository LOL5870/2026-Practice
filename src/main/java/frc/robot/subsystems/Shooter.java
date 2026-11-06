package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.Supplier;

public class Shooter extends SubsystemBase {

    SparkMax shooterLeft;
    SparkMax shooterRight;
    SparkMax intakeFlap;
    SparkMax indexer;
    SparkMax groundIntake;

    public Shooter() {

        shooterLeft = new SparkMax(Constants.ShooterConstants.SHOOTER_LEFT, MotorType.kBrushless);
        shooterRight = new SparkMax(Constants.ShooterConstants.SHOOTER_RIGHT, MotorType.kBrushless);
        intakeFlap = new SparkMax(Constants.ShooterConstants.INTAKE_FLAP, MotorType.kBrushless);
        indexer = new SparkMax(Constants.ShooterConstants.INDEXER, MotorType.kBrushless);
        groundIntake = new SparkMax(Constants.ShooterConstants.GROUND_INTAKE, MotorType.kBrushless);

    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("ShooterSpeed", shooterLeft.get());
        SmartDashboard.putNumber("IntakeFlapSpeed", intakeFlap.get());
        SmartDashboard.putNumber("IndexerSpeed", intakeFlap.get());
        SmartDashboard.putNumber("GroundIntakeSpeed", groundIntake.get());

    }

    // CYCLES
    public Command intakeCycle() {
        return null;
    }

    public Command reverseShoot() {
        return null;
    }

    public Command ejectCycle() {
        return null;
    }

    public Command shootCycle() {
        return null;
    }

    // STOP
    public Command stopIntake() {
        return null;
    }

    public Command stopEject() {
        return null;
    }

    public Command stopShoot() {
        return null;
    }

    // TEST
    public Command testGroundIntake(Supplier<Double> speed) {
        return null;
    }

    public Command testShooterLeft(Supplier<Double> speed) {
        return null;
    }

    public Command testShooterRight(Supplier<Double> speed) {
        return null;
    }

    public Command testIntakeFlap(Supplier<Double> speed) {
        return null;
    }

    public Command testIndexer(Supplier<Double> speed) {
        return null;
    }
}
