import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener {
    
    // Data model for gadgets
    // private ArrayList<Gadget> gadgets = new ArrayList<>();
    
    // UI components
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneField;
    private JTextField durationField;
    private JTextField downloadField;

    // Define text color
    private static final Color TEXT_COLOR = Color.WHITE;

    // Define button background color (dark grey)
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(51, 51, 51); // Dark Grey

    public GadgetShop() {

        // Initialize UI components
        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        creditField = new JTextField();
        memoryField = new JTextField();
        phoneField = new JTextField();
        durationField = new JTextField();
        downloadField = new JTextField();

        // Create buttons

        JButton addMobileButton   = createStyledButton("Add Mobile");
        JButton addMP3Button      = createStyledButton("Add MP3");
        JButton clearButton       = createStyledButton("Clear");
        JButton displayAllButton  = createStyledButton("Display All");
        JButton makeCallButton    = createStyledButton("Make A Call");
        JButton downloadMusicButton = createStyledButton("Download Music");

         // Register this class as the listener for every button

        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);


         // Build a *master* panel that will hold everything

        JPanel master = new JPanel(new BorderLayout(10, 10));
        master.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

         // Set dark theme colors

        Color backgroundColor = new Color(32, 32, 32); // Dark background
        master.setBackground(backgroundColor);

         // Create the labels

        JLabel modelLabel      = createStyledLabel("Model:");
        JLabel priceLabel      = createStyledLabel("Price:");
        JLabel weightLabel     = createStyledLabel("Weight:");
        JLabel sizeLabel       = createStyledLabel("Size:");
        JLabel creditLabel     = createStyledLabel("Credit:");
        JLabel memoryLabel     = createStyledLabel("Memory:");
        JLabel phoneLabel      = createStyledLabel("Phone Number:");
        JLabel durationLabel   = createStyledLabel("Duration (min):");
        JLabel downloadLabel   = createStyledLabel("Download Size (MB):");


         // Layout the components

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 15, 15));
        inputPanel.setBackground(backgroundColor);

        inputPanel.add(modelLabel);
        inputPanel.add(modelField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeField);
        inputPanel.add(creditLabel);
        inputPanel.add(creditField);
        inputPanel.add(memoryLabel);
        inputPanel.add(memoryField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(durationLabel);
        inputPanel.add(durationField);
        inputPanel.add(downloadLabel);
        inputPanel.add(downloadField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMP3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadMusicButton);

        master.add(inputPanel, BorderLayout.CENTER);
        master.add(buttonPanel, BorderLayout.SOUTH);


         // Set the frame properties

        setTitle("Gadget Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(master);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createStyledButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(BUTTON_BACKGROUND_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(TEXT_COLOR);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Add Mobile":
                addMobile();
                break;
            case "Add MP3":
                addMP3();
                break;
            case "Clear":
                clearFields();
                break;
            case "Display All":
                displayAllGadgets();
                break;
            case "Make A Call":
                makeCall();
                break;
            case "Download Music":
                downloadMusic();
                break;
        }
    }

    private void addMobile() {
        String model = modelField.getText();
        try {
            double price = Double.parseDouble(priceField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double size = Double.parseDouble(sizeField.getText());
            double credit = Double.parseDouble(creditField.getText());
            double memory = Double.parseDouble(memoryField.getText());

            Mobile mobile = new Mobile(model, price, weight, size, credit, memory);
            gadgets.add(mobile);

            JOptionPane.showMessageDialog(this, "Mobile added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for price, weight, size, credit, and memory.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addMP3() {
        String model = modelField.getText();
        try {
            double price = Double.parseDouble(priceField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double size = Double.parseDouble(sizeField.getText());
            double duration = Double.parseDouble(durationField.getText());
            double downloadSize = Double.parseDouble(downloadField.getText());

            MP3Player mp3Player = new MP3Player(model, price, weight, size, duration, downloadSize);
            gadgets.add(mp3Player);

            JOptionPane.showMessageDialog(this, "MP3 Player added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for price, weight, size, duration, and download size.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneField.setText("");
        durationField.setText("");
        downloadField.setText("");
    }

    private void displayAllGadgets() {
        if (gadgets.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No gadgets added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder gadgetsList = new StringBuilder();
        for (Gadget gadget : gadgets) {
            gadgetsList.append(gadget.toString()).append("\n");
        }

        JTextArea textArea = new JTextArea(gadgetsList.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(this, scrollPane, "All Gadgets", JOptionPane.INFORMATION_MESSAGE);
    }

    private void makeCall() {
        String phoneNumber = phoneField.getText();
        try {
            double duration = Double.parseDouble(durationField.getText());

            if (phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder callDetails = new StringBuilder();
            callDetails.append("Calling ").append(phoneNumber).append(" for ").append(duration).append(" minutes.");

            JOptionPane.showMessageDialog(this, callDetails.toString(), "Call Details", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a numeric value for duration.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void downloadMusic() {
        try {
            double downloadSize = Double.parseDouble(downloadField.getText());

            StringBuilder downloadDetails = new StringBuilder();
            downloadDetails.append("Downloading ").append(downloadSize).append(" MB of music.");

            JOptionPane.showMessageDialog(this, downloadDetails.toString(), "Download Details", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a numeric value for download size.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GadgetShop());
    }
}

class Gadget {
    protected String model;
    protected double price;
    protected double weight;
    protected double size;

    public Gadget(String model, double price, double weight, double size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Model: " + model + ", Price: $" + price + ", Weight: " + weight + "g, Size: " + size + "cm";
    }
}

class Mobile extends Gadget {
    private double credit;
    private double memory;

    public Mobile(String model, double price, double weight, double size, double credit, double memory) {
        super(model, price, weight, size);
        this.credit = credit;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return super.toString() + ", Credit: $" + credit + ", Memory: " + memory + "GB";
    }
}

class MP3Player extends Gadget {
    private double duration;
    private double downloadSize;

    public MP3Player(String model, double price, double weight, double size, double duration, double downloadSize) {
        super(model, price, weight, size);
        this.duration = duration;
        this.downloadSize = downloadSize;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + "min, Download Size: " + downloadSize + "MB";
    }
}
