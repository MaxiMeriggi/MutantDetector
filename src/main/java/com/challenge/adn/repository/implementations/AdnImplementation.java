package com.challenge.adn.repository.implementations;

import com.challenge.adn.core.interfaces.Adn;
import org.springframework.stereotype.Service;

@Service
public class AdnImplementation implements Adn {

    private static final int SEQUENCE_LENGTH = 4;

    @Override
    public boolean isMutant(String[] dna) {
        int n = dna.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check for a sequence of four identical letters in any of the four directions.
                if (checkSequence(dna, i, j, 1, 0, n) ||  // Horizontal
                        checkSequence(dna, i, j, 0, 1, n) ||  // Vertical
                        checkSequence(dna, i, j, 1, 1, n) ||  // Diagonal \
                        checkSequence(dna, i, j, 1, -1, n)) { // Diagonal /

                    return true; // Mutant detected
                }
            }
        }
        return false; // Not a mutant
    }

    private boolean checkSequence(String[] dna, int row, int col, int rowStep, int colStep, int n) {
        if (row + (SEQUENCE_LENGTH - 1) * rowStep >= n || row + (SEQUENCE_LENGTH - 1) * rowStep < 0 ||
                col + (SEQUENCE_LENGTH - 1) * colStep >= n || col + (SEQUENCE_LENGTH - 1) * colStep < 0) {
            return false; // Out of bounds
        }

        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (dna[row + i * rowStep].charAt(col + i * colStep) != base) return false;
        }
        return true; // Sequence of 4 identical characters found
    }
}
