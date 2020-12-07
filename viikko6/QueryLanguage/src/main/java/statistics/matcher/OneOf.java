package statistics.matcher;

import statistics.Player;

public class OneOf implements Matcher {

    private Matcher[] matchers;

    public OneOf(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                return true;
            }
        }

        return false;
    }
}
