public boolean equals (Object other) {
    boolean result;
    if ((other == null) || (getClass () != other.getClass ())) {
        result = false;
    } else {
        People otherPeople = (People) other;
        result = name.equals (otherPeople.name) && age == otherPeople.age;
    }
    return result;
}



public boolean equals (Object other) {
    if (other == this) {
        return true;
    }
    if (!(other instanceof People)) {
        return false;
    }
    return name.equals (((People) other).name) && age == ((People) other).age;
}


