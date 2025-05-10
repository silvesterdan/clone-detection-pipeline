public static void throwException (String className) throws CheckedException, UncheckedException {
    Class < ? > exceptionClass;
    try {
        exceptionClass = Class.forName (className);
    } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException (e);
    }
    try {
        if (CheckedException.class.isAssignableFrom (exceptionClass)) {
            throw exceptionClass.asSubclass (CheckedException.class).newInstance ();
        } else if (UncheckedException.class.isAssignableFrom (exceptionClass)) {
            throw exceptionClass.asSubclass (UncheckedException.class).newInstance ();
        } else {
            throw new IllegalArgumentException ("Not a valid exception type: " + exceptionClass.getName ());
        }
    } catch (InstantiationException | IllegalAccessException e) {
        throw new IllegalStateException (e);
    }
}


public static void throwException (String className) throws Exception {
	  Class<?> exceptionClass;
	  try {
	    exceptionClass = Class.forName(className);
	  }
	  catch (ClassNotFoundException e) {
	    throw new IllegalArgumentException (e);
	  }

	  if (CheckedException.class.isAssignableFrom(exceptionClass)) {
	    try {
	      throw exceptionClass.asSubclass(CheckedException.class).getConstructor().newInstance();
	    }
	    catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
	      throw new IllegalStateException (e);
	    }
	  }
	  else if (UncheckedException.class.isAssignableFrom(exceptionClass)) {
	    try {
	      throw exceptionClass.asSubclass(UncheckedException.class).getConstructor().newInstance();
	    }
	    catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
	      throw new IllegalStateException (e);
	    }
	  }
	  else {
	    throw new IllegalArgumentException ("Not a valid exception type: " + exceptionClass.getName ());
	  }
}


