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
        OracleHelper dbHelper = new OracleHelper (this);
        Statement sql = dbHelper.getWritableStatement ();
        sql.executeUpdate ("insert statement for inserting path to database");
        sql.close ();
        dbHelper.close ();
    }
}
