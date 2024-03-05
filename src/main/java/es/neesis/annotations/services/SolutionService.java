package es.neesis.annotations.services;

import es.neesis.annotations.applications.AhorcadoApplication;
import es.neesis.annotations.applications.AhorcadoState;
import org.springframework.stereotype.Service;

@Service
public class SolutionService {

  public boolean checkSolution(AhorcadoState state, String guess) {
    String solutionWord = new String(state.getSolucion());
    if (guess.length() == 1) {
      char letter = guess.toLowerCase().toCharArray()[0];
      boolean isLetterInSolution = (solutionWord.toLowerCase().contains(guess.toLowerCase()));
      if (isLetterInSolution) {
        char[] aciertos = state.getAciertos();
        aciertos = this.replaceLetter(aciertos, letter, solutionWord);
        state.setAciertos(aciertos);
      } else {
        state.restarIntentos();
      }
    } else {
      if (solutionWord.equalsIgnoreCase(guess)) {
        state.setAciertos(state.getSolucion());
        return true;
      }
      state.restarIntentos();
    }
    return new String(state.getAciertos()).equalsIgnoreCase(new String(state.getSolucion()));
  }

  private char[] replaceLetter(char[] array, char letter, String solution) {
    char[] solutionArray = solution.toCharArray();
    char[] copyArray = array.clone();
    for (int i = 0; i < solutionArray.length; i++) {
      if (Character.toLowerCase(solutionArray[i]) == letter) {
        copyArray[i] = solutionArray[i];
      }
    }
    return copyArray;
  }
}
