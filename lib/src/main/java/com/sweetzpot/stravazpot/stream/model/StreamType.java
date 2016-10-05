package com.sweetzpot.stravazpot.stream.model;

public enum StreamType {
    TIME("time"),
    LATLNG("latlng"),
    DISTANCE("distance"),
    ALTITUDE("altitude"),
    VELOCITY_SMOOTH("velocity_smooth"),
    HEART_RATE("heartrate"),
    CADENCE("cadence"),
    WATTS("watts"),
    TEMPERATURE("temp"),
    MOVING("moving"),
    GRADE_SMOOTH("grade_smooth");

    private String rawValue;

    StreamType(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return rawValue;
    }

    public static String getQueryString(StreamType[] types) {
        if(types != null){
            String result = "";

            for(int i = 0; i < types.length; i++) {
                if(i > 0) {
                    result += ",";
                }
                result += types[i].toString();
            }

            return result;
        }

        return null;
    }
}
