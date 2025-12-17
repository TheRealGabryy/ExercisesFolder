package Es6.ChatBot;

public class LayerNorm {

    private final int dModel;
    private final float eps = 1e-5f;

    public LayerNorm(int dModel) {
        this.dModel = dModel;
    }

    // Normalize per token
    public float[][] forward(float[][] x) {
        int seqLen = x.length;
        float[][] out = new float[seqLen][dModel];

        for (int i = 0; i < seqLen; i++) {
            float mean = 0f;
            float var = 0f;

            for (int j = 0; j < dModel; j++) {
                mean += x[i][j];
            }
            mean /= dModel;

            for (int j = 0; j < dModel; j++) {
                float diff = x[i][j] - mean;
                var += diff * diff;
            }
            var /= dModel;

            float denom = (float) Math.sqrt(var + eps);

            for (int j = 0; j < dModel; j++) {
                out[i][j] = (x[i][j] - mean) / denom;
            }
        }

        return out;
    }
}

