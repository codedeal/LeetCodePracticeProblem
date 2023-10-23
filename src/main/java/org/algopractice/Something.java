package org.algopractice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Restaurant {
    private String name;
    private List<Integer> reviewScores;

    public Restaurant(String name, List<Integer> reviewScores) {
        this.name = name;
        this.reviewScores = reviewScores;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getReviewScores() {
        return reviewScores;
    }

    public String calculateRating() {
        List<Integer> sortedScores = new ArrayList<>(reviewScores);
        Collections.sort(sortedScores, Collections.reverseOrder());

        double mean = 0;
        int count = Math.min(sortedScores.size(), 4); // Consider only the top 4 scores

        for (int i = 0; i < count; i++) {
            mean += sortedScores.get(i);
        }

        mean /= count;

        if (mean < 4) {
            return "Poor";
        } else if (mean < 7) {
            return "Average";
        } else {
            return "Excellent";
        }
    }
}

public class Something {
}
