protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    if (requestCode == IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
        DBHelper dbHelper = new DBHelper (this);
        SQLiteDatabase sql = dbHelper.getWritableDatabase ();
        sql.execSQL ("insert statement for inserting path to database");
        sql.close ();
        dbHelper.close ();
    }
}


protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    if (requestCode == IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
        SQLiteDatabase sql = null;
        try {
            DBHelper dbHelper = new DBHelper (this);
            sql = dbHelper.getWritableDatabase ();
            sql.execSQL ("insert statement for inserting path to database");
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        } finally {
            if (sql != null)
                sql.close ();
            dbHelper.close ();
        }
    }
}


