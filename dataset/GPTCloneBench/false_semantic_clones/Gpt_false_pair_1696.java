public static void main (String [] args) {
    int a = 100;
    int b = 1000;
    int lowest = b;
    int highest = a;
    int count = 100000;
    Random random = new Random ();
    for (int i = 0;
    i < count; i ++) {
        int nextNumber = (int) ((Math.abs (random.nextDouble ()) * (b - a))) + a;
        if (nextNumber < a || nextNumber > b) {
            System.err.println ("number not in range :" + nextNumber);
        } else {
            System.out.println (nextNumber);
        }
        if (nextNumber < lowest) {
            lowest = nextNumber;
        }
        if (nextNumber > highest) {
            highest = nextNumber;
        }
    }
    System.out.println ("Produced " + count + " numbers from " + lowest + " to " + highest);
}


 public static void main (String [] args) {
    int a = 100;
    int b = 1000;
    int low = b;
    int high = a;
    int count = 100000;
    Random random = new Random ();
    while (count > 0) {
        int nextNum = (int) ((Math.abs (random.nextDouble ()) * (b - a))) + a;
        if (nextNum < a || nextNum > b) {
            System.err.println ("number not in range :" + nextNum);
        } else {
            System.out.println (nextNum);
        }
        if (nextNum < low) {
            low = nextNum;
        }
        if (nextNum > high) {
            high = nextNum;
        }
        count--;
    }
    System.out.println ("Created " + (100000 - count) + " numbers in the range of " + low + " to " + high);
}
