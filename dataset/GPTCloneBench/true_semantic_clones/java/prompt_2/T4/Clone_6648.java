public static void main (String [] args) {
    ArrayList < String > keys = new ArrayList < > (Arrays.asList ("1", "1", "1", "2", "2", "3"));
    ArrayList < String > values = new ArrayList < > (Arrays.asList ("2016-06-22 07:18:45", "2016-06-22 08:18:45", "2016-06-22 09:18:45", "2016-06-22 03:18:45", "2016-06-22 04:18:45", "2016-06-22 01:18:45"));
    HashMap < String, String > map = new HashMap < String, String > ();
    for (int i = 0;
    keys.size () == values.size () && i < keys.size (); i ++) {
        String key = keys.get (i);
        String value = values.get (i);
        if (! map.containsKey (key) || dateAsNo (value) > dateAsNo (map.get (key))) {
            map.put (key, value);
        }
    }
    System.out.println (map);
}




public static void main (String[] args) {
    var keys = List.of("1", "1", "1", "2", "2", "3");
    var values = List.of(
        "2016-06-22 07:18:45", "2016-06-22 08:18:45", "2016-06-22 09:18:45",
        "2016-06-22 03:18:45", "2016-06-22 04:18:45", "2016-06-22 01:18:45"
    );

    var map = IntStream.range(0, keys.size())
        .boxed()
        .collect(
            Collectors.toMap(
                keys::get, 
                values::get, 
                (v1, v2) -> dateAsNo(v1) > dateAsNo(v2) ? v1 : v2));

    System.out.println(map);
}


