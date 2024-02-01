public class Score {
    int id = 0;
    String name = "";
    int[] subjects = new int[5];

    int getJapanese() {
        return subjects[0];
    }
    int getMathmatics() {
        return subjects[1];
    }
    int getScience() {
        return subjects[2];
    }
    int getSocialStudies() {
        return subjects[3];
    }
    int getEnglish() {
        return subjects[4];
    }
    void setJapanese(int value) {
        subjects[0] = value;
    }
    void setMathmatics(int value) {
        subjects[1] = value;
    }
    void setScience(int value) {
        subjects[2] = value;
    }
    void setSocialStudies(int value) {
        subjects[3] = value;
    }
    void setEnglish(int value) {
        subjects[4] = value;
    }

    int getTotal(){
        int sum = 0;
        for (int sub : subjects) {
            sum += sub;
        }
        return sum;
    }
    double getAverage() {
        return (double) getTotal() / subjects.length;
    }
    int getHighScore() {
        int max = 0;
        for (int sub : subjects) {
            if (max < sub) {
                max = sub;
            }
        }
        return max;
    }
    String getHighScoreSubject() {
        String subjectName = "";
        int max = getHighScore();
        for (int x = 0; x < subjects.length; x++) {
            if (max == subjects[x]) {
                if (subjectName.length() != 0) {
                    subjectName += ",";
                }
                switch (x) {
                    case 0:
                        subjectName += "国語";
                        break;
                    case 1:
                        subjectName += "数学";
                        break;
                    case 2:
                        subjectName += "理科";
                        break;
                    case 3:
                        subjectName += "社会";
                        break;
                    case 4:
                        subjectName += "英語";
                        break;
                }
            }
        }
        return subjectName;
    }
    int getLowScore() {
        int min = Integer.MAX_VALUE;    // int型の最大値からスタート
        for (int sub : subjects) {
            if (min > sub) {
                min = sub;
            }
        }
        return min;
    }
    String getLowScoreSubject() {
        String subjectName = "";
        int min = getLowScore();
        for (int y = 0; y < subjects.length; y++) {
            if (min == subjects[y]) {
                if (subjectName.length() != 0) {
                    subjectName += ",";
                }
                switch (y) {
                    case 0:
                        subjectName += "国語";
                        break;
                    case 1:
                        subjectName += "数学";
                        break;
                    case 2:
                        subjectName += "理科";
                        break;
                    case 3:
                        subjectName += "社会";
                        break;
                    case 4:
                        subjectName += "英語";
                        break;
                }
            }
        }
        return subjectName;
    }
    void printInfo() {
        System.out.println(id + " " + name + " " +
                "国語" + getJapanese() + "点," +
                "数学" + getMathmatics() + "点," +
                "理科" + getScience() + "点," +
                "社会" + getSocialStudies() + "点," +
                "英語" + getEnglish() + "点 " +
                "合計" + getTotal() + "点 " +
                "平均" + getAverage() + "点 " +
                "得意科目:" + getHighScoreSubject() + " " + getHighScore() + "点 " +
                "苦手科目:" + getLowScoreSubject() + " " + getLowScore() + "点"
        );
    }


}
