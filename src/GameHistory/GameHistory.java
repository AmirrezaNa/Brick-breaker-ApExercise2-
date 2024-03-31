package GameHistory;

import Game.Brick;
import Start.StartPagePanel;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameHistory {
    private static final String FILE_NAME = "GameHistory.json";

    public static void saveScores(Map<String, Integer> scores) {

        Map<String, Integer> existingScores = readScores();

        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            existingScores.putAll(scores);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(existingScores, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> readScores() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<HashMap<String, Integer>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static List<Integer> getAllScores() {
        Map<String, Integer> retrievedScores = readScores();
        List<Integer> allScores = new ArrayList<>();
        for (int score : retrievedScores.values()) {
            allScores.add(score);
        }
        return allScores;
    }

    public static int findMax() {
        List<Integer> list = getAllScores();
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is either null or empty");
        }

        int max = Integer.MIN_VALUE;
        for (int num : list) {
            max = Math.max(max, num);
        }

        return max;
    }

    public static Map<String, Integer> getNamesAndScoresMap() {
        Map<String, Integer> retrievedScores = readScores();
        return retrievedScores;
    }
}
