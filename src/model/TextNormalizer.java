package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextNormalizer {
    private String inputFileName;
    private String outputFileName;

    public TextNormalizer(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public void normalizeText() throws IOException {
        // Read input file
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFileName));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Normalize content
            String normalizedContent = normalize(content.toString());

            // Write to output file
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(outputFileName));
                writer.write(normalizedContent);
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private String normalize(String text) {
        String[] sentences = text.split("[\\.\\?!]\\s*");
        StringBuilder normalizedText = new StringBuilder();

        for (String sentence : sentences) {
            if (!sentence.isEmpty()) {
                String normalizedSentence = normalizeSentence(sentence);
                normalizedText.append(normalizedSentence).append(". ");
            }
        }

        return normalizedText.toString().trim();
    }

    private String normalizeSentence(String sentence) {
        StringBuilder normalizedSentence = new StringBuilder();
        String[] words = sentence.split("\\s+");

            for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                // First word in the sentence
                normalizedSentence.append(words[i].substring(0, 1).toUpperCase())
                                  .append(words[i].substring(1).toLowerCase());
            } else {
                normalizedSentence.append(" ")
                                  .append(words[i].toLowerCase());
            }
        }

        return normalizedSentence.toString();
    }
}