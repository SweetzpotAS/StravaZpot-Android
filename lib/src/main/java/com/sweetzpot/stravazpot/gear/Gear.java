package com.sweetzpot.stravazpot.gear;

import com.sweetzpot.stravazpot.Distance;
import com.sweetzpot.stravazpot.ResourceState;

public class Gear {
    private String ID;
    private ResourceState resourceState;
    private boolean primary;
    private String name;
    private Distance distance;
    private String brandName;
    private String modelName;
    private FrameType frameType;
    private String description;

    public String getID() {
        return ID;
    }

    public ResourceState getResourceState() {
        return resourceState;
    }

    public boolean isPrimary() {
        return primary;
    }

    public String getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public FrameType getFrameType() {
        return frameType;
    }

    public String getDescription() {
        return description;
    }
}
