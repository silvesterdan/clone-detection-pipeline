public void onClick (View v) {
    Toast.makeText (
        container.getContext (), 
    "You clicked: " + page + ". page.", 
    Toast.LENGTH_SHORT).show ();
}


public void onClick (View v) {
        String message = String.format("You clicked: %s. page.", page);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(container.getContext(), message, duration);
        toast.show();
}


