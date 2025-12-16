package Es6.ChatBot;

public class PositionalEncoding {

    private final int maxSeqLen;
    private final int dModel;
    private final float[][] encoding;

    public PositionalEncoding(int maxSeqLen, int dModel) {
        this.maxSeqLen = maxSeqLen;
        this.dModel = dModel;
        this.encoding = new float[maxSeqLen][dModel];

        buildEncoding();
    }

    // Precompute positional encodings
    private void buildEncoding() {
        for (int pos = 0; pos < maxSeqLen; pos++) {
            for (int i = 0; i < dModel; i++) {

                double angle = pos / Math.pow(
                        10000.0,
                        (2.0 * (i / 2)) / dModel
                );

                if (i % 2 == 0) {
                    encoding[pos][i] = (float) Math.sin(angle);
                } else {
                    encoding[pos][i] = (float) Math.cos(angle);
                }
            }
        }
    }

    // Add positional encoding to embeddings
    // Input and output shape: [seqLen][dModel]
    public float[][] forward(float[][] embeddings) {
        int seqLen = embeddings.length;
        float[][] output = new float[seqLen][dModel];

        for (int t = 0; t < seqLen; t++) {
            for (int j = 0; j < dModel; j++) {
                output[t][j] = embeddings[t][j] + encoding[t][j];
            }
        }

        return output;
    }
}

