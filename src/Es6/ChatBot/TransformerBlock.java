package Es6.ChatBot;

public class TransformerBlock {

    private final int dModel;

    private final SelfAttention attention;
    private final LayerNorm norm1;
    private final LayerNorm norm2;

    private final Linear ff1;
    private final Linear ff2;

    public TransformerBlock(int dModel) {
        this.dModel = dModel;

        this.attention = new SelfAttention(dModel);
        this.norm1 = new LayerNorm(dModel);
        this.norm2 = new LayerNorm(dModel);

        // FeedForward network
        this.ff1 = new Linear(dModel, 4 * dModel);
        this.ff2 = new Linear(4 * dModel, dModel);
    }

    // Input shape: [seqLen][dModel]
    public float[][] forward(float[][] x) {

        // --- Self Attention ---
        float[][] attnOut = attention.forward(x);

        // Residual connection + normalization
        float[][] x1 = add(x, attnOut);
        x1 = norm1.forward(x1);

        // --- Feed Forward ---
        float[][] ffOut = ff1.forward(x1);
        relu(ffOut);
        ffOut = ff2.forward(ffOut);

        // Residual connection + normalization
        float[][] out = add(x1, ffOut);
        out = norm2.forward(out);

        return out;
    }

    // ---------- utilities ----------

    private float[][] add(float[][] a, float[][] b) {
        int n = a.length;
        int m = a[0].length;
        float[][] out = new float[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out[i][j] = a[i][j] + b[i][j];
            }
        }
        return out;
    }

    private void relu(float[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                if (x[i][j] < 0f) x[i][j] = 0f;
            }
        }
    }
}

