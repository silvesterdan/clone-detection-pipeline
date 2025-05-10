private int sum (@NotNull
Index mainIndex,@NotNull
Index secondaryIndex) {
    int localSum = 0;
    while (mainIndex.index < array.length && secondaryIndex.sign.test (array [mainIndex.index])) {
        mainIndex.index ++;
    }
    if (mainIndex.index < array.length) {
        localSum += array [mainIndex.index ++];
    } else {
        for (; secondaryIndex.index < array.length; secondaryIndex.index ++) {
            if (secondaryIndex.sign.test (array [secondaryIndex.index])) {
                localSum += array [secondaryIndex.index];
            }
        }
    }
    return localSum;
}


  private int sum (Index mainIndex, Index secondaryIndex) {  
    int localSum = 0; 
    boolean found = false;
    for (int i = mainIndex.index; i < array.length; i++) { 
        if (secondaryIndex.sign.test (array [i])) {
            mainIndex.index ++; 
        }
        else {
            found = true;
            localSum += array [mainIndex.index ++];  
            break; 
        }
    }
    if (!found) {
        for (; secondaryIndex.index < array.length; secondaryIndex.index++) { 
            if (secondaryIndex.sign.test (array [secondaryIndex.index])) {
                localSum += array [secondaryIndex.index]; 
            } 
        }
    }
    return localSum; 
}


