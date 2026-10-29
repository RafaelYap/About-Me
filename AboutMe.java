import java.awt.*;
import java.net.URI;
import javax.swing.*;

public class AboutMe {
    private static final Color BG = new Color(16, 26, 43);
    private static final Color CARD = new Color(24, 37, 58);
    private static final Color TEXT = new Color(246, 247, 251);
    private static final Color MUTED = new Color(170, 184, 202);
    private static final Color ACCENT = new Color(169, 240, 205);
    private static final String GITHUB = "https://github.com/pogiko1345";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AboutMe::show);
    }

    private static void show() {
        JFrame frame = new JFrame("Rafael Yap | Developer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600, 500));

        JPanel content = new JPanel();
        content.setBackground(BG);
        content.setBorder(BorderFactory.createEmptyBorder(40, 48, 48, 48));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(label("RAFAEL YAP  /  DEVELOPER", 14, ACCENT, Font.BOLD));
        gap(content, 38);
        content.add(label("Hi, I'm Rafael.", 42, TEXT, Font.BOLD));
        gap(content, 12);
        content.add(paragraph("I build useful software across web and mobile. My recent public work includes a student information system and a campus access platform.", BG, 18));
        gap(content, 20);
        content.add(link("Explore my GitHub", GITHUB));
        gap(content, 46);

        content.add(label("SELECTED WORK", 14, ACCENT, Font.BOLD));
        gap(content, 16);
        content.add(project("Student Information System", "A MERN application with registration, JWT sign in, protected student records, search, pagination, and a dashboard. I worked on authentication in this team project.", "React  ·  Node.js  ·  MongoDB", GITHUB + "/student-information-system-advwebdev"));
        gap(content, 14);
        content.add(project("Sapphire Centrix SafePass", "A cross platform campus access and visitor management project with appointments, role based views, attendance, and access records.", "React Native  ·  Expo  ·  Node.js", GITHUB + "/Centrix_SafePass"));
        gap(content, 14);
        content.add(project("Advanced Web Yap", "A web development project with separate client and server code. Explore the live site to see the work in action.", "JavaScript  ·  Web application", "https://advanced-web-yap-mu.vercel.app"));
        gap(content, 46);

        content.add(label("ABOUT ME", 14, ACCENT, Font.BOLD));
        gap(content, 14);
        content.add(paragraph("I enjoy turning complex workflows into software people can use. My public projects span full stack web development and cross platform apps. I like learning by building and sharing the results.", BG, 16));
        gap(content, 36);
        content.add(label("LET'S CONNECT", 24, TEXT, Font.BOLD));
        gap(content, 12);
        content.add(link("Visit my GitHub profile", GITHUB));
        gap(content, 32);
        content.add(label("© 2026 Rafael Yap", 12, MUTED, Font.PLAIN));

        JScrollPane scroll = new JScrollPane(content);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        frame.add(scroll);
        frame.setSize(900, 760);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel project(String title, String description, String tech, String url) {
        JPanel card = new JPanel();
        card.setBackground(CARD);
        card.setBorder(BorderFactory.createEmptyBorder(22, 24, 22, 24));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setAlignmentX(0);
        card.add(label(title, 21, TEXT, Font.BOLD));
        gap(card, 10);
        card.add(paragraph(description, CARD, 15));
        gap(card, 12);
        card.add(label(tech, 13, ACCENT, Font.BOLD));
        gap(card, 10);
        card.add(link("Open project ↗", url));
        return card;
    }

    private static void gap(JPanel panel, int pixels) {
        panel.add(Box.createVerticalStrut(pixels));
    }

    private static JLabel label(String value, int size, Color color, int style) {
        JLabel label = new JLabel(value);
        label.setFont(new Font(Font.SANS_SERIF, style, size));
        label.setForeground(color);
        label.setAlignmentX(0);
        return label;
    }

    private static JTextArea paragraph(String value, Color background, int size) {
        JTextArea area = new JTextArea(value);
        area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, size));
        area.setForeground(MUTED);
        area.setBackground(background);
        area.setEditable(false);
        area.setFocusable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setColumns(42);
        area.setRows(Math.max(2, value.length() / 65 + 1));
        area.setMaximumSize(new Dimension(Integer.MAX_VALUE, area.getPreferredSize().height));
        area.setAlignmentX(0);
        return area;
    }

    private static JButton link(String title, String url) {
        JButton button = new JButton(title);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        button.setForeground(BG);
        button.setBackground(ACCENT);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(0);
        button.addActionListener(event -> {
            try {
                Desktop.getDesktop().browse(URI.create(url));
            } catch (Exception error) {
                JOptionPane.showMessageDialog(button, "Could not open " + url, "Link unavailable", JOptionPane.ERROR_MESSAGE);
            }
        });
        return button;
    }
}
