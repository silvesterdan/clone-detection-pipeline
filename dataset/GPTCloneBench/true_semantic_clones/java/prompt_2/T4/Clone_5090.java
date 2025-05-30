public static void main (String [] args) throws Exception {
    AuthMethod auth = new TokenAuthMethod (API_KEY, API_SECRET);
    NexmoClient client = new NexmoClient (auth);
    TextMessage message = new TextMessage (FROM_NUMBER, TO_NUMBER, "Hello from Nexmo!");
    SmsSubmissionResult [] responses = client.getSmsClient ().submitMessage (message);
    for (SmsSubmissionResult response : responses) {
        System.out.println (response);
    }
}





public static void main (String [] args) {
    AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
    NexmoClient client = new NexmoClient(auth);
    TextMessage msg = new TextMessage(FROM_NUMBER, TO_NUMBER, "Nexmo says Hi!");
    Arrays.asList(client.getSmsClient().submitMessage(msg)).forEach(System.out::println);
}


