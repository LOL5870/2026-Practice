package frc.robot.Subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
    // method:
    // spinShooter()
    // stopShooter()
    // reverseShooter()

   

public class Shooter extends SubsystemBase{
 // DEFINE THE MOTORS

public SparkMax shooterLeft;
public SparkMax shooterRight;
    
    //CREATE CONSTRUCTOR AND INITIALIZE THE MOTORS
public Shooter() {
    shooterLeft = new SparkMax(3, kBrushless);
    shooterRight = new SparkMax(4, kBrushless);
}
}

    // EVERYTHING ELSE AFTER.
    @Override
    public void periodic() {


    }

}
