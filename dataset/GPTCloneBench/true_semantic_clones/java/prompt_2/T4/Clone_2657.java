static void throwException (final String exClassName) throws CheckedException, UncheckedException {
    Class < ? > clazz;
    try {
        clazz = Class.forName (exClassName);
    } catch (ClassNotFoundException cnfe) {
        throw new InternalError (exClassName, cnfe);
    }
    if (CheckedException.class.isAssignableFrom (clazz)) {
        throw newException (clazz.asSubclass (CheckedException.class));
    } else if (UncheckedException.class.isAssignableFrom (clazz)) {
        throw newException (clazz.asSubclass (UncheckedException.class));
    } else {
        throw new InternalError (exClassName + " is not a valid exception");
    }
}


 

static void throwException(String className) throws CheckedException, UncheckedException{
        try {
        Class clazz = Class.forName(className);
        if (CheckedException.class.isAssignableFrom(clazz) || UncheckedException.class.isAssignableFrom(clazz)){
                throw (Exception) clazz.newInstance();
            }
        } catch (Exception e){
        throw new RuntimeException(e);
        }
}


