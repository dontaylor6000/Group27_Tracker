package tracker.db;

import android.annotation.TargetApi;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class API {

    private static final String TAG = "Database API";
    private DatabaseReference alerts;
    private DatabaseReference allowedLocation;
    private DatabaseReference network;
    private DatabaseReference patient;
    private DatabaseReference trackers;

    public API() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        this.alerts = db.getReference("Alerts");
        this.alerts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        this.allowedLocation = db.getReference("AllowedLocation");
        this.allowedLocation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference mappingToAllowed = db.getReference("MappingToAllowed");
        mappingToAllowed.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        this.network = db.getReference("Network");
        this.network.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        this.patient = db.getReference("Patient");
        this.patient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        this.trackers = db.getReference("Trackers");
        this.trackers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @TargetApi(28)
    public static String encrypt(String str) {

        byte[] encrypted;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //Need to solve compatibility problem with KITKAT
        }

        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec key = new SecretKeySpec(bytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec("SecretBytes".getBytes(StandardCharsets.UTF_8));
            Cipher crypto = Cipher.getInstance("AES/GCM/NoPadding");
            crypto.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            encrypted = crypto.doFinal(bytes);

        } catch (Exception ex) {
            ex.printStackTrace();
            encrypted = new byte[0];
        }
        return new String(encrypted, StandardCharsets.UTF_8);
    }

    public void addToDb(String cls, Object... args) {
        switch (cls) {
            case "Alerts":
                Alerts alert = new Alerts((int) args[0], (Date) args[1]);
                this.alerts.push().setValue(alert);
                break;
            case "AllowedLocation":
                AllowedLocation allowedLocation = new AllowedLocation((String) args[0]);
                this.allowedLocation.push().setValue(allowedLocation);
                break;

            case "Network":
                Network network = new Network((String) args[0], (String) args[1]);
                this.network.push().setValue(network);
                break;
            case "Patient":
                Patient patient = new Patient((String) args[0], (String) args[1], (int) args[2]);
                this.patient.push().setValue(patient);
                break;
            case "Trackers":
                Trackers tracker = new Trackers((String) args[0], (String) args[1], (String) args[2], (String) args[3], (String) args[4]);
                this.trackers.push().setValue(tracker);
                break;
            default:
                break;
        }
    }

    public void updateDb(String cls, String id, String field, Object value) {
        switch (cls) {
            case "Alerts":
                this.alerts.child(id).child(field).setValue(value);
                break;
            case "AllowedLocation":
                this.allowedLocation.child(id).child(field).setValue(value);
                break;
            case "Network":
                this.network.child(id).child(field).setValue(value);
                break;
            case "Patient":
                this.patient.child(id).child(field).setValue(value);
                break;
            case "Trackers":
                this.trackers.child(id).child(field).setValue(value);
                break;
            default:
                break;
        }
    }

    public void removeFromDb(String cls, String id) {
        switch (cls) {
            case "Alerts":
                this.alerts.child(id).removeValue();
                break;
            case "AllowedLocation":
                this.allowedLocation.child(id).removeValue();
                break;
            case "Network":
                this.network.child(id).removeValue();
                break;
            case "Patient":
                this.patient.child(id).removeValue();
                break;
            case "Trackers":
                this.trackers.child(id).removeValue();
                break;
            default:
                break;
        }
    }
}
