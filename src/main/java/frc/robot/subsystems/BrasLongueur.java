// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BrasLongueur extends SubsystemBase {
  private WPI_TalonSRX brasLongueur = new WPI_TalonSRX(18);//Comentaire des bleus: vérifier si 15 ou 16 est le bon
  //private Encoder encoderLongueur = new Encoder(0, 1);
  public BrasLongueur() {
    brasLongueur.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("longueur bras", getEncoderLongueurPosition());
  }

  public void driveLongueur(double vitesse){
      brasLongueur.set(ControlMode.PercentOutput, vitesse);
  }
  public void resetEncoder(){
    //encoderLongueur.reset();
    brasLongueur.setSelectedSensorPosition(0);
  }

  public double getEncoderLongueurPosition(){
    //return encoderLongueur.get();
    return brasLongueur.getSelectedSensorPosition();
  }

  public void stop()
  {
    driveLongueur(0);
  }
}
