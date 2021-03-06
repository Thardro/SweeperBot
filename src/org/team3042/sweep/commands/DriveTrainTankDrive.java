/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.sweep.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author NewUser
 */
public class DriveTrainTankDrive extends CommandBase {
    
    //Scale the joystick values to restrict maximum speed
    private final double speedScale = 1.0;
    
    public DriveTrainTankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftPower = -oi.stickLeft.getY() * speedScale;
        double rightPower = -oi.stickRight.getY() * speedScale;
        
        
        if(oi.lTrigger.get()){
            rightPower = leftPower;
        }
        else if (oi.rTrigger.get()){
            leftPower = rightPower;
        }
        
        SmartDashboard.putNumber("Left encoder", driveTrain.getLeftEncoder());
        SmartDashboard.putNumber("Right encoder", driveTrain.getRightEncoder());
        driveTrain.drive(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
