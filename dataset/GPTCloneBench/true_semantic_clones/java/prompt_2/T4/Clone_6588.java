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
            switch (requestCode) {
                case REQUEST_CAMERA :
                    {
                        if (isPermissionGranted(grantResults)) {
                            showMessage("Permission to use camera granted.");
                            restartActivity();
                        } else {
                            showMessage("The app needs camera permission to function properly.");
                        }
                    } break;
                case REQUEST_CONTACTS :
                    {
                        if (isPermissionGranted(grantResults)) {
                            showMessage("Permission to access contacts granted.");
                            restartActivity();
                        } else {
                            showMessage("The app needs access to contacts to function properly.");
                        }
                    } break;
                case REQUEST_LOCATION :
                    {
                        if (isPermissionGranted(grantResults)) {
                            showMessage("Permission to access location granted.");
                            restartActivity();
                        } else {
                            showMessage("The app needs access to location to function properly.");
                        }
                    } break;
        }
        }

        public boolean isPermissionGranted(int[] grantResults) {
            return grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
        }

        public void showMessage(String message) {
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        public void restartActivity() {
            finish();
            startActivity(getIntent());
}


