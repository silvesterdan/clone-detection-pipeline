public void sort (int [] input) {
    for (int i = 0;
    i < input.length - 1; i ++) {
        int k = i + 1;
        int nxtVal = input [k];
        while (input [k - 1] > nxtVal) {
            input [k] = input [k - 1];
            k --;
            if (k == 0) break;
        }
        input [k] = nxtVal;
    }
    System.out.println ("Medium sorting is done and the result is :");
    for (int i : input) {
        System.out.print (i + ",");
    }
}





public void sort(int[] arr){
            sort(arr, 0, arr.length-1);
        }
        private void sort(int arr[], int l, int r){
            if (l < r){
                int m = (l+r)/2;
                sort(arr, l, m);
                sort(arr , m+1, r);
                merge(arr, l, m, r);
            }
        }
        private void merge(int arr[], int l, int m, int r){
            int n1 = m - l + 1;
            int n2 = r - m;
            int L[] = new int [n1];
            int R[] = new int [n2];
            for (int i=0; i<n1; ++i)
                L[i] = arr[l + i];
            for (int j=0; j<n2; ++j)
                R[j] = arr[m + 1+ j];
            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2){
                if (L[i] <= R[j]){
                    arr[k] = L[i];
                    i++;
                }
                else{
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
            while (i < n1){
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2){
                arr[k] = R[j];
                j++;
                k++;
            }
}


