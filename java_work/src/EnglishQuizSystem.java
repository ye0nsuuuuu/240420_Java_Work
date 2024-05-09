package EnglishQuiz;




    import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

    public class EnglishQuizSystem extends JFrame {
        private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
        private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
        private static final String USER = "scott";
        private static final String PASSWORD = "tiger";
        private Connection conn;
        private Statement stmt;
        private ResultSet rs;
        private JLabel wordLabel;
        private JTextField answerField;
        private JButton submitButton;
        private JButton showAnswerButton;
        // private JButton addButton; // 단어 추가 버튼 삭제
        private String currentWord;
        private String currentMeaning;

        public EnglishQuizSystem() {
            initializeDB();
            initializeUI();
            loadNextQuiz();
        }

        private void initializeDB() {
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                stmt = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void initializeUI() {
            setTitle("English Quiz Program");
            setSize(400, 250);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout());

            wordLabel = new JLabel();
            answerField = new JTextField(20);
            submitButton = new JButton("제출하기");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer();
                }
            });
            showAnswerButton = new JButton("정답 보기");
            showAnswerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showAnswer();
                }
            });

            // addButton = new JButton("Add Word"); // 단어 추가 버튼 삭제

            JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // 3개 버튼에서 2개 버튼으로 변경
            buttonPanel.add(submitButton);
            buttonPanel.add(showAnswerButton);
            // buttonPanel.add(addButton); // 단어 추가 버튼 삭제

            panel.add(wordLabel, BorderLayout.NORTH);
            panel.add(answerField, BorderLayout.CENTER);
            panel.add(buttonPanel, BorderLayout.SOUTH);

            add(panel);
        }

        private void loadNextQuiz() {
            try {
                String query = "SELECT word, meaning FROM words ORDER BY DBMS_RANDOM.RANDOM";
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    currentWord = rs.getString("word");
                    currentMeaning = rs.getString("meaning");
                    wordLabel.setText("단어의 뜻을 입력하세요: " + currentWord);
                    answerField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No words found in the database.");
                    System.exit(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void checkAnswer() {
            String userAnswer = answerField.getText().trim();
            if (userAnswer.equalsIgnoreCase(currentMeaning)) {
                JOptionPane.showMessageDialog(null, "정답입니다!");
            } else {
                int option = JOptionPane.showConfirmDialog(null, "오답입니다 다시 시도해 보세요", null,
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    answerField.setText("");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "정답은 " + currentMeaning + " 입니다.");
                }
            }
            loadNextQuiz();
        }

        private void showAnswer() {
            JOptionPane.showMessageDialog(null, "정답은 " + currentMeaning + " 입니다.");
        }

        /*
        private void addNewWord() {
            String newWord = JOptionPane.showInputDialog("새로운 단어를 입력하세요:");
            String newMeaning = JOptionPane.showInputDialog("새로운 단어의 뜻을 입력하세요:");

            try {
                String query = "INSERT INTO words (word, meaning) VALUES ('" + newWord + "', '" + newMeaning + "')";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "새로운 단어가 성공적으로 추가되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "단어 추가 중 오류가 발생했습니다.");
            }
        }
        */

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new EnglishQuizSystem().setVisible(true);
                }
            });
        }
    }

