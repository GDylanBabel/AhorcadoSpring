package es.neesis.annotations.services;

import es.neesis.annotations.models.AhorcadoState;

public interface IUserInterfaceService {

  public void showMenu();

  public void showState(AhorcadoState state);

  public int selectOption();

  public String userInputLetter();

  public void showEnd(boolean hasWon);
}
