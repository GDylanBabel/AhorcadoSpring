package es.neesis.annotations.applications;

import es.neesis.annotations.services.SolutionService;
import es.neesis.annotations.services.UserInterfaceService;
import es.neesis.annotations.services.WordSelectorService;
import org.springframework.stereotype.Component;

@Component
public class AhorcadoApplication {
  private AhorcadoState state;
  private WordSelectorService wordSelectorService;
  private UserInterfaceService userInterfaceService;
  private SolutionService solutionService;

  public AhorcadoApplication(
      WordSelectorService wordSelectorService,
      UserInterfaceService userInterfaceService,
      SolutionService solutionService) {
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
