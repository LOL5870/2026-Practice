package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.InstantCommand;

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
        return run(() -> {
            SmartDashboard.putBoolean("intakeCycle", true);
        });
    }

    public Command reverseShoot() {
        return run(() -> {
            SmartDashboard.putBoolean("reverseShoot", true);
        });
    }

    public Command ejectCycle() {
        return run(() -> {
            SmartDashboard.putBoolean("ejectCycle", true);
        });
    }

    public Command shootCycle() {
        return run(() -> {
            SmartDashboard.putBoolean("shootCycle", true);

        });
    }

    // STOP
    public Command stopIntake() {
        return run(() -> {
            SmartDashboard.putBoolean("intakeCycle", false);

        });
    }

    public Command stopEject() {
        return run(() -> {
            SmartDashboard.putBoolean("ejectCycle", false);
        });
    }

    public Command stopShoot() {
        return run(() -> {
            SmartDashboard.putBoolean("shootCycle", false);
        });
    }

    // TEST
    public Command testGroundIntake(Supplier<Double> speed) {
        return new InstantCommand();
    }

    public Command testShooterLeft(Supplier<Double> speed) {
        return new InstantCommand();
    }

    public Command testShooterRight(Supplier<Double> speed) {
        return new InstantCommand();
    }

    public Command testIntakeFlap(Supplier<Double> speed) {
        return new InstantCommand();
    }

    public Command testIndexer(Supplier<Double> speed) {
        return new InstantCommand();
    }

}
