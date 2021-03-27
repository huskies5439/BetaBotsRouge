package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BasePilotable;

public class Drive extends CommandBase{

    BasePilotable basePilotable;
    DoubleSupplier xSupplier;
    DoubleSupplier ySupplier;


    public Drive(DoubleSupplier xSupplier, DoubleSupplier ySupplier, BasePilotable basePilotable){
        this.basePilotable = basePilotable;   
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
        addRequirements(basePilotable);
    }

    @Override
    public void initialize() {
    }
  
    @Override
    public void execute() {
        basePilotable.conduire(xSupplier.getAsDouble(),ySupplier.getAsDouble());
    }
  
    @Override
    public void end(boolean interrupted) {
    }
}