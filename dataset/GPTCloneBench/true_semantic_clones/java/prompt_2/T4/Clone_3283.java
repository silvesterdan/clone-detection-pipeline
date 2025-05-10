public int solution (int X, int [] A) {
    Set < Integer > leaves = new HashSet < > ();
    for (int i = 0;
    i < A.length; i ++) {
        leaves.add (A [i]);
        if (leaves.contains (X) && leaves.size () == X) return i;
    }
    return - 1;
}



public int solution (int X, int [] A){
    Set < Integer > leaves = new TreeSet<>();
    for(var i = 0; i < A.length; i++ ){
        if(leaves.add (A[i]) && leaves.size() == X && A[i] == X) return i;
    } 
    return -1;
}


