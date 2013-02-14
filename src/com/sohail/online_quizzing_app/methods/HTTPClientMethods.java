/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.methods;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author sohail.alam
 */
public class HTTPClientMethods {
    
    private static HTTPClientMethods instance;
    
    public static HTTPClientMethods getInstance(){
        if (instance == null) {
            return instance = new HTTPClientMethods();
        } else {
            return instance;
        }
    }
    
    private HTTPClientMethods(){
        
    }
    
    public URI buildURI(String host, String path, HashMap<String, String> query){
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http").setHost(host).setPath(path);
        Set<Map.Entry<String, String>> map = query.entrySet();
        for (Map.Entry<String, String> entry : map) {
            builder.setParameter(entry.getKey(), entry.getValue());
        }
        URI uri = null;
        try {
            uri = builder.build();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        return uri;
    }
    
    public void doGet(URI url){
        
    }
}
