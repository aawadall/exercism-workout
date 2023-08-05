import java.util.List;

class HighScores {
    private List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    /**
     * Returns complete list of scores
     * @return a list of scores
     */
    List<Integer> scores() {
        return this.highScores;
    }

    /**
     * Returns last score recorded
     * @return the last score recorded
     */
    Integer latest() {
        var lastIndex = this.highScores.size() - 1;
        return this.highScores.get(lastIndex);
    }

    /**
     * Returns the highest score
     * @return the highest score
     */
    Integer personalBest() {
        return this.highScores.stream()
            .max(Integer::compare)
            .get();
    }

    /**
     * Returns the top three scores recorded
     * @return a list of top three scores
     */
    List<Integer> personalTopThree() {
        return this.highScores.stream()
            .sorted((a, b) -> b.compareTo(a))
            .limit(3)
            .toList();
    }

}
