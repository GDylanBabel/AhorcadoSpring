package es.neesis.annotations.services;

import es.neesis.annotations.applications.AhorcadoApplication;
import es.neesis.annotations.applications.AhorcadoState;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserInterfaceService {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";

  public void showMenu() {
    System.out.println("Elige una opción:\n1 - Nuevo juego\n2 - Salir\n");
  }

  public void showState(AhorcadoState state) {
    String aciertos = this.getWordFromArray(state.getAciertos());
    System.out.printf("Estado acutal: %s\nIntentos actuales:%d/8\n", aciertos, state.getIntentos());
  }

  public int selectOption() {
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }

  public String userInputLetter() {
    Scanner sc = new Scanner(System.in);
    return sc.nextLine();
  }

  private String getWordFromArray(char[] chars) {
    StringBuilder sb = new StringBuilder();
    for (char c : chars) {
      sb.append(c);
    }
    return sb.toString();
  }

  public void showEnd(boolean hasWon) {
    if (hasWon) System.out.println(ANSI_GREEN + "Has ganado!" + ANSI_RESET);
    else System.out.println(ANSI_RED + "Has perdido! Vuelve a intentarlo!" + ANSI_RESET);
  }
}
