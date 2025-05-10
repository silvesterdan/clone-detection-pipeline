public static void removeDuplicates (char [] str) {
    int map = 0;
    for (int i = 0;
    i < str.length; i ++) {
        if ((map & (1 << (str [i] - 'a'))) > 0) str [i] = 0;
        else map |= 1 << (str [i] - 'a');
    }
}


public static void removeDuplicates(char[] str) 
{ 
    int bitmap = 0; 
    for (int i = 0; i < str.length; i++) 
    { 
        int x = str[i] - 'a'; 
        if ((bitmap & (1 << x)) > 0) 
            str[i] = 0; 
        else 
            bitmap = bitmap | (1 << x); 
    } 
} 


