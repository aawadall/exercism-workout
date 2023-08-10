import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class HandshakeCalculator {
    private static final int REVERSE = 1 << 4;
    private Deque<Signal> signals = new ArrayDeque<>();;

    List<Signal> calculateHandshake(int number) {
        signals.clear();
        for(int bit = 0; bit < 4; bit++) {
            if((number & (1 << bit)) != 0) {
                signals.add(Signal.values()[bit]);
            }
        }
        
        // if bit 4 is set, reverse the signals
        if((number & REVERSE) != 0) {
            return reverse();
        }

        // otherwise, return the signals as-is
        return signals.stream().toList();
    }

    /**
     * Reverse the signals
     * @return the reversed signals
     */
    private List<Signal> reverse() {
        var result = new ArrayList<Signal>();
        
        while(!signals.isEmpty()) {
            result.add(signals.removeLast());
        }

        return result;
    }
}
