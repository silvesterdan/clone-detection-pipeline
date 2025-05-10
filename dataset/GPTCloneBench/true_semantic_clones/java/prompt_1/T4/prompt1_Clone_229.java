private static void removeEven (int [] k, int n) {
    int counter = 0;
    for (int i = 0;
    i < n; i ++) if (k [i] % 2 == 1) k [counter ++] = k [i];
    for (int i = counter;
    i < n; i ++) k [i] = 0;
}


private static void removeEven (int [] k, int n) {
    int last_odd = -1;
    for (int i = 0; i < n; i++) {
    	if (k[i] % 2 == 1) {
        	if (last_odd + 1 < i) {
            	k[last_odd + 1] = k[i];
            }
            last_odd++;
        }
    }
    for (int i = last_odd + 1; i < n; i++)
        k[i] = 0;
}


