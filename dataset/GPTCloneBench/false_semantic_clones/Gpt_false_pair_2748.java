public static void main (String [] args) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Object obj = new Object ();
    Class < Object > objClass = Object.class;
    String s;
    long start = System.nanoTime ();
    s = obj.toString ();
    long directInvokeEnd = System.nanoTime ();
    System.out.println (s);
    long methodLookupStart = System.nanoTime ();
    java.lang.reflect.Method method = objClass.getMethod ("toString");
    long methodLookupEnd = System.nanoTime ();
    s = (String) (method.invoke (obj));
    long reflectInvokeEnd = System.nanoTime ();
    System.out.println (s);
    System.out.println (directInvokeEnd - start);
    System.out.println (methodLookupEnd - methodLookupStart);
    System.out.println (reflectInvokeEnd - methodLookupEnd);
}


 public static void main (String [] args) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Object obj4 = new Object ();
    Class < Object > objClass = Object.class;
    String s;
    long start = System.nanoTime ();
    s = obj4.toString ();
    long directInvokeEnd = System.nanoTime ();
    System.out.println (s);
    long methodLookupStart = System.nanoTime ();
    java.lang.reflect.Method objMethodName = objClass.getMethod ("toString", new Class[]{});
    long methodLookupEnd = System.nanoTime ();
    s = (String) (objMethodName.invoke (obj4));
    long reflectInvokeEnd = System.nanoTime ();
    System.out.println (s);
    System.out.println (directInvokeEnd - start);
    System.out.println (methodLookupEnd - methodLookupStart);
    System.out.println (reflectInvokeEnd - methodLookupEnd);
}
