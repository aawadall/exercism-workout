class AnnalynsInfiltration {
    /**
     * Returns the validity of a fast attack, IFF knight is not aware.
     * @param knightIsAwake whether the knight is awake
     * @return whether a fast attack is valid
     */
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    /**
     * Returns the validity of spying, if at least one party is aware
     * @param knightIsAwake whether the knight is awake
     * @param archerIsAwake whether the archer is awake
     * @param prisonerIsAwake whether the prisoner is awake
     * @return whether spying is valid
     */
    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    /**
     * Returns the validity of a signal, if the prisoner is awake and the archer is not
     * @param archerIsAwake whether the archer is awake
     * @param prisonerIsAwake whether the prisoner is awake
     * @return whether a signal is valid
     */
    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    /**
     * Returns the validity of freeing the prisoner, if:
     * * the prisoner is awake, the archer is not, and the dog is present
     * * or the prisoner is awake, and both kidnappers are asleep
     * @param knightIsAwake whether the knight is awake
     * @param archerIsAwake whether the archer is awake
     * @param prisonerIsAwake whether the prisoner is awake
     * @param petDogIsPresent whether the pet dog is present
     * @return whether freeing the prisoner is valid
     */
    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        return (petDogIsPresent && !archerIsAwake) || // scenario 1
               (prisonerIsAwake && !knightIsAwake && !archerIsAwake); // scenario 2
    }
}
