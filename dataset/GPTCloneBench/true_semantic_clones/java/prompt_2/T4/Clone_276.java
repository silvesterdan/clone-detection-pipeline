public int solution (int X, int [] A) {
    HashSet < Integer > hset = new HashSet < Integer > ();
    for (int i = 0;
    i < A.length; i ++) {
        if (A [i] <= X) hset.add (A [i]);
        if (hset.size () == X) return i;
    }
    return - 1;
}


 public int solution (int X, int [] A) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
	for (int i = 0; i < A.length; i++)
	 {
	  if(A[i] <= X)
	  {
	   if (map.get(A[i]) == null)
	   {
	    map.put(A[i], 1);
	   }
	  if (map.size() == X)
	   return i;
	 }

	 }
	 return -1;
}


