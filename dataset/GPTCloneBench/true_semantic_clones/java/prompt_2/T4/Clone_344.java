public int solution (int X, int [] A) {
    Set < Integer > leaves = new HashSet < > ();
    for (int i = 0;
    i < A.length; i ++) {
        leaves.add (A [i]);
        if (leaves.contains (X) && leaves.size () == X) return i;
    }
    return - 1;
}


 public int solution (int X, int[] A) { 
   int count = 0; 
   boolean found = false; 
   while (!found && count < A.length) { 
      if (A [count] <= X) { 
         found = true; 
         for (int i = 0; i < count; i ++) { 
            if (A [i] == X) return i; 
         } 
      } 
      count ++; 
   } 
   return -1; 
}


