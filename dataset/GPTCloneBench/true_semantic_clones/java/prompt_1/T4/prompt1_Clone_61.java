public void onRequestPermissionsResult (int requestCode,@NonNull
String [] permissions,@NonNull
int [] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    if (requestCode == REQUEST_CODE_CAMERA && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
    } else {
    }
}


public void onRequestPermissionsResult (int requestCode, String [] permissions, int [] grantResults) 
{
    if(requestCode == REQUEST_CODE_CAMERA)
    {
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            
        } else 
        {
            
        }   
    }
    else
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    
}


