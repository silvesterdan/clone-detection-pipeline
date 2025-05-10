protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    if (requestCode == 0) {
        try {
            Bitmap cameraBitmap;
            cameraBitmap = BitmapFactory.decodeFile (myFilesDir + "/temp.jpg");
            Bitmap.createBitmap (cameraBitmap);
            ivPhoto.setImageBitmap (cameraBitmap);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 0) {
        try {
            Bitmap cameraImage;
            cameraImage = BitmapFactory.decodeFile (myFilesDir + "/temp.jpg");
            Bitmap.createBitmap(cameraImage);
            ivPhoto.setImageBitmap(cameraImage);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
