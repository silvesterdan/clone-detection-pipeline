public static int binarySearch (int intToSearch, int [] sortedArray) {
    int lower = 0;
    int upper = sortedArray.length - 1;
    while (lower <= upper) {
        int mid = lower + (upper - lower) / 2;
        if (intToSearch < sortedArray [mid]) upper = mid - 1;
        else if (intToSearch > sortedArray [mid]) lower = mid + 1;
        else return mid;
    }
    return - 1;
}


public static int binarySearch (int intToSearch, int [] sortedArray) {
	int lower, mid, upper;
	lower = 0;
	upper = sortedArray.length - 1;
	
	while (lower <= upper) {
	    mid = lower + (upper - lower) / 2;
	    if (sortedArray[mid] == intToSearch) 
	    	return mid; 
	    else if (sortedArray[mid] < intToSearch) 
	    	lower = mid + 1;	 
	    else 
	    	upper = mid - 1; 	    
	}
	return -1; 
}


