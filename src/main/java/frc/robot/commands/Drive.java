package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BasePilotable;

public class Drive extends CommandBase{

    BasePilotable basePilotable;
    Double xSupplier;
    Double ySupplier;


    public Drive(BasePilotable basePilotable, Double xSupplier, Double ySupplier){
        this.basePilotable = basePilotable;   
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
    }

    @Override
    public void initialize() {
    }
  
    @Override
    public void execute() {
        basePilotable.drive(xSupplier.doubleValue(),ySupplier.doubleValue());
    }
  
    @Override
    public void end(boolean interrupted) {
    }
}