public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    CharSequence out = super.filter (source, start, end, dest, dstart, dend);
    if (out != null) {
        source = out;
        start = 0;
        end = out.length ();
    }
    int len = end - start;
    if (len == 0) {
        return source;
    }
    int dlen = dest.length ();
    for (int i = 0;
    i < dstart; i ++) {
        if (dest.charAt (i) == '.') {
            return (dlen - (i + 1) + len > digits) ? "" : new SpannableStringBuilder (source, start, end);
        }
    }
    for (int i = start;
    i < end; ++ i) {
        if (source.charAt (i) == '.') {
            if ((dlen - dend) + (end - (i + 1)) > digits) return "";
            else break;
        }
    }
    return new SpannableStringBuilder (source, start, end);
}


public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) 
{
    CharSequence out = super.filter(source, start, end, dest, dstart, dend);

    if (out != null) {
        source = out;
        start = 0;
        end = out.length();
    }

    int len = end - start;
    if (len == 0) {
        return source;
    }

    int dlen = dest.length();
    
    //Check if source contains a dot
    boolean containsDot = false;
    for (int i = start; i < end; i++) {
        if (source.charAt(i) == '.') {
            containsDot = true;
            break;
        }
    }

    //The source does not have a dot - just return the source
    if (!containsDot) {
        return  new SpannableStringBuilder (source, start, end);
    }

    //The source does have a dot - check if the dot position is valid
    int dotPosition = -1;
    for (int i = start; i < end; i++) {
        if (source.charAt(i) == '.') {
            dotPosition = i;
            break;
        }
    }

    if ((dlen - dend) + (end - (dotPosition + 1)) > digits) {
        return "";
    }
    
    //Don't change source if the dot is at the beginning
    if (start == dotPosition) {
        return source;
    }


    return  new SpannableStringBuilder (source, start, end);
}


