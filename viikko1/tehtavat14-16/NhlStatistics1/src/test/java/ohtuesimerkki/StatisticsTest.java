/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author aleksi
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void konstruktoritesti(){
        Statistics test = new Statistics(readerStub);
        boolean res1 = false;
        if (test.search("Semenko") != null) {
            res1 = true;
        }
        assertTrue(res1);
    }
    
    @Test
    public void searchToimii() {
        String res = stats.search("Lemieux").getName();
        String exp = "Lemieux";
        assertEquals(exp, res);
    }
    
    @Test
    public void searchPoikkeus() {
        Player res = stats.search("Kalle");
        assertNull(res);
    }
    
    @Test
    public void teamToimii() {
        String res = stats.team("DET").get(0).getName();
        String exp = "Yzerman";
        assertEquals(exp, res);
    }
    
    @Test
    public void topScorersToimii() {
        List<Player> players2 = stats.topScorers(4);
        boolean res = true;
        int score = players2.get(0).getPoints();
        for (int i = 0; i < 4; i++) {
            if (score < players2.get(i).getPoints()) {
                res = false;
            }
            score = players2.get(i).getPoints();
        }
        assertTrue(res);
    }
}
