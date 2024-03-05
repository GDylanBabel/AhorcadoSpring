package es.neesis.annotations.models;

public class AhorcadoState {
  private char[] solucion;
  private char[] aciertos;
  private int intentos;
  private boolean hasWon;

  public AhorcadoState() {
    this.intentos = 8;
    this.hasWon = false;
  }

  public char[] getSolucion() {
    return solucion;
  }

  public void setSolucion(char[] solucion) {
    this.solucion = solucion;
  }

  public char[] getAciertos() {
    return aciertos;
  }

  public void setAciertos(char[] aciertos) {
    this.aciertos = aciertos;
  }

  public int getIntentos() {
    return intentos;
  }

  public void setIntentos(int intentos) {
    this.intentos = intentos;
  }

  public boolean hasWon() {
    return hasWon;
  }

  public void setHasWon(boolean hasWon) {
    this.hasWon = hasWon;
  }

  public void reload() {
    this.intentos = 8;
    this.hasWon = false;
  }

  public void restarIntentos() {
    this.intentos--;
  }
}
