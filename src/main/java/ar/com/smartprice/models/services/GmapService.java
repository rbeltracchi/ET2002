package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.GmapsDto;
import ar.com.smartprice.utils.gmaps.Geocoding;
import ar.com.smartprice.utils.gmaps.Route;
import ar.com.smartprice.utils.gmaps.StaticMaps;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class GmapService {

    /**
     * Retorna un GmapsDto con varios datos a partir de dos direcciones
     *
     *
     * @param fromPlace direccion del usuario
     * @param toPlace direccion de destino (comercio)
     * @return GmapsDto
     *
     */
    public GmapsDto mapsData(String fromPlace, String toPlace) {

        if (fromPlace == null || fromPlace.isEmpty()) {
            fromPlace = "pinto 500 ,Tandil";
        } else {
            fromPlace = fromPlace + " Tandil";
        }

        if (toPlace == null || toPlace.isEmpty()) {
            toPlace = "pinto 500 ,Tandil";
        } else {
            toPlace = toPlace + " Tandil";
        }

        GmapsDto gmps = new GmapsDto();

        gmps.setUserLocation(fromPlace);
        gmps.setUserDestination(toPlace);

        this.getDistanceAndTime(fromPlace, toPlace, gmps);

        //this.gmps.setSimpleImage(this.getImageLink(fromPlace, toPlace));
        return gmps;

    }

    /**
     * Agrega al un GmapsDto una URL de Imagen. Genera una URL de Imagen a
     * partir de dos direcciones.
     *
     * @param fromPlace direccion del usuario
     * @param toPlace direccion de destino (comercio)
     * @return URL de imagen de google
     *
     */
    public URL getImageLink(String fromPlace, String toPlace) {
        String URLRoot = "http://maps.googleapis.com/maps/api/staticmap";

        URL url = null;
        //fromPlace = "Pinto 500, Tandil, Buenos Aires, Argentina";
        if (fromPlace.equals("No data") || fromPlace.equals("Tandil, Buenos Aires, Argentina")) {

            fromPlace = "Pinto 500, Tandil, Buenos Aires, Argentina";
        }
        try {

            url = new URL(URLRoot + "?autoscale=1"
                    + "&size=600x300" + "&scale=1"
                    + "&format=png" + "&maptype=roadmap"
                    + "&markers=size:mid%7Ccolor:0x00ffff%7Clabel:0%7C" + URLEncoder.encode(fromPlace, "utf-8")
                    + "&markers=size:mid%7Ccolor:0xff0000%7Clabel:1%7C" + URLEncoder.encode(toPlace, "utf-8")
                    + "&path=color:0x0000ff80|weight:1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GmapService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GmapService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return url;
    }

    /**
     * Agrega al un GmapsDto las distancias.
     *
     * @param fromPlace direccion del usuario
     * @param toPlace direccion de destino (comercio)
     * @return Image image de google
     *
     */
    private void getDistanceAndTime(String fromPlace, String toPlace, GmapsDto gmps) {

        try {

            Route routes = new Route();

            routes.getRoute(fromPlace, toPlace, null, true, Route.mode.driving, Route.avoids.nothing);
            if (!routes.getTotalDistance().isEmpty()) {
                gmps.setDistanceDrive(routes.getTotalDistance().get(0));
                gmps.setTimeDrive(routes.getTotalTime().get(0));
                //System.out.println(routes.getTotalDistance().get(0));
                //System.out.println("Time: " + routes.getTotalTime());
            }

            routes.getRoute(fromPlace, toPlace, null, true, Route.mode.walking, Route.avoids.nothing);
            if (!routes.getTotalDistance().isEmpty()) {
                gmps.setDistanceWalk(routes.getTotalDistance().get(0));
                gmps.setTimeWalk(routes.getTotalTime().get(0));
                //System.out.println(routes.getTotalDistance().get(0));
                //System.out.println("Time: " + routes.getTotalTime());
            }

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GmapService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GmapService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**
     * Devuelve una Imagen de Google Maps.
     *
     * @param url se pasa una url de enlace para generar la imagen
     * @return Image image de google
     *
     */
    public static Image getImage(URL url) {
        StaticMaps image = new StaticMaps();
        return image.getStaticMap(url);
    }



    /**
     * Devuelve un String con una direccion validada por google.
     *
     * @param address requiere una direccion para comprobar.
     * @return String direccion retornada por google. En caso de no encontrar la
     * direccion retornara null.
     *
     */
    public static String validateAddress(String address) {
        
        Geocoding a = new Geocoding();
        String direccionValidada= "Direccion Invalida";
        try {
            
            a.getCoordinates(address+" Tandil, Buenos Aires, Argentina");
            direccionValidada=a.getAddressFound();
            if (direccionValidada.equalsIgnoreCase("no data")|| direccionValidada.equalsIgnoreCase("Tandil, Buenos Aires, Argentina")
                ||!direccionValidada.contains("Tandil, Buenos Aires, Argentina")){
            direccionValidada= "Direccion Invalida";
        }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GmapService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GmapService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return direccionValidada;
                
    }
}
