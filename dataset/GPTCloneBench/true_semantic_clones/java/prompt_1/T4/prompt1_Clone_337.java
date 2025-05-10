public void onClick (View v) {
    Toast.makeText (
        container.getContext (), 
    "You clicked: " + page + ". page.", 
    Toast.LENGTH_SHORT).show ();
}


public void onClick (View v) {
        Context context = container.getContext();
        String message = "You clicked: " + page + ". page.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
}


