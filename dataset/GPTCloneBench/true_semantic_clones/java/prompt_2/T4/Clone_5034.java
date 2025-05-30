public static boolean isBalanced (String str) {
    boolean result = false;
    if (str.length () < 2) return false;
    Stack < Character > stack = new Stack < > ();
    for (int i = 0;
    i < str.length (); i ++) {
        char ch = str.charAt (i);
        if (! parenthesesMapRight.containsKey (ch) && ! parenthesesMapLeft.containsKey (ch)) {
            continue;
        }
        if (parenthesesMapLeft.containsKey (ch)) {
            stack.push (ch);
        } else {
            if (! stack.isEmpty () && stack.pop () == parenthesesMapRight.get (ch).charValue ()) {
                result = true;
            } else {
                return false;
            }
        }
    }
    if (! stack.isEmpty ()) return result = false;
    return result;
}



public static boolean isBalanced (String str) {
    int length = str.length();
    if(length < 2)
        return false;

    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < length; i++){
        char character = str.charAt(i);
        if(parenthesesMapRight.containsKey(character) || parenthesesMapLeft.containsKey(character)){
            if(parenthesesMapLeft.containsKey(character)){
                stack.push(character);
            } else {
                if(!stack.isEmpty() && parenthesesMapRight.get(character).equals(stack.pop())){
                    return true;
                } else
                    return false;
            }
        }
    }
    return stack.isEmpty();
}


