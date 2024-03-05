package es.neesis.annotations.services;

import es.neesis.annotations.models.AhorcadoState;

public interface ISolutionService {

  public boolean checkSolution(AhorcadoState state, String guess);
}
