public void onRequestPermissionsResult (int requestCode, String [] permissions, int [] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    switch (requestCode) {
        case REQUEST_READ_PHONE_STATE :
            {
                if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText (LoginActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show ();
                    finish ();
                    startActivity (getIntent ());
                } else {
                    Toast.makeText (LoginActivity.this, "The app was not allowed to get your phone state. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show ();
                }
            } case REQUEST_ACCESS_FINE_LOCATION :
            {
                if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText (LoginActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show ();
                    finish ();
                    startActivity (getIntent ());
                } else {
                    Toast.makeText (LoginActivity.this, "The app was not allowed to get your location. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show ();
                }
            } case REQUEST_WRITE_STORAGE :
            {
                if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText (LoginActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show ();
                    finish ();
                    startActivity (getIntent ());
                } else {
                    Toast.makeText (LoginActivity.this, "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show ();
                }
            }}
}


public void onRequestPermissionsResult (int requestCode, String [] permissions, int [] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    
    boolean permissionGranted = false;
    String permissionName = "";
    String errorMessage = ""; 

    switch (requestCode) {
        case REQUEST_READ_PHONE_STATE : 
            permissionGranted = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
            permissionName = "phone state";
            errorMessage = "The app was not allowed to get your phone state. Hence, it cannot function properly. Please consider granting it this permission";
            break;
        case REQUEST_ACCESS_FINE_LOCATION : 
            permissionGranted = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
            permissionName = "location";
            errorMessage = "The app was not allowed to get your location. Hence, it cannot function properly. Please consider granting it this permission"; 
            break; 
        case REQUEST_WRITE_STORAGE : 
            permissionGranted = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
            permissionName = "write to storage";
            errorMessage = "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission"; 
            break; 
    }

    if (permissionGranted) {
        showToast("Permission granted.");
        finish();
        startActivity(getIntent());
    }
    else {
        showToast(String.format("The app was not allowed to get your %s. Hence, it cannot function properly. Please consider granting it this permission", permissionName));
    }
}


