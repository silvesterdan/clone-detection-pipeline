private void type (char character) {
    handleSpecialCharacter (character);
    if (Character.isLowerCase (character)) {
        typeCharacter (Character.toUpperCase (character));
    }
    if (Character.isUpperCase (character)) {
        typeShiftCharacter (character);
    }
    if (Character.isDigit (character)) {
        typeCharacter (character);
    }
}


 private void type (char character)  {
    char upperChar = Character.toUpperCase(character);

    if(upperChar == '@' || upperChar == '#' || upperChar == '$' || upperChar == '!'){
        handleSpecialCharacter(character);
    }
    else if(Character.isLowerCase(character)){
        typeCharacter(upperChar);
    }
    else if(Character.isUpperCase(character)){
        typeShiftCharacter(character);
    }
    else if(Character.isDigit(character)){
        typeCharacter(character);
    }
}


