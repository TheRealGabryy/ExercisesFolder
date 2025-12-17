package Es6.ChatBot;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

    public static class Sample {
        public final int[] input;
        public final int target;

        public Sample(int[] input, int target) {
            this.input = input;
            this.target = target;
        }
    }

    private final List<Sample> samples = new ArrayList<>();

    public Dataset(List<String> words, Tokenizer tokenizer) {
        buildSamples(words, tokenizer);
    }

    private void buildSamples(List<String> words, Tokenizer tokenizer) {

        for (String word : words) {

            // tokenize the full word (+ eos)
            int[] tokens = tokenizer.encode(word);

            // generate prefix -> next token samples
            for (int t = 1; t < tokens.length; t++) {

                int[] input = new int[t];
                System.arraycopy(tokens, 0, input, 0, t);

                int target = tokens[t];

                samples.add(new Sample(input, target));
            }
        }
    }

    public int size() {
        return samples.size();
    }

    public Sample get(int index) {
        return samples.get(index);
    }

    public List<Sample> getAll() {
        return samples;
    }
}

