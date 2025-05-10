public void onRequestPermissionsResult (int requestCode,@NonNull
String [] permissions,@NonNull
int [] grantResults) {
    if (requestCode == mRequestCode) {
        if (grantResults.length > 0) {
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    mRequestPermissionListener.onFailed ();
                    return;
                }
            }
            mRequestPermissionListener.onSuccess ();
        } else {
            mRequestPermissionListener.onFailed ();
        }
    }
}


public void onRequestPermissionsResult(int reqCode, String[] perm, 
    int[] grantResults) {
    if (reqCode == mRequestCode) {
        if (grantResults.length == 0) {
            mRequestPermissionListener.onFailed();
            return;
        }
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                mRequestPermissionListener.onFailed();
                return;
            }
        }
        mRequestPermissionListener.onSuccess();
    }
}


