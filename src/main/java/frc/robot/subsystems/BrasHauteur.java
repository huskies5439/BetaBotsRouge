// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class BrasHauteur extends SubsystemBase {
  private Encoder encoderHauteur = new Encoder(2, 3);
  private WPI_TalonSRX brasHauteur = new WPI_TalonSRX(17);

  /** Creates a new BrasHauteur. */
  public BrasHauteur() {
    brasHauteur.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("hauteur", getEncoderHauteurPosition());
    

  }
  public void driveHauteur(double vitesse){
    brasHauteur.set(ControlMode.PercentOutput, vitesse);
  }
  public void resetEncoder(){
    encoderHauteur.reset();
  }
  public double getEncoderHauteurPosition(){
    return encoderHauteur.get();
  }

  public void stop()
  {
    driveHauteur(0);
  }
}
