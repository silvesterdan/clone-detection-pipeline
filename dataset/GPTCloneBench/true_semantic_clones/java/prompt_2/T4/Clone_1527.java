public ResponseEntity < ? > match (@PathVariable
String matchId,@RequestBody
String body, HttpServletRequest request, HttpServletResponse response) {
    Product p;
    try {
        p = service.getProduct (request.getProductId ());
    } catch (Exception ex) {
        return new ResponseEntity < String > (HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity (p, HttpStatus.OK);
}


 public ResponseEntity match(@PathVariable String matchId,@RequestBody String body, HttpServletRequest request, HttpServletResponse response) {
        try {
            Optional<Product> p =  service.getProduct(request.getProductId());
            if(p.isPresent())
                    return new ResponseEntity < Product >(p.get(), HttpStatus.OK);
             else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
}


