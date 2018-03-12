package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by dorine.niel on 12/03/2018.
 */
public class CommercialTest {

    @Test
    public void testPrimeAnnuelleWithCANull() {
        //GIVEN - Initialisation des données
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(null);

        //WHEN - Exécution/test de la méthode
        Double prime = commercial.getPrimeAnnuelle();

        //THEN - Vérification par rapport à la sortie de la méthode
        Assertions.assertThat(prime).isEqualTo(500d);
    }

    @Test
    public void testPrimeAnnuelleIsHigherThan500d() {
        //GIVEN - Initialisation des données
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(10000.50);

        //WHEN - Exécution/test de la méthode
        Double prime = commercial.getPrimeAnnuelle();

        //THEN - Vérification par rapport à la sortie de la méthode
        Assertions.assertThat(prime).isGreaterThan(500d);
    }

    @Test
    public void testPrimeAnnuelleIsBelowThan500d() {
        //GIVEN - Initialisation des données
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(50.50);

        //WHEN - Exécution/test de la méthode
        Double prime = commercial.getPrimeAnnuelle();

        //THEN - Vérification par rapport à la sortie de la méthode
        Assertions.assertThat(prime).isEqualTo(500d);
    }

    @Test
    public void testPrimeAnnuelleIsPositive() {
        //GIVEN - Initialisation des données
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(50.50);

        //WHEN - Exécution/test de la méthode
        Double prime = commercial.getPrimeAnnuelle();

        //THEN - Vérification par rapport à la sortie de la méthode
        Assertions.assertThat(prime).isNotNegative();
    }

}
