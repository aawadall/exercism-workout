abstract class Fighter {

    boolean isVulnerable() {
        throw new UnsupportedOperationException("Please provide implementation for this method");
    }

    abstract int damagePoints(Fighter fighter);

    @Override
    public String toString() {
        return "Fighter is a " + fighterType();
    }

    abstract String fighterType();
}

class Warrior extends Fighter {


    // Magic numbers
    private static final int VULNERABLE_DAMAGE = 10;
    private static final int NORMAL_DAMAGE = 6;

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int damagePoints(Fighter wizard) {
        if (wizard.isVulnerable()) {
            return VULNERABLE_DAMAGE;
        } else {
            return NORMAL_DAMAGE;
        }
    }

    @Override
    String fighterType() {
        return "Warrior";
    }
}

class Wizard extends Fighter {

    private Boolean spellPrepared = false;

    // Magic numbers
    private static final int SPELL_DAMAGE = 12;
    private static final int NORMAL_DAMAGE = 3;

    @Override
    boolean isVulnerable() {
        return !spellPrepared;
    }

    @Override
    int damagePoints(Fighter warrior) {
        
        if (spellPrepared) {
            return SPELL_DAMAGE;
        } else {
            return NORMAL_DAMAGE;
        }
    }

    void prepareSpell() {
        this.spellPrepared = true;
    }

    @Override
    String fighterType() {
        return "Wizard";
    }

}
