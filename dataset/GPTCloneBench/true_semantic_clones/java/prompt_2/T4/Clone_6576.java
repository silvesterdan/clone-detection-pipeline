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



public void onRequestPermissionsResult(int requestCode, String [] permissions, int [] grantResults){
    if(requestCode == mRequestCode){
        int i = 0;
        while(i < grantResults.length){
            if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                mRequestPermissionListener.onFailed();
                return;
            }
            i++;
        }
        mRequestPermissionListener.onSuccess();
    }
}


