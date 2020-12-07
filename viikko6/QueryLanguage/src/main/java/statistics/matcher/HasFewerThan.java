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
public class HasFewerThan implements Matcher{
    private int value;
    private String field;
    
    public HasFewerThan(int value, String field) {
        this.value = value;
        this.field = field;
    }
    
    @Override
    public boolean matches(Player p) {
        return !(new HasAtLeast(value, field).matches(p));
    }
}
