package com.LocationTracking.TrackingSoftware.controller;
import com.LocationTracking.TrackingSoftware.model.Location;
import com.LocationTracking.TrackingSoftware.utility.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutionException;

@RestController
public class FirebaseController {

    @Autowired
    FirebaseInitializer db;

    @GetMapping("/getLocation/{name}")
    public List<Object> getLocation(@PathVariable("name") String name) throws ExecutionException, InterruptedException {
        List<Object> locationList = new ArrayList<>();
        Map<String, Object> geoPointList;
        DocumentReference documentReference = db.getFirebase().collection("Location").document(name);
        ApiFuture<DocumentSnapshot> querySnapshot = documentReference.get();
        DocumentSnapshot documentSnapshot = querySnapshot.get();
        geoPointList = documentSnapshot.getData();
        Iterator<Map.Entry<String, Object>> it = geoPointList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> pair = it.next();
            locationList.add(pair.getValue());
        }
        return locationList;
    }


}
