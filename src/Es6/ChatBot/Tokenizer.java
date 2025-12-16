package Es6.ChatBot;

import java.util.*;

public class Tokenizer {

    private static final String PAD = "<pad>";
    private static final String EOS = "<eos>";

    private final Map<Character, Integer> charToId = new HashMap<>();
    private final Map<Integer, Character> idToChar = new HashMap<>();

    private final int padId = 0;
    private final int eosId = 1;

    public Tokenizer() {
        charToId.put(null, padId);
        charToId.put(null, eosId);

        // a-z
        int id = 2;
        for (char c = 'a'; c <= 'z'; c++) {
            charToId.put(c, id);
            idToChar.put(id, c);
            id++;
        }
    }

    public int[] encode(String word) {
        word = word.toLowerCase();
        int[] tokens = new int[word.length() + 1];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!charToId.containsKey(c)) {
                throw new IllegalArgumentException("Unknown character: " + c);
            }
            tokens[i] = charToId.get(c);
        }

        tokens[word.length()] = eosId;
        return tokens;
    }

    public String decode(int[] tokens) {
        StringBuilder sb = new StringBuilder();
        for (int id : tokens) {
            if (id == eosId) break;
            if (id == padId) continue;
            sb.append(idToChar.get(id));
        }
        return sb.toString();
    }

    public int getVocabSize() {
        return 28;
    }

    public int getPadId() {
        return padId;
    }

    public int getEosId() {
        return eosId;
    }
}

