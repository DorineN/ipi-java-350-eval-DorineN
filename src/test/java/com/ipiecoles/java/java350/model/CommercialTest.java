package com.ipiecoles.java.java350.model;

import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CommercialTest {

    @Test
    @Parameters(value = {
            //"null,500d",
            "0d, 500d",
            "10000d,5000d",
    })
    public void testPrimeAnnuelleOne(Double caAnnuel, Double expectedPrime)
    {
        //Given : Initialisation des données d'entrée
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(caAnnuel);
        //When :
        double prime= commercial.getPrimeAnnuelle();
        //Then :
        Assertions.assertThat(prime).isEqualTo(expectedPrime);
    }

    @Test
    public void testPrimeAnnuelleWithCANull()
    {
        //Given : Initialisation des données d'entrée
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(null);
        //When :
        double prime= commercial.getPrimeAnnuelle();
        //Then :
        Assertions.assertThat(prime).isEqualTo(500d);
    }

    @Test
    public void testPrimeAnnuelleWithCA0()
    {
        //Given
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(0d);
        //When
        double prime= commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);

    }

    @Test
    public void testPrimeAnnuelleWithCA10000()
    {
        //Given
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(100000d);
        //When
        double prime= commercial.getPrimeAnnuelle();
        //Then
        Assertions.assertThat(prime).isGreaterThanOrEqualTo(5000d);

    }

}