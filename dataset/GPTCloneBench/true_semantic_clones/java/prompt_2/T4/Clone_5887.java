public static void main (String [] args) {
    List < Integer > initialNumbers = new ArrayList < Integer > ();
    initialNumbers.add (1);
    initialNumbers.add (2);
    Observable < Integer > observableInitial = Observable.from (initialNumbers);
    ReplaySubject < Integer > subject = ReplaySubject.create ();
    Observable < Integer > source = Observable.merge (observableInitial, subject);
    source.subscribe (System.out :: println);
    for (int i = 0;
    i < 100; ++ i) {
        subject.onNext (i);
    }
}





public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<>(List.of(1, 2));
    ReplaySubject<Integer> subject = ReplaySubject.create();
    Observable.merge(Observable.fromIterable(array), subject).subscribe(System.out::println);
    IntStream.range(0, 100).forEach(subject::onNext);
}


