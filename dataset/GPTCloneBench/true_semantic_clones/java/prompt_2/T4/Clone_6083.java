public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    int dotPos = - 1;
    int len = dest.length ();
    for (int i = 0;
    i < len; i ++) {
        char c = dest.charAt (i);
        if (c == '.' || c == ',') {
            dotPos = i;
            break;
        }
    }
    if (dotPos >= 0) {
        if (source.equals (".") || source.equals (",")) {
            return "";
        }
        if (dend <= dotPos) {
            return null;
        }
        if (len - dotPos > decimalDigits) {
            return "";
        }
    }
    return null;
}


  
public CharSequence filter(CharSequence seq, int s, int e, Spanned d, int ds, int de) {
    int dot=-1, l=d.length();
    for(int i=0;i<l;i++){
        char c=d.charAt(i);
        if(c=='.'||c==','){dot=i;break;}
    }
    if(dot>=0){
       if(seq.equals(".")||seq.equals(",")) return "";
       if(de<=dot) return null;
       if(l-dot>decimalDigits) return "";
    }
    return null;
}


