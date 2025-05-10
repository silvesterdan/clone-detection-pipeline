public int solution (int N) {
    int result = 0;
    while (N > 0) {
        if ((N & 1) == 1) {
            int temp = 0;
            while ((N>>= 1) > 0 && ((N & 1) != 1)) {
                temp ++;
            }
            result = Math.max (result, temp);
        } else {
            N>>= 1;
        }
    }
    return result;
}


 

public int solution(int N) {
    int result = 0, temp;
    for (; N > 0; N >>= 1) {
        for (temp = 0; N > 0 && (N & 1) == 0; N >>= 1, ++temp);
        result = temp > result ? temp : result;
    }
    return result;
}


