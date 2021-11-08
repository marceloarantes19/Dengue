/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.Random;

/**
 *
 * @author Marcelo
 */
public class rnd {
    private static Random random;
    public rnd(int semente) {
        random=new Random(semente);
    }
    public static Random getRandom() {
        return random;
    }
}
