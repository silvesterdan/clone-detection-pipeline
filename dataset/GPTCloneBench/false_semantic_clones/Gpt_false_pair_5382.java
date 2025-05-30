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
    int lowest = b;
    int highest = a;
    int numof = 100000;
    Random rand = new Random ();
    for (int i = 0;
    i < numof; i ++) {
        int num = (int) ((Math.abs (rand.nextDouble ()) * (b - a))) + a;
        if (num < a || num > b) {
            System.err.println ("number not in range :" + num);
        } else {
            System.out.println (num);
        }
        if (num < lowest) {
            lowest = num;
        }
        if (num > highest) {
            highest = num;
        }
    }
    System.out.println ("Created " + numof + " numbers from " + lowest + " to " + highest);
}
