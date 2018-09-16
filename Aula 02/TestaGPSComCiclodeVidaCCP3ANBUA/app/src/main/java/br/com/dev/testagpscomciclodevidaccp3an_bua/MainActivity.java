package br.com.dev.testagpscomciclodevidaccp3an_bua;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_PERMISSION_GPS = 1001;
    private LocationManager locationManager;
    private LocationListener locationListener =
            //Classe interna anônima
            new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double lat = location.getLatitude();
                    double longi = location.getLongitude();
                    locationTextView.setText(String.format("Lat: %f, Long: %f", lat, longi));
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            };

    private TextView locationTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationTextView = (TextView) findViewById(R.id.locationTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, new String[]
                                                 { Manifest.permission.ACCESS_FINE_LOCATION }, REQUEST_PERMISSION_GPS);
        }
        else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0, locationListener);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if(requestCode == REQUEST_PERMISSION_GPS){
            if(grantResults.length >= 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                if(ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,
                                                            locationListener);
                }
            }
            else{
                Toast.makeText(this, getString(R.string.lamento), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
    }
}