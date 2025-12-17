package Es6.ChatBot;

import java.util.Random;

public class Linear {

    private final int in;
    private final int out;

    private final float[][] W; // [in][out]
    private final float[] b;   // [out]

    public Linear(int in, int out) {
        this.in = in;
        this.out = out;

        W = new float[in][out];
        b = new float[out];

        init();
    }

    private void init() {
        Random rnd = new Random();
        for (int i = 0; i < in; i++) {
            for (int j = 0; j < out; j++) {
                W[i][j] = (rnd.nextFloat() - 0.5f) * 0.1f;
            }
        }
        for (int j = 0; j < out; j++) b[j] = 0f;
    }

    // Forward: X shape [seqLen][in] -> [seqLen][out]
    public float[][] forward(float[][] x) {
        int seqLen = x.length;
        float[][] outArr = new float[seqLen][out];

        for (int t = 0; t < seqLen; t++) {
            for (int j = 0; j < out; j++) {
                float sum = b[j];
                for (int k = 0; k < in; k++) {
                    sum += x[t][k] * W[k][j];
                }
                outArr[t][j] = sum;
            }
        }
        return outArr;
    }

    // Backward for ONE time step
    // xVec: input vector at that time step, shape [in]
    // gradOut: dL/dY for that time step, shape [out]
    // Returns gradIn: dL/dX, shape [in]
    public float[] backwardStep(float[] xVec, float[] gradOut, float lr) {

        // gradIn = gradOut * W^T
        float[] gradIn = new float[in];
        for (int k = 0; k < in; k++) {
            float sum = 0f;
            for (int j = 0; j < out; j++) {
                sum += gradOut[j] * W[k][j];
            }
            gradIn[k] = sum;
        }

        // SGD update:
        // dW = xVec^T * gradOut
        for (int k = 0; k < in; k++) {
            for (int j = 0; j < out; j++) {
                float dW = xVec[k] * gradOut[j];
                W[k][j] -= lr * dW;
            }
        }

        // db = gradOut
        for (int j = 0; j < out; j++) {
            b[j] -= lr * gradOut[j];
        }

        return gradIn;
    }
}


