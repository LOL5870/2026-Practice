package frc.robot.subsystems;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase{
    VictorSP hopperL;
    VictorSP hopperR;

    

    public Hopper() {
        hopperL = new VictorSP(Constants.HopperConstants.HOPPER_LEFT);
        hopperR = new VictorSP(Constants.HopperConstants.HOPPER_RIGHT);
    }

    public Command extendHopper(){
        SmartDashboard.putBoolean("HOPPER", true); 
        return null;
    }

    public Command detractHopper(){
        SmartDashboard.putBoolean("HOPPER", true);
        return null;
    }
    public Command stopHopper(){
        SmartDashboard.putBoolean("HOPPER", false); 
        return null;
    }

    public Command testExtend(Supplier<Double> speed){
        return null;
    }

    public Command testDetract(Supplier<Double> speed){
        return null;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("HopperSpeed", hopperL.get());
    }
}
