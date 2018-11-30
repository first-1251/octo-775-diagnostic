package org.team1251.frc.robot;

import org.team1251.frc.robot.robotMap.DeviceAssignment;

/**
 * Used to identify/select a specific motor.
 */
public enum Motor {
    LEFT_LFB(false, DeviceAssignment.DRIVE_LEFT_FRONT_BOTTOM),
    LEFT_LFT(false, DeviceAssignment.DRIVE_LEFT_FRONT_TOP),
    LEFT_LBT(false, DeviceAssignment.DRIVE_LEFT_BACK_TOP),
    LEFT_LBB(false, DeviceAssignment.DRIVE_LEFT_BACK_BOTTOM),
    RIGHT_RFB(false, DeviceAssignment.DRIVE_RIGHT_FRONT_BOTTOM),
    RIGHT_RFT(false, DeviceAssignment.DRIVE_RIGHT_FRONT_TOP),
    RIGHT_RBT(false, DeviceAssignment.DRIVE_RIGHT_BACK_TOP),
    RIGHT_RBB(false, DeviceAssignment.DRIVE_RIGHT_BACK_BOTTOM);

    private final boolean inverted;

    public boolean isInverted() {
        return inverted;
    }

    public DeviceAssignment getDeviceAssignment() {
        return deviceAssignment;
    }

    private final DeviceAssignment deviceAssignment;

    Motor(boolean inverted, DeviceAssignment deviceAssignment) {
        this.inverted = inverted;
        this.deviceAssignment = deviceAssignment;
    }
}
