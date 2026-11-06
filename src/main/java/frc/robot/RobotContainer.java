// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.interpolation.InterpolatingDoubleTreeMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import swervelib.SwerveInputStream;

import java.io.File;
import com.pathplanner.lib.auto.AutoBuilder; 
import com.pathplanner.lib.auto.NamedCommands;

public class RobotContainer {

  final CommandXboxController driverXbox = new CommandXboxController(0);
  final CommandXboxController opXbox = new CommandXboxController(1);
  private Hopper hopper = new Hopper(); 
  private Shooter shooter = new Shooter();

 

  // Swerve Initialization
  // public final SwerveSubsystem swerveSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
  //     "swerve"));

  private SendableChooser<Command> sendableChooser = new SendableChooser<>();

  // SwerveInputStream driveAngularVelocity = SwerveInputStream.of(swerveSubsystem.getSwerveDrive(),
  //     () -> driverXbox.getLeftY() * -1,
  //     () -> driverXbox.getLeftX() * -1)
  //     .withControllerRotationAxis(driverXbox::getRightX)
  //     .deadband(0.1)
  //     .scaleTranslation(.60)
  //     .allianceRelativeControl(true);
    

  public RobotContainer() {

    configureBindings();

    DriverStation.silenceJoystickConnectionWarning(true); // Get rid of controller error
  }

  private void configureBindings() {

    // Setup swervedrive command
    // Command driveFieldOrientedAnglularVelocity = swerveSubsystem.driveFieldOriented(driveAngularVelocity);
    // swerveSubsystem.setDefaultCommand(driveFieldOrientedAnglularVelocity);

    // Reset gyro
    // driverXbox.start().onTrue(new InstantCommand(() -> swerveSubsystem.zeroGyro()));

    opXbox.rightBumper().whileTrue(hopper.extendHopper()).onFalse(hopper.stopHopper());
    opXbox.leftBumper().whileTrue(hopper.detractHopper()).onFalse(hopper.stopHopper());
    opXbox.a().whileTrue(shooter.intakeCycle()).onFalse(shooter.stopIntake());
    opXbox.y().whileTrue(shooter.shootCycle()).onFalse(shooter.stopShoot());
    opXbox.povDown().whileTrue(shooter.ejectCycle()).onFalse(shooter.stopEject());
    opXbox.rightTrigger().whileTrue(hopper.extendHopper()).onFalse(hopper.stopHopper());
    opXbox.leftTrigger().whileTrue(hopper.detractHopper()).onFalse(hopper.stopHopper());

    opXbox.x().onTrue(new SequentialCommandGroup(
      hopper.extendHopper().withTimeout(1.5),
      shooter.intakeCycle().withTimeout(2),
      shooter.shootCycle().withTimeout(1)
    ));
  }


  public Command getAutonomousCommand() {

    return sendableChooser.getSelected();
    // return hopper.hopperExtend(); 

  }
  
  public void setMotorBrake(boolean brake) {
    // swerveSubsystem.setMotorBrake(brake);
  }
}
