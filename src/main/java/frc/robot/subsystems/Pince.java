// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Pince extends SubsystemBase {

  Servo servo = new Servo(0);

  public Pince() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pince(boolean isOuvert){
    if (isOuvert){
      servo.setAngle(0);
    }
    else{
      servo.setAngle(11);
    }
  }
}
