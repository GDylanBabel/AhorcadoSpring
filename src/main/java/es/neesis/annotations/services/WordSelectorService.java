package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@Service
public class WordSelectorService implements IWordSelectorService {

  private String[] words;
  private String selectedWord;

  public WordSelectorService() throws IOException {
    words = new String[10];
    int count = 0;
    try (BufferedReader br =
        new BufferedReader(new FileReader("src/main/java/es/neesis/annotations/palabras.txt"))) {
      String line = br.readLine();

      while (line != null) {
        words[count] = line;
        count++;
        line = br.readLine();
      }
    }
  }

  public void selectRandomWord() {
    this.selectedWord = this.words[new Random().nextInt(this.words.length - 1)];
  }

  public char[] getWord() {
    return this.selectedWord.toCharArray();
  }

  public char[] getHiddenWord() {
    char[] hiddenWord = new char[this.selectedWord.length()];
    Arrays.fill(hiddenWord, '_');
    return hiddenWord;
  }
}
