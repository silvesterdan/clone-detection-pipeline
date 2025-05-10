public boolean equals (Object obj) {
    if (obj == null) {
        return false;
    }
    if (! Person.class.isAssignableFrom (obj.getClass ())) {
        return false;
    }
    final Person other = (Person) obj;
    if ((this.name == null) ? (other.name != null) : ! this.name.equals (other.name)) {
        return false;
    }
    if (this.age != other.age) {
        return false;
    }
    return true;
}


public boolean equals (Object obj) {
    if (obj == null || ! Person.class.isAssignableFrom (obj.getClass ()) || this.name != null || other.name == null) {
        return false;
    }
    final Person other = (Person) obj;
    if (! this.name.equals (other.name) || this.age != other.age) {
        return false;
    }
    return true;
}


