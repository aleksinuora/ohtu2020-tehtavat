/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;
/**
 *
 * @author aleksi
 */
public class Or implements Matcher{
    Matcher[] matches;
    
    public Or(Matcher... matches) {
        this.matches = matches;
    }
    
    @Override
    public boolean matches(Player p) {
        for(Matcher m: matches) {
            if (m.matches(p)) {
                return true;
            }
        }
        return false;
    }
}
