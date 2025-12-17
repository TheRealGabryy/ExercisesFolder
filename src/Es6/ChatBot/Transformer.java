package Es6.ChatBot;

public class Transformer {

    private final int vocabSize;
    private final int dModel;
    private final int maxSeqLen;
    private float[][] lastHidden; // the output of the block, input to outputLayer
    private int lastSeqLen;

    private final Embedding embedding;
    private final PositionalEncoding positionalEncoding;
    private final TransformerBlock block;
    private final Linear outputLayer;

    public Transformer(int vocabSize, int dModel, int maxSeqLen) {
        this.vocabSize = vocabSize;
        this.dModel = dModel;
        this.maxSeqLen = maxSeqLen;

        this.embedding = new Embedding(vocabSize, dModel);
        this.positionalEncoding = new PositionalEncoding(maxSeqLen, dModel);
        this.block = new TransformerBlock(dModel);

        // Projects from model space to vocabulary space
        this.outputLayer = new Linear(dModel, vocabSize);
    }

    // Forward pass
    // Input: token IDs of the context
    // Output: probabilities for next token at each position
    public float[][] forward(int[] tokenIds) {

        // 1. Token embeddings
        float[][] x = embedding.forward(tokenIds);
        // Shape: [seqLen][dModel]

        // 2. Add positional information
        x = positionalEncoding.forward(x);
        // Shape unchanged

        // 3. Context mixing
        x = block.forward(x);
        // Shape unchanged

        // cache hidden states for trainer backward
        lastHidden = x;
        lastSeqLen = x.length;

        // 4. Project to vocabulary
        float[][] logits = outputLayer.forward(x);
        // Shape: [seqLen][vocabSize]

        // 5. Softmax per position
        float[][] probs = new float[logits.length][vocabSize];
        for (int i = 0; i < logits.length; i++) {
            probs[i] = softmax(logits[i]);
        }

        return probs;
    }

    // Predict next token given a context
    // Uses the LAST position only
    public int predictNext(int[] tokenIds) {
        float[][] probs = forward(tokenIds);
        float[] last = probs[probs.length - 1];

        int best = 0;
        float max = last[0];

        for (int i = 1; i < last.length; i++) {
            if (last[i] > max) {
                max = last[i];
                best = i;
            }
        }

        return best;
    }

    // ---------- utilities ----------

    private float[] softmax(float[] x) {
        float max = Float.NEGATIVE_INFINITY;
        for (float v : x) {
            if (v > max) max = v;
        }

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

    public void backwardOutputOnly(float[] gradLogitsLastPos, float lr) {
        if (lastHidden == null || lastSeqLen <= 0) {
            throw new IllegalStateException("Call forward() before backwardOutputOnly().");
        }

        int pos = lastSeqLen - 1;

        // input vector to the output layer at the last position
        float[] xVec = lastHidden[pos];

        // update output layer weights using grad of logits at last position
        outputLayer.backwardStep(xVec, gradLogitsLastPos, lr);

        // We stop here on purpose.
        // Updating embeddings would require backprop through block + positional encoding.
    }


}

