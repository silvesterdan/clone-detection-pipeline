public static void print (Object...toPrint) {
    for (Object item : toPrint) {
        if (item.getClass () == int [].class) {
            System.out.println (Arrays.toString ((int []) item));
        } else if (item.getClass () == double [].class) {
            System.out.println (Arrays.toString ((double []) item));
        } else if (item instanceof Object []) {
            System.out.println (Arrays.toString ((Object []) item));
        } else {
            System.out.println (item);
        }
    }
}


public static void print (Object...toPrint) {
    for (Object item : toPrint) {
        if (item.getClass() == int [].class) {
            int[] x = (int[]) item;
            String y = "";
            for (int z : x) {
                y = y + z + " ";
            }
            System.out.println(y);
        } else if (item.getClass() == double [].class) {
            double[] x = (double[]) item;
            String y = "";
            for (double z : x) {
                y = y + z + " ";
            }
            System.out.println(y);
        } else if (item instanceof Object []) {
            Object[] x = (Object[]) item;
            String y = "";
            for (Object z : x) {
                y = y + z + " ";
            }
            System.out.println(y);
        } else {
            System.out.println (item);
        }
    }
}


