package utils;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// https://gist.github.com/JordanTFA/8e6f32bf1a114eed48c762c7fda4d5e8

public class DialogueUTest {

    @Test
    public void repondreQuestion0123() {
        List<Integer> reponses = new ArrayList<Integer>();
        reponses.add(0);
        reponses.add(1);
        reponses.add(2);
        reponses.add(3);

        Dialogue dialogue = mock(Dialogue.class);
        when(dialogue.demandeEntier(System.in)).thenReturn(1);
        assertThat(reponses).contains(dialogue.demandeEntier(System.in));
        when(dialogue.demandeEntier(System.in)).thenReturn(5);
        assertThat(reponses).doesNotContain(dialogue.demandeEntier(System.in));
    }

    @Test
    public void repondreQuestionABCD() {
        List<String> reponses = new ArrayList<String>();
        reponses.add("A");
        reponses.add("B");
        reponses.add("C");
        reponses.add("D");

        Dialogue dialogue = mock(Dialogue.class);
        when(dialogue.demandeChaine(System.in)).thenReturn("B");
        assertThat(reponses).contains(dialogue.demandeChaine(System.in));
        when(dialogue.demandeChaine(System.in)).thenReturn("E");
        assertThat(reponses).doesNotContain(dialogue.demandeChaine(System.in));
    }

}
