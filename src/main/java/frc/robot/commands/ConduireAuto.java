// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BasePilotable;

public class ConduireAuto extends CommandBase {
  
  BasePilotable basePilotable;
  DoubleSupplier ySupplier;

  public ConduireAuto(DoubleSupplier ySupplier, BasePilotable basePilotable) {
    this.basePilotable = basePilotable;
    this.ySupplier = ySupplier;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    basePilotable.conduireAuto(ySupplier.getAsDouble());
    //TODO ultrason
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return basePilotable.getUlrtasonicRange() < 100;
  }
}
