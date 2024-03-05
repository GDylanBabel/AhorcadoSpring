package es.neesis.annotations.services;

public interface IWordSelectorService {
  public void selectRandomWord();

  public char[] getWord();

  public char[] getHiddenWord();

}
