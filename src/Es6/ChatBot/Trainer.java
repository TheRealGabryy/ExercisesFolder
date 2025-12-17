package Es6.ChatBot;

import java.util.List;

public class Trainer {

    private final Transformer model;
    private final Tokenizer tokenizer;
    private final float learningRate;

    public Trainer(Transformer model, Tokenizer tokenizer, float learningRate) {
        this.model = model;
        this.tokenizer = tokenizer;
        this.learningRate = learningRate;
    }

    // Train on a list of words
    public void train(List<String> words, int epochs) {

        for (int epoch = 0; epoch < epochs; epoch++) {
            float totalLoss = 0f;
            int count = 0;

            for (String word : words) {
                int[] tokens = tokenizer.encode(word);

                // create prefix -> next char pairs
                for (int t = 1; t < tokens.length; t++) {

                    int[] input = new int[t];
                    System.arraycopy(tokens, 0, input, 0, t);

                    int target = tokens[t];

                    float loss = trainStep(input, target);
                    totalLoss += loss;
                    count++;
                }
            }

            System.out.println(
                    "Epoch " + epoch +
                            " | Loss: " + (totalLoss / count)
            );
        }
    }

    // One training step
    private float trainStep(int[] input, int target) {

        // Forward pass
        float[][] probs = model.forward(input);
        float[] lastProbs = probs[probs.length - 1];

        // Cross entropy loss
        float loss = (float) -Math.log(lastProbs[target] + 1e-9f);

        // Gradient of loss w.r.t logits
        // softmax + cross-entropy derivative
        float[] grad = new float[lastProbs.length];
        System.arraycopy(lastProbs, 0, grad, 0, grad.length);
        grad[target] -= 1f;

        // Backprop ONLY through output layer
        model.backwardOutputOnly(grad, learningRate);

        return loss;
    }

}

