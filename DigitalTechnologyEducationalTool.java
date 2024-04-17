package privacyAnalyzer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class DigitalTechnologyEducationalTool extends JFrame {

    private JProgressBar progressBar;

    public DigitalTechnologyEducationalTool() {
        setTitle("Digital Technology Educational Tool");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(240, 200, 200)); // Pink background

        JLabel titleLabel = new JLabel("Digital Technology Educational Tool", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        mainPanel.add(progressBar, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(240, 200, 200)); // Pink background

        JButton infoButton = new JButton("Digital Technology Info");
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display information about digital technology
                String info = "Digital technology refers to the use of digital systems and devices to process, store, and transmit information.\n\n";
                info += "Key considerations include:\n";
                info += "- Data security and encryption methods\n";
                info += "- Privacy regulations and compliance\n";
                info += "- User rights and control over personal data\n\n";
                // Include facts from Lessig's "Code is Law" concept
                info += "Facts from Lessig's 'Code is Law':\n";
                info += "- The architecture of digital systems can shape user behavior and influence power dynamics.\n";
                info += "- Centralized control over internet infrastructure can lead to censorship and surveillance.\n";
                info += "- Open standards and decentralized architectures promote innovation and individual autonomy.\n\n";
                // Include digital privacy tips
                info += getDigitalPrivacyTips();
                textArea.setText(info);
            }
        });
        buttonPanel.add(infoButton);

        JButton tutorialButton = new JButton("Tutorials");
        tutorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display tutorials related to digital technology
                displayTutorials(textArea);
            }
        });
        buttonPanel.add(tutorialButton);

        JButton quizButton = new JButton("Quizzes");
        quizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start a quiz on digital technology
                startQuiz();
            }
        });
        buttonPanel.add(quizButton);

        JButton tipsButton = new JButton("Privacy Tips");
        tipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display tips on understanding privacy in digital technology
                String tips = "Tips for Understanding Privacy in Digital Technology:\n";
                tips += "- Review privacy settings and permissions on devices and platforms.\n";
                tips += "- Be cautious about sharing personal information online.\n";
                tips += "- Keep software and security measures up to date to protect against threats.\n";
                tips += "- Enable two factor authentication when creating your login information for sites. \n";
                tips += "- Regularly review access permissions for files stored in the cloud to ensure only authorized users have access. \n";
                tips += "- Encrypt sensitive files before uploading them to the cloud to prevent breaches. \n";
                tips += "- Use strong, unique passwords for all cloud service accounts and consider using a password manager to securely store passwords. \n";
                tips += "- Be cautious when sharing files or folders in the cloud. \n";
                tips += "- Avoid storing highly sensitive information, such as SSN or finances in the cloud unless necessary. \n";
                tips += "- Consider a VPN when accessing your cloud accounts from public WiFi networks. \n";
                textArea.setText(tips);
            }
        });
        buttonPanel.add(tipsButton);

        JButton privacyPolicyButton = new JButton("Privacy Policy Analyzer");
        privacyPolicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display Privacy Policy Analyzer
                displayPrivacyPolicyAnalyzer(textArea);
            }
        });
        buttonPanel.add(privacyPolicyButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

    // Get digital privacy tips
    private String getDigitalPrivacyTips() {
        String tips = "Digital Privacy Tips and Tricks:\n";
        tips += "- Review privacy settings and permissions on devices and platforms regularly.\n";
        tips += "- Be cautious about sharing personal information online, and avoid oversharing.\n";
        tips += "- Use strong, unique passwords for each online account and consider using a password manager.\n";
        tips += "- Keep software and security measures up to date to protect against threats such as malware and phishing.\n";
        tips += "- Encrypt sensitive data and use secure communication methods, such as VPNs, when accessing the internet.\n";
        tips += "- Be mindful of the data you share with online services and consider the potential consequences.\n";
        tips += "- Educate yourself about privacy laws and regulations to understand your rights and responsibilities.\n\n";
        return tips;
    }

    // Display tutorials related to digital technology
    private void displayTutorials(JTextArea textArea) {
        // List of available tutorials
        List<String> tutorials = Arrays.asList(
                "Introduction to Digital Technology",
                "Data Security and Encryption",
                "Privacy Regulations and Compliance",
                "User Rights in Digital Technology",
                "Secure Communication and Data Transmission"
        );

        // Randomize the order of tutorials
        Collections.shuffle(tutorials);

        // Display tutorials
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < tutorials.size(); i++) {
            message.append(i + 1).append(". ").append(tutorials.get(i)).append("\n");
            // Add detailed information for each tutorial
            message.append(getTutorialDetails(tutorials.get(i))).append("\n");
            // Add demo button for each tutorial
            message.append("    ").append("[Demo]").append("\n\n");
        }
        textArea.setText(message.toString());

        // Add buttons for puzzles
        for (int i = 0; i < tutorials.size(); i++) {
            String tutorial = tutorials.get(i);
            JButton puzzleButton = new JButton("Puzzle " + (i + 1));
            puzzleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startPuzzle(tutorial);
                }
            });
            textArea.add(puzzleButton);
        }
    }

    // Get detailed information for each tutorial
    private String getTutorialDetails(String tutorial) {
        switch (tutorial) {
            case "Introduction to Digital Technology":
                return "This tutorial provides an overview of digital technology and its applications in various fields.\n";
            case "Data Security and Encryption":
                return "Learn about data security measures and encryption techniques used to protect information in digital systems.\n";
            case "Privacy Regulations and Compliance":
                return "Explore the regulations and standards governing privacy in digital technology, such as GDPR, CCPA, and COPPA.\n";
            case "User Rights in Digital Technology":
                return "Understand the rights of users regarding their personal data in digital technology, including access, control, and deletion.\n";
            case "Secure Communication and Data Transmission":
                return "Discover methods for ensuring secure communication and data transmission over digital networks, including VPNs and encryption protocols.\n";
            default:
                return "";
        }
    }

    // Start a quiz on digital technology
    private void startQuiz() {
        // List of quiz questions
        List<String> questions = Arrays.asList(
                "What is digital technology?",
                "Why is data encryption important?",
                "What are privacy regulations?",
                "What are user rights in digital technology?",
                "How can communication be secured in digital networks?",
                // Additional quiz questions
                "What is the purpose of a VPN?",
                "What is two-factor authentication?",
                "What does GDPR stand for?",
                "Why is it important to regularly update software?",
                "What is the difference between HTTP and HTTPS?"
        );

        // List of possible answers for each question
        List<List<String>> answers = Arrays.asList(
                Arrays.asList("The use of digital systems and devices", "Traditional manual processes", "Analog communication methods"),
                Arrays.asList("To protect information from unauthorized access", "To reduce data storage costs", "To increase processing speed"),
                Arrays.asList("Laws and standards governing privacy practices", "Industry best practices", "Optional guidelines for businesses"),
                Arrays.asList("*Rights regarding personal data access, control, and deletion", "Rights to access government services", "Rights to free speech"),
                Arrays.asList("*Through encryption and secure protocols", "By using outdated technology", "By sharing data openly"),
                // Additional answers
                Arrays.asList("To create a secure connection over the internet", "To track online activities", "To bypass internet restrictions"),
                Arrays.asList("A method of confirming a user's identity using two different factors", "A type of computer virus", "A form of online advertising"),
                Arrays.asList("General Data Protection Regulation", "Global Digital Privacy Regulation", "General Data Processing Rules"),
                Arrays.asList("To patch security vulnerabilities and add new features", "To decrease device performance", "To increase data storage"),
                Arrays.asList("HTTP does not encrypt data, while HTTPS does", "They are the same", "HTTP is faster than HTTPS")
        );

        // Create quiz dialog
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < questions.size(); i++) {
            message.append(questions.get(i)).append("\n");
            List<String> options = answers.get(i);
            for (int j = 0; j < options.size(); j++) {
                message.append((char) ('a' + j)).append(") ").append(options.get(j)).append("\n");
            }
            message.append("\n");
        }

        String response = JOptionPane.showInputDialog(this, message.toString(), "Quiz", JOptionPane.QUESTION_MESSAGE);

        // Check answers
        int score = 0;
        if (response != null) {
            String[] answersArray = response.split("\\s+");
            for (int i = 0; i < answersArray.length; i++) {
                int answerIndex = answersArray[i].charAt(0) - 'a';
                if (answerIndex >= 0 && answerIndex < answers.get(i).size() && answers.get(i).get(answerIndex).startsWith("*")) {
                    score++;
                }
            }
            JOptionPane.showMessageDialog(this, "Your score: " + score + "/" + questions.size(), "Quiz Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Start a puzzle for a specific tutorial
    private void startPuzzle(String tutorial) {
        // Define the words for the puzzle based on the tutorial
        String[] words;
        switch (tutorial) {
            case "Introduction to Digital Technology":
                words = new String[]{"electronics", "communication", "encryption", "security", "confirmation"};
                break;
            case "Data Security and Encryption":
                words = new String[]{"security", "encryption", "privacy", "algorithm", "authentication"};
                break;
            case "Privacy Regulations and Compliance":
                words = new String[]{"regulations", "compliance", "GDPR", "CCPA", "COPPA"};
                break;
            case "User Rights in Digital Technology":
                words = new String[]{"rights", "privacy", "data", "access", "control"};
                break;
            case "Secure Communication and Data Transmission":
                words = new String[]{"communication", "secure", "transmission", "protocol", "VPN"};
                break;
            default:
                words = new String[]{};
                break;
        }

        // Shuffle the words
        List<String> wordList = Arrays.asList(words);
        Collections.shuffle(wordList);
        words = wordList.toArray(new String[0]);

        // Prompt the user to unscramble the words
        StringBuilder puzzleMessage = new StringBuilder("Unscramble the following words:\n");
        for (int i = 0; i < words.length; i++) {
            puzzleMessage.append(i + 1).append(". ").append(scrambleWord(words[i])).append("\n");
        }
        String response = JOptionPane.showInputDialog(this, puzzleMessage.toString(), "Puzzle", JOptionPane.QUESTION_MESSAGE);

        // Check the user's answers
        if (response != null) {
            String[] userAnswers = response.toLowerCase().split("\\s+");
            if (Arrays.equals(userAnswers, words)) {
                JOptionPane.showMessageDialog(this, "Congratulations! You solved the puzzle!", "Puzzle Solved", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Oops! Try again.", "Puzzle Not Solved", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Scramble a word for the puzzle
    private String scrambleWord(String word) {
        List<Character> chars = Arrays.asList(word.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        Collections.shuffle(chars);
        return chars.stream().map(String::valueOf).collect(Collectors.joining());
    }


    // Display Privacy Policy Analyzer
    private void displayPrivacyPolicyAnalyzer(JTextArea textArea) {
        // Select a file to analyze
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Read the contents of the file
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Analyze the privacy policy
            String analysisResult = analyzePrivacyPolicy(content.toString());
            textArea.setText(analysisResult);
        }
    }

    // Analyze the privacy policy
    private String analyzePrivacyPolicy(String policy) {
        // Dummy implementation for demonstration
        return "Privacy Policy Analysis:\n" +
                "This is a placeholder result. Actual analysis of the privacy policy would require sophisticated natural language processing and legal expertise.";
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DigitalTechnologyEducationalTool().setVisible(true);
            }
        });
    }
}

/*
For this final presentation, I decided to show what I have learned in this class and my research through a Graphical-User Interface. 
My proposal is a Digital Privacy Educational Tool that is aimed to be an educational aid as well as a service for users who need to understand privacy laws. My product is a Graphical User Interface that would include features such as informational content, tutorials, quizzes, puzzles, privacy tips, and a privacy policy analyzer.
Originally, I had a plan to host this on an AWS platform to step into more of a practitioner role, but I ended up just focusing on the features I wanted to include in my project
In my proposal, I discussed how I wanted to empower users to make informed decisions about when to accept a privacy document or not as well as
become informed on the ways to protect their privacy as cloud services become more on the rise
As we know a lot of people say "Whatever you say or do on the cloud stays on the cloud" this is true which is why people need to understand how to protect their privacy and stay mindful 
The tool offers informational content on digital technology, including data security, encryption methods, privacy regulations, and user rights. By educating users about these topics, it raises awareness of the importance of digital privacy within digital technology.
 Users can access tutorials covering various aspects of digital technology, including data security, privacy regulations, and secure communication. These tutorials help users understand best practices for maintaining privacy in cloud environments.
The tool provides quizzes that test users' knowledge of digital technology, data security, and privacy regulations. By engaging users in quizzes, it reinforces their understanding of privacy laws and rules applicable to cloud technology
Users can solve puzzles related to different topics such as encryption, communication, and privacy regulations. These puzzles offer an interactive way to learn about digital privacy concepts within cloud technology.
The tool offers practical tips for understanding and maintaining privacy in digital technology. It covers areas such as reviewing privacy settings, being cautious about sharing personal information online, and keeping software updated. These tips promote good privacy practices in cloud environments.
The Privacy Policy Analyzer feature allows users to upload privacy policy files and analyze them to determine whether they should agree to the policies. This functionality contributes to digital privacy within cloud technology by empowering users to make informed decisions about their data privacy rights when using cloud services.


Conclusion:
With the research I did for my proposal, I discussed how the United States still has yet to balance privacy and new technologies which contribute to discussions about federal privacy legislation
There are acts that exist to try to balance this including HIPPA, GBLA, CCPA, and CLOUD Act
These privacy laws that exist are more sector specific and not focused on the growing Cloud services, which the US needs to focus on
Obviously cloud services have issues with confidentiality, data loss and theft, and more but this is why I wanted to create this educational GUI
I know users also do not truly read the terms of service documents, but now I know how crucial it is because the question is: do we really know how our data is being used?
Because of this class, I have become more mindful of using 2FA and doing less skimming with terms of service agreements
I understand there are ethical considerations to be mindful of hence why I aim to prioritize user privacy and freedom within this GUI 
One of the biggest takeaway from this class was from Lessig's "Code is Law" that we read which I included in the GUI
The quote I will remember is "Architecture of freedom could become architecture of control" which is so true 
In regards to today, our privacy is not really private anymore the government tries to control it 
The more advanced technology gets, the US has to start creating stricter laws especially for cloud services 

How will I get this out to people?
I want to give it to people to test to see if the privacy analyzer feature does in fact work on all and any device. 
To market my project, I would first start out with raising awareness on social media like Instagram and Snapchat
or maybe a test drive with your students that come through each semester
I could also try to test it with professors so they could try it as well
I would definitely start with the Pitt community then expand to schools in the area
Another possible idea would be to start out with kids in Pittsburgh Public Schools since its the surrounding area and it would be spreading awareness at a young age




*/