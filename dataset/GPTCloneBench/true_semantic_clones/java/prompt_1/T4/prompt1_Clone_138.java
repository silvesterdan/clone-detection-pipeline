public boolean isBalanced (String strExpression) {
    Map < Character, Character > bracketPair = new HashMap < Character, Character > ();
    bracketPair.put ('(', ')');
    bracketPair.put ('[', ']');
    bracketPair.put ('{', '}');
    Stack < Character > stk = new Stack < Character > ();
    for (int i = 0;
    i < strExpression.length (); i ++) {
        if (bracketPair.containsKey (strExpression.charAt (i))) stk.push (strExpression.charAt (i));
        else if (bracketPair.containsValue (strExpression.charAt (i))) if (stk.isEmpty () || bracketPair.get (stk.pop ()) != strExpression.charAt (i)) return false;
    }
    if (stk.isEmpty ()) return true;
    else return false;
}


public boolean isBalanced4 (String strExpression) {
    Stack<Character> stk = new Stack<Character>();
    for (int i = 0;
    i < strExpression.length(); i++) {
        if (strExpression.charAt(i) == '(' || strExpression.charAt(i) == '{' || strExpression.charAt(i) == '[') 
            stk.push(strExpression.charAt(i));
        else {
            if (stk.isEmpty()) 
                return false;
            if (strExpression.charAt(i) == ')'){
                char openingBracket = stk.pop();
                if (openingBracket != '(') 
                    return false;
            }
            else if (strExpression.charAt(i) == '}'){
                char openingBracket = stk.pop();
                if (openingBracket != '{') 
                    return false;
            } 
            else if (strExpression.charAt(i) == ']'){
                char openingBracket = stk.pop();
                if (openingBracket != '[') 
                    return false;
            }
        }
    }

    if (stk.isEmpty()) 
        return true;
    else 
        return false;
}


