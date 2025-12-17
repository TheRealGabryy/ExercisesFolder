package Es6.ChatBot;

import java.util.Random;

public class SelfAttention {

    private final int dModel;

    private final float[][] Wq;
    private final float[][] Wk;
    private final float[][] Wv;

    public SelfAttention(int dModel) {
        this.dModel = dModel;

        Wq = new float[dModel][dModel];
        Wk = new float[dModel][dModel];
        Wv = new float[dModel][dModel];

        initWeights(Wq);
        initWeights(Wk);
        initWeights(Wv);
    }

    private void initWeights(float[][] W) {
        Random rnd = new Random();
        for (int i = 0; i < dModel; i++) {
            for (int j = 0; j < dModel; j++) {
                W[i][j] = (rnd.nextFloat() - 0.5f) * 0.1f;
            }
        }
    }

    // X shape: [seqLen][dModel]
    public float[][] forward(float[][] X) {
        int seqLen = X.length;

        float[][] Q = matMul(X, Wq);
        float[][] K = matMul(X, Wk);
        float[][] V = matMul(X, Wv);

        // Attention scores: [seqLen][seqLen]
        float[][] scores = new float[seqLen][seqLen];

        for (int i = 0; i < seqLen; i++) {
            for (int j = 0; j < seqLen; j++) {

                // causal mask
                if (j > i) {
                    scores[i][j] = -1e9f;
                } else {
                    scores[i][j] = dot(Q[i], K[j]) / (float) Math.sqrt(dModel);
                }
            }
        }

        // Softmax per row
        float[][] weights = new float[seqLen][seqLen];
        for (int i = 0; i < seqLen; i++) {
            weights[i] = softmax(scores[i]);
        }

        // Output = weights · V
        float[][] output = new float[seqLen][dModel];
        for (int i = 0; i < seqLen; i++) {
            for (int j = 0; j < seqLen; j++) {
                for (int k = 0; k < dModel; k++) {
                    output[i][k] += weights[i][j] * V[j][k];
                }
            }
        }

        return output;
    }

    // --------- utilities ----------

    private float[][] matMul(float[][] A, float[][] B) {
        int n = A.length;
        int m = B[0].length;
        int shared = B.length;

        float[][] out = new float[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < shared; k++) {
                    out[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return out;
    }

    private float dot(float[] a, float[] b) {
        float sum = 0f;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    private float[] softmax(float[] x) {
        float max = Float.NEGATIVE_INFINITY;
        for (float v : x) max = Math.max(max, v);

        float sum = 0f;
        float[] out = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            out[i] = (float) Math.exp(x[i] - max);
            sum += out[i];
        }

        for (int i = 0; i < out.length; i++) {
            out[i] /= sum;
        }

        return out;
    }
}

