package Es6.ChatBot;

import java.util.Random;

public class Embedding {

    // Vocabulary size (number of tokens)
    private final int vocabSize;

    // Dimension of each embedding vector
    private final int dModel;

    // The embedding table:
    // embeddingTable[tokenId] -> vector of size dModel
    private final float[][] embeddingTable;

    public Embedding(int vocabSize, int dModel) {
        this.vocabSize = vocabSize;
        this.dModel = dModel;
        this.embeddingTable = new float[vocabSize][dModel];

        initWeights();
    }

    // Initialize embeddings randomly
    // Small values to avoid exploding activations
    private void initWeights() {
        Random rnd = new Random();
        for (int i = 0; i < vocabSize; i++) {
            for (int j = 0; j < dModel; j++) {
                embeddingTable[i][j] = (rnd.nextFloat() - 0.5f) * 0.1f;
            }
        }
    }

    // Forward pass
    // Input: array of token IDs
    // Output: matrix [sequenceLength][dModel]
    public float[][] forward(int[] tokenIds) {
        int seqLen = tokenIds.length;
        float[][] output = new float[seqLen][dModel];

        for (int t = 0; t < seqLen; t++) {
            int tokenId = tokenIds[t];

            if (tokenId < 0 || tokenId >= vocabSize) {
                throw new IllegalArgumentException("Invalid token ID: " + tokenId);
            }

            // Copy embedding vector
            System.arraycopy(
                    embeddingTable[tokenId],
                    0,
                    output[t],
                    0,
                    dModel
            );
        }

        return output;
    }
}

