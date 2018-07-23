
package ar.com.smartprice.dtos;

import java.net.URL;

/**
 *
 * @author Andres
 */
public class GmapsDto {
    
    private String userLocation;
    private String userDestination;
    private int distanceToWalk;
    private int distanceToDrive;
    private int timeWalk;
    private int timeDrive;
    
    private URL urlSimpleImage;
    

    public GmapsDto() {
    }

    public GmapsDto(String userLocation, String userDestination, int distanceWalk, int distanceDrive, int timeWalk, int timeDrive, URL simpleImage) {
        this.userLocation = userLocation;
        this.userDestination = userDestination;
        this.distanceToWalk = distanceWalk;
        this.distanceToDrive = distanceDrive;
        this.timeWalk = timeWalk;
        this.timeDrive = timeDrive;
        this.urlSimpleImage = simpleImage;
       
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserDestination() {
        return userDestination;
    }

    public void setUserDestination(String userDestination) {
        this.userDestination = userDestination;
    }

    public int getDistanceWalk() {
        return distanceToWalk;
    }

    public void setDistanceWalk(int distanceWalk) {
        this.distanceToWalk = distanceWalk;
    }

    public int getDistanceDrive() {
        return distanceToDrive;
    }

    public void setDistanceDrive(int distanceDrive) {
        this.distanceToDrive = distanceDrive;
    }

    public int getTimeWalk() {
        return timeWalk;
    }

    public void setTimeWalk(int timeWalk) {
        this.timeWalk = timeWalk;
    }

    public int getTimeDrive() {
        return timeDrive;
    }

    public void setTimeDrive(int timeDrive) {
        this.timeDrive = timeDrive;
    }

    public URL getSimpleImage() {
        return urlSimpleImage;
    }

    public void setSimpleImage(URL simpleImage) {
        this.urlSimpleImage = simpleImage;
    }

    @Override
    public String toString() {
        return "GmapsDto{" + "userLocation=" + userLocation + ", userDestination=" + userDestination + ", distanceToWalk=" + distanceToWalk + ", distanceToDrive=" + distanceToDrive + ", timeWalk=" + timeWalk + ", timeDrive=" + timeDrive + ", urlSimpleImage=" + urlSimpleImage + '}';
    }

   

   
    
    
}
