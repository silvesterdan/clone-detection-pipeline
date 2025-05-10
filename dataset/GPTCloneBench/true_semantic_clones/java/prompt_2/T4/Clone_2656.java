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


 

static void throwException (final String exClassName) throws CheckedException, UncheckedException {
    try {
        if (Class.forName(exClassName).isAssignableFrom(CheckedException.class)) {
            throw (CheckedException)Class.forName(exClassName).newInstance();
        } else if(Class.forName(exClassName).isAssignableFrom(UncheckedException.class)) {
            throw (UncheckedException)Class.forName(exClassName).newInstance();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


