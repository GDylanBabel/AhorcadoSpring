package es.neesis.annotations.applications;

import es.neesis.annotations.models.AhorcadoState;
import es.neesis.annotations.services.*;
import org.springframework.stereotype.Component;

@Component
public class AhorcadoApplication {
  private AhorcadoState state;
  private IWordSelectorService wordSelectorService;
  private IUserInterfaceService userInterfaceService;
  private ISolutionService solutionService;

  public AhorcadoApplication(
      IWordSelectorService wordSelectorService,
      IUserInterfaceService userInterfaceService,
      ISolutionService solutionService) {
    this.wordSelectorService = wordSelectorService;
    this.userInterfaceService = userInterfaceService;
    this.solutionService = solutionService;
    this.state = new AhorcadoState();
  }

  public void execute() {
    while (true) {
      userInterfaceService.showMenu();
      if (userInterfaceService.selectOption() == 2) {
        return;
      }
      wordSelectorService.selectRandomWord();
      this.state.setSolucion(wordSelectorService.getWord());
      this.state.setAciertos(wordSelectorService.getHiddenWord());

      // Comienzo del juego
      while (this.state.getIntentos() > 0 && !state.hasWon()) {
        userInterfaceService.showState(this.state);
        String guess = userInterfaceService.userInputLetter();
        state.setHasWon(solutionService.checkSolution(this.state, guess));
      }
      userInterfaceService.showState(this.state);
      userInterfaceService.showEnd(state.hasWon());
      this.state.reload();
    }
  }
}
