package privacyAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrivacyPolicyAnalyzer {

    public static void main(String[] args) {
        // Parse privacy policy document
        File policyFile = new File("privacy_policy.txt");
        String policyText = parsePolicyDocument(policyFile);

        // Perform compliance checks
        boolean isCompliant = checkCompliance(policyText);

        // Display results
        displayResults(policyText, isCompliant);
    }

    // Parse privacy policy document
    public static String parsePolicyDocument(File file) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    // Check compliance using regular expressions
    public static boolean checkCompliance(String text) {
        // Define regex patterns for the keywords and phrases
        String[] keywords = {
        		"data collection",
                "data processing",
                "data storage",
                "data retention",
                "data encryption",
                "data security",
                "data sharing",
                "personal information",
                "personally identifiable information",
                "user consent",
                "user data",
                "user privacy",
                "privacy policy",
                "privacy notice",
                "information security",
                "confidentiality",
                "access control",
                "authentication",
                "authorization",
                "transparency",
                "consent management",
                "opt-in",
                "opt-out",
                "data usage",
                "data ownership",
                "data protection",
                "data breach",
                "security measures",
                "compliance",
                "regulations",
                "gdpr",
                "ccpa",
                "hipaa",
                "glba",
                "coppa",
                "privacy shield",
                "safe harbor",
                "jurisdiction",
                "cross-border data transfer",
                "data localization",
                "consent form",
                "cookies",
                "tracking technologies",
                "third-party services",
                "service providers",
                "cloud service",
                "cloud computing",
                "cloud storage",
                "terms of service",
                "acceptable use policy"
        };

        // Create a regex pattern for matching any of the keywords
        String regexPattern = String.join("|", keywords);
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);

        // Check if any of the keywords/phrases are present in the text
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    // Display results
    public static void displayResults(String policyText, boolean isCompliant) {
        // Logic to display results
        System.out.println("Privacy Policy Document:");
        System.out.println(policyText);
        System.out.println("Compliance: " + (isCompliant ? "Compliant" : "Not Compliant"));
    }
}
