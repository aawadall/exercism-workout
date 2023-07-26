class ReverseString {

    String reverse(String inputString) {
        var outcome = new StringBuilder();
        for (var c : inputString.toCharArray()) {
            outcome.insert(0, c);
        }
        return outcome.toString();
    }
  
}
