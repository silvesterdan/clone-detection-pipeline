public void onRequestPermissionsResult (int requestCode, String permissions [], int [] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    if (grantResults.length == 0 || grantResults == null) {
    } else if (grantResults [0] == PackageManager.PERMISSION_GRANTED) {
    } else if (grantResults [0] == PackageManager.PERMISSION_DENIED) {
    }
}


public void onRequestPermissionsResult (int requestCode, String permissions [], int [] grantResults) {
    if (grantResults == null || grantResults.length == 0) {
    } else if (!(grantResults [0] == PackageManager.PERMISSION_GRANTED) && !(grantResults [0] == PackageManager.PERMISSION_DENIED)) {
    } else if (grantResults [0] == PackageManager.PERMISSION_GRANTED) {
    } else {
        // Denied
    }
}


