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
        SQLiteDatabase db = openOrCreateDatabase("MyDB.db", Context.MODE_PRIVATE, null);
        ContentValues values = new ContentValues(); 
        values.put("path", data.getData().toString()); 
        long newRowId = db.insert("table_name", null, values);
        db.close ();
    }
}


