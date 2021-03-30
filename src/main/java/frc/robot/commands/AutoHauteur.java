// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BrasHauteur;

public class AutoHauteur extends CommandBase {
  
  BrasHauteur brasHauteur;
  int cible;
  int marge;
  boolean stop;

  public AutoHauteur(int cible, BrasHauteur brasHauteur) {
    
    this.cible = cible;
    this.brasHauteur = brasHauteur;
    marge = 10;
    stop = false;
    addRequirements(brasHauteur);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (brasHauteur.getEncoderHauteurPosition() > cible + marge){
      brasHauteur.driveHauteur(-1);
    }
    else if (brasHauteur.getEncoderHauteurPosition() < cible - marge){
      brasHauteur.driveHauteur(1);
    }
    else 
    {
      brasHauteur.stop();
      stop = true;
    }
  }

  
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stop;
  }
}