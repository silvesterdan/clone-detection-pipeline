public int loneSum (int a, int b, int c) {
    int sum = 0;
    boolean ab = a != b;
    boolean ac = a != c;
    boolean bc = b != c;
    if (ab && ac) sum += a;
    if (ab && bc) sum += b;
    if (bc && ac) sum += c;
    return sum;
}


 

public int loneSum (int a, int b, int c) {
    return a == b && b == c ? 0 : 
           a == b ? c: 
           a == c ? b: 
           b == c ? a: a+b+c;
}


