// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BrasLongueur;

public class DriveBrasLongueur extends CommandBase {
  DoubleSupplier longueur;
  BrasLongueur bras;


  public DriveBrasLongueur(BrasLongueur bras, DoubleSupplier longueur) {
    this.bras = bras;
    this.longueur = longueur;
    addRequirements(bras);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ((bras.getEncoderLongueurPosition() > 70000 && longueur.getAsDouble() > 0) || (bras.getEncoderLongueurPosition() < 0 && longueur.getAsDouble() < 0))
    {
      bras.driveLongueur(0);
    } 
    else
    {
      bras.driveLongueur(longueur.getAsDouble());
    }
  }
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
