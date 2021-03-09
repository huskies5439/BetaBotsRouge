package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BasePilotable extends SubsystemBase {

    private CANSparkMax neoAvantGauche = new CANSparkMax(23, MotorType.kBrushless);
    private CANSparkMax neoArriereGauche = new CANSparkMax(22, MotorType.kBrushless);
    private CANSparkMax neoAvantDroit = new CANSparkMax(25, MotorType.kBrushless);
    private CANSparkMax neoArriereDroit = new CANSparkMax(24, MotorType.kBrushless);

    private SpeedControllerGroup gauche = new SpeedControllerGroup(neoAvantGauche, neoArriereGauche);
    private SpeedControllerGroup droit = new SpeedControllerGroup(neoAvantDroit, neoArriereDroit);

    private DifferentialDrive drive = new DifferentialDrive(droit, gauche);

    public BasePilotable() {
        resetEncoder();
    }

    @Override
    public void periodic() {

    }

    public void driver(double joystickX, double joystickY) {
        drive.arcadeDrive(0.5 * joystickX, 0.5 * joystickY);
    }

    private void resetEncoder() {
        neoAvantDroit.getEncoder().setPosition(0);
    }

    public double getEncoderValue() {
        return neoAvantDroit.getEncoder().getPosition();
    }
}
