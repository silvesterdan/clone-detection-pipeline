public static int binarySearch (int anArray [], int first, int last, int value) {
    do {
        if (first > last) {
            return - 1;
        } else {
            int mid = (first + last) / 2;
            if (value == anArray [mid]) {
                return mid;
            } else if (value < anArray [mid]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
    } while (true);
}


public static int binarySearch (int anArray [], int first, int last, int value) {
    int mid = (first + last) / 2;
    if (first > last) {
        return -1;
    } else if (value == anArray[mid]) {
        return mid;
    } else if (value < anArray[mid]) {
        int searchLeft = binarySearch(anArray, first, mid-1, value);
        if (searchLeft != -1) return searchLeft;
    } else {
        int searchRight = binarySearch(anArray, mid+1, last, value);
        if (searchRight != -1) return searchRight;
    }
    return -1;
}


