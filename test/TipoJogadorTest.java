/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rpg.enums.TipoJogador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class TipoJogadorTest {
    
    public TipoJogadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNextTipoJogadorHuman(){
        assertEquals(TipoJogador.HUMAN, TipoJogador.CPU.next());
    }
    
    @Test
    public void testNextTipoJogadorCpu(){
        assertEquals(TipoJogador.CPU, TipoJogador.HUMAN.next());
    }
    
    @Test
    public void testTipoJogadorToString(){
        assertEquals("Humano", TipoJogador.HUMAN.toString());
    }
}
