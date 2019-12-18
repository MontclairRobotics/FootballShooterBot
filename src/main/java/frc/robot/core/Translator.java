package frc.robot.core;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class Translator {

    //OBJECTS//
    public Map<String, Double> extractedData;
    private Collection<String> wantedData;
    private NetworkTable privateTableInstance;

    private String tablePath;

    //INIT//
    public void init(boolean debug) {

        tablePath = "PLACEHOLDER";

        extractedData = new Map<String, Double>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object o) {
                return false;
            }

            @Override
            public boolean containsValue(Object o) {
                return false;
            }

            @Override
            public Double get(Object o) {
                return null;
            }

            @Override
            public Double put(String s, Double aDouble) {
                return null;
            }

            @Override
            public Double remove(Object o) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends Double> map) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Double> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Double>> entrySet() {
                return null;
            }
        };

        for( String key: wantedData ) {

            extractedData.put(key, null);

        }

        if( debug ) { SmartDashboard.putBoolean("Translator Initiation", true); }

    }

    //GETTERS-SETTERS//
    public void setWantedData(Collection<String> wantedData) {

        this.wantedData = wantedData;
        init(false);

    }

    public Collection<String> getWantedData() { return wantedData; }

    //PERIODIC//

    public void periodicMovementless(boolean debug) {

        NetworkTable networkTable = NetworkTableInstance.getDefault().getTable(tablePath);

        for( String key: networkTable.getKeys() ) {

            if( wantedData.contains(key) ) {

                extractedData.replace(key, (Double)networkTable.getEntry(key).getValue().getValue() );

            }

        }

        privateTableInstance = networkTable;

    }

    public void periodic(boolean debug, double distanceFactor, int imageSize) {

        periodicMovementless(debug);

        extractedData.put( "xMovement", xMovement( 0, distanceFactor, imageSize ) );
        extractedData.put( "thetaMovement", angleMovement(0, distanceFactor, imageSize ) );

    }

    //GET MOVEMENT DATA//
    private double xMovement( int pixel, double distanceFactor, int imageSize ) {

        return 0;

    }

    private double angleMovement( int pixel, double distanceFactor, int imageSize ) {

        return 0;

    }

}
