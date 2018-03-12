package com.ipiecoles.java.java350.service;

import com.ipiecoles.java.java350.model.Commercial;
import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

/**
 * Created by dorine.niel on 12/03/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

    @InjectMocks
    private EmployeService employeService;

    @Mock
    private EmployeRepository employeRepository;

    @Test
    public void testFindByMatriculeFound() {
        //GIVEN
        Commercial commercial = new Commercial();
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(commercial);

        //WHEN
        Employe employe = employeService.findByMatricule("C12345");

        //THEN
        Assertions.assertThat(employe).isEqualTo(commercial);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindByMatriculeFoundWithException() {
        //GIVEN
        Commercial commercial = new Commercial();
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);

        //WHEN
        Employe employe = employeService.findByMatricule("C12345");

        //THEN
    }

    @Test
    public void testFindByMatriculeNotFound() {
        //GIVEN
        Commercial commercial = new Commercial();
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);

        //WHEN
        try{
            Employe employe = employeService.findByMatricule("C12345");
            Assertions.fail("Cela aurait du planter");
        }catch (Exception e) {
            //THEN
            Assertions.assertThat(e).isInstanceOf(EntityNotFoundException.class);
            Assertions.assertThat(e).hasMessage("Impossible de trouver l'employé de matricule C12345");
        }


    }
}
