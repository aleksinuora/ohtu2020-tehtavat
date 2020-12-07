/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author aleksi
 */
public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new And(new All());
    }
    
    public Matcher build() {
        Matcher returnValue = matcher;
        this.matcher = new And(new All());
        return returnValue;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(matcher, team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matches) {
        this.matcher = new OneOf(matches);
        return this;
    }
}
