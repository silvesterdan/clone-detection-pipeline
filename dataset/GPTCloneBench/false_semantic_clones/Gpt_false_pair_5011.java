public String toString (Object obj) {
    if (obj == null) return "null";
    if (visited.contains (obj)) return "...";
    visited.add (obj);
    Class cl = obj.getClass ();
    if (cl == String.class) return (String) obj;
    if (cl.isArray ()) {
        String r = cl.getComponentType () + "[]{";
        for (int i = 0;
        i < Array.getLength (obj); i ++) {
            if (i > 0) r += ",";
            Object val = Array.get (obj, i);
            if (cl.getComponentType ().isPrimitive ()) r += val;
            else r += toString (val);
        }
        return r + "}";
    }
    String r = cl.getName ();
    do {
        r += "[";
        Field [] fields = cl.getDeclaredFields ();
        AccessibleObject.setAccessible (fields, true);
        for (Field f : fields) {
            if (! Modifier.isStatic (f.getModifiers ())) {
                if (! r.endsWith ("[")) r += ",";
                r += f.getName () + "=";
                try {
                    Class t = f.getType ();
                    Object val = f.get (obj);
                    if (t.isPrimitive ()) r += val;
                    else r += toString (val);
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }
        r += "]";
        cl = cl.getSuperclass ();
    } while (cl != null);
    return r;
}


public String toString (Object obj) {
    if (obj == null) return "null";
    if (visited.contains (obj)) return "...";
    visited.add (obj);
    Class cl = obj.getClass ();
    if (cl == String.class) return (String) obj;
    if (cl.isArray ()) {
        String r = cl.getComponentType () + "[]{";
        for (int i = 0;
        i < Array.getLength (obj); i ++) {
            if (i > 0) r += ",";
            Object val = Array.get (obj, i);
            if (cl.getComponentType ().isPrimitive ()) r += val;
            else r += toString (val);
        }
        return r + "}";
    }
    String r = cl.getName ();
    do {
        r += "[";
        Field [] fields = cl.getDeclaredFields ();
        for (int i=0; i<fields.length; i++) {	
        	Field f = fields[i]; 
            if (! Modifier.isStatic (f.getModifiers ())) {
                if (! r.endsWith ("[")) r += ",";
                r += f.getName () + "=";
                AccessibleObject.setAccessible (f, true); 
                try {
                    Class t = f.getType ();
                    Object val = f.get (obj);
                    if (t.isPrimitive ()) r += val;
                    else r += toString (val);
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }
        r += "]";
        cl = cl.getSuperclass ();
    } while (cl != null);
    return r;
}
