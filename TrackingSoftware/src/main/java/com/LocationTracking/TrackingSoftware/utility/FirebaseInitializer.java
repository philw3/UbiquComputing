package com.LocationTracking.TrackingSoftware.utility;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.annotation.PostConstruct;

@Service
public class FirebaseInitializer {

    @PostConstruct
    private void initDB() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/ubiqitous-b0fb4-firebase-adminsdk-26k4d-6ef618f5ad.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://ubiqitous-b0fb4-default-rtdb.firebaseio.com")
                .build();

        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);
        }
    }

    public Firestore getFirebase(){
        return FirestoreClient.getFirestore();
    }

}
